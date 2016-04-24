package org.parquelibertad.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.parquelibertad.view.jmodels.DatabaseTableModel;
import org.parquelibertad.view.jmodels.TableModelFactory;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.OracleCallableStatement;

public class QueryController {
  private static Vector<String> columnasUltimaConsulta;
  private static Connection     myConnection = null;

  public static void startJDBC() throws SQLException{
    DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
  }
  public static void closeConnection() throws SQLException {
    if (myConnection != null) {
      myConnection.close();
    }
    myConnection = null;
  }

  public static Connection openConnection() throws SQLException {
    if (myConnection == null) {
      myConnection = ConnectionFactory.getConnection();
    }
    return myConnection;
  }
  /** SQL Syntax based on:
   * https://docs.oracle.com/cd/E16338_01/appdev.112/e13995/oracle/jdbc/OracleCallableStatement.html
   *   // Oracle PL/SQL block syntax
   *   CallableStatement cs3 = conn.prepareCall
   *   ( "begin proc (?,?); end;" ) ; // stored proc
   *   CallableStatement cs4 = conn.prepareCall
   *   ( "begin ? := func(?,?); end;" ) ; // stored func
   *   
   *   Column indexes always start in 1, based on:
   *   http://javarevisited.blogspot.com/2012/01/javasqlsqlexception-invalid-column.html
   *   
   *   Learn how to obtain cursors at:
   *   ttps://oracle-base.com/articles/misc/using-ref-cursors-to-return-recordsets#11g-updates
   */
  public static Integer getPaisID(String pNombrePais) throws SQLException{
    String proposal = "BEGIN ? := get_Pais_ID(?); END;";
    OracleCallableStatement cstmt = (OracleCallableStatement) myConnection.prepareCall(proposal);
    cstmt.registerOutParameter(1, OracleTypes.INTEGER);
    cstmt.setString(2, pNombrePais);
    cstmt.executeQuery();
    Integer paisID = cstmt.getInt(1);
    cstmt.close();
    return paisID;
  }
  
  public static void getProvinciasPorPais(Integer pPaisID) throws SQLException{
    String proposal = "BEGIN get_Provincias_por_Pais(?, ?); END;";
    OracleCallableStatement cstmt = (OracleCallableStatement) myConnection.prepareCall(proposal);
    cstmt.setInt(1, pPaisID);
    cstmt.registerOutParameter(2, OracleTypes.CURSOR);
    // http://stackoverflow.com/questions/14946959/
    // callablestatement-getresultset-always-return-null-when-calling-an-oracle-funct
    System.out.println(cstmt.execute());
    ResultSet result = cstmt.getCursor(2);
    System.out.println(result.getType() == ResultSet.TYPE_FORWARD_ONLY);
    System.out.println(result.getFetchDirection() == ResultSet.FETCH_FORWARD);
    System.out.println(result.isBeforeFirst());
    System.out.println(result.next());
    System.out.println(result.isFirst());
    System.out.println(result.getInt(1) + " || " + result.getString(2));
    System.out.println(result.next());
    System.out.println(result.getInt(1) + " || " + result.getString(2));
    System.out.println(result.next());
    System.out.println(result.getInt(1) + " || " + result.getString(2));
    System.out.println(result.next());
    result.close();
  }
  
  public static void promoverPersona(Integer selectedPersonaID) {
    if (selectedPersonaID != null) {
      // PENDING TESTS FROM METHODS BELOW.
      JOptionPane.showMessageDialog(MainController.getInstance().getMainScreen(),
          "FELICIDADES: las pruebas han sido satisfactorias y logró seleccionar\n"
              + "el ID para promover una persona a Estudiante o Profesora.\n\n"
                + "ID interno seleccionado: "
                + selectedPersonaID.toString());
    }
  }

  public static Vector<String> getColumnasUltimaConsulta() {
    return columnasUltimaConsulta;
  }

  public static DatabaseTableModel buscarPersona(String tipoIdentificacion,
      String numeroIdentificacion, String tipoAtributo, String atributo)
      throws SQLException, IllegalArgumentException {
    /**
     * Llamada a procedimiento almacenado que implique SELECT FROM Persona...
     * La cláusula WHERE debe NO incluir ID en los parámetros para que tenga
     * sentido. Esta búsqueda no depende del número de identificación.
     */
    String proposal = "BEGIN buscarPersona(?, ?, ?, ?); END;";
    CallableStatement cstmt = myConnection.prepareCall(proposal);
    cstmt.registerOutParameter(1, OracleTypes.CURSOR);
    cstmt.setString(2, tipoIdentificacion);
    cstmt.setInt(3, validarNumero(numeroIdentificacion));
    // ResultSet rset = cstmt.executeQuery();
    // Based on: https://oracle-base.com/articles/misc/using-ref-cursors-to-return-recordsets#11g-updates
    ResultSet rs = ((OracleCallableStatement) cstmt).getCursor(2);

    columnasUltimaConsulta = new Vector<String>();
    columnasUltimaConsulta.add("Nombre");
    columnasUltimaConsulta.add("Primer Apellido");
    columnasUltimaConsulta.add("Segundo Apellido");
    columnasUltimaConsulta.add("Distrito Origen");
    columnasUltimaConsulta.add("Nacionalidad");
    columnasUltimaConsulta.add("Numero de " + tipoIdentificacion);

    DatabaseTableModel toReturn = TableModelFactory
        .getDatabaseModel(columnasUltimaConsulta, rs);
    // Avoid meamory leak:
    rs.close();
    rs = null;
    cstmt.close();
    cstmt = null;
    // Based on:
    // http://stackoverflow.com/questions/22136168/will-resultset-leak-if-not-explicitly-closed
    return toReturn;
  }

  public static Integer selectPersona(String tipoIdentificacion,
      String numeroIdentificacion) throws SQLException, IllegalArgumentException {
    String proposedSQLStatement = "{? = call SELECTPersona (?, ?)}";
    CallableStatement cstmt = myConnection.prepareCall(proposedSQLStatement);
    // !! Test pending
    cstmt.registerOutParameter(1, OracleTypes.INTEGER);
    cstmt.setString(2, tipoIdentificacion);
    cstmt.setInt(3, validarNumero(numeroIdentificacion));
    ResultSet rset = cstmt.executeQuery();
    Integer selectedPersonaID = rset.getInt(0);
    rset.close();
    return selectedPersonaID;
  }

  private static Integer validarNumero(String test) throws IllegalArgumentException {
    // Lo más probable es que numeroIdentificacion tenga un error.
    // Validar siempre en vez de esperar una excepción.
    if (test.equals("")
        || !Pattern.compile("/^[0-9]*$/").matcher(test)
            .matches()) { throw new IllegalArgumentException(
                "El valor ingresado como número de identifación "
                    + "debe contener números solamente y no estar vacío."); }
    // Basado en : http://stackoverflow.com/questions/1306827/
    // which-is-better-more-efficient-check-for-bad-values-or-catch-exceptions-in-java
    return Integer.parseInt(test);
  }
}

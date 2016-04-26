package org.parquelibertad.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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

  public static void startJDBC() throws SQLException {
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
  /**
   * SQL Syntax based on:
   * https://docs.oracle.com/cd/E16338_01/appdev.112/e13995/oracle/jdbc/
   * OracleCallableStatement.html
   * // Oracle PL/SQL block syntax
   * CallableStatement cs3 = conn.prepareCall
   * ( "begin proc (?,?); end;" ) ; // stored proc
   * CallableStatement cs4 = conn.prepareCall
   * ( "begin ? := func(?,?); end;" ) ; // stored func
   * 
   * Column indexes always start in 1, based on:
   * http://javarevisited.blogspot.com/2012/01/javasqlsqlexception-invalid-
   * column.html
   * 
   * Learn how to obtain cursors at:
   * ttps://oracle-base.com/articles/misc/using-ref-cursors-to-return-recordsets
   * #11g-updates
   */
  
  public static HashMap<Integer, String> getPaises() throws SQLException {
    String statement = "get_Paises";
    ResultSet result = ResultSetFactory.callStoredProc(statement, new Vector<Object>(), 1);
    boolean lastOperationResult;
    lastOperationResult = result.next(); // System.out.println(lastOperationResult);
    lastOperationResult = result.isFirst(); // System.out.println(lastOperationResult);
    HashMap<Integer, String> comboBoxContents = new HashMap<Integer, String>();
    if (lastOperationResult) {
      while (lastOperationResult) {
        comboBoxContents.put(result.getInt(1), result.getString(2));
        // Sabemos que el procedimiento tiene una columna de IDs y otra de descripcion.
        lastOperationResult = result.next();
      }
    }
    result.close();
    return comboBoxContents;
  }
  
  public static Integer getPaisID(String pNombrePais) throws SQLException {
    String proposal = "BEGIN ? := get_Pais_ID(?); END;";
    OracleCallableStatement cstmt = (OracleCallableStatement) myConnection
        .prepareCall(proposal);
    cstmt.registerOutParameter(1, OracleTypes.INTEGER);
    cstmt.setString(2, pNombrePais);
    cstmt.executeQuery();
    Integer paisID = cstmt.getInt(1);
    cstmt.close();
    return paisID;

    /* Vector<Object> variables = new Vector<Object>();
     * variables.addElement(pNombrePais);
     * return (Integer) callStoredFunc("get_Pais_ID", variables, Integer.class); */
  }

  public static HashMap<Integer, String> getProvinciasPorPais(Integer pPaisID) throws SQLException {
    String statement = "get_Provincias_por_Pais";
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pPaisID);
    ResultSet result = ResultSetFactory.callStoredProc(statement, parametros, 2);
    boolean lastOperationResult;
    lastOperationResult = result.next(); // System.out.println(lastOperationResult);
    lastOperationResult = result.isFirst(); // System.out.println(lastOperationResult);
    HashMap<Integer, String> comboBoxContents = new HashMap<Integer, String>();
    if (lastOperationResult) {
      while (lastOperationResult) {
        comboBoxContents.put(result.getInt(1), result.getString(2));
        // Sabemos que el procedimiento tiene una columna de IDs y otra de descripcion.
        lastOperationResult = result.next();
      }
    }
    result.close();
    return comboBoxContents;
  }
  
  public static HashMap<Integer, String> getCantonesPorProvincia(Integer pProvinciaID) throws SQLException {
    String statement = "get_Cantones_por_Provincia";
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pProvinciaID);
    ResultSet result = ResultSetFactory.callStoredProc(statement, parametros, 2);
    boolean lastOperationResult;
    lastOperationResult = result.next(); // System.out.println(lastOperationResult);
    lastOperationResult = result.isFirst(); // System.out.println(lastOperationResult);
    HashMap<Integer, String> comboBoxContents = new HashMap<Integer, String>();
    if (lastOperationResult) {
      while (lastOperationResult) {
        comboBoxContents.put(result.getInt(1), result.getString(2));
        // Sabemos que el procedimiento tiene una columna de IDs y otra de descripcion.
        lastOperationResult = result.next();
      }
    }
    result.close();
    return comboBoxContents;
  }
  
  public static HashMap<Integer, String> getDistritosPorCanton(Integer pCantonID) throws SQLException {
    String statement = "get_Distritos_por_Canton";
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pCantonID);
    ResultSet result = ResultSetFactory.callStoredProc(statement, parametros, 2);
    boolean lastOperationResult;
    lastOperationResult = result.next(); // System.out.println(lastOperationResult);
    lastOperationResult = result.isFirst(); // System.out.println(lastOperationResult);
    HashMap<Integer, String> comboBoxContents = new HashMap<Integer, String>();
    if (lastOperationResult) {
      while (lastOperationResult) {
        comboBoxContents.put(result.getInt(1), result.getString(2));
        // Sabemos que el procedimiento tiene una columna de IDs y otra de descripcion.
        lastOperationResult = result.next();
      }
    }
    result.close();
    return comboBoxContents;
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
    // Based on:
    // https://oracle-base.com/articles/misc/using-ref-cursors-to-return-recordsets#11g-updates
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
  /*
  private static void demo() {
    try {
      openConnection();
      for (String x : QueryController
          .getProvinciasPorPais(QueryController.getPaisID("Costa Rica"))) {
        System.out.println(x);
      }
      closeConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  */
  // Static nested class:
  private static class ResultSetFactory {
    /**
     * Esta clase permitirá la generalización de las consultas en algo más
     * abstracto que no se relacione tan cercanamente al driver JDBC.
     * Requiere únicamente que las sentencias invoquen directamente
     * al procedimiento almacenado de la base de datos de Oracle, en formato:
     * 
     * nobmre_procedimiento_almacenado(?{, ?, ...,}, ?)
     * 
     * usando N parámetros de entrada y asumiendo que existe un parámetro
     * que siempre estará ubicado en el último ? y será @type
     * OracleTypes.CURSOR.
     * 
     * Retorna un conjunto de datos resultado de ejecutar una sentencia PL/SQL
     * aleatoria. Estado inicial del ResultSet siempre será:
     * result.getType() == ResultSet.TYPE_FORWARD_ONLY
     * result.getFetchDirection() == ResultSet.FETCH_FORWARD
     * result.isBeforeFirst() == true
     */
    static ResultSet callStoredProc(String originalSTMT, Vector<Object> variables,
        int cursorMarkPosition) throws SQLException {
      // Assume the procedure call is well-formed.
      // Assume we don't know how to construct the PL/SQL sentence:
      String newStatement = "BEGIN " + originalSTMT + "(";
      for (@SuppressWarnings("unused")
      Object x : variables) {
        newStatement += "?, ";
      }
      newStatement += "?); END;";
      OracleCallableStatement cstmt = (OracleCallableStatement) myConnection
          .prepareCall(newStatement);
      // System.out.println("GETTING cursorOutputIndex at " +
      // cursorMarkPosition);
      // Assume all initial ? marks are input variables:
      if (!variables.isEmpty()) {
        for (int mark = 0; mark < variables.size(); mark++) {
          if (variables.get(mark).getClass() == Integer.class) {
            // System.out.println("cstmt.setInt(" + (mark+1) + ", " + (Integer)
            // variables.get(mark));
            cstmt.setInt(mark + 1, (Integer) variables.get(mark));
          } else if (variables.get(mark).getClass() == String.class) {
            cstmt.setString(mark + 1, (String) variables.get(mark));
          } else {
            cstmt.setObject(mark + 1, variables.get(mark));
          }
        }
      }
      if (variables.size() + 1 != cursorMarkPosition) { throw new SQLException(
          "Invalid cursor ? position."); }
      // Assume the last ? mark is always a CURSOR:
      cstmt.registerOutParameter(cursorMarkPosition, OracleTypes.CURSOR);

      // Why use .execute() instead of .executeQuery(): sety
      // http://stackoverflow.com/questions/19443213/
      // cannot-perform-fetch-on-a-plsql-statement-next
      cstmt.execute();
      ResultSet result = cstmt.getCursor(cursorMarkPosition);
      return result;
    }
  }
  

}

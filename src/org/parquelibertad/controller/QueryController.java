package org.parquelibertad.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.parquelibertad.view.jmodels.DatabaseTableModel;
import org.parquelibertad.view.jmodels.TableModelFactory;

import oracle.jdbc.OracleTypes;

public class QueryController {
  private static Vector<String> columnasUltimaConsulta;

  public static void promoverPersona(Integer selectedPersonaID) {
    // PENDING TESTS FROM METHODS BELOW.
    JOptionPane.showMessageDialog(MainController.getInstance().getMainScreen(),
        "FELICIDADES: las pruebas han sido satisfactorias y logró seleccionar\n"
            + "el ID para promover una persona a Estudiante o Profesora.\n\n"
              + "ID interno seleccionado: " + selectedPersonaID.toString());
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
    String proposedSQLStatement = "{? = call BUSCARPersona (? , ?, ?, ?)}";
    Connection database = MainController.getInstance().getMyConnection();
    CallableStatement cstmt = database.prepareCall(proposedSQLStatement);
    cstmt.registerOutParameter(1, OracleTypes.CURSOR);
    cstmt.setString(2, tipoIdentificacion);
    cstmt.setInt(3, validarNumero(numeroIdentificacion));
    ResultSet rset = cstmt.executeQuery();

    columnasUltimaConsulta = new Vector<String>();
    columnasUltimaConsulta.add("Nombre");
    columnasUltimaConsulta.add("Primer Apellido");
    columnasUltimaConsulta.add("Segundo Apellido");
    columnasUltimaConsulta.add("Distrito Origen");
    columnasUltimaConsulta.add("Nacionalidad");
    columnasUltimaConsulta.add("Numero de " + tipoIdentificacion);

    DatabaseTableModel toReturn = TableModelFactory
        .getDatabaseModel(columnasUltimaConsulta, rset);
    // Avoid meamory leak:
    rset.close();
    // Based on:
    // http://stackoverflow.com/questions/22136168/will-resultset-leak-if-not-explicitly-closed
    return toReturn;
  }

  public static Integer selectPersona(String tipoIdentificacion,
      String numeroIdentificacion) throws SQLException, IllegalArgumentException {
    String proposedSQLStatement = "{? = call SELECTPersona (?, ?)}";
    Connection database = MainController.getInstance().getMyConnection();
    CallableStatement cstmt = database.prepareCall(proposedSQLStatement);
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

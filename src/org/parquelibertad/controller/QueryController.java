package org.parquelibertad.controller;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.OracleCallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import static org.assertj.core.api.Assertions.*;

import org.parquelibertad.view.busquedas.FiltroPersona;
import org.parquelibertad.view.jmodels.DatabaseTableModel;

public class QueryController {
  private static Connection myConnection = null;

  public static void startJDBC() throws SQLException {
    DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
  }

  public static void closeConnection() throws SQLException {
    if (myConnection != null) {
      myConnection.close();
    }
    myConnection = null;
  }

  public static boolean isConnected() throws SQLException {
    if (myConnection != null) {
      if (!myConnection.isClosed()) { return true; }
      return false;
    }
    return false;
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
  public static String getDistritoNombre(Integer selectedDistritoID) throws SQLException {
    String statement = "BEGIN ? := get_unq_Distrito_Nombre(?); END;";
    OracleCallableStatement cstmt = (OracleCallableStatement) myConnection
        .prepareCall(statement);
    cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
    cstmt.setInt(2, selectedDistritoID);
    cstmt.executeQuery();
    String distritoNombre = cstmt.getString(1);
    cstmt.close();
    return distritoNombre;
  }

  public static Integer selectSemanaID(boolean lunes, boolean martes, boolean miercoles,
      boolean jueves, boolean viernes, boolean sabado, boolean domingo)
      throws SQLException {
    if (!(lunes
        || martes
          || miercoles
          || jueves
          || viernes
          || sabado
          || domingo)) { throw new SQLException(
              "Al menos uno de los días debe ser seleccionado."); }
    ;
    String statement = "BEGIN ? := get_unq_id_semana(?,?,?,?,?,?,?); END;";
    OracleCallableStatement cstmt = (OracleCallableStatement) myConnection
        .prepareCall(statement);
    cstmt.registerOutParameter(1, OracleTypes.INTEGER);
    cstmt.setInt(2, (lunes ? 1 : 0));
    cstmt.setInt(3, (martes ? 1 : 0));
    cstmt.setInt(4, (miercoles ? 1 : 0));
    cstmt.setInt(5, (jueves ? 1 : 0));
    cstmt.setInt(6, (viernes ? 1 : 0));
    cstmt.setInt(7, (sabado ? 1 : 0));
    cstmt.setInt(8, (domingo ? 1 : 0));
    cstmt.executeQuery();
    Integer selectedSemanaID = cstmt.getInt(1);
    cstmt.close();
    return selectedSemanaID;
  }

  public static Integer selectHoraID(Integer hora, Integer minuto) throws SQLException {
    String statement = "BEGIN ? := get_unq_id_Horario(?,?); END;";
    OracleCallableStatement cstmt = (OracleCallableStatement) myConnection
        .prepareCall(statement);
    cstmt.registerOutParameter(1, OracleTypes.INTEGER);
    cstmt.setInt(2, hora);
    cstmt.setInt(3, minuto);
    cstmt.executeQuery();
    Integer selectedHorarioID = cstmt.getInt(1);
    cstmt.close();
    return selectedHorarioID;
  }

  public static HashMap<Integer, String> getTiposDocumento() throws SQLException {
    String statement = "get_Tipos_Documento";
    return ResultSetFactory.getComboBoxContents(statement, null);
  }

  public static HashMap<Integer, String> getNacionalidades() throws SQLException {
    String statement = "get_Nacionalidades";
    return ResultSetFactory.getComboBoxContents(statement, null);
  }

  // Rangos de Edad debe usar una implementación nueva
  public static HashMap<Integer, String> getRangosEdad() throws SQLException {
    String statement = "get_Rangos_Edad";
    ResultSet result = ResultSetFactory.callStoredProc(statement, new Vector<Object>(),
        1);
    boolean lastOperationResult;
    lastOperationResult = result.next(); // System.out.println(lastOperationResult);
    lastOperationResult = result.isFirst(); // System.out.println(lastOperationResult);
    HashMap<Integer, String> comboBoxContents = new HashMap<Integer, String>();
    if (lastOperationResult) {
      while (lastOperationResult) {
        // Este ComboBox debe construirse diferente:
        comboBoxContents.put(result.getInt(1),
            "De " + (result.getInt(2)) + " a " + (result.getInt(3)) + " Años");
        lastOperationResult = result.next();
      }
    }
    result.close();
    return comboBoxContents;
  }

  public static HashMap<Integer, String> getPaises() throws SQLException {
    String statement = "get_Paises";
    return ResultSetFactory.getComboBoxContents(statement, null);
  }

  public static HashMap<Integer, String> getTiposActividad() throws SQLException {
    String statement = "get_Tipos_Actividad";
    return ResultSetFactory.getComboBoxContents(statement, null);
  }

  public static HashMap<Integer, String> getTiposEmpleado() throws SQLException {
    String statement = "get_Tipos_Empleado";
    return ResultSetFactory.getComboBoxContents(statement, null);
  }

  public static HashMap<Integer, String> getProvinciasPorPais(Integer pPaisID)
      throws SQLException {
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pPaisID);
    String statement = "get_Provincias_por_Pais";
    return ResultSetFactory.getComboBoxContents(statement, parametros);
  }

  public static HashMap<Integer, String> getCantonesPorProvincia(Integer pProvinciaID)
      throws SQLException {
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pProvinciaID);
    String statement = "get_Cantones_por_Provincia";
    return ResultSetFactory.getComboBoxContents(statement, parametros);
  }

  public static HashMap<Integer, String> getDistritosPorCanton(Integer pCantonID)
      throws SQLException {
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pCantonID);
    String statement = "get_Distritos_por_Canton";
    return ResultSetFactory.getComboBoxContents(statement, parametros);
  }

  public static void insertarPersona(String pNombre, String pPrimerApellido,
      String pSegundoApellido, Integer pNumeroDocumento, Integer pIDTipoDocumento,
      Integer pRangoEdadID, Integer pIDNacionalidad, Integer pDistritoID,
      String pDireccion) throws SQLException {
    String statement = "INSERT_PERSONA";
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pNombre);
    parametros.addElement(pPrimerApellido);
    parametros.addElement(pSegundoApellido);
    parametros.addElement(pNumeroDocumento);
    parametros.addElement(pIDTipoDocumento);
    parametros.addElement(pRangoEdadID);
    parametros.addElement(pIDNacionalidad);
    parametros.addElement(pDistritoID);
    parametros.addElement(pDireccion);
    ResultSet result = ResultSetFactory.callStoredProc(statement, parametros, -1);
    assertThat(result).isNull(); // No hay cursor de salida, AssertJ
    JOptionPane.showMessageDialog(MainController.getInstance().getMainScreen(),
        "Confirmada la inserción de la nueva persona en el sistema.");
  }

  public static void insertarActividad(String pDescripcion, Integer pIDTipo,
      boolean pIsActiva) throws SQLException {
    String statement = "INSERT_ACTIVIDAD";
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pDescripcion);
    parametros.addElement(pIDTipo);
    parametros.addElement(pIsActiva);
    ResultSet result = ResultSetFactory.callStoredProc(statement, parametros, -1);
    assertThat(result).isNull(); // No hay cursor de salida, AssertJ
    JOptionPane.showMessageDialog(MainController.getInstance().getMainScreen(),
        "Confirmada la inserción de la nueva actividad en el sistema.");
  }

  public static void insertarCurso(String pNombre, Integer pCosto, Integer pIDHorario,
      Integer pIDHoraInicio, Integer pIDHoraFinal, Integer pIDRangoEdadMercadoMeta,
      boolean isActivo) throws SQLException {
    String statement = "INSERT_CURSO";
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pNombre);
    parametros.addElement(pCosto);
    parametros.addElement(pIDHorario);
    parametros.addElement(pIDHoraInicio);
    parametros.addElement(pIDHoraFinal);
    parametros.addElement(pIDRangoEdadMercadoMeta);
    parametros.addElement(isActivo);
    ResultSet result = ResultSetFactory.callStoredProc(statement, parametros, -1);
    assertThat(result).isNull(); // No hay cursor de salida, AssertJ
    JOptionPane.showMessageDialog(MainController.getInstance().getMainScreen(),
        "Confirmada la inserción de la nuevo curso en el sistema.");
  }

  public static void insertarMatricula(Integer pCursoXPeriodoID, Integer pAlumnoID)
      throws SQLException {
    String statement = "INSERT_MATRICULA";
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pCursoXPeriodoID);
    parametros.addElement(pAlumnoID);
    ResultSet result = ResultSetFactory.callStoredProc(statement, parametros, -1);
    assertThat(result).isNull(); // No hay cursor de salida, AssertJ
    JOptionPane.showMessageDialog(MainController.getInstance().getMainScreen(),
        "Confirmada la matrícula.");
  }
  
  public static void insertarEmpleado(Integer pPersonaID, Integer pTipoID, String pNickname, String pContrasenia)
      throws SQLException {
    String statement = "INSERT_EMPLEADO";
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pPersonaID);
    parametros.addElement(pTipoID);
    parametros.addElement(pNickname);
    parametros.addElement(pContrasenia);
    ResultSet result = ResultSetFactory.callStoredProc(statement, parametros, -1);
    assertThat(result).isNull(); // No hay cursor de salida, AssertJ
    JOptionPane.showMessageDialog(MainController.getInstance().getMainScreen(),
        "Confirmada la promoción a empleado. Felicidades");
  }
  
  public static void insertarAlumno(Integer pPersonaID, Integer pAnioMatricula)
      throws SQLException {
    String statement = "INSERT_ALUMNO";
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pPersonaID);
    parametros.addElement(pAnioMatricula);
    ResultSet result = ResultSetFactory.callStoredProc(statement, parametros, -1);
    assertThat(result).isNull(); // No hay cursor de salida, AssertJ
    JOptionPane.showMessageDialog(MainController.getInstance().getMainScreen(),
        "Confirmada la promoción a empleado. Felicidades");
  }

  public static DatabaseTableModel buscarPersonaTerritorios(Integer pTerritorioID,
      boolean buscarPorPais, boolean buscarPorProvincia, boolean buscarPorCanton,
      boolean buscarPorDistrito) throws SQLException {
    String statement = "";
    if (buscarPorPais) {
      statement = "personas_PAIS";
    } else if (buscarPorProvincia) {
      statement = "personas_PROVINCIA";
    } else if (buscarPorCanton) {
      statement = "personas_CANTON";
    } else if (buscarPorDistrito) {
      statement = "personas_DISTRITO";
    }
    // System.out.println(statement + " || " + pTerritorioID);
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pTerritorioID);
    Vector<String> columnHeaders = new Vector<String>();
    columnHeaders.addElement("Nombre");
    columnHeaders.addElement("Primer Apellido");
    columnHeaders.addElement("Segundo Apellido");
    return ResultSetFactory.getTableContents(statement, parametros, columnHeaders);
  }

  public static DatabaseTableModel buscarPersonasFechaRegistro(Calendar initialCal,
      Calendar finalCal) throws SQLException {
    String statement = "personas_RANGO_FECHA_REG";
    if (initialCal.getTimeInMillis() > finalCal
        .getTimeInMillis()) { throw new SQLException(
            "La fecha de inicio debe ser menor o igual a la final."); }
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(initialCal);
    parametros.addElement(finalCal);
    Vector<String> columnHeaders = new Vector<String>();
    columnHeaders.addElement("Nombre");
    columnHeaders.addElement("Primer Apellido");
    columnHeaders.addElement("Segundo Apellido");
    return ResultSetFactory.getTableContents(statement, parametros, columnHeaders);
  }

  public static DatabaseTableModel buscarPersonaGeneral(String pTipoIdentidad,
      Integer pTipoIdentidadID, Integer pIntegerBusqueda, String pAtributo,
      String pStringBusqueda, boolean buscaPorID, boolean buscaPorAtributo)
      throws SQLException {
    String statement = "";
    Vector<Object> parametros = new Vector<Object>();
    if (buscaPorID) {
      statement = "personas_IDENTIFICACION";
      parametros.addElement(pIntegerBusqueda);
      parametros.addElement(pTipoIdentidadID);
    } else if (buscaPorAtributo) {
      if (pAtributo.equals(FiltroPersona.atributos[0])){
        statement = "personas_NOMBRE";
      } else if (pAtributo.equals(FiltroPersona.atributos[1])){
        statement = "personas_PRIMER_APELLIDO";
      } else if (pAtributo.equals(FiltroPersona.atributos[2])){
        statement = "personas_SEGUNDO_APELLIDO";
      }
      parametros.addElement(pStringBusqueda);
      parametros.addElement(pTipoIdentidadID);
    }
    Vector<String> columnHeaders = new Vector<String>();
    columnHeaders.addElement("Nombre");
    columnHeaders.addElement("Primer Apellido");
    columnHeaders.addElement("Segundo Apellido");
    columnHeaders.addElement("Tipo de " + pTipoIdentidad);
    return ResultSetFactory.getTableContents(statement, parametros, columnHeaders);
  }

  // .lastIndexOf((String) comboTipoIdentificacion.getSelectedItem());

  public static DatabaseTableModel getCursosPorPeriodos() throws SQLException {
    String statement = "get_CURSOSXPERIODO";
    Vector<String> columnHeaders = new Vector<String>();
    columnHeaders.addElement("Nombre");
    columnHeaders.addElement("Costo");
    columnHeaders.addElement("Fecha Inicial");
    columnHeaders.addElement("Fecha Final");
    columnHeaders.addElement("Activo?");
    // cxp.id, c.nombre, c.costo, p.idfechainicial, p.idfechafinal, c. isactivo
    return ResultSetFactory.getTableContents(statement, null, columnHeaders);
  }

  public static DatabaseTableModel buscarAlumnosSinMatricular(Integer pCursoPeriodoID)
      throws SQLException {
    String statement = "get_Posibles_Alumnos";
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pCursoPeriodoID);
    Vector<String> columnHeaders = new Vector<String>();
    columnHeaders.addElement("Nombre");
    columnHeaders.addElement("Primer Apellido");
    columnHeaders.addElement("Segundo Apellido");
    return ResultSetFactory.getTableContents(statement, parametros, columnHeaders);
  }

  public static DatabaseTableModel getPersonasDocentes() throws SQLException {
    String statement = "get_personas_DOCENTES";
    Vector<String> columnHeaders = new Vector<String>();
    columnHeaders.addElement("Nombre");
    columnHeaders.addElement("Primer Apellido");
    columnHeaders.addElement("Segundo Apellido");
    return ResultSetFactory.getTableContents(statement, null, columnHeaders);
  }

  public static DatabaseTableModel getAlumnos() throws SQLException {
    String statement = "get_Alumnos";
    Vector<String> columnHeaders = new Vector<String>();
    columnHeaders.addElement("Nombre");
    columnHeaders.addElement("Primer Apellido");
    columnHeaders.addElement("Segundo Apellido");
    return ResultSetFactory.getTableContents(statement, null, columnHeaders);
  }
  
  public static DatabaseTableModel getRankingVisitasActividades(Integer pTop) throws SQLException {
    String statement = "topN_visitas_ACTIVIDADES";
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pTop);
    Vector<String> columnHeaders = new Vector<String>();
    columnHeaders.addElement("Posición");
    columnHeaders.addElement("Nombre");
    columnHeaders.addElement("Primer Apellido");
    columnHeaders.addElement("Segundo Apellido");
    columnHeaders.addElement("Actividad más Frecuente");
    return ResultSetFactory.getTableContents(statement, parametros, columnHeaders);
  }
  public static DatabaseTableModel getRankingVisitasEventos(Integer pTop) throws SQLException {
    String statement = "topN_visitas_EVENTOS";
    Vector<Object> parametros = new Vector<Object>();
    parametros.addElement(pTop);
    Vector<String> columnHeaders = new Vector<String>();
    columnHeaders.addElement("Posición");
    columnHeaders.addElement("Nombre");
    columnHeaders.addElement("Primer Apellido");
    columnHeaders.addElement("Segundo Apellido");
    columnHeaders.addElement("Evento más Frecuente");
    return ResultSetFactory.getTableContents(statement, parametros, columnHeaders);    
  }

  private static class ResultSetFactory { // NESTED
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
    static HashMap<Integer, String> getComboBoxContents(String statement,
        Vector<Object> parametros) throws SQLException {
      /**
       * Copiar el statement a partir del procedimiento almacenado
       * desde PL/SQL Developer, el segundo parámetro es una lista de
       * más parámetros para el statement mismo, null significa cero.
       */
      ResultSet result = ResultSetFactory.callStoredProc(statement,
          (parametros == null ? new Vector<Object>() : parametros),
          (parametros == null ? 1 : parametros.size() + 1));
      boolean lastOperationResult;
      lastOperationResult = result.next(); // System.out.println(lastOperationResult);
      lastOperationResult = result.isFirst(); // System.out.println(lastOperationResult);
      HashMap<Integer, String> comboBoxContents = new HashMap<Integer, String>();
      if (lastOperationResult) {
        while (lastOperationResult) {
          comboBoxContents.put(result.getInt(1), result.getString(2));
          // Sabemos que el procedimiento tiene una columna de IDs y otra de
          // descripcion.
          lastOperationResult = result.next();
        }
      }
      result.close();
      return comboBoxContents;
    }

    static DatabaseTableModel getTableContents(String statement,
        Vector<Object> parametros, Vector<String> columnasUltimaConsulta)
        throws SQLException {
      /**
       * Copiar el statement a partir del procedimiento almacenado
       * desde PL/SQL Developer, el segundo parámetro es una lista de
       * más parámetros para el statement mismo, null significa cero.
       */
      ResultSet result = ResultSetFactory.callStoredProc(statement,
          (parametros == null ? new Vector<Object>() : parametros),
          (parametros == null ? 1 : parametros.size() + 1));
      // Desaparece el bug donde se pierde siempre el primer registro:
      // boolean lastOperationResult = false;
      // lastOperationResult = result.next();
      // System.out.println("IS SET FILLED IN? " + lastOperationResult);
      // lastOperationResult = result.isFirst();
      // System.out.println("IS SET READY TO FETCH? " + lastOperationResult);
      DatabaseTableModel tableModel = new DatabaseTableModel(columnasUltimaConsulta,
          result);
      result.close();
      return tableModel;
    }

    static ResultSet callStoredProc(String originalSTMT, Vector<Object> variables,
        int cursorMarkPosition) throws SQLException {
      // Assume the procedure call is well-formed.
      // Assume we don't know how to construct the PL/SQL sentence:
      String newStatement = "BEGIN " + originalSTMT + "(";
      for (int var = 0; var < variables.size(); var++) {
        newStatement += "?";
        if (cursorMarkPosition != -1) { // last question mark handled out of
                                        // for.
          newStatement += ", ";
        } else { // no cursor
          if (var != variables.size() - 1) { // reached end of parameters?
            newStatement += ", ";
          }
        }
      }
      if (cursorMarkPosition != -1) {
        newStatement += "?";
      }
      newStatement += "); END;";

      /* for (@SuppressWarnings("unused")
       * Object x : variables) {
       * newStatement += "?, ";
       * }
       * newStatement += "?); END;"; */
      // System.out.println(newStatement);

      OracleCallableStatement cstmt = (OracleCallableStatement) myConnection
          .prepareCall(newStatement);
      // System.out.println("GETTING cursorOutputIndex at " +
      // cursorMarkPosition);
      // Assume all initial ? marks are input variables:
      if (!variables.isEmpty()) {
        for (int mark = 0; mark < variables.size(); mark++) {
          if (variables.get(mark) instanceof Integer) {
            // System.out.println("cstmt.setInt(" + (mark+1) + ", " + (Integer)
            // variables.get(mark));
            cstmt.setInt(mark + 1, (Integer) variables.get(mark));
          } else if (variables.get(mark) instanceof String) {
            cstmt.setString(mark + 1, (String) variables.get(mark));
          } else if (variables.get(mark) instanceof Boolean) {
            cstmt.setInt(mark + 1, ((boolean) variables.get(mark) ? 1 : 0));
            // Representación interna de boolean dado que BOOLEAN no existe en
            // Oracle.
          } else if (variables.get(mark) instanceof Calendar) {
            cstmt.setDate(mark + 1,
                new java.sql.Date(((Calendar) variables.get(mark)).getTimeInMillis()));
          } else {

            cstmt.setObject(mark + 1, variables.get(mark));
          }
        }
      }
      // If it is supposed to have a cursor as last output variable:
      if (cursorMarkPosition != -1) {
        if (variables.size() + 1 != cursorMarkPosition) { throw new SQLException(
            "Invalid cursor ? position."); }
        // Assume the last ? mark is always a CURSOR:
        cstmt.registerOutParameter(cursorMarkPosition, OracleTypes.CURSOR);
      }
      boolean executeQueryResult = cstmt.execute();
      /* 
         
         This line above will always return FALSE, as the first object that the query returns is NOT a ResultSet object:
         https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html#executing_queries
         and actually there is no RETURN on the stored procedures, instead there is a OUT SYS_REFCURSOR parameter at the end:
         https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html#execute--
         Why use .execute() instead of .executeQuery(): by database architecture, stored procedures never return cursors:
         http://stackoverflow.com/questions/19443213/cannot-perform-fetch-on-a-plsql-statement-next
      */
      // System.out.println("WAS CALL SUCCESSFULL? " + executeQueryResult);
      if (cursorMarkPosition != -1) {
        ResultSet result = cstmt.getCursor(cursorMarkPosition);
        return result;
      } else {
        return null;
      }
    }
  }

}

package org.parquelibertad.view.jmodels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import static org.assertj.core.api.Assertions.*;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import org.parquelibertad.controller.MainController;

public class DatabaseTableModel extends AbstractTableModel {

  private static final long      serialVersionUID = 9063340574991700213L;
  private Vector<String>         columnHeaders;
  private Vector<Integer>        rowIDs;
  private Vector<Vector<Object>> dataVector;

  public DatabaseTableModel(Vector<String> pColumnHeaders, ResultSet contents)
      throws SQLException {
    rowIDs = new Vector<Integer>();
    columnHeaders = new Vector<String>();
    if (pColumnHeaders != null) {
      columnHeaders = pColumnHeaders;
    }
    assertThat(columnHeaders.size())
        .isEqualTo(contents.getMetaData().getColumnCount() - 1);
    dataVector = new Vector<Vector<Object>>();
    try {
      while (contents.next()) {
        Vector<Object> newRow = new Vector<Object>();
        // Omit first column that contains the database IDs:
        for (int i = 0; i < contents.getMetaData().getColumnCount(); i++) {
          if (i == 0) {
            rowIDs.addElement(contents.getInt(i + 1));
          } else {
            newRow.addElement(contents.getString(i + 1));
          }
        }
        // System.out.println(newRow);
        dataVector.addElement(newRow);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        /**
         * @author Luis Andr�s Pe�a Castillo
         *         Closing the SQL ResultSet is a GOOD PRACTICE as explained on:
         *         http://stackoverflow.com/questions/4507440/
         *         must-jdbc-resultsets-and-statements-be-closed-separately-
         *         although-the
         *         -connection
         * 
         *         See also:
         *         http://stackoverflow.com/questions/22136168/will-resultset-
         *         leak-if-
         *         not-explicitly-closed
         * 
         *         Why closing ResultSet twice is neccesary
         *         (since this was "also" closed on QueryController):
         *         see "Java is always pass-by-value":
         *         http://stackoverflow.com/questions/40480/is-java-pass-by-
         *         reference-or
         *         -pass-by-value
         * 
         */
        contents.close();
      } catch (SQLException e) {
        // !! Totally unexpected error, test pending
        JOptionPane.showMessageDialog(MainController.getInstance().getMainScreen(),
            e.getMessage());
      }
    }
  }

  public Vector<Integer> getDatabaseRowIDs() {
    return rowIDs;
  }

  @Override
  public int getRowCount() {
    if (dataVector != null) { return dataVector.size(); }
    return 0;
  }

  @Override
  public int getColumnCount() {
    if (columnHeaders != null) { return columnHeaders.size(); }
    return 0;
  }

  @Override
  public Object getValueAt(int row, int column) {
    if (dataVector != null) {
      if (dataVector.get(row) != null) { return dataVector.get(row).get(column); }
      return null;
    }
    return null;
  }

  // Permite extraer el ID de la persona seleccionada
  // en el JTable desde la interfaz.
  public Integer getDBIndex(int row) {
    return rowIDs.get(row);
  }

  /* !! Testing pending, possibly unreachable code
   * public Object getRecordAt(int row) {
   * if (dataVector != null) { return dataVector.get(row); }
   * return null;
   * } */

  @Override
  public String getColumnName(int column) {
    if (columnHeaders != null) { return columnHeaders.get(column); }
    return null;
  }

  @Override
  public int findColumn(String columnName) {
    for (int i = 0; i < columnHeaders.size(); i++) {
      if (columnHeaders.get(i) == columnName) { return i; }
    }
    return -1;
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    // System.out.println("getColumnClass(int " + columnIndex + ")");
    if (dataVector != null && dataVector.size() > 0) { return dataVector.get(0)
        .get(columnIndex).getClass(); }
    return String.class;
  }

}

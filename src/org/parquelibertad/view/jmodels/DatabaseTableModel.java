package org.parquelibertad.view.jmodels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class DatabaseTableModel extends AbstractTableModel {

  private static final long serialVersionUID = 9063340574991700213L;
  private Vector<String> columnHeaders;
  private Vector<Vector<Object>> dataVector;
  
  public DatabaseTableModel(Vector<String> pColumnHeaders, ResultSet contents){
    columnHeaders = new Vector<String>();
    if (pColumnHeaders != null) {
      columnHeaders = pColumnHeaders;
    }
    dataVector = new Vector<Vector<Object>>();
    try {
      while (contents.next()){
        Vector<Object> newRow =  new Vector<Object>();
        for (int i = 0; i < columnHeaders.size(); i++) {
          newRow.addElement(contents.getObject(i));
        }
        dataVector.addElement(newRow);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
  
  @Override
  public int getRowCount() {
    if (dataVector != null){
      return dataVector.size();
    }
    return 0;
  }
  
  @Override
  public int getColumnCount() {
    if (columnHeaders != null) {
      return columnHeaders.size();
    }
    return 0;
  }
  
  @Override
  public Object getValueAt(int row, int column) {
    if (dataVector != null) {
      if (dataVector.get(row) != null) {
        return dataVector.get(row).get(column);
      }
      return null;
    }
    return null;
  }
  
  @Override
  public String getColumnName(int column) {
    if (columnHeaders != null) {
      return columnHeaders.get(column);
    }
    return null;
  }
  
  @Override
  public int findColumn(String columnName) {
    for (int i = 0; i < columnHeaders.size(); i++){
      if (columnHeaders.get(i) == columnName){
        return i;
      }
    }
    return -1;
  }
  
  @Override
  public Class<?> getColumnClass(int columnIndex) {
    if (dataVector != null && dataVector.size() > 0){
      return dataVector.get(columnIndex).getClass();
    }
    return String.class;
  }

}

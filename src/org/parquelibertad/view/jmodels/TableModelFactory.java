package org.parquelibertad.view.jmodels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class TableModelFactory {

  public static DatabaseTableModel getDatabaseModel(Vector<String> pColumnHeaders, ResultSet rset) throws SQLException {
    return new DatabaseTableModel(pColumnHeaders, rset);
  }

}

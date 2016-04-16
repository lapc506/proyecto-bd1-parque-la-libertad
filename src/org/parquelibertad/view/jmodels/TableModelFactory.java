package org.parquelibertad.view.jmodels;

import java.sql.ResultSet;
import java.util.Vector;

public class TableModelFactory {

  public static DatabaseTableModel getDatabaseModel(Vector<String> pColumnHeaders, ResultSet rset) {
    return new DatabaseTableModel(pColumnHeaders, rset);
  }

}

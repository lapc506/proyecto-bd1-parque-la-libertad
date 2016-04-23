/**
 * 
 */
package org.parquelibertad;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.parquelibertad.controller.MainController;
import org.parquelibertad.controller.QueryController;
import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.metadata.Filepath;

/**
 * proyecto-bd1-parque-la-libertad org.parquelibertad
 * 
 * @author Luis Andrés Peña Castillo 2014057250 Derechos reservados bajo
 *         licencia MIT.
 *
 */
public class App {
  public static void main(String[] args) {
    // test();
    Filepath.loadAllProjectFolders();
    DesignController.startLookAndFeel();
    // Background color based on www.parquelalibertad.org
    DesignController.setWindowBGColor(DesignController.getHexColor("#FF8F00"));
    // Fonts folder can be empty
    FontController.loadFallbackFonts();
    FontController.loadAvailableFonts();
    FontController.loadDefaultFonts();
    try {
      QueryController.startJDBC();
      QueryController.openConnection();
      Integer paisID = QueryController.getPaisID("Costa Rica");
      System.out.println(paisID + " - Costa Rica");
      ResultSet result = QueryController.getProvinciasPorPais(paisID);
      // http://stackoverflow.com/questions/192078/how-do-i-get-the-size-of-a-java-sql-resultset
      // Para ResultSets de Oracle no es necesario 
      // result.first();
      // http://es.comp.lenguajes.java.narkive.com/7gOrsdbL/problema-con-resultset-en-jdbc
      Vector<String> listaProvincias = new Vector<String>();
      while (result.next()) {
        listaProvincias.addElement(result.getString(0));
      }
      for (String x : listaProvincias) {
        System.out.println(x);
      }
      result.close();
      QueryController.closeConnection();
      /* EventQueue.invokeLater(new Runnable() {
       * public void run() {
       * MainController.getInstance().showMainScreen();
       * }
       * }); */
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,
          "No es posible conectarse a la base de datos Oracle: \n" + e.getMessage(),
          "Oracle SQLException", JOptionPane.ERROR_MESSAGE);
      System.exit(-1);
    }
  }

  // Dummy method for filling SQL tables
  private static void test() {
    for (int i = 0; i < 24; i++) {
      for (int j = 0; j < 60; j++) {
        System.out.println("INSERT INTO TranscursoDia (id, hora, minuto) VALUES ("
            + ((i * 60) + j + 1)
              + ", "
              + i
              + ", "
              + j
              + ");");
      }
    }
    for (int i = 0; i < 128; i++) {
      int lunes = ((i & 0b1000000) == 0b1000000) ? 1 : 0;
      int martes = ((i & 0b0100000) == 0b0100000) ? 1 : 0;
      int miercoles = ((i & 0b0010000) == 0b0010000) ? 1 : 0;
      int jueves = ((i & 0b0001000) == 0b0001000) ? 1 : 0;
      int viernes = ((i & 0b0000100) == 0b0000100) ? 1 : 0;
      int sabado = ((i & 0b0000010) == 0b0000010) ? 1 : 0;
      int domingo = ((i & 0b0000001) == 0b0000001) ? 1 : 0;
      System.out.println("INSERT INTO HorarioSemanal "
          + "(id, lunes, martes, miercoles, jueves, viernes, sabado, domingo) VALUES ("
            + i
            + ", "
            + lunes
            + ", "
            + martes
            + ", "
            + miercoles
            + ", "
            + jueves
            + ", "
            + viernes
            + ", "
            + sabado
            + ", "
            + domingo
            + ");");
    }
  }
}

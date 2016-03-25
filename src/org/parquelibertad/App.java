/**
 * 
 */
package org.parquelibertad;

import java.awt.EventQueue;

import org.parquelibertad.controller.DebugController;
import org.parquelibertad.controller.DesignStyles;
import org.parquelibertad.controller.MainController;
import org.parquelibertad.metadata.Filepath;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad
 * @author Luis Andrés Peña Castillo 2014057250
 * Derechos reservados bajo licencia MIT.
 *
 */
public class App {
  public static MainController Instance;
	public static void main(String[] args) {
	  Filepath.loadAll();
    DesignStyles.startLookAndFeel();
    EventQueue.invokeLater(new Runnable() {
      public void run() { 
        Instance = MainController.getInstance();
        DebugController.loadAvailableFonts(); // Assuming fonts folder is not empty
        Instance.showDemoEmptyWindow();
      }
    });
	}

}

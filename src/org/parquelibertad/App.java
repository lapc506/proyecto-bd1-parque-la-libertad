/**
 * 
 */
package org.parquelibertad;

import java.awt.EventQueue;

import org.parquelibertad.controller.MainController;
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
	Filepath.loadAllProjectFolders();
	DesignController.startLookAndFeel();
	// Background color based on www.parquelalibertad.org
	DesignController.setWindowBGColor(DesignController.getHexColor("#FF8F00"));
	// Fonts folder can be empty
	FontController.loadFallbackFonts();
	FontController.loadAvailableFonts();
	FontController.loadDefaultFonts();
	
	// Will only run Swing JFrames and JDialogs
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			MainController.getInstance().getMainScreen();
		}
	});
  }
}

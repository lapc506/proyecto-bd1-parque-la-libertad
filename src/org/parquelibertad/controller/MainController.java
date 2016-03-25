/**
 * 
 */
package org.parquelibertad.controller;

import javax.swing.JFrame;
import org.parquelibertad.view.WindowTemplate;
/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.controller
 * @author Luis Andrés Peña Castillo 2014057250
 * Derechos reservados bajo licencia MIT.
 *
 */
public class MainController {
  private static MainController instance = null;
  protected MainController() {
    // Exists only to defeat instantiation.
  }
  public static MainController getInstance() {
    if (instance == null) {
      instance = new MainController();
    }
    return instance;
  }
  
  @SuppressWarnings("unused")
  public void showDemoEmptyWindow() {
   JFrame demo = new WindowTemplate("Background color #002957", "#002957", 600, 600, true, false);
  }
  
}

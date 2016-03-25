/**
 * 
 */
package org.parquelibertad.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.parquelibertad.metadata.Filepath;
import org.parquelibertad.view.FontSelectorForm;
import org.parquelibertad.view.TerritoryRegistrationForm;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.controller
 * 
 * @author Luis Andrés Peña Castillo 2014057250
 *         Derechos reservados bajo licencia MIT.
 *
 */
@SuppressWarnings("unused")
public class MainController {

  private static MainController singleton          = null;
  private JFrame                territorySelector = null;
  private JFrame                fontSelector      = null;

  protected MainController() {
    // Exists only to defeat instantiation.
  }

  public static MainController getInstance() {
    if (singleton == null) {
      singleton = new MainController();
    }
    return singleton;
  }

  private static int bootstrapStage = 0;
  public static void nextBootStage() { bootstrapStage++; }
  public static void bootstrap() {
    switch (bootstrapStage) {
      case 0:
        singleton.selectFont("titles");
        break;
      case 1:
        singleton.selectFont("subtitles");
        break;
      case 2:
        singleton.selectFont("regularLabels");
        break;
      case 3:
        singleton.selectFont("boldLabels");
        break;
      case 4:
        singleton.showDemoTerritories();
        break;
    }
  }

  public void showDemoTerritories() {
    territorySelector = new TerritoryRegistrationForm("Registro de Territorios",
        600, 600, true, false);
  }

  public void selectFont(String desiredType) {
    if (Filepath.listAvailableFonts().size() != 0) {
      fontSelector = new FontSelectorForm("Choose " + desiredType + " font", 400, 100,
          true, false, desiredType);
    } else {
      JOptionPane.showMessageDialog(null,
          "No extra fonts on project, using Java defaults.", "Noncritical error",
          JOptionPane.ERROR_MESSAGE);
      nextBootStage();
      bootstrap();
    }
  }

}

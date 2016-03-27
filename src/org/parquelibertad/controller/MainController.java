/**
 * 
 */
package org.parquelibertad.controller;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.metadata.Filepath;
import org.parquelibertad.view.AddPersonas;
import org.parquelibertad.view.FontSelectorForm;
import org.parquelibertad.view.MainWindow;
import org.parquelibertad.view.TerritoryEditDialog;
import org.parquelibertad.view.adminEdit.AddPaisDialog;
import org.parquelibertad.view.adminEdit.EditPaisDialog;

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

  private static MainController singleton         = null;
  private JDialog               territorySelector = null;
  private JDialog               debugFontSelector = null;
  private JFrame                mainScreen        = null;

  protected MainController() {
    // Exists only to defeat instantiation.
  }

  public static MainController getInstance() {
    if (singleton == null) {
      singleton = new MainController();
    }
    return singleton;
  }

  public static void bootstrap() {
    // singleton.showSelectFont("titles");
    FontController.setFont("titles", "PalanquinDark-Bold.ttf", 32);
    // singleton.showSelectFont("subtitles");
    FontController.setFont("subtitles", "Palanquin-Regular.ttf", 16);
    // singleton.showSelectFont("regularLabels");
    FontController.setFont("regularLabels", "Quicksand_Book.otf", 16);
    // singleton.showSelectFont("boldLabels");
    FontController.setFont("boldLabels", "Quicksand_Bold.otf", 16);
    singleton.loadMainScreen();
    singleton.showMainScreen();
  }

  public void showEditTerritories() {
    territorySelector = new TerritoryEditDialog(mainScreen, "Registro de Territorios",
        600, 350, false);
    territorySelector.setVisible(true);
  }

  public void loadMainScreen() {
    if (mainScreen != null) {
      mainScreen.dispose();
    }
    mainScreen = new MainWindow("Parque La Libertad", 800, 400, false, true);
  }

  public void showMainScreen() {
    mainScreen.setVisible(true);
  }

  public void showAddPais() {
    JDialog now = new AddPaisDialog(mainScreen, "Agregar país", 600, 600, false);
    now.setVisible(true);
  }

  public void showEditPais() {
    JDialog now = new EditPaisDialog(mainScreen, "Editar país", 600, 600, false);
    now.setVisible(true);
  }

  public void showSelectFont(String desiredType) {
    if (Filepath.listAvailableFonts().size() != 0) {
      debugFontSelector = new FontSelectorForm("Choose " + desiredType + " font", 400,
          100, false, desiredType);
      debugFontSelector.setVisible(true);
    } else {
      JOptionPane.showMessageDialog(null,
          "No extra fonts on project, using Java defaults.", "Noncritical error",
          JOptionPane.ERROR_MESSAGE);
      // nextBootStage();
      // bootstrap();
    }
  }

public void showAddPersona() {
	JDialog now = new AddPersonas(mainScreen, "Editar país", 600, 600, false);
    now.setVisible(true);
}

}

/**
 * 
 */
package org.parquelibertad.controller;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.parquelibertad.App;
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
  private static MainController instance = null;
  private MainController(){
	  territorySelector = null;
	  debugFontSelector = null;
	  mainScreen        = null;
  }
  public static MainController getInstance() {
    if (instance == null) {
    	instance = new MainController();
    }
    return instance;
  }
	
  private JDialog territorySelector;
  private JDialog debugFontSelector;
  private JFrame  mainScreen;

  public void showEditTerritories() {
    territorySelector = new TerritoryEditDialog(mainScreen, "Registro de Territorios",
        600, 350, false);
    territorySelector.setVisible(true);
  }

  public void getMainScreen() {
	mainScreen = new MainWindow("Parque La Libertad", 800, 400, false, true);
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
    }
  }

public void showAddPersona() {
	JDialog now = new AddPersonas(mainScreen, "Editar país", 600, 600, false);
    now.setVisible(true);
}

}

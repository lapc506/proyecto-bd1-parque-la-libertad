/**
 * 
 */
package org.parquelibertad.controller;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.parquelibertad.App;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.metadata.Filepath;
import org.parquelibertad.view.Principal;
import org.parquelibertad.view.adminDialogs.AgregarPais;
import org.parquelibertad.view.adminDialogs.EditarPais;
import org.parquelibertad.view.adminDialogs.EditarTerritorio;
import org.parquelibertad.view.busquedas.FiltroAlumnos;
import org.parquelibertad.view.busquedas.FiltroDistrito;
import org.parquelibertad.view.busquedas.FiltroPersona;
import org.parquelibertad.view.busquedas.FiltroRangoFechaRegistro;
import org.parquelibertad.view.busquedas.FiltroTerritorio;
import org.parquelibertad.view.debugDialogs.FontSelectorForm;
import org.parquelibertad.view.general.AgregarActividad;
import org.parquelibertad.view.general.AgregarCurso;
import org.parquelibertad.view.general.AgregarPersona;
import org.parquelibertad.view.general.ControlCursos;
import org.parquelibertad.view.general.Matricula;
import org.parquelibertad.view.general.PromoverPersona;
import org.parquelibertad.view.ranking.RankingVisitas;

import static org.assertj.core.api.Assertions.*;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.controller
 * 
 * @author Luis Andrés Peña Castillo 2014057250
 *         Derechos reservados bajo licencia MIT.
 *
 */
public class MainController {
  private static MainController instance = null;

  private JDialog               territorySelector;
  private JDialog               debugFontSelector;
  private JFrame                mainScreen;

  private MainController() {
    territorySelector = null;
    debugFontSelector = null;
    mainScreen = null;
  }

  public static MainController getInstance() {
    if (instance == null) {
      instance = new MainController();
    }
    return instance;
  }

  public void showEditTerritories() {
    territorySelector = new EditarTerritorio(mainScreen, "Registro de Territorios", 600,
        350, false);
    territorySelector.setVisible(true);
  }

  public JFrame getMainScreen() {
    if (mainScreen == null) {
      mainScreen = new Principal("Parque La Libertad", 750, 500, false, true);
    }
    return mainScreen;
  }

  public void showMainScreen() {
    getMainScreen().setVisible(true);
  }

  public void showAddPais() {
    JDialog now = new AgregarPais(mainScreen, "Agregar país", 600, 600, false);
    now.setVisible(true);
  }

  public void showEditPais() {
    JDialog now = new EditarPais(mainScreen, "Editar país", 600, 600, false);
    now.setVisible(true);
  }

  public void testSelectFont(String desiredType) {
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

  public Integer testBuscarPersonaTerritorio() {
    try {
      QueryController.openConnection();
      assertThat(QueryController.isConnected()).isTrue();
      FiltroTerritorio now = new FiltroTerritorio(mainScreen, "Buscar Personas", 600, 600,
          false);
      now.setVisible(true);
      // A partir de aquí asume que la ventana seguirá en memoria después de ser
      // desplegada y cerrada:
      Integer id = now.getSelectedPersonaID();
      JOptionPane.showMessageDialog(mainScreen,
          "ID Seleccionado: " + now.getSelectedPersonaID());
      QueryController.closeConnection();
      return id;
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(mainScreen, e.getMessage(),
          "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
      return -1;
    }
  }

  public Integer testBuscarPersonaRangosFechas() {
    try {
      QueryController.openConnection();
      assertThat(QueryController.isConnected()).isTrue();
      FiltroRangoFechaRegistro now = new FiltroRangoFechaRegistro(mainScreen,
          "Buscar Personas", 600, 600, false);
      now.setVisible(true);
      // A partir de aquí asume que la ventana seguirá en memoria después de ser
      // desplegada y cerrada:
      Integer id = now.getSelectedPersonaID();
      JOptionPane.showMessageDialog(mainScreen,
          "ID Seleccionado: " + now.getSelectedPersonaID());
      QueryController.closeConnection();
      return id;
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(mainScreen, e.getMessage(),
          "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
      return -1;
    }
  }

  public Integer selectDistrito(String prompt) {
    try {
      assertThat(QueryController.isConnected()).isTrue();
      // No es cualquier JDialog:
      FiltroDistrito now = new FiltroDistrito(mainScreen, prompt, 725, 520, true);
      now.setVisible(true);
      // A partir de aquí asume que la ventana seguirá en memoria después de ser
      // desplegada y cerrada:
      Integer id = now.getSelectedDistritoID();
      // JOptionPane.showMessageDialog(mainScreen, "ID Seleccionado: " + id);
      // QueryController.closeConnection();
      return id;
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(mainScreen, e.getMessage(),
          "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
      return -1;
    }
  }

  public void showAgregarPersona() {
    try {
      QueryController.openConnection();
      assertThat(QueryController.isConnected()).isTrue();
      AgregarPersona now = new AgregarPersona(mainScreen, "Parque La Libertad", 700, 600,
          false);
      now.setVisible(true);
      
    } catch (HeadlessException | SQLException e) {
      JOptionPane.showMessageDialog(mainScreen, e.getMessage(),
          "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void showAgregarCurso() {
    try {
      QueryController.openConnection();
      assertThat(QueryController.isConnected()).isTrue();
      JDialog now = new AgregarCurso(mainScreen, "Agregar Curso", 450, 600, false);
      now.setVisible(true);
      QueryController.closeConnection();
    } catch (HeadlessException | SQLException e) {
      JOptionPane.showMessageDialog(mainScreen, e.getMessage(),
          "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void showAgregarActividad() {
    try {
      QueryController.openConnection();
      assertThat(QueryController.isConnected()).isTrue();
      JDialog now = new AgregarActividad(mainScreen, "Agregar Actividad", 400,
          250, false);
      now.setVisible(true);
      QueryController.closeConnection();
    } catch (HeadlessException | SQLException e) {
      JOptionPane.showMessageDialog(mainScreen, e.getMessage(),
          "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  public void showMatricula() {
    try {
      QueryController.openConnection();
      assertThat(QueryController.isConnected()).isTrue();
      JDialog now = new Matricula(mainScreen, "Matrícula de Estudiantes", 500,
          500, false);
      now.setVisible(true);
      QueryController.closeConnection();
    } catch (HeadlessException | SQLException e) {
      JOptionPane.showMessageDialog(mainScreen, e.getMessage(),
          "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
    }
  }
  public void showAlumnos() {
    try {
      QueryController.openConnection();
      assertThat(QueryController.isConnected()).isTrue();
      JDialog now = new FiltroAlumnos(mainScreen, "Matrícula de Estudiantes", 500,
          500, false);
      now.setVisible(true);
      QueryController.closeConnection();
    } catch (HeadlessException | SQLException e) {
      JOptionPane.showMessageDialog(mainScreen, e.getMessage(),
          "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void showPromoverPersona() {
    JDialog now = new PromoverPersona(mainScreen, "Agregar Curso", 500, 520, true);
    now.setVisible(true);
  }

  public void showControlCursos() {
    try {
      QueryController.openConnection();
      assertThat(QueryController.isConnected()).isTrue();
      JDialog now = new ControlCursos(mainScreen, "Panel de Control de Cursos", 725, 520, false);
      now.setVisible(true);
      QueryController.closeConnection();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(mainScreen, e.getMessage(),
          "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void showBuscarPersonas() {
    try {
      QueryController.openConnection();
      assertThat(QueryController.isConnected()).isTrue();
      JDialog now = new FiltroPersona(mainScreen, "Búsqueda General de Personas", 800, 550, false);
      now.setVisible(true);
      QueryController.closeConnection();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(mainScreen, e.getMessage(),
          "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void showRankingVisitantes() {
    try {
      QueryController.openConnection();
      assertThat(QueryController.isConnected()).isTrue();
      JDialog now = new RankingVisitas(mainScreen, "Ranking de Visitantes", 800, 550, false);
      now.setVisible(true);
      QueryController.closeConnection();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(mainScreen, e.getMessage(),
          "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
    }
  }

}

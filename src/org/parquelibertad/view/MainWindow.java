/**
 * 
 */
package org.parquelibertad.view;

import java.awt.HeadlessException;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.parquelibertad.controller.MainController;
import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.view
 * @author Luis Andrés Peña Castillo 2014057250
 * Derechos reservados bajo licencia MIT.
 *
 */
public class MainWindow extends WindowTemplate {
  private JMenuBar menuBar;
  private JMenu menuEdit;
  private JMenuItem mntmTerritorios;

  /**
   * @param windowName
   * @param width
   * @param height
   * @param isVisible
   * @param isResizable
   * @throws HeadlessException
   */
  public MainWindow(String windowName, int width, int height, boolean isVisible,
      boolean isResizable) throws HeadlessException {
    super(windowName, width, height, isVisible, isResizable);
    
    this.menuBar = new JMenuBar();
    setJMenuBar(this.menuBar);
    
    this.menuEdit = new JMenu("Editar...");
    this.menuEdit.setFont(FontController.getBoldLabelFont());
    this.menuBar.add(this.menuEdit);
    
    this.mntmTerritorios = new JMenuItem("Territorios");
    this.mntmTerritorios.addActionListener(event->MainController.getInstance().showEditTerritories());
    this.mntmTerritorios.setFont(FontController.getBoldLabelFont());
    this.menuEdit.add(this.mntmTerritorios);
    
  }
  
}

/**
 * 
 */
package org.parquelibertad.view;

import java.awt.HeadlessException;

import javax.swing.JDialog;

import org.parquelibertad.controller.design.DesignController;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.view
 * @author Luis Andrés Peña Castillo 2014057250
 * Derechos reservados bajo licencia MIT.
 *
 */
@SuppressWarnings("serial")
public class DialogTemplate extends JDialog {
  public DialogTemplate(String windowName, int width, int height, boolean isVisible,
      boolean isResizable) throws HeadlessException {
    super();
    setTitle(windowName);
    getContentPane().setBackground(DesignController.getWindowBGColor());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(width, height);
    setVisible(isVisible);
    setResizable(isResizable);
  }

}

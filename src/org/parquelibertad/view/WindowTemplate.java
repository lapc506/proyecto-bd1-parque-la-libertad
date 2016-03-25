/**
 * 
 */
package org.parquelibertad.view;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import org.parquelibertad.controller.DesignStyles;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.view
 * 
 * @author Luis Andrés Peña Castillo 2014057250
 *         Derechos reservados bajo licencia MIT.
 *
 */
@SuppressWarnings("serial")
public class WindowTemplate extends JFrame {
  private final String windowName;

  /**
   * @param windowName
   * @throws HeadlessException
   */
  public WindowTemplate(String windowName, String hexColor, int width, int height,
      boolean isVisible, boolean isResizable) throws HeadlessException {
    super();
    this.windowName = windowName;
    setTitle(this.windowName);
    setBackground(DesignStyles.getHexColor(hexColor));
    getContentPane().setBackground(DesignStyles.windowBGColor);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(width, height);
    setVisible(isVisible);
    setResizable(isResizable);
  }

}

/**
 * 
 */
package org.parquelibertad.view;

import java.awt.HeadlessException;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.parquelibertad.controller.DesignStyles;

import java.awt.Font;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.view
 * @author Luis Andrés Peña Castillo 2014057250
 * Derechos reservados bajo licencia MIT.
 *
 */
public class TerritoryRegistrationForm extends WindowTemplate {

  /**
   * @param windowName
   * @param hexColor
   * @param width
   * @param height
   * @param isVisible
   * @param isResizable
   * @throws HeadlessException
   */
  public TerritoryRegistrationForm(String windowName, String hexColor, int width,
      int height, boolean isVisible, boolean isResizable) throws HeadlessException {
    super(windowName, hexColor, width, height, isVisible, isResizable);
    getContentPane().setLayout(new BorderLayout(0, 0));
    
    JLabel lblRegistroDeTerritorios = new JLabel("Registro de Territorios");
    lblRegistroDeTerritorios.setFont(DesignStyles.Fonts.get(""));
    lblRegistroDeTerritorios.setHorizontalAlignment(SwingConstants.CENTER);
    getContentPane().add(lblRegistroDeTerritorios, BorderLayout.NORTH);
    
  }

}

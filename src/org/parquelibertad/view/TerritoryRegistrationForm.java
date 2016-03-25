/**
 * 
 */
package org.parquelibertad.view;

import java.awt.HeadlessException;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.parquelibertad.controller.DesignStyles;
import org.parquelibertad.controller.FontController;

import java.awt.Font;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.view
 * @author Luis Andrés Peña Castillo 2014057250
 * Derechos reservados bajo licencia MIT.
 *
 */
@SuppressWarnings("serial")
public class TerritoryRegistrationForm extends WindowTemplate {
  private JLabel lblRegistroDeTerritorios;

  public TerritoryRegistrationForm(String windowName, String hexColor, int width,
      int height, boolean isVisible, boolean isResizable) throws HeadlessException {
    super(windowName, hexColor, width, height, isVisible, isResizable);
    getContentPane().setLayout(new BorderLayout(10, 10));
    
    this.lblRegistroDeTerritorios = new JLabel("Registro de Territorios");
    if (FontController.getTitleFont() != null){
      this.lblRegistroDeTerritorios.setFont(FontController.getTitleFont());
    }
    this.lblRegistroDeTerritorios.setHorizontalAlignment(SwingConstants.CENTER);
    this.lblRegistroDeTerritorios.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    getContentPane().add(this.lblRegistroDeTerritorios, BorderLayout.NORTH);
    
  }

}

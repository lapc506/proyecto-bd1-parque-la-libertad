/**
 * 
 */
package org.parquelibertad.view;

import java.awt.HeadlessException;
import java.util.Vector;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.parquelibertad.controller.DesignStyles;
import org.parquelibertad.controller.FontController;
import org.parquelibertad.controller.MainController;
import org.parquelibertad.metadata.Filepath;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.view
 * 
 * @author Luis Andr�s Pe�a Castillo 2014057250
 *         Derechos reservados bajo licencia MIT.
 *
 */
@SuppressWarnings("serial")
public class FontSelectorForm extends WindowTemplate {
  private JLabel    lblChooseAFont;
  private JButton   btnSelect;
  private JComboBox<String> comboBox;
  private JSpinner spinner;

  /**
   * @param windowName
   * @param hexColor
   * @param width
   * @param height
   * @param isVisible
   * @param isResizable
   * @throws HeadlessException
   */
  public FontSelectorForm(String windowName, String hexColor, int width, int height,
      boolean isVisible, boolean isResizable, String fontToSelect) {
    super(windowName, hexColor, width, height, isVisible, isResizable);
    getContentPane().setLayout(new BorderLayout(0, 0));

    this.lblChooseAFont = new JLabel("Choose " + fontToSelect + " font: ");
    this.lblChooseAFont.setHorizontalAlignment(SwingConstants.CENTER);
    getContentPane().add(this.lblChooseAFont, BorderLayout.NORTH);

    this.btnSelect = new JButton("Confirm");
    // Lambda function from Java 8
    this.btnSelect.addActionListener(event -> {
      FontController.setFont(fontToSelect, (String) this.comboBox.getSelectedItem(),
          (int) this.spinner.getValue());
      // Rather than making this a modal window, and wait from App.main() this window
      // gets closed, we simply use the same controller singleton:
      MainController.nextBootStep();
      this.dispose();
      MainController.bootstrap();
    });
    getContentPane().add(this.btnSelect, BorderLayout.SOUTH);

    // Filing contents of comboBox with a vector of strings
    // assuming there is at least one available font on project folder
    this.comboBox = new JComboBox<String>(new DefaultComboBoxModel<String>(
        new Vector<String>(Filepath.listAvailableFonts())));
    getContentPane().add(this.comboBox, BorderLayout.CENTER);
    
    this.spinner = new JSpinner();
    this.spinner.setBackground(DesignStyles.getHexColor(hexColor));
    this.spinner.setModel(new SpinnerNumberModel(12, 9, 64, 1));
    getContentPane().add(this.spinner, BorderLayout.EAST);

  }

}

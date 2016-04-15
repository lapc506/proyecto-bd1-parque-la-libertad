/**
 * 
 */
package org.parquelibertad.view.debugDialogs;

import java.awt.HeadlessException;
import java.util.Vector;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.parquelibertad.controller.MainController;
import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.metadata.Filepath;
import org.parquelibertad.view.templates.DialogTemplate;

import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.SpinnerNumberModel;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.view
 * 
 * @author Luis Andrés Peña Castillo 2014057250
 *         Derechos reservados bajo licencia MIT.
 *
 */
@SuppressWarnings("serial")
public class FontSelectorForm extends DialogTemplate {
  private JLabel            lblChooseAFont;
  private JButton           btnSelect;
  private JComboBox<String> comboBox;
  private JSpinner          spinner;

  public FontSelectorForm(String windowName, int width, int height, boolean isResizable,
      String fontToSelect) {
    super(null, windowName, width, height, isResizable);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    getContentPane().setLayout(new BorderLayout(0, 0));

    this.lblChooseAFont = new JLabel("Choose " + fontToSelect + " font: ");
    this.lblChooseAFont.setHorizontalAlignment(SwingConstants.CENTER);
    getContentPane().add(this.lblChooseAFont, BorderLayout.NORTH);

    this.btnSelect = new JButton("Confirm");
    // Lambda function from Java 8
    this.btnSelect.addActionListener(event -> {
      FontController.setFont(fontToSelect, (String) this.comboBox.getSelectedItem(),
          (int) this.spinner.getValue());
      this.dispose(); // This is now a modal window, this window simply gets closed.
    });
    getContentPane().add(this.btnSelect, BorderLayout.SOUTH);

    // Filing contents of comboBox with a vector of strings
    // assuming there is at least one available font on project folder
    this.comboBox = new JComboBox<String>(new DefaultComboBoxModel<String>(
        new Vector<String>(Filepath.listAvailableFonts())));
    getContentPane().add(this.comboBox, BorderLayout.CENTER);

    this.spinner = new JSpinner();
    this.spinner.setBackground(DesignController.getWindowBGColor());
    this.spinner.setModel(new SpinnerNumberModel(12, 9, 64, 1));
    getContentPane().add(this.spinner, BorderLayout.EAST);

  }

}

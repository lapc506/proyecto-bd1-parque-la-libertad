/**
 * Ventana donde se pueden editar e inclu�r nuevos territorios en el sistema.
 * Esta ventana debe contectarse a la base de datos para cada consulta y
 * edici�n.
 * 
 */
package org.parquelibertad.view.adminEdit;

import java.awt.HeadlessException;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.view.DialogTemplate;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSeparator;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.view
 * 
 * @author Luis Andr�s Pe�a Castillo 2014057250
 *         Derechos reservados bajo licencia MIT.
 *
 */
@SuppressWarnings("serial")
public class AddPaisDialog extends DialogTemplate {
  private JLabel            lblSeleccion;
  private JPanel            contentPane;
  private JPanel            paisPanel;
  private JPanel            confirmPanel;
  private JButton           btnCerrar;
  private JButton btnAgregar;
  private JTextField selectedTextEdit;

  public AddPaisDialog(JFrame parent, String windowName, int width, int height, 
      boolean isResizable) throws HeadlessException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setLayout(new BorderLayout(0, 0));

    this.lblSeleccion = new JLabel("Seleccione pa\u00EDs por agregar:");
    this.lblSeleccion.setFont(FontController.getSubtitleFont());
    this.lblSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
    this.lblSeleccion.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    getContentPane().add(this.lblSeleccion, BorderLayout.NORTH);

    this.contentPane = new JPanel();
    this.contentPane.setBackground(DesignController.getWindowBGColor());
    getContentPane().add(this.contentPane, BorderLayout.CENTER);
    this.contentPane.setLayout(new BoxLayout(this.contentPane, BoxLayout.Y_AXIS));

    this.paisPanel = new JPanel();
    this.paisPanel
        .setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null),
            "Pa\u00EDs", TitledBorder.LEADING, TitledBorder.TOP,
            FontController.getBoldLabelFont(), DesignController.getFontColor()));
    this.paisPanel.setBackground(DesignController.getWindowBGColor());
    this.contentPane.add(this.paisPanel);
        this.paisPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        this.selectedTextEdit = new JTextField();
        this.paisPanel.add(this.selectedTextEdit);
        this.selectedTextEdit.setColumns(20);
        
        this.btnAgregar = new JButton("Agregar");
        this.paisPanel.add(this.btnAgregar);

    this.confirmPanel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) this.confirmPanel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    getContentPane().add(this.confirmPanel, BorderLayout.SOUTH);
    this.confirmPanel.setBackground(DesignController.getWindowBGColor());

    this.btnCerrar = new JButton("Cerrar");
    this.btnCerrar.setFont(FontController.getRegularLabelFont());
    this.btnCerrar.addActionListener(event -> this.dispose());
    this.confirmPanel.add(this.btnCerrar);

    revalidate();
    repaint();
  }
}
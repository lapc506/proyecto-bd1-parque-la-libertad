package org.parquelibertad.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.view.jmodels.JDatabaseText;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class AgregarActividad extends DialogTemplate {

  /**
   * @param parent
   * @param windowName
   * @param width
   * @param height
   * @param isResizable
   * @throws HeadlessException
   */
  private JFrame        frame;
  private JDatabaseText txtDescripcion;
  private JDatabaseText textField_1;
  private JPanel        panelDetalles;

  public AgregarActividad(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setBackground(DesignController.getWindowBGColor());
    getContentPane().setLayout(null);

    JPanel panel = new JPanel();
    panel.setForeground(new Color(255, 255, 0));
    panel.setBackground(new Color(0, 0, 0));
    panel.setName("");
    panel.setFocusable(false);
    panel.setOpaque(false);
    LineBorder colorTitledBorder = (new LineBorder(new Color(255, 255, 0)));
    panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Actividad",
        TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16),
        null));
    panel.setBounds(10, 11, 630, 699);
    getContentPane().add(panel);
    panel.setLayout(null);

    JButton btnNewButton = new JButton("Registrar");
    btnNewButton.setBounds(261, 665, 125, 23);
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
    panel.add(btnNewButton);

    JPanel panel_1 = new JPanel();
    panel_1.setLayout(null);
    panel_1.setOpaque(false);
    panel_1.setName("");
    panel_1.setForeground(Color.YELLOW);
    panel_1.setFocusable(false);
    panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Filtros",
        TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16),
        null));
    panel_1.setBackground(Color.BLACK);
    panel_1.setBounds(26, 219, 594, 253);
    panel.add(panel_1);

    JLabel label_2 = new JLabel("Nombre");
    label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
    label_2.setBounds(10, 24, 75, 27);
    panel_1.add(label_2);

    JLabel label_3 = new JLabel("Primer Apellido");
    label_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
    label_3.setBounds(199, 24, 167, 27);
    panel_1.add(label_3);

    JLabel label_4 = new JLabel("Segundo Apellido");
    label_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
    label_4.setBounds(392, 24, 144, 27);
    panel_1.add(label_4);

    JComboBox comboBox_2 = new JComboBox();
    comboBox_2.setBounds(392, 62, 184, 44);
    panel_1.add(comboBox_2);

    JComboBox comboBox_3 = new JComboBox();
    comboBox_3.setBounds(10, 62, 184, 44);
    panel_1.add(comboBox_3);

    JComboBox comboBox_4 = new JComboBox();
    comboBox_4.setBounds(199, 62, 184, 44);
    panel_1.add(comboBox_4);

    JLabel lblTipoDeIdentificacin = new JLabel("Tipo de Identificaci\u00F3n");
    lblTipoDeIdentificacin.setFont(new Font("Tahoma", Font.PLAIN, 17));
    lblTipoDeIdentificacin.setBounds(10, 117, 184, 27);
    panel_1.add(lblTipoDeIdentificacin);

    JLabel lblIdentificacin = new JLabel("Identificaci\u00F3n");
    lblIdentificacin.setFont(new Font("Tahoma", Font.PLAIN, 17));
    lblIdentificacin.setBounds(251, 117, 184, 27);
    panel_1.add(lblIdentificacin);

    JComboBox comboBox_5 = new JComboBox();
    comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
    comboBox_5.setBounds(10, 155, 237, 42);
    panel_1.add(comboBox_5);

    textField_1 = new JDatabaseText(10);
    textField_1.setBounds(251, 155, 325, 42);
    panel_1.add(textField_1);
    textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
    textField_1.setColumns(10);

    JButton btnFiltrar = new JButton("Filtrar");
    btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
    btnFiltrar.setBounds(238, 208, 106, 34);
    panel_1.add(btnFiltrar);

    JPanel panel_2 = new JPanel();
    panel_2.setLayout(null);
    panel_2.setOpaque(false);
    panel_2.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Días",
        TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16),
        null));
    panel_2.setBounds(26, 483, 295, 171);
    panel.add(panel_2);

    JCheckBox checkBox = new JCheckBox("Lunes");
    checkBox.setOpaque(false);
    checkBox.setBounds(6, 46, 97, 23);
    panel_2.add(checkBox);

    JCheckBox checkBox_1 = new JCheckBox("Jueves");
    checkBox_1.setOpaque(false);
    checkBox_1.setBounds(6, 81, 97, 23);
    panel_2.add(checkBox_1);

    JCheckBox checkBox_2 = new JCheckBox("Domingo");
    checkBox_2.setOpaque(false);
    checkBox_2.setBounds(103, 117, 97, 23);
    panel_2.add(checkBox_2);

    JCheckBox checkBox_3 = new JCheckBox("Viernes");
    checkBox_3.setOpaque(false);
    checkBox_3.setBounds(103, 81, 97, 23);
    panel_2.add(checkBox_3);

    JCheckBox checkBox_4 = new JCheckBox("Martes");
    checkBox_4.setOpaque(false);
    checkBox_4.setBounds(103, 46, 97, 23);
    panel_2.add(checkBox_4);

    JCheckBox checkBox_5 = new JCheckBox("Mi\u00E9rcoles");
    checkBox_5.setOpaque(false);
    checkBox_5.setBounds(214, 46, 90, 23);
    panel_2.add(checkBox_5);

    JCheckBox checkBox_6 = new JCheckBox("S\u00E1bado");
    checkBox_6.setOpaque(false);
    checkBox_6.setBounds(214, 81, 74, 23);
    panel_2.add(checkBox_6);

    JPanel panel_3 = new JPanel();
    panel_3.setLayout(null);
    panel_3.setOpaque(false);
    panel_3.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Horario",
        TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16),
        null));
    panel_3.setBounds(331, 483, 222, 171);
    panel.add(panel_3);

    JSpinner spinner = new JSpinner();
    spinner.setBounds(47, 56, 53, 20);
    panel_3.add(spinner);

    JSpinner spinner_1 = new JSpinner();
    spinner_1.setBounds(47, 114, 53, 20);
    panel_3.add(spinner_1);

    JLabel label = new JLabel(":");
    label.setFont(new Font("Tahoma", Font.PLAIN, 17));
    label.setBounds(106, 108, 14, 27);
    panel_3.add(label);

    JLabel label_1 = new JLabel("a");
    label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
    label_1.setBounds(106, 76, 14, 27);
    panel_3.add(label_1);

    JLabel label_6 = new JLabel(":");
    label_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
    label_6.setBounds(106, 50, 14, 27);
    panel_3.add(label_6);

    JSpinner spinner_2 = new JSpinner();
    spinner_2.setBounds(120, 56, 53, 20);
    panel_3.add(spinner_2);

    JSpinner spinner_3 = new JSpinner();
    spinner_3.setBounds(120, 114, 53, 20);
    panel_3.add(spinner_3);

    this.panelDetalles = new JPanel();
    this.panelDetalles.setBounds(671, 78, 152, 170);
    getContentPane().add(this.panelDetalles);

    JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
    this.panelDetalles.add(lblDescripcion);
    lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 17));

    txtDescripcion = new JDatabaseText(30);
    this.panelDetalles.add(this.txtDescripcion);
    txtDescripcion.setColumns(10);

    JLabel lblNombreDeLa = new JLabel("Tipo de Actividad");
    this.panelDetalles.add(lblNombreDeLa);
    lblNombreDeLa.setFont(new Font("Tahoma", Font.PLAIN, 17));

    JComboBox comboBox_1 = new JComboBox();
    this.panelDetalles.add(comboBox_1);

    JLabel lblProfesor = new JLabel("Profesor");
    this.panelDetalles.add(lblProfesor);
    lblProfesor.setFont(new Font("Tahoma", Font.PLAIN, 17));

    JComboBox comboBox = new JComboBox();
    this.panelDetalles.add(comboBox);

    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setResizable(false);
    setVisible(true);
  }
}

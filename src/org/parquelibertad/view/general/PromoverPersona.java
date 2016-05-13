package org.parquelibertad.view.general;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import org.jdatepicker.JDatePanel;
import static org.assertj.core.api.Assertions.*;
import org.parquelibertad.controller.MainController;
import org.parquelibertad.controller.QueryController;
import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.model.LibertadDatabaseConstraints;
import org.parquelibertad.view.jmodels.JDatabaseText;
import org.parquelibertad.view.templates.DialogTemplate;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;

public class PromoverPersona extends DialogTemplate {
  private static final long serialVersionUID = 3125118100972900974L;
  private JPanel            panelAcciones;
  private JButton           btnConfirmarPromocion;
  private JPanel            panelContenido;
  private JRadioButton      rdbtnEmpleado;
  private JPanel            panelOpcionesEmpleado;
  private JLabel            lblTipo;
  private JComboBox<String> comboTipoEmpleado;
  private JLabel            lblNombreDeUsuario;
  private JTextField        txtNombreUsuario;
  private JLabel            lblContrasena;
  private JDatabaseText     txtContrasena;
  private JRadioButton      rdbtnAlumno;
  private JPanel            panelOpcionesAlumno;
  private JLabel            lblFechaMatricula;
  private JLabel            label5;
  private final ButtonGroup buttonGroup      = new ButtonGroup();
  private JPanel            panelOpciones;
  private JTextField        selectedPersona;
  private Vector<Object>    selectedPersonaData;
  private Vector<Integer>   idsTipoEmpleado;
  private JButton           btnFiltrarPersona;
  private JLabel            lblTitulo;
  private JSeparator        separator;
  private JPanel            panelPersona;
  private JSpinner          spinner;

  // Size 350x450 min
  public PromoverPersona(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException, SQLException {
    super(parent, windowName, width, height, isResizable);
    BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
    borderLayout.setHgap(10);
    borderLayout.setVgap(10);

    this.panelContenido = new JPanel();
    this.panelContenido.setOpaque(false);
    getContentPane().add(this.panelContenido, BorderLayout.CENTER);
    this.panelContenido.setLayout(new BoxLayout(this.panelContenido, BoxLayout.Y_AXIS));

    lblTitulo = new JLabel("Promoci\u00F3n de Usuarios");
    lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    lblTitulo.setFont(FontController.getTitleFont());
    getContentPane().add(lblTitulo, BorderLayout.NORTH);

    panelPersona = new JPanel();
    panelPersona.setOpaque(false);
    panelContenido.add(panelPersona);
    GridBagLayout gbl_panelPersona = new GridBagLayout();
    gbl_panelPersona.columnWidths = new int[] {
        275, 125
    };
    gbl_panelPersona.rowHeights = new int[] {
        40
    };
    gbl_panelPersona.columnWeights = new double[] {
        0.0, 1.0
    };
    gbl_panelPersona.rowWeights = new double[] {
        0.0
    };
    panelPersona.setLayout(gbl_panelPersona);

    this.selectedPersona = new JTextField();
    selectedPersona.setFont(FontController.getBoldLabelFont());
    selectedPersona.setEditable(false);
    GridBagConstraints gbc_selectedPersona = new GridBagConstraints();
    gbc_selectedPersona.fill = GridBagConstraints.HORIZONTAL;
    gbc_selectedPersona.insets = new Insets(0, 0, 0, 5);
    gbc_selectedPersona.gridx = 0;
    gbc_selectedPersona.gridy = 0;
    panelPersona.add(selectedPersona, gbc_selectedPersona);

    this.btnFiltrarPersona = new JButton("Filtrar Persona...");
    btnFiltrarPersona.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
          Vector<Object> temp = MainController.getInstance()
              .showBuscarPersonaTerritorio(true);
          assertThat(temp).isNotNull();
          assertThat(temp.get(0)).isNotEqualTo(-1);
          // System.out.println(temp.get(1));
          selectedPersona.setText((String) temp.get(1));
          selectedPersonaData = temp; // Confirmado el guardado seguro.
        } catch (AssertionError e) {
          selectedPersona.setText("");
        }
      }
    });
    this.btnFiltrarPersona.setFont(FontController.getRegularLabelFont());
    GridBagConstraints gbc_btnFiltrarPersona = new GridBagConstraints();
    gbc_btnFiltrarPersona.anchor = GridBagConstraints.WEST;
    gbc_btnFiltrarPersona.gridx = 1;
    gbc_btnFiltrarPersona.gridy = 0;
    panelPersona.add(btnFiltrarPersona, gbc_btnFiltrarPersona);

    separator = new JSeparator();
    panelContenido.add(separator);

    this.panelOpciones = new JPanel();
    this.panelOpciones.setBorder(new TitledBorder(null, "Promover persona al rol de: ",
        TitledBorder.LEADING, TitledBorder.TOP, FontController.getSubtitleFont(), null));
    this.panelOpciones.setOpaque(false);
    this.panelContenido.add(this.panelOpciones);
    GridBagLayout gbl_panelOpciones = new GridBagLayout();
    gbl_panelOpciones.columnWidths = new int[] {
        250
    };
    gbl_panelOpciones.rowHeights = new int[] {
        20, 80, 20, 30
    };
    gbl_panelOpciones.columnWeights = new double[] {
        1.0
    };
    gbl_panelOpciones.rowWeights = new double[] {
        0.0, 0.0, 0.0, 0.0
    };
    panelOpciones.setLayout(gbl_panelOpciones);

    this.rdbtnEmpleado = new JRadioButton("Empleado:");
    GridBagConstraints gbc_rdbtnEmpleado = new GridBagConstraints();
    gbc_rdbtnEmpleado.fill = GridBagConstraints.BOTH;
    gbc_rdbtnEmpleado.insets = new Insets(0, 0, 5, 0);
    gbc_rdbtnEmpleado.gridx = 0;
    gbc_rdbtnEmpleado.gridy = 0;
    buttonGroup.add(this.rdbtnEmpleado);
    this.rdbtnEmpleado.setFont(FontController.getRegularLabelFont());
    this.rdbtnEmpleado.setSelected(true);
    this.rdbtnEmpleado.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent arg0) {
        spinner.setEnabled(!rdbtnEmpleado.isSelected());
      }
    });
    this.rdbtnEmpleado.setBackground(DesignController.getWindowBGColor());
    panelOpciones.add(rdbtnEmpleado, gbc_rdbtnEmpleado);

    this.panelOpcionesEmpleado = new JPanel();
    GridBagConstraints gbc_panelOpcionesEmpleado = new GridBagConstraints();
    gbc_panelOpcionesEmpleado.fill = GridBagConstraints.BOTH;
    gbc_panelOpcionesEmpleado.insets = new Insets(0, 0, 5, 0);
    gbc_panelOpcionesEmpleado.gridx = 0;
    gbc_panelOpcionesEmpleado.gridy = 1;
    panelOpciones.add(panelOpcionesEmpleado, gbc_panelOpcionesEmpleado);
    this.panelOpcionesEmpleado.setBackground(DesignController.getWindowBGColor());
    this.panelOpcionesEmpleado.setLayout(new GridLayout(0, 2, 10, 2));

    this.lblTipo = new JLabel("Tipo:");
    this.lblTipo.setFont(FontController.getRegularLabelFont());
    this.panelOpcionesEmpleado.add(this.lblTipo);

    this.comboTipoEmpleado = new JComboBox<String>();
    this.comboTipoEmpleado.setFont(FontController.getRegularLabelFont());
    this.panelOpcionesEmpleado.add(this.comboTipoEmpleado);

    this.lblNombreDeUsuario = new JLabel("Nombre de Usuario");
    this.lblNombreDeUsuario.setFont(FontController.getRegularLabelFont());
    this.panelOpcionesEmpleado.add(this.lblNombreDeUsuario);

    this.txtNombreUsuario = new JDatabaseText(
        LibertadDatabaseConstraints.CuentaUsuario_usuario_VARCHAR2);
    this.txtNombreUsuario.setColumns(10);
    this.panelOpcionesEmpleado.add(this.txtNombreUsuario);

    this.lblContrasena = new JLabel("Contrase\u00F1a");
    this.lblContrasena.setFont(FontController.getRegularLabelFont());
    this.panelOpcionesEmpleado.add(this.lblContrasena);

    this.txtContrasena = new JDatabaseText(
        LibertadDatabaseConstraints.CuentaUsuario_contrasena_VARCHAR2);
    this.txtContrasena.setColumns(10);
    this.panelOpcionesEmpleado.add(this.txtContrasena);

    this.rdbtnAlumno = new JRadioButton("Alumno");
    GridBagConstraints gbc_rdbtnAlumno = new GridBagConstraints();
    gbc_rdbtnAlumno.fill = GridBagConstraints.BOTH;
    gbc_rdbtnAlumno.insets = new Insets(0, 0, 5, 0);
    gbc_rdbtnAlumno.gridx = 0;
    gbc_rdbtnAlumno.gridy = 2;
    buttonGroup.add(this.rdbtnAlumno);
    rdbtnAlumno.setFont(FontController.getRegularLabelFont());
    rdbtnAlumno.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent arg0) {
        comboTipoEmpleado.setEnabled(!rdbtnAlumno.isSelected());
        txtNombreUsuario.setEnabled(!rdbtnAlumno.isSelected());
        txtContrasena.setEnabled(!rdbtnAlumno.isSelected());
      }
    });
    this.rdbtnAlumno.setBackground(DesignController.getWindowBGColor());
    panelOpciones.add(rdbtnAlumno, gbc_rdbtnAlumno);

    this.panelOpcionesAlumno = new JPanel();
    GridBagConstraints gbc_panelOpcionesAlumno = new GridBagConstraints();
    gbc_panelOpcionesAlumno.fill = GridBagConstraints.BOTH;
    gbc_panelOpcionesAlumno.gridx = 0;
    gbc_panelOpcionesAlumno.gridy = 3;
    panelOpciones.add(panelOpcionesAlumno, gbc_panelOpcionesAlumno);
    this.panelOpcionesAlumno.setBackground(new Color(255, 143, 0));
    this.panelOpcionesAlumno.setLayout(new GridLayout(0, 2, 10, 2));

    this.lblFechaMatricula = new JLabel("Fecha de Matr\u00EDcula");
    this.lblFechaMatricula.setFont(FontController.getRegularLabelFont());
    this.panelOpcionesAlumno.add(this.lblFechaMatricula);

    spinner = new JSpinner();
    spinner.setModel(new SpinnerDateModel(new Date(1451628000000L),
        new Date(1262325600000L), null, Calendar.YEAR));
    spinner.setFont(FontController.getRegularLabelFont());
    panelOpcionesAlumno.add(spinner);

    new GregorianCalendar();

    this.panelAcciones = new JPanel();
    FlowLayout flowLayout = (FlowLayout) this.panelAcciones.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    this.panelAcciones.setBackground(DesignController.getWindowBGColor());
    getContentPane().add(this.panelAcciones, BorderLayout.SOUTH);

    this.btnConfirmarPromocion = new JButton("Confirmar Promoci\u00F3n");
    btnConfirmarPromocion.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
          assertThat(selectedPersonaData).isNotNull();
          Integer idPersona = (Integer) selectedPersonaData.get(0);
          assertThat(rdbtnEmpleado.isSelected() || rdbtnAlumno.isSelected()).isTrue();
          if (rdbtnEmpleado.isSelected()) {
            QueryController.insertarEmpleado(idPersona,
                idsTipoEmpleado.elementAt(comboTipoEmpleado.getSelectedIndex()),
                txtNombreUsuario.getText(), txtContrasena.getText());
          } else if (rdbtnAlumno.isSelected()) {
            QueryController.insertarAlumno(idPersona, (Integer) spinner.getValue());
          }
          dispose();
        } catch (AssertionError e) {
          JOptionPane.showMessageDialog(rootPane,
              "Asegúrese de haber seleccionado a alguien y su respectivo rol."
                  + e.getMessage(),
              "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(rootPane, e.getMessage(),
              "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    this.panelAcciones.add(this.btnConfirmarPromocion);

    JLabel label4 = new JLabel("   ");
    getContentPane().add(label4, BorderLayout.WEST);

    this.label5 = new JLabel("   ");
    getContentPane().add(this.label5, BorderLayout.EAST);

    loadConnection();
  }

  private void loadConnection() throws SQLException {
    HashMap<Integer, String> paises = QueryController.getTiposEmpleado();
    Vector<String> contents = new Vector<String>();
    for (Integer x : paises.keySet()) {
      idsTipoEmpleado.addElement(x);
      contents.addElement(paises.get(x));
    }
    comboTipoEmpleado.setModel(new DefaultComboBoxModel<String>(contents));
  }

}

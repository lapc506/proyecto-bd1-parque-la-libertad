package org.parquelibertad.view.general;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import org.parquelibertad.controller.MainController;
import org.parquelibertad.controller.QueryController;
import org.parquelibertad.controller.design.DesignController;
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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PromoverPersona extends DialogTemplate {
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
  private JDatabaseText     txtFechaMatricula;
  private JLabel            label2;
  private JLabel            label5;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private JPanel            panelSeleccion;
  private JComboBox<String> comboPersonas;
  private JButton           btnFiltrarPersona;

  // Size 350x450 min
  public PromoverPersona(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException {
    super(parent, windowName, width, height, isResizable);
    BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
    borderLayout.setHgap(10);
    borderLayout.setVgap(10);

    this.panelContenido = new JPanel();
    this.panelContenido.setBorder(new TitledBorder(null, "Promover persona a...",
        TitledBorder.LEADING, TitledBorder.TOP, null, null));
    this.panelContenido.setBackground(DesignController.getWindowBGColor());
    getContentPane().add(this.panelContenido, BorderLayout.CENTER);
    this.panelContenido.setLayout(new BoxLayout(this.panelContenido, BoxLayout.Y_AXIS));

    this.panelSeleccion = new JPanel();
    this.panelSeleccion.setBackground(DesignController.getWindowBGColor());
    this.panelSeleccion.setLayout(new GridLayout(0, 2, 10, 0));
    this.panelContenido.add(this.panelSeleccion);

    this.comboPersonas = new JComboBox<String>();
    this.panelSeleccion.add(this.comboPersonas);

    this.btnFiltrarPersona = new JButton("Filtrar Persona...");
    this.btnFiltrarPersona.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent arg0) {
        QueryController.promoverPersona(MainController.getInstance()
            .selectPersona("Seleccione la persona por promover: "));
      }
    });
    this.panelSeleccion.add(this.btnFiltrarPersona);

    this.panelOpcionesEmpleado = new JPanel();
    this.panelContenido.add(this.panelOpcionesEmpleado);
    this.panelOpcionesEmpleado.setBackground(DesignController.getWindowBGColor());
    this.panelOpcionesEmpleado.setLayout(new GridLayout(0, 2, 10, 2));

    this.rdbtnEmpleado = new JRadioButton("Empleado:");
    buttonGroup.add(this.rdbtnEmpleado);
    this.panelOpcionesEmpleado.add(this.rdbtnEmpleado);
    this.rdbtnEmpleado.setSelected(true);
    this.rdbtnEmpleado.setBackground(DesignController.getWindowBGColor());

    JLabel label1 = new JLabel("");
    this.panelOpcionesEmpleado.add(label1);

    this.lblTipo = new JLabel("Tipo:");
    this.panelOpcionesEmpleado.add(this.lblTipo);

    this.comboTipoEmpleado = new JComboBox<String>();
    this.panelOpcionesEmpleado.add(this.comboTipoEmpleado);

    this.lblNombreDeUsuario = new JLabel("Nombre de Usuario");
    this.panelOpcionesEmpleado.add(this.lblNombreDeUsuario);

    this.txtNombreUsuario = new JDatabaseText(
        LibertadDatabaseConstraints.CuentaUsuario_usuario_VARCHAR2);
    this.txtNombreUsuario.setColumns(10);
    this.panelOpcionesEmpleado.add(this.txtNombreUsuario);

    this.lblContrasena = new JLabel("Contrase\u00F1a");
    this.panelOpcionesEmpleado.add(this.lblContrasena);

    this.txtContrasena = new JDatabaseText(
        LibertadDatabaseConstraints.CuentaUsuario_contrasena_VARCHAR2);
    this.txtContrasena.setColumns(10);
    this.panelOpcionesEmpleado.add(this.txtContrasena);

    this.panelOpcionesAlumno = new JPanel();
    this.panelContenido.add(this.panelOpcionesAlumno);
    this.panelOpcionesAlumno.setBackground(new Color(255, 143, 0));
    this.panelOpcionesAlumno.setLayout(new GridLayout(0, 2, 10, 2));

    this.rdbtnAlumno = new JRadioButton("Alumno");
    buttonGroup.add(this.rdbtnAlumno);
    this.panelOpcionesAlumno.add(this.rdbtnAlumno);
    this.rdbtnAlumno.setBackground(DesignController.getWindowBGColor());

    this.label2 = new JLabel("");
    this.panelOpcionesAlumno.add(this.label2);

    this.lblFechaMatricula = new JLabel("Fecha de Matr\u00EDcula");
    this.panelOpcionesAlumno.add(this.lblFechaMatricula);

    this.txtFechaMatricula = new JDatabaseText(20);
    this.txtFechaMatricula.setEnabled(false);
    this.txtFechaMatricula.setEditable(false);
    this.txtFechaMatricula.setColumns(10);
    this.panelOpcionesAlumno.add(this.txtFechaMatricula);

    this.panelAcciones = new JPanel();
    FlowLayout flowLayout = (FlowLayout) this.panelAcciones.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    this.panelAcciones.setBackground(DesignController.getWindowBGColor());
    getContentPane().add(this.panelAcciones, BorderLayout.SOUTH);

    this.btnConfirmarPromocion = new JButton("Confirmar Promoci\u00F3n");
    this.panelAcciones.add(this.btnConfirmarPromocion);

    JLabel label3 = new JLabel(" ");
    getContentPane().add(label3, BorderLayout.NORTH);

    JLabel label4 = new JLabel("   ");
    getContentPane().add(label4, BorderLayout.WEST);

    this.label5 = new JLabel("   ");
    getContentPane().add(this.label5, BorderLayout.EAST);

  }

}

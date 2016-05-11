package org.parquelibertad.view.general;

import javax.swing.JFrame;

import org.parquelibertad.controller.MainController;
import org.parquelibertad.controller.QueryController;
import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.model.LibertadDatabaseConstraints;
import org.parquelibertad.view.jmodels.JDatabaseText;
import org.parquelibertad.view.templates.DialogTemplate;

import javax.swing.JTextField;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarPersona extends DialogTemplate {
  private static final long serialVersionUID = -2946814475281597104L;

  private Integer           selectedDistritoID;

  private JTextField        txtPrimerApellido;
  private JTextField        txtSegundoApellido;
  private JTextField        txtIdentificacion;
  private JTextField        txtDireccionExacta;
  private JLabel            label;
  private JLabel            label_3;
  private JLabel            label_4;
  private JLabel            lblNombre;
  private JLabel            lblPrimerApellido;
  private JLabel            lblSegundoApellido;
  private JTextField        txtNombre;
  private JLabel            lblIdentificacion;
  private JLabel            lblTipoDeIdentificacin;
  private JLabel            lblNacionalidad;
  private JComboBox<String> comboTiposDocumento;
  private JComboBox<String> comboNacionalidad;
  private JLabel            lblPaisResidencia;
  private JPanel            panelActions;
  private JPanel            panelDireccion;
  private JPanel            panelDistrito;
  private JPanel            panelDocumento;
  private JPanel            panelDetalles;
  private Vector<Integer>   idsNacionalidades;
  private Vector<Integer>   idsTiposDocumento;
  private JTextField        txtDistritoResidencia;
  private JLabel            lblRangoDeEdad;
  private JComboBox<String> comboRangosEdad;

  private Vector<Integer>   idsRangosEdad;

  public AgregarPersona(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException, SQLException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setBackground(DesignController.getWindowBGColor());
    getContentPane().setLayout(new BorderLayout(20, 30));
    // ----------------------------------
    label = new JLabel("Registrar nueva Persona");
    this.label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setFont(FontController.getTitleFont());
    getContentPane().add(label, BorderLayout.NORTH);
    // ----------------------------------
    label_3 = new JLabel("  ");
    getContentPane().add(label_3, BorderLayout.WEST);
    // ----------------------------------
    label_4 = new JLabel("  ");
    getContentPane().add(label_4, BorderLayout.EAST);

    JPanel panelContents = new JPanel();
    panelContents.setFocusable(false);
    panelContents.setOpaque(false);
    getContentPane().add(panelContents);
    panelContents.setLayout(new GridLayout(0, 1, 30, 10));

    this.panelDetalles = new JPanel();
    this.panelDetalles.setOpaque(false);
    panelContents.add(this.panelDetalles);
    this.panelDetalles.setLayout(new GridLayout(2, 3, 5, 10));

    lblNombre = new JLabel("Nombre");
    this.lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
    this.panelDetalles.add(this.lblNombre);
    lblNombre.setFont(FontController.getRegularLabelFont());

    lblPrimerApellido = new JLabel("Primer Apellido");
    this.lblPrimerApellido.setHorizontalAlignment(SwingConstants.CENTER);
    this.panelDetalles.add(this.lblPrimerApellido);
    lblPrimerApellido.setFont(FontController.getRegularLabelFont());

    lblSegundoApellido = new JLabel("Segundo Apellido");
    this.lblSegundoApellido.setHorizontalAlignment(SwingConstants.CENTER);
    this.panelDetalles.add(this.lblSegundoApellido);
    lblSegundoApellido.setFont(FontController.getRegularLabelFont());

    txtNombre = new JDatabaseText(LibertadDatabaseConstraints.Persona_nombre_VARCHAR2);
    txtNombre.setFont(FontController.getRegularLabelFont());
    this.panelDetalles.add(this.txtNombre);

    txtPrimerApellido = new JDatabaseText(
        LibertadDatabaseConstraints.Persona_primerApellido_VARCHAR2);
    this.panelDetalles.add(this.txtPrimerApellido);
    txtPrimerApellido.setFont(FontController.getRegularLabelFont());

    txtSegundoApellido = new JDatabaseText(
        LibertadDatabaseConstraints.Persona_segundoApellido_VARCHAR2);
    this.panelDetalles.add(this.txtSegundoApellido);
    txtSegundoApellido.setFont(FontController.getRegularLabelFont());

    this.panelDocumento = new JPanel();
    this.panelDocumento.setOpaque(false);
    panelContents.add(this.panelDocumento);
    this.panelDocumento.setLayout(new GridLayout(2, 3, 5, 10));

    lblIdentificacion = new JLabel("Documento de Identidad Inicial");
    this.lblIdentificacion.setHorizontalAlignment(SwingConstants.CENTER);
    this.panelDocumento.add(this.lblIdentificacion);
    lblIdentificacion.setFont(FontController.getRegularLabelFont());

    lblTipoDeIdentificacin = new JLabel("Tipo de Documento");
    this.lblTipoDeIdentificacin.setHorizontalAlignment(SwingConstants.CENTER);
    this.panelDocumento.add(this.lblTipoDeIdentificacin);
    lblTipoDeIdentificacin.setFont(FontController.getRegularLabelFont());

    this.lblRangoDeEdad = new JLabel("Rango de Edad");
    this.lblRangoDeEdad.setHorizontalAlignment(SwingConstants.CENTER);
    this.lblRangoDeEdad.setFont(FontController.getRegularLabelFont());
    this.panelDocumento.add(this.lblRangoDeEdad);

    lblNacionalidad = new JLabel("Nacionalidad");
    this.lblNacionalidad.setHorizontalAlignment(SwingConstants.CENTER);
    this.panelDocumento.add(this.lblNacionalidad);
    lblNacionalidad.setFont(FontController.getRegularLabelFont());

    txtIdentificacion = new JDatabaseText(
        LibertadDatabaseConstraints.DocumentoIdentidad_numeroIdentidad_NUMBER);
    this.panelDocumento.add(this.txtIdentificacion);
    txtIdentificacion.setFont(FontController.getRegularLabelFont());

    comboTiposDocumento = new JComboBox<String>();
    comboTiposDocumento.setFont(FontController.getRegularLabelFont());
    this.panelDocumento.add(this.comboTiposDocumento);

    this.comboRangosEdad = new JComboBox<String>();
    this.comboRangosEdad.setFont(FontController.getRegularLabelFont());
    this.panelDocumento.add(this.comboRangosEdad);

    comboNacionalidad = new JComboBox<String>();
    this.panelDocumento.add(this.comboNacionalidad);
    comboNacionalidad.setFont(FontController.getRegularLabelFont());

    this.panelDistrito = new JPanel();
    this.panelDistrito.setOpaque(false);
    panelContents.add(this.panelDistrito);
    this.panelDistrito.setLayout(new BorderLayout(10, 10));

    JButton btnSeleccionarDistrito = new JButton("Seleccionar Distrito...");
    btnSeleccionarDistrito.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          selectedDistritoID = MainController.getInstance()
              .selectDistrito("Seleccione el distrito de residencia...");
          if (selectedDistritoID != -1) {
            txtDistritoResidencia
                .setText(QueryController.getDistritoNombre(selectedDistritoID));
          }
        } catch (SQLException e1) {
          JOptionPane.showMessageDialog(rootPane, e1.getMessage(),
              "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    this.panelDistrito.add(btnSeleccionarDistrito, BorderLayout.WEST);
    btnSeleccionarDistrito.setFont(FontController.getBoldLabelFont());

    txtDistritoResidencia = new JDatabaseText(
        LibertadDatabaseConstraints.Distrito_descripcion_VARCHAR2);
    txtDistritoResidencia.setEditable(false);
    this.panelDistrito.add(txtDistritoResidencia, BorderLayout.CENTER);
    txtDistritoResidencia.setFont(FontController.getRegularLabelFont());

    lblPaisResidencia = new JLabel("Distrito de Residencia");
    this.panelDistrito.add(this.lblPaisResidencia, BorderLayout.NORTH);
    this.lblPaisResidencia.setHorizontalAlignment(SwingConstants.CENTER);
    lblPaisResidencia.setFont(FontController.getRegularLabelFont());

    this.panelDireccion = new JPanel();
    this.panelDireccion.setOpaque(false);
    panelContents.add(this.panelDireccion);
    this.panelDireccion.setLayout(new BorderLayout(10, 10));

    JLabel lblDireccionExacta = new JLabel("Direcci\u00F3n Exacta");
    lblDireccionExacta.setHorizontalAlignment(SwingConstants.CENTER);
    this.panelDireccion.add(lblDireccionExacta, BorderLayout.NORTH);
    lblDireccionExacta.setFont(FontController.getRegularLabelFont());

    txtDireccionExacta = new JDatabaseText(
        LibertadDatabaseConstraints.Persona_direccionExacta_VARCHAR2);
    txtDireccionExacta.setFont(FontController.getRegularLabelFont());
    this.panelDireccion.add(this.txtDireccionExacta);

    this.panelActions = new JPanel();
    FlowLayout fl_panelActions = (FlowLayout) this.panelActions.getLayout();
    fl_panelActions.setAlignment(FlowLayout.RIGHT);
    this.panelActions.setOpaque(false);
    getContentPane().add(this.panelActions, BorderLayout.SOUTH);

    JButton btnRegistrar = new JButton("Registrar");
    btnRegistrar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
          QueryController.insertarPersona(txtNombre.getText(),
              txtPrimerApellido.getText(),
              txtSegundoApellido.getText(),
              Integer.getInteger(txtIdentificacion.getText()),
              idsTiposDocumento.elementAt(comboTiposDocumento.getSelectedIndex()),
              idsRangosEdad.elementAt(comboRangosEdad.getSelectedIndex()),
              idsNacionalidades.elementAt(comboNacionalidad.getSelectedIndex()),
              selectedDistritoID,
              txtDireccionExacta.getText());
          dispose();
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(rootPane, e.getMessage(),
              "Error a la hora de confirmar inserción.", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    btnRegistrar.setFont(FontController.getSubtitleFont());
    this.panelActions.add(btnRegistrar);
    loadConnections();
  }

  private void loadConnections() throws SQLException {
    idsTiposDocumento = new Vector<Integer>();
    HashMap<Integer, String> tiposDocumentos = QueryController.getTiposDocumento();
    Vector<String> textTipos = new Vector<String>();
    for (Integer x : tiposDocumentos.keySet()) {
      idsTiposDocumento.addElement(x);
      textTipos.addElement(tiposDocumentos.get(x));
    }
    this.comboTiposDocumento.setModel(new DefaultComboBoxModel<String>(textTipos));

    idsNacionalidades = new Vector<Integer>();
    HashMap<Integer, String> nacionalidades = QueryController.getNacionalidades();
    Vector<String> textNacs = new Vector<String>();
    for (Integer x : nacionalidades.keySet()) {
      idsNacionalidades.addElement(x);
      textNacs.addElement(nacionalidades.get(x));
    }
    this.comboNacionalidad.setModel(new DefaultComboBoxModel<String>(textNacs));

    idsRangosEdad = new Vector<Integer>();
    HashMap<Integer, String> rangos = QueryController.getRangosEdad();
    Vector<String> textRangos = new Vector<String>();
    for (Integer x : rangos.keySet()) {
      idsRangosEdad.addElement(x);
      textRangos.addElement(rangos.get(x));
    }
    this.comboRangosEdad.setModel(new DefaultComboBoxModel<String>(textRangos));
  }
}

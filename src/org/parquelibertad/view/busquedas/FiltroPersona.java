package org.parquelibertad.view.busquedas;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.parquelibertad.controller.MainController;
import org.parquelibertad.controller.QueryController;
import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.model.LibertadDatabaseConstraints;
import org.parquelibertad.view.jmodels.JDatabaseText;
import org.parquelibertad.view.templates.DialogTemplate;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class FiltroPersona extends DialogTemplate {
  private static final long serialVersionUID = 5606586311814273552L;
  private JPanel            content;
  private JButton           btnBuscar;
  private JPanel            panelBusqueda;
  private JLabel            lblIdentificacion;
  private JComboBox<String> comboTipoIdentificacion;
  private JLabel            lblNombre;
  private JTextField        txtNombre;
  private JComboBox<String> comboAtributos;
  private JTextField        txtIdentificacion;
  private JPanel            panelTop;

  private JPanel            actions;
  private JButton           btnSeleccionar;
  private Integer           selectedPersonaID;
  private JButton           btnConfirmar;
  private JScrollPane       scrollBusqueda;
  private JTable            tablePersona;

  // Size 600 x 350 min
  public FiltroPersona(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setLayout(new BorderLayout(0, 0));

    content = new JPanel();
    content.setBackground(DesignController.getWindowBGColor());
    content.setBorder(new TitledBorder(null, "Seleccionar persona:", TitledBorder.LEADING,
        TitledBorder.TOP, null, null));
    getContentPane().add(content, BorderLayout.CENTER);
    content.setLayout(new BorderLayout(0, 0));

    panelTop = new JPanel();
    panelTop.setBackground(DesignController.getWindowBGColor());
    content.add(panelTop, BorderLayout.NORTH);
    panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.Y_AXIS));

    this.panelBusqueda = new JPanel();
    panelTop.add(panelBusqueda);
    this.panelBusqueda.setBackground(DesignController.getWindowBGColor());
    panelBusqueda.setLayout(new GridLayout(0, 3, 5, 0));

    lblIdentificacion = new JLabel("Identidad de tipo...");

    lblIdentificacion.setFont(FontController.getRegularLabelFont());
    lblIdentificacion.setBackground(DesignController.getWindowBGColor());
    panelBusqueda.add(lblIdentificacion);

    comboTipoIdentificacion = new JComboBox<String>();
    comboTipoIdentificacion.setFont(FontController.getRegularLabelFont());
    panelBusqueda.add(comboTipoIdentificacion);

    txtIdentificacion = new JDatabaseText(
        LibertadDatabaseConstraints.DocumentoIdentidad_numeroIdentidad_NUMBER);
    txtIdentificacion.setColumns(10);
    panelBusqueda.add(txtIdentificacion);

    lblNombre = new JLabel("Atributo por especificar:");
    lblNombre.setFont(FontController.getRegularLabelFont());
    lblNombre.setBackground(DesignController.getWindowBGColor());
    panelBusqueda.add(lblNombre);

    comboAtributos = new JComboBox<String>();
    comboAtributos.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "Primer Apellido", "Segundo Apellido"}));
    comboAtributos.setFont(FontController.getRegularLabelFont());
    panelBusqueda.add(comboAtributos);

    txtNombre = new JDatabaseText(LibertadDatabaseConstraints.Persona_nombre_VARCHAR2);
    panelBusqueda.add(txtNombre);
    txtNombre.setColumns(10);

    scrollBusqueda = new JScrollPane();
    content.add(scrollBusqueda, BorderLayout.CENTER);

    tablePersona = new JTable();
    scrollBusqueda.setViewportView(tablePersona);

    // Final de construcción de la ventana:
    actions = new JPanel();
    getContentPane().add(this.actions, BorderLayout.SOUTH);
    FlowLayout fl_actions = (FlowLayout) actions.getLayout();
    fl_actions.setAlignment(FlowLayout.RIGHT);
    actions.setBackground(new Color(255, 143, 0));

    this.btnConfirmar = new JButton("Confirmar Selecci\u00F3n");
    this.btnConfirmar.setOpaque(false);
    this.btnConfirmar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent arg0) {
        /**
         * @author Andrés Peña Castillo
         *         Este método asume que existe una columna que debe llamarse
         *         "Tipo de " + <tipoIdentificacion>, busca la posición de esa
         *         columna, obtiene el número de <tipoIdentificacion> de la
         *         persona en la hilera seleccionada, y finalmente,
         *         consulta a la base de datos cual es el ID interno de la base
         *         para guardarlo dentro de la ventana.
         * 
         *         selectedPersonaID es retornado por getSelectedValue(),
         *         quien es llamado desde
         *         MainController.getInstance().selectPersona(...);
         */

        // .lastIndexOf("Tipo de " + (String) comboTipoIdentificacion.getSelectedItem());
        /*
        try {
          
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(MainController.getInstance().getMainScreen(),
              e.getMessage(), "Error de consulta en la base de datos",
              JOptionPane.ERROR_MESSAGE);
        }
        */
      }
    });
    
        btnBuscar = new JButton("Buscar...");
        actions.add(btnBuscar);
        btnBuscar.setOpaque(false);
        this.btnBuscar.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            
          }
        });
    this.actions.add(this.btnConfirmar);
  }

  public Integer getSelectedValue() {
    return selectedPersonaID;
  }

}

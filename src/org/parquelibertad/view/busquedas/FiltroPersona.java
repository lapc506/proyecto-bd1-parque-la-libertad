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

public class FiltroPersona extends DialogTemplate {
  private static final long serialVersionUID = 5606586311814273552L;
  private JPanel            content;
  private JTable            table;
  private JButton           btnBuscar;
  private JPanel            panelBusqueda;
  private JLabel      lblIdentificacion;
  private JComboBox<String> comboTipoIdentificacion;
  private JLabel      lblNombre;
  private JTextField        txtNombre;
  private JComboBox<String> comboAtributos;
  private JTextField        txtIdentificacion;
  private JPanel            panelTop;
  
  private JPanel            actions;
  private JButton           btnSeleccionar;
  private Integer           selectedPersonaID;
  private JButton btnConfirmar;

  // Size 500 x 350 min
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

    this.panelBusqueda = new JPanel();
    panelTop.add(panelBusqueda);
    this.panelBusqueda.setBackground(DesignController.getWindowBGColor());
    panelBusqueda.setLayout(new GridLayout(0, 3, 5, 0));

    lblIdentificacion = new JLabel("Identidad de tipo...");
    
    lblIdentificacion.setFont(FontController.getRegularLabelFont());
    lblIdentificacion.setBackground(DesignController.getWindowBGColor());
    panelBusqueda.add(lblIdentificacion);

    comboTipoIdentificacion = new JComboBox<String>();
    this.comboTipoIdentificacion.setModel(new DefaultComboBoxModel(new String[] {"C\u00E9dula", "Tarjeta Identificaci\u00F3n Menores", "Pasaporte"}));
    comboTipoIdentificacion.setFont(FontController.getRegularLabelFont());
    panelBusqueda.add(comboTipoIdentificacion);

    txtIdentificacion = new JDatabaseText(
        LibertadDatabaseConstraints.DocumentoIdentidad_numeroIdentidad_NUMBER);
    txtIdentificacion.setColumns(10);
    panelBusqueda.add(txtIdentificacion);

    lblNombre = new JLabel("...o Atributo por especificar:");
    lblNombre.setFont(FontController.getRegularLabelFont());
    lblNombre.setBackground(DesignController.getWindowBGColor());
    panelBusqueda.add(lblNombre);

    comboAtributos = new JComboBox<String>();
    comboAtributos.setFont(FontController.getRegularLabelFont());
    panelBusqueda.add(comboAtributos);

    txtNombre = new JDatabaseText(LibertadDatabaseConstraints.Persona_nombre_VARCHAR2);
    panelBusqueda.add(txtNombre);
    txtNombre.setColumns(10);
    
        this.btnBuscar = new JButton("Buscar...");
        this.btnBuscar.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
          }
        });
        this.panelTop.add(this.btnBuscar);
        this.btnBuscar.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent arg0) {
            try {
              table.setModel(QueryController.buscarPersonaTerritorios(
                  (String) comboTipoIdentificacion.getSelectedItem(),
                  txtIdentificacion.getText(), (String) comboAtributos.getSelectedItem(),
                  txtNombre.getText()));
            } catch (SQLException e) {
              JOptionPane.showMessageDialog(MainController.getInstance().getMainScreen(),
                  e.getMessage(), "Error de consulta en la base de datos",
                  JOptionPane.ERROR_MESSAGE);
            }
          }
        });

    this.table = new JTable();
    this.content.add(this.table);

    // Final de construcci�n de la ventana:
    actions = new JPanel();
    getContentPane().add(this.actions, BorderLayout.SOUTH);
    FlowLayout fl_actions = (FlowLayout) actions.getLayout();
    fl_actions.setAlignment(FlowLayout.RIGHT);
    actions.setBackground(new Color(255, 143, 0));
    
    this.btnConfirmar = new JButton("Confirmar Selecci\u00F3n");
    this.btnConfirmar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent arg0) {
        /**
         * @author Andr�s Pe�a Castillo
         *         Este m�todo asume que existe una columna que debe llamarse
         *         "Tipo de " + <tipoIdentificacion>, busca la posici�n de esa
         *         columna, obtiene el n�mero de <tipoIdentificacion> de la
         *         persona en la hilera seleccionada, y finalmente,
         *         consulta a la base de datos cual es el ID interno de la base
         *         para guardarlo dentro de la ventana.
         * 
         *         selectedPersonaID es retornado por getSelectedValue(),
         *         quien es llamado desde
         *         MainController.getInstance().selectPersona(...);
         */
        Integer columnIndex = QueryController.getColumnasUltimaConsulta()
            .lastIndexOf("Tipo de " + (String) comboTipoIdentificacion.getSelectedItem());
        try {
          selectedPersonaID = QueryController.selectPersona(
              (String) comboTipoIdentificacion.getSelectedItem(),
              (String) table.getModel().getValueAt(table.getSelectedRow(), columnIndex)
              // para buscar por <tipoIdentificacion>
          );
          // http://stackoverflow.com/questions/3495926/can-i-catch-multiple-java-exceptions-in-the-same-catch-clause
        } catch (SQLException | IllegalArgumentException e) {
          JOptionPane.showMessageDialog(MainController.getInstance().getMainScreen(),
              e.getMessage(), "Error de consulta en la base de datos",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    this.actions.add(this.btnConfirmar);
  }

  public Integer getSelectedValue() {
    return selectedPersonaID;
  }

}

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
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

public class FiltroPersona extends DialogTemplate {
  private JPanel            content;
  private JTable            table;
  private JButton           btnBuscar;
  private JPanel            panelBusqueda;
  private JRadioButton      rdbtnIdentificacion;
  private JComboBox<String> comboTipoIdentificacion;
  private JRadioButton      rdbtnNombre;
  private JTextField        txtNombre;
  private JComboBox<String> comboAtributos;
  private JTextField        txtIdentificacion;
  private JPanel            panelTop;
  private final ButtonGroup buttonGroupBusqueda = new ButtonGroup();
  private JPanel            panel;
  private JButton           btnSeleccionar;
  private Integer           selectedPersonaID;

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

    rdbtnIdentificacion = new JRadioButton("Identificaci\u00F3n...");
    buttonGroupBusqueda.add(rdbtnIdentificacion);
    rdbtnIdentificacion.setFont(FontController.getRegularLabelFont());
    rdbtnIdentificacion.setBackground(DesignController.getWindowBGColor());
    panelBusqueda.add(rdbtnIdentificacion);
    rdbtnIdentificacion.setSelected(true);

    comboTipoIdentificacion = new JComboBox<String>();
    comboTipoIdentificacion.setFont(FontController.getRegularLabelFont());
    panelBusqueda.add(comboTipoIdentificacion);

    txtIdentificacion = new JDatabaseText(
        LibertadDatabaseConstraints.DocumentoIdentidad_numeroIdentidad_NUMBER);
    txtIdentificacion.setColumns(10);
    panelBusqueda.add(txtIdentificacion);

    rdbtnNombre = new JRadioButton("Otro Atributo...");
    buttonGroupBusqueda.add(rdbtnNombre);
    rdbtnNombre.setFont(FontController.getRegularLabelFont());
    rdbtnNombre.setBackground(DesignController.getWindowBGColor());
    panelBusqueda.add(rdbtnNombre);

    comboAtributos = new JComboBox<String>();
    comboAtributos.setFont(FontController.getRegularLabelFont());
    panelBusqueda.add(comboAtributos);

    txtNombre = new JDatabaseText(LibertadDatabaseConstraints.Persona_nombre_VARCHAR2);
    panelBusqueda.add(txtNombre);
    txtNombre.setColumns(10);

    this.table = new JTable();
    this.content.add(this.table);

    this.btnBuscar = new JButton("Buscar...");
    this.btnBuscar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent arg0) {
        try {
          table.setModel(QueryController.buscarPersona(
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
    panelTop.add(btnBuscar);

    btnSeleccionar = new JButton("Seleccionar");
    btnSeleccionar = new JButton("Seleccionar");
    this.btnSeleccionar.addMouseListener(new MouseAdapter() {
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
    panel.add(btnSeleccionar);

    // Final de construcción de la ventana:
    panel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) panel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    panel.setBackground(new Color(255, 143, 0));
    content.add(panel, BorderLayout.SOUTH);
  }

  public Integer getSelectedValue() {
    return selectedPersonaID;
  }

}

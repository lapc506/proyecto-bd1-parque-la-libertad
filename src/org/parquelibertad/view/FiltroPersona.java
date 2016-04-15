package org.parquelibertad.view;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.model.LibertadDatabaseConstraints;
import org.parquelibertad.view.jmodels.JDatabaseText;

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

public class FiltroPersona extends DialogTemplate {
	private JPanel content;
	private JTable table;
	private JButton btnBuscar;
	private JPanel panelBusqueda;
	private JRadioButton rdbtnIdentificacion;
	private JComboBox<String> comboTipoIdentificacion;
	private JRadioButton rdbtnNombre;
	private JTextField txtNombre;
	private JComboBox<String> comboAtributos;
	private JTextField txtIdentificacion;
	private JPanel panelTop;
	private final ButtonGroup buttonGroupBusqueda = new ButtonGroup();
	private JPanel panel;
	private JButton btnSeleccionar;

  public FiltroPersona(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setLayout(new BorderLayout(0, 0));
    
    content = new JPanel();
    content.setBackground(DesignController.getWindowBGColor());
    content.setBorder(new TitledBorder(null, "Seleccionar persona:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
    
    txtIdentificacion = new JDatabaseText(LibertadDatabaseConstraints.DocumentoIdentidad_numeroIdentidad_NUMBER);
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
    
    this.btnBuscar = new JButton("Buscar...");
    panelTop.add(btnBuscar);
    
    this.table = new JTable();
    this.content.add(this.table);
    
    panel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) panel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    panel.setBackground(new Color(255, 143, 0));
    content.add(panel, BorderLayout.SOUTH);
    
    btnSeleccionar = new JButton("Seleccionar");
    panel.add(btnSeleccionar);
    
  }

}

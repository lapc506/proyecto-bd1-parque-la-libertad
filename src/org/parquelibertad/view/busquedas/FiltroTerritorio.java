package org.parquelibertad.view.busquedas;

import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JFrame;

import org.parquelibertad.controller.QueryController;
import org.parquelibertad.view.templates.DialogTemplate;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JCheckBox;

public class FiltroTerritorio extends DialogTemplate {
	private static final long serialVersionUID = 59331234940240453L;

	private Integer selectedPaisID;
	private Integer selectedProvinciaID;
	private Integer selectedCantonID;
	private Integer selectedDistritoID;
	private Integer selectedPersonaID;

	private JLabel lblBsquedaPorTerritorio;
	private JPanel panelActions;
	private JButton btnBuscar;
	private JPanel panelContent;
	private JComboBox<String> comboBoxPaises;
	private JComboBox<String> comboBoxProvincias;
	private JLabel lblPais;
	private JCheckBox checkProvincia;
	private JCheckBox checkCanton;
	private JComboBox<String> comboBoxCanton;
	private JCheckBox lblDistrito;
	private JComboBox<String> comboBoxDistrito;
	private JPanel panel;
	private JTable tableContents;
	private JButton btnSeleccionar;

  private Vector<Integer> idsPaises;

  private Vector<Integer> idsProvincias;

  private Vector<Integer> idsCantones;

  private Vector<Integer> idsDistritos;

	public FiltroTerritorio(JFrame parent, String windowName, int width, int height, boolean isResizable)
			throws HeadlessException, SQLException {
		super(parent, windowName, width, height, isResizable);
		getContentPane().setLayout(new BorderLayout(0, 0));

		this.lblBsquedaPorTerritorio = new JLabel("B\u00FAsqueda por Territorio");
		this.lblBsquedaPorTerritorio.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(this.lblBsquedaPorTerritorio, BorderLayout.NORTH);

		this.panelActions = new JPanel();
		FlowLayout flowLayout = (FlowLayout) this.panelActions.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		this.panelActions.setOpaque(false);

		getContentPane().add(this.panelActions, BorderLayout.SOUTH);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBackground(new Color(255, 143, 0));
		panelActions.add(btnSeleccionar);
		
		panel = new JPanel();
		panel.setOpaque(false);
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		this.panelContent = new JPanel();
		panel.add(panelContent);
		this.panelContent.setOpaque(false);

		this.comboBoxPaises = new JComboBox<String>();
		panelContent.setLayout(new GridLayout(0, 2, 0, 0));
		// ----------------------------------
		lblPais = new JLabel("Pa\u00EDs");
		this.lblPais.setHorizontalAlignment(SwingConstants.CENTER);
		panelContent.add(lblPais);
		this.panelContent.add(this.comboBoxPaises);
		// ----------------------------------
		checkProvincia = new JCheckBox("Provincia");
		this.checkProvincia.addItemListener(new ItemListener() {
		  public void itemStateChanged(ItemEvent arg0) {
		    if(checkProvincia.isSelected()){
		      try {
            HashMap<Integer, String> provincias = QueryController.getProvinciasPorPais(idsPaises.get(comboBoxPaises.getSelectedIndex()));
            Vector<String> contents = new Vector<String>(); 
            for (Integer x : provincias.keySet()){
              idsProvincias.addElement(x);
              contents.addElement(provincias.get(x));
            }
            comboBoxProvincias.setEnabled(true);
            comboBoxProvincias.setModel(new DefaultComboBoxModel<String>(contents));
          } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
          };
		    } else {
		      comboBoxProvincias.setModel(new DefaultComboBoxModel<>());
		      idsProvincias.clear();
		      comboBoxProvincias.setEnabled(false);
		    }
		  }
		});
		checkProvincia.setOpaque(false);
		this.checkProvincia.setHorizontalAlignment(SwingConstants.CENTER);
		panelContent.add(checkProvincia);
		// ----------------------------------
		comboBoxProvincias = new JComboBox<String>();
		this.comboBoxProvincias.setEnabled(false);
		
		comboBoxProvincias.setModel(new DefaultComboBoxModel<>());
		panelContent.add(comboBoxProvincias);
		// ----------------------------------
		checkCanton = new JCheckBox("Cant\u00F3n");
		checkCanton.setOpaque(false);
		checkCanton.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent arg0) {
        if(checkCanton.isSelected()){
          try {
            HashMap<Integer, String> cantones = QueryController.getCantonesPorProvincia(idsProvincias.get(comboBoxProvincias.getSelectedIndex()));
            Vector<String> contents = new Vector<String>(); 
            for (Integer x : cantones.keySet()){
              idsCantones.addElement(x);
              contents.addElement(cantones.get(x));
            }
            comboBoxCanton.setEnabled(true);
            comboBoxCanton.setModel(new DefaultComboBoxModel<String>(contents));
            for (Integer x : idsCantones){
              System.out.println(x);
            }
          } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
          };
        } else {
          comboBoxCanton.setModel(new DefaultComboBoxModel<>());
          idsCantones.clear();
          comboBoxCanton.setEnabled(false);
        }
      }
    });
		this.checkCanton.setHorizontalAlignment(SwingConstants.CENTER);
		panelContent.add(checkCanton);
		// ----------------------------------
		comboBoxCanton = new JComboBox<String>();
		this.comboBoxCanton.setEnabled(false);
		panelContent.add(comboBoxCanton);
		// ----------------------------------
		lblDistrito = new JCheckBox("Distrito");
		lblDistrito.setOpaque(false);
		this.lblDistrito.setHorizontalAlignment(SwingConstants.CENTER);
		panelContent.add(lblDistrito);
		// ----------------------------------
		comboBoxDistrito = new JComboBox<String>();
		this.comboBoxDistrito.setEnabled(false);
		panelContent.add(comboBoxDistrito);

		this.btnBuscar = new JButton("Buscar...");
		this.btnBuscar.setOpaque(false);
		panel.add(btnBuscar);
		// ----------------------------------
		tableContents = new JTable();
		getContentPane().add(tableContents, BorderLayout.CENTER);

		loadConnections();
	}

	private void loadConnections() throws SQLException {
	  idsPaises = new Vector<Integer>();
	  idsProvincias = new Vector<Integer>();
	  idsCantones = new Vector<Integer>();
	  idsDistritos = new Vector<Integer>();
	  
	  HashMap<Integer, String> paises = QueryController.getPaises();
	  Vector<String> contents = new Vector<String>(); 
	  for (Integer x : paises.keySet()){
	    idsPaises.addElement(x);
	    contents.addElement(paises.get(x));
	  }
		this.comboBoxPaises.setModel(new DefaultComboBoxModel<String>(contents));
		for (Integer x : idsPaises){
		  System.out.println(x);
		}
	}

}

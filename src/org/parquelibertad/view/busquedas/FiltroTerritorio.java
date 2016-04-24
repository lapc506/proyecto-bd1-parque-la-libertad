package org.parquelibertad.view.busquedas;

import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.JFrame;

import org.parquelibertad.controller.QueryController;
import org.parquelibertad.controller.design.DesignController;
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
	private JLabel lblProvincia;
	private JLabel lblCantn;
	private JComboBox<String> comboBoxCanton;
	private JLabel lblDistrito;
	private JComboBox<String> comboBoxDistrito;
	private JPanel panel;
	private JTable tableContents;
	private JButton btnSeleccionar;

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
		// ----------------------------------
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBackground(new Color(255, 143, 0));
		panelActions.add(btnSeleccionar);
		/*
		 * DefaultComboBoxModel<String> paises = new DefaultComboBoxModel<>(
		 * QueryController.getProvinciasPorPais(QueryController.getPaisID((
		 * String) paises.getSelectedItem())));
		 * this.comboBoxPaises.setModel(paises);
		 */
		// ----------------------------------
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
		panelContent.add(lblPais);
		this.panelContent.add(this.comboBoxPaises);
		// ----------------------------------
		lblProvincia = new JLabel("Provincia");
		panelContent.add(lblProvincia);
		// ----------------------------------
		comboBoxProvincias = new JComboBox<String>();
		panelContent.add(comboBoxProvincias);
		// ----------------------------------
		lblCantn = new JLabel("Cant\u00F3n");
		panelContent.add(lblCantn);
		// ----------------------------------
		comboBoxCanton = new JComboBox<String>();
		panelContent.add(comboBoxCanton);
		// ----------------------------------
		lblDistrito = new JLabel("Distrito");
		panelContent.add(lblDistrito);
		// ----------------------------------
		comboBoxDistrito = new JComboBox<String>();
		panelContent.add(comboBoxDistrito);

		this.btnBuscar = new JButton("Buscar...");
		panel.add(btnBuscar);
		this.btnBuscar.setBackground(DesignController.getWindowBGColor());
		// ----------------------------------
		tableContents = new JTable();
		getContentPane().add(tableContents, BorderLayout.CENTER);

		loadConnections();
	}

	private void loadConnections() throws SQLException {
		this.comboBoxPaises.setModel(new DefaultComboBoxModel<>(QueryController.getPaises()));
		this.comboBoxPaises.addItemListener(new PaisComboboxListener());
	}

	private class PaisComboboxListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				try {
					String selectedOption = (String) ((JComboBox<String>) e.getItem()).getSelectedItem();
					QueryController.getPaisID(selectedOption);
					JOptionPane.showMessageDialog(rootPane, selectedOption, "Conexión exitosa",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(rootPane, e1.getMessage(), "Se perdió la conexión con la base.",
							JOptionPane.ERROR_MESSAGE);
				}
				;
				// do something with object
			}
		}
	}

}

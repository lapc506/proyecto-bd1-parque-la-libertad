package org.parquelibertad.view;

import javax.swing.JFrame;

import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class AddPersonas extends DialogTemplate {

	private JTextField txtNombre;
	private JTextField txtPrimerApellido;
	private JTextField txtSegundoApellido;
	private JTextField txtIdentificacion;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel label_8;
	private JLabel lblDistrito;
	private JComboBox<String> comboDistrito;
	private JLabel label_1;
	private JComboBox<String> comboBox_1;
	private JLabel label;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;

	public AddPersonas(JFrame parent, String windowName, int width, int height, boolean isResizable)
			throws HeadlessException {
		super(parent, windowName, width, height, isResizable);
		/*
		 * Comportamientos heredados de DialogTemplate:
		 * 
		 * setSize(1000, 500); setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 * setResizable(false); setVisible(true);
		 */
		getContentPane().setBackground(DesignController.getWindowBGColor());
		getContentPane().setLayout(new BorderLayout(20, 30));
		// ----------------------------------
		label = new JLabel("  ");
		getContentPane().add(label, BorderLayout.NORTH);
		// ----------------------------------
		label_2 = new JLabel("  ");
		getContentPane().add(label_2, BorderLayout.SOUTH);
		// ----------------------------------
		label_3 = new JLabel("  ");
		getContentPane().add(label_3, BorderLayout.WEST);
		// ----------------------------------
		label_4 = new JLabel("  ");
		getContentPane().add(label_4, BorderLayout.EAST);

		JPanel panel = new JPanel();
		panel.setFocusable(false);
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Nueva Persona", TitledBorder.LEADING,
				TitledBorder.TOP, FontController.getSubtitleFont()));
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 10, 3));

		JLabel lblNombre = new JLabel("Nombre");
		panel.add(lblNombre);
		lblNombre.setFont(FontController.getRegularLabelFont());

		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		panel.add(lblPrimerApellido);
		lblPrimerApellido.setFont(FontController.getRegularLabelFont());

		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		panel.add(lblSegundoApellido);
		lblSegundoApellido.setFont(FontController.getRegularLabelFont());

		txtNombre = new JTextField();
		panel.add(txtNombre);
		txtNombre.setFont(FontController.getRegularLabelFont());
		txtNombre.setColumns(10);

		txtPrimerApellido = new JTextField();
		panel.add(txtPrimerApellido);
		txtPrimerApellido.setFont(FontController.getRegularLabelFont());
		txtPrimerApellido.setColumns(10);

		txtSegundoApellido = new JTextField();
		panel.add(txtSegundoApellido);
		txtSegundoApellido.setFont(FontController.getRegularLabelFont());
		txtSegundoApellido.setColumns(10);

		JLabel lblIdentificacion = new JLabel("Identificaci\u00F3n");
		panel.add(lblIdentificacion);
		lblIdentificacion.setFont(FontController.getRegularLabelFont());

		JLabel lblTipoDeIdentificacin = new JLabel("Tipo de Identificaci\u00F3n");
		panel.add(lblTipoDeIdentificacin);
		lblTipoDeIdentificacin.setFont(FontController.getRegularLabelFont());

		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setFont(FontController.getRegularLabelFont());
		panel.add(lblNacionalidad);

		txtIdentificacion = new JTextField();
		panel.add(txtIdentificacion);
		txtIdentificacion.setFont(FontController.getRegularLabelFont());
		txtIdentificacion.setColumns(10);

		JComboBox<String> comboTipoID = new JComboBox<String>();
		panel.add(comboTipoID);
		comboTipoID.setFont(FontController.getRegularLabelFont());
		comboTipoID.setModel(new DefaultComboBoxModel(new String[] { "TIM", "C\u00E9dula", "Pasaporte" }));

		JComboBox<String> comboNacionalidad = new JComboBox<String>();
		comboNacionalidad.setFont(FontController.getRegularLabelFont());
		panel.add(comboNacionalidad);

		JLabel lblPaisResidencia = new JLabel("Pa\u00EDs de residencia");
		lblPaisResidencia.setFont(FontController.getRegularLabelFont());
		panel.add(lblPaisResidencia);

		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setFont(FontController.getRegularLabelFont());
		panel.add(lblProvincia);

		JLabel lblCanton = new JLabel("Cant\u00F3n");
		lblCanton.setFont(FontController.getRegularLabelFont());
		panel.add(lblCanton);

		JComboBox<String> comboPais = new JComboBox<String>();
		comboPais.setFont(FontController.getRegularLabelFont());
		panel.add(comboPais);

		JComboBox<String> comboProvincia = new JComboBox<String>();
		comboProvincia.setFont(FontController.getRegularLabelFont());
		panel.add(comboProvincia);

		JComboBox<String> comboCanton = new JComboBox<String>();
		comboCanton.setFont(FontController.getRegularLabelFont());
		panel.add(comboCanton);
		// ----------------------------------
		lblDistrito = new JLabel("Distrito");
		lblDistrito.setFont(null);
		panel.add(lblDistrito);
		// ----------------------------------
		label_1 = new JLabel("Ciudad");
		label_1.setFont(null);
		panel.add(label_1);

		JLabel lblDireccionExacta = new JLabel("Direcci\u00F3n Exacta");
		lblDireccionExacta.setFont(FontController.getRegularLabelFont());
		panel.add(lblDireccionExacta);
		// ----------------------------------
		comboDistrito = new JComboBox<String>();
		comboDistrito.setFont(null);
		panel.add(comboDistrito);
		// ----------------------------------
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setFont(null);
		panel.add(comboBox_1);

		textField_4 = new JTextField();
		textField_4.setFont(FontController.getRegularLabelFont());
		textField_4.setColumns(10);
		panel.add(textField_4);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(FontController.getRegularLabelFont());
		panel.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(FontController.getRegularLabelFont());
		panel.add(lblContrasea);
		// ----------------------------------
		label_8 = new JLabel("");
		panel.add(label_8);

		textField_5 = new JTextField();
		textField_5.setFont(FontController.getRegularLabelFont());
		textField_5.setColumns(10);
		panel.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setFont(FontController.getRegularLabelFont());
		textField_6.setColumns(10);
		panel.add(textField_6);

		JButton btnRegistrar = new JButton("Registrar");
		panel.add(btnRegistrar);
		btnRegistrar.setFont(FontController.getSubtitleFont());

	}
}

package org.parquelibertad.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.parquelibertad.controller.DesignStyles;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class AddPersonas extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPersonas window = new AddPersonas();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddPersonas() {
		setTitle("Registrar Nueva Persona");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setSize(1000, 500);
		getContentPane().setBackground(DesignStyles.windowBGColor);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(45, 60, 276, 42);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setBounds(331, 60, 276, 42);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBounds(617, 60, 276, 42);
		getContentPane().add(textField_2);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(45, 31, 193, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		lblPrimerApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrimerApellido.setBounds(331, 33, 193, 16);
		getContentPane().add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSegundoApellido.setBounds(617, 31, 193, 18);
		getContentPane().add(lblSegundoApellido);
		
		JLabel lblIdentificacin = new JLabel("Identificaci\u00F3n");
		lblIdentificacin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdentificacin.setBounds(45, 127, 193, 14);
		getContentPane().add(lblIdentificacin);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_3.setColumns(10);
		textField_3.setBounds(45, 156, 276, 42);
		getContentPane().add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"TIM", "C\u00E9dula", "Pasaporte"}));
		comboBox.setBounds(331, 156, 276, 42);
		getContentPane().add(comboBox);
		
		JLabel lblTipoDeIdentificacin = new JLabel("Tipo de Identificaci\u00F3n");
		lblTipoDeIdentificacin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoDeIdentificacin.setBounds(331, 129, 193, 16);
		getContentPane().add(lblTipoDeIdentificacin);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 0));
		panel.setBackground(new Color(0, 0, 0));
		panel.setName("");
		panel.setFocusable(false);
		panel.setOpaque(false);
		LineBorder colorTitledBorder=(new LineBorder(new Color(255, 255, 0)));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Nueva Persona", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel.setBounds(10, 11, 925, 449);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(605, 116, 94, 20);
		lblNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNacionalidad);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox_1.setBounds(605, 145, 274, 42);
		panel.add(comboBox_1);
		
		JLabel lblPasDeResidencia = new JLabel("Pa\u00EDs de residencia");
		lblPasDeResidencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPasDeResidencia.setBounds(35, 214, 193, 14);
		panel.add(lblPasDeResidencia);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProvincia.setBounds(321, 214, 193, 14);
		panel.add(lblProvincia);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCiudad.setBounds(605, 214, 193, 14);
		panel.add(lblCiudad);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox_2.setBounds(35, 236, 274, 42);
		panel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox_3.setBounds(320, 239, 274, 42);
		panel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox_4.setBounds(602, 239, 274, 42);
		panel.add(comboBox_4);
		
		JLabel lblDireccinExacta = new JLabel("Direcci\u00F3n Exacta");
		lblDireccinExacta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccinExacta.setBounds(35, 293, 193, 14);
		panel.add(lblDireccinExacta);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_4.setColumns(10);
		textField_4.setBounds(35, 317, 560, 42);
		panel.add(textField_4);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(660, 360, 193, 42);
		panel.add(btnNewButton);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(35, 375, 193, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea.setBounds(321, 377, 193, 14);
		panel.add(lblContrasea);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_5.setColumns(10);
		textField_5.setBounds(34, 396, 275, 42);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_6.setColumns(10);
		textField_6.setBounds(321, 396, 273, 42);
		panel.add(textField_6);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}

package org.parquelibertad.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


import org.parquelibertad.controller.design.DesignController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class AgregarEmpleado extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEmpleado window = new AgregarEmpleado();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgregarEmpleado() {
		setTitle("Agregar Empleado");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setSize(650, 500);
		getContentPane().setBackground(DesignController.getWindowBGColor());
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 0));
		panel.setBackground(new Color(0, 0, 0));
		panel.setName("");
		panel.setFocusable(false);
		panel.setOpaque(false);
		LineBorder colorTitledBorder=(new LineBorder(new Color(255, 255, 0)));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), null, TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel.setBounds(10, 11, 630, 449);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la Persona");
		lblNombreDeLa.setBounds(26, 45, 190, 27);
		lblNombreDeLa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(lblNombreDeLa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(26, 83, 515, 44);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setName("");
		panel_1.setForeground(Color.YELLOW);
		panel_1.setFocusable(false);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Filtros", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(26, 138, 594, 118);
		panel.add(panel_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombre.setBounds(10, 24, 75, 27);
		panel_1.add(lblNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		lblPrimerApellido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrimerApellido.setBounds(199, 24, 167, 27);
		panel_1.add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSegundoApellido.setBounds(392, 24, 144, 27);
		panel_1.add(lblSegundoApellido);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(392, 62, 184, 44);
		panel_1.add(comboBox_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 62, 184, 44);
		panel_1.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(199, 62, 184, 44);
		panel_1.add(comboBox_2);
		
		JLabel lblActividad = new JLabel("Puesto");
		lblActividad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblActividad.setBounds(277, 282, 167, 27);
		panel.add(lblActividad);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(167, 320, 289, 44);
		panel.add(comboBox_4);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRegistrar.setBounds(244, 388, 126, 40);
		panel.add(btnRegistrar);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}
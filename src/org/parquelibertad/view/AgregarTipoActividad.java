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

public class AgregarTipoActividad extends JFrame{

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarTipoActividad window = new AgregarTipoActividad();
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
	public AgregarTipoActividad() {
		setTitle("Agregar Tipo de Actividad");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setSize(350, 250);
		getContentPane().setBackground(DesignController.getWindowBGColor());
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 0));
		panel.setBackground(new Color(0, 0, 0));
		panel.setName("");
		panel.setFocusable(false);
		panel.setOpaque(false);
		LineBorder colorTitledBorder=(new LineBorder(new Color(255, 255, 0)));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Tipo de Actividad", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel.setBounds(10, 11, 330, 199);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDeLa = new JLabel("Nombre");
		lblNombreDeLa.setBounds(26, 45, 190, 27);
		lblNombreDeLa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(lblNombreDeLa);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(105, 135, 125, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(26, 83, 280, 41);
		panel.add(textField);
		textField.setColumns(10);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}

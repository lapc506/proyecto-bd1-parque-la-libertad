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
import javax.swing.UIManager;

public class AgregarAlumno extends JFrame{

	private JFrame frame;
	private JTextField textField;

	public AgregarAlumno() {
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
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRegistrar.setBounds(246, 398, 126, 40);
		panel.add(btnRegistrar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setName("");
		panel_1.setForeground(Color.YELLOW);
		panel_1.setFocusable(false);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Filtros", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(26, 138, 594, 253);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Nombre");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(10, 24, 75, 27);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Primer Apellido");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(199, 24, 167, 27);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Segundo Apellido");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(392, 24, 144, 27);
		panel_1.add(label_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(392, 62, 184, 44);
		panel_1.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(10, 62, 184, 44);
		panel_1.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(199, 62, 184, 44);
		panel_1.add(comboBox_3);
		
		JLabel label_3 = new JLabel("Tipo de Identificaci\u00F3n");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_3.setBounds(10, 117, 184, 27);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Identificaci\u00F3n");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_4.setBounds(251, 117, 184, 27);
		panel_1.add(label_4);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox_4.setBounds(10, 155, 237, 42);
		panel_1.add(comboBox_4);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setColumns(10);
		textField.setBounds(251, 155, 325, 42);
		panel_1.add(textField);
		
		JButton button = new JButton("Filtrar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button.setBounds(238, 208, 106, 34);
		panel_1.add(button);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}

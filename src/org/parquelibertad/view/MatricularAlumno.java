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
import javax.swing.SwingConstants;

public class MatricularAlumno extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatricularAlumno window = new MatricularAlumno();
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
	public MatricularAlumno() {
		setTitle("Matricular Alumno");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setSize(650, 775);
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
		panel.setBounds(10, 11, 630, 724);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la Persona");
		lblNombreDeLa.setBounds(27, 11, 190, 27);
		lblNombreDeLa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(lblNombreDeLa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(27, 49, 515, 40);
		panel.add(comboBox);
		
		JButton btnRegistrar = new JButton("Matricular");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRegistrar.setBounds(245, 673, 126, 40);
		panel.add(btnRegistrar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Costo", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel_2.setBounds(27, 588, 296, 74);
		panel.add(panel_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(52, 23, 221, 40);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("\u20A1");
		textField_1.setOpaque(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 23, 32, 40);
		panel_2.add(textField_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setOpaque(false);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Curso", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel_3.setBounds(27, 335, 399, 74);
		panel.add(panel_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(10, 19, 379, 31);
		panel_3.add(comboBox_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setOpaque(false);
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Profesor", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel_4.setBounds(27, 420, 535, 61);
		panel.add(panel_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(10, 19, 515, 31);
		panel_4.add(comboBox_5);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setOpaque(false);
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Horario", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel_5.setBounds(27, 492, 568, 96);
		panel.add(panel_5);
		
		JLabel lblDas = new JLabel("D\u00EDas");
		lblDas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDas.setBounds(10, 24, 75, 27);
		panel_5.add(lblDas);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(10, 51, 346, 33);
		panel_5.add(comboBox_6);
		
		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHoras.setBounds(363, 11, 75, 27);
		panel_5.add(lblHoras);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(359, 51, 199, 33);
		panel_5.add(comboBox_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setName("");
		panel_1.setForeground(Color.YELLOW);
		panel_1.setFocusable(false);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Filtros", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(27, 90, 594, 230);
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
		comboBox_1.setBounds(392, 62, 184, 34);
		panel_1.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(10, 62, 184, 34);
		panel_1.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(199, 62, 184, 34);
		panel_1.add(comboBox_3);
		
		JLabel label_3 = new JLabel("Tipo de Identificaci\u00F3n");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_3.setBounds(10, 107, 184, 27);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Identificaci\u00F3n");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_4.setBounds(251, 107, 184, 27);
		panel_1.add(label_4);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox_8.setBounds(10, 145, 237, 34);
		panel_1.add(comboBox_8);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBounds(251, 145, 325, 34);
		panel_1.add(textField_2);
		
		JButton button = new JButton("Filtrar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button.setBounds(239, 190, 106, 34);
		panel_1.add(button);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}
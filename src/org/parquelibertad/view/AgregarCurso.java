package org.parquelibertad.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.parquelibertad.controller.DesignStyles;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class AgregarCurso extends JFrame{

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
					AgregarCurso window = new AgregarCurso();
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
	public AgregarCurso() {
		setTitle("Agregar Curso");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setSize(700, 650);
		getContentPane().setBackground(DesignStyles.windowBGColor);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 0));
		panel.setBackground(new Color(0, 0, 0));
		panel.setName("");
		panel.setFocusable(false);
		panel.setOpaque(false);
		LineBorder colorTitledBorder=(new LineBorder(new Color(255, 255, 0)));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Curso", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel.setBounds(10, 11, 680, 599);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Días", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel_1.setBounds(26, 239, 295, 171);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Horario", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel_2.setBounds(331, 239, 222, 171);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Costo", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel_3.setBounds(25, 428, 296, 74);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(52, 23, 221, 40);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setOpaque(false);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText("\u20A1");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setBounds(10, 23, 32, 40);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNombreDeLa = new JLabel("Nombre del Curso");
		lblNombreDeLa.setBounds(26, 45, 190, 27);
		lblNombreDeLa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(lblNombreDeLa);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(279, 543, 125, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(btnNewButton);
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblProfesor.setBounds(26, 128, 190, 27);
		panel.add(lblProfesor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(26, 166, 282, 42);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(26, 83, 282, 42);
		panel.add(comboBox_1);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDescripcin.setBounds(333, 45, 190, 27);
		panel.add(lblDescripcin);
		
		textField = new JTextField();
		textField.setBounds(333, 83, 317, 127);
		panel.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxLunes = new JCheckBox("Lunes");
		chckbxLunes.setBounds(6, 46, 97, 23);
		panel_1.add(chckbxLunes);
		chckbxLunes.setOpaque(false);
		
		JCheckBox chckbxJueves = new JCheckBox("Jueves");
		chckbxJueves.setBounds(6, 81, 97, 23);
		panel_1.add(chckbxJueves);
		chckbxJueves.setOpaque(false);
		
		JCheckBox chckbxDomingo = new JCheckBox("Domingo");
		chckbxDomingo.setBounds(103, 117, 97, 23);
		panel_1.add(chckbxDomingo);
		chckbxDomingo.setOpaque(false);
		
		JCheckBox chckbxViernes = new JCheckBox("Viernes");
		chckbxViernes.setBounds(103, 81, 97, 23);
		panel_1.add(chckbxViernes);
		chckbxViernes.setOpaque(false);
		
		JCheckBox chckbxMartes = new JCheckBox("Martes");
		chckbxMartes.setBounds(103, 46, 97, 23);
		panel_1.add(chckbxMartes);
		chckbxMartes.setOpaque(false);
		
		JCheckBox chckbxMircoles = new JCheckBox("Mi\u00E9rcoles");
		chckbxMircoles.setBounds(214, 46, 90, 23);
		panel_1.add(chckbxMircoles);
		chckbxMircoles.setOpaque(false);
		
		JCheckBox chckbxSbado = new JCheckBox("S\u00E1bado");
		chckbxSbado.setBounds(214, 81, 74, 23);
		panel_1.add(chckbxSbado);
		chckbxSbado.setOpaque(false);
		
		
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(47, 56, 53, 20);
		panel_2.add(spinner);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(47, 114, 53, 20);
		panel_2.add(spinner_2);
		
		JLabel label_1 = new JLabel(":");
		label_1.setBounds(106, 108, 14, 27);
		panel_2.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblA = new JLabel("a");
		lblA.setBounds(106, 76, 14, 27);
		panel_2.add(lblA);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel label = new JLabel(":");
		label.setBounds(106, 50, 14, 27);
		panel_2.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(120, 56, 53, 20);
		panel_2.add(spinner_1);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(120, 114, 53, 20);
		panel_2.add(spinner_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setOpaque(false);
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Mercado Meta", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel_4.setBounds(331, 428, 296, 74);
		panel.add(panel_4);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(10, 23, 276, 40);
		panel_4.add(comboBox_2);
		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}


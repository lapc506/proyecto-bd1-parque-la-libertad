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

public class AgregarActividad extends JFrame{

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarActividad window = new AgregarActividad();
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
	public AgregarActividad() {
		setTitle("Agregar Actividad");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setSize(350, 750);
		getContentPane().setBackground(DesignStyles.windowBGColor);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 0));
		panel.setBackground(new Color(0, 0, 0));
		panel.setName("");
		panel.setFocusable(false);
		panel.setOpaque(false);
		LineBorder colorTitledBorder=(new LineBorder(new Color(255, 255, 0)));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Actividad", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel.setBounds(10, 11, 330, 699);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDeLa = new JLabel("Tipo de Actividad");
		lblNombreDeLa.setBounds(26, 45, 190, 27);
		lblNombreDeLa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(lblNombreDeLa);
		
		JLabel lblDas = new JLabel("D\u00EDas");
		lblDas.setBounds(26, 369, 190, 27);
		lblDas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(lblDas);
		
		JCheckBox chckbxLunes = new JCheckBox("Lunes");
		chckbxLunes.setBounds(26, 418, 97, 23);
		chckbxLunes.setOpaque(false);
		panel.add(chckbxLunes);
		
		JCheckBox chckbxMartes = new JCheckBox("Martes");
		chckbxMartes.setBounds(123, 418, 97, 23);
		chckbxMartes.setOpaque(false);
		panel.add(chckbxMartes);
		
		JCheckBox chckbxMircoles = new JCheckBox("Mi\u00E9rcoles");
		chckbxMircoles.setBounds(234, 418, 90, 23);
		chckbxMircoles.setOpaque(false);
		panel.add(chckbxMircoles);
		
		JCheckBox chckbxJueves = new JCheckBox("Jueves");
		chckbxJueves.setBounds(26, 453, 97, 23);
		chckbxJueves.setOpaque(false);
		panel.add(chckbxJueves);
		
		JCheckBox chckbxViernes = new JCheckBox("Viernes");
		chckbxViernes.setBounds(123, 453, 97, 23);
		chckbxViernes.setOpaque(false);
		panel.add(chckbxViernes);
		
		JCheckBox chckbxSbado = new JCheckBox("S\u00E1bado");
		chckbxSbado.setBounds(234, 453, 74, 23);
		chckbxSbado.setOpaque(false);
		panel.add(chckbxSbado);
		
		JCheckBox chckbxDomingo = new JCheckBox("Domingo");
		chckbxDomingo.setBounds(123, 489, 97, 23);
		chckbxDomingo.setOpaque(false);
		panel.add(chckbxDomingo);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setBounds(127, 519, 62, 27);
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(lblHorario);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(98, 563, 53, 20);
		panel.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(171, 563, 53, 20);
		panel.add(spinner_1);
		
		JLabel label = new JLabel(":");
		label.setBounds(157, 557, 14, 27);
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(label);
		
		JLabel label_1 = new JLabel(":");
		label_1.setBounds(157, 615, 14, 27);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(label_1);
		
		JLabel lblA = new JLabel("a");
		lblA.setBounds(157, 583, 14, 27);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(lblA);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(98, 621, 53, 20);
		panel.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(171, 621, 53, 20);
		panel.add(spinner_3);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(98, 665, 125, 23);
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
		lblDescripcin.setBounds(26, 219, 190, 27);
		panel.add(lblDescripcin);
		
		textField = new JTextField();
		textField.setBounds(26, 257, 282, 112);
		panel.add(textField);
		textField.setColumns(10);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}

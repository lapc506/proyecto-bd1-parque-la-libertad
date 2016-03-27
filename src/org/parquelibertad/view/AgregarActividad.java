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
		setSize(350, 550);
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
		panel.setBounds(10, 11, 330, 499);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la actividad");
		lblNombreDeLa.setBounds(26, 56, 190, 27);
		lblNombreDeLa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(lblNombreDeLa);
		
		textField = new JTextField();
		textField.setBounds(26, 94, 289, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDas = new JLabel("D\u00EDas");
		lblDas.setBounds(26, 153, 190, 27);
		lblDas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(lblDas);
		
		JCheckBox chckbxLunes = new JCheckBox("Lunes");
		chckbxLunes.setBounds(26, 202, 97, 23);
		chckbxLunes.setOpaque(false);
		panel.add(chckbxLunes);
		
		JCheckBox chckbxMartes = new JCheckBox("Martes");
		chckbxMartes.setBounds(139, 202, 97, 23);
		chckbxMartes.setOpaque(false);
		panel.add(chckbxMartes);
		
		JCheckBox chckbxMircoles = new JCheckBox("Mi\u00E9rcoles");
		chckbxMircoles.setBounds(250, 202, 97, 23);
		chckbxMircoles.setOpaque(false);
		panel.add(chckbxMircoles);
		
		JCheckBox chckbxJueves = new JCheckBox("Jueves");
		chckbxJueves.setBounds(26, 237, 97, 23);
		chckbxJueves.setOpaque(false);
		panel.add(chckbxJueves);
		
		JCheckBox chckbxViernes = new JCheckBox("Viernes");
		chckbxViernes.setBounds(139, 237, 97, 23);
		chckbxViernes.setOpaque(false);
		panel.add(chckbxViernes);
		
		JCheckBox chckbxSbado = new JCheckBox("S\u00E1bado");
		chckbxSbado.setBounds(250, 237, 97, 23);
		chckbxSbado.setOpaque(false);
		panel.add(chckbxSbado);
		
		JCheckBox chckbxDomingo = new JCheckBox("Domingo");
		chckbxDomingo.setBounds(139, 273, 97, 23);
		chckbxDomingo.setOpaque(false);
		panel.add(chckbxDomingo);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setBounds(127, 303, 62, 27);
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(lblHorario);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(98, 347, 53, 20);
		panel.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(171, 347, 53, 20);
		panel.add(spinner_1);
		
		JLabel label = new JLabel(":");
		label.setBounds(157, 341, 14, 27);
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(label);
		
		JLabel label_1 = new JLabel(":");
		label_1.setBounds(157, 399, 14, 27);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(label_1);
		
		JLabel lblA = new JLabel("a");
		lblA.setBounds(157, 367, 14, 27);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(lblA);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(98, 405, 53, 20);
		panel.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(171, 405, 53, 20);
		panel.add(spinner_3);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(98, 449, 125, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(btnNewButton);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}

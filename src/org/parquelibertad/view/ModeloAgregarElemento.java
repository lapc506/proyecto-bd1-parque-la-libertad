package org.parquelibertad.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.parquelibertad.controller.DesignStyles;

public class ModeloAgregarElemento extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModeloAgregarElemento window = new ModeloAgregarElemento();
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
	public ModeloAgregarElemento() {
		setTitle("Window Name Goes Here");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setSize(1000, 500);
		getContentPane().setBackground(DesignStyles.windowBGColor);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 0));
		panel.setBackground(new Color(0, 0, 0));
		panel.setName("");
		panel.setFocusable(false);
		panel.setOpaque(false);
		LineBorder colorTitledBorder=(new LineBorder(new Color(255, 255, 0)));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Border Title Goes Here", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel.setBounds(10, 11, 925, 449);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

}

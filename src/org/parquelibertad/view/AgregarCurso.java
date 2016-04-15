package org.parquelibertad.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.model.LibertadDatabaseConstraints;
import org.parquelibertad.view.jmodels.JDatabaseText;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.FlowLayout;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;

public class AgregarCurso extends DialogTemplate {
	private static final long serialVersionUID = 3721795951153442361L;
	private JTextField txtCosto;
	private JPanel panelContents;
	private JPanel panelSemana;
	private JPanel panelHorario;
	private JPanel panelCosto;
	private JLabel lblNombreCurso;
	private JLabel lblColones;
	private JTextField txtNombre;
	private JLabel lblProfesor;
	private JComboBox<String> comboProfesor;
	private JCheckBox chckbxLunes;
	private JCheckBox chckbxJueves;
	private JCheckBox chckbxDomingo;
	private JCheckBox chckbxViernes;
	private JCheckBox chckbxMartes;
	private JCheckBox chckbxMircoles;
	private JCheckBox chckbxSbado;
	private JSpinner spinHoraInicio;
	private JLabel labeltime1;
	private JSpinner spinMinutoInicio;
	private JLabel lblHasta;
	private JSpinner spinHoraFinal;
	private JLabel labeltime2;
	private JSpinner spinMinutoFinal;
	private JPanel panelMercado;
	private JComboBox<String> comboMercadoMeta;
	private JPanel panelBottom;
	private JButton btnRegistrar;
	private JSpinner spinnerAMPMinicio;
	private JSpinner spinnerAMPMfinal;

	public AgregarCurso(JFrame parent, String windowName, int width, int height, boolean isResizable)
			throws HeadlessException {
		super(parent, windowName, width, height, isResizable);
		panelContents = new JPanel();
		panelContents.setForeground(new Color(255, 255, 0));
		panelContents.setName("");
		panelContents.setFocusable(false);
		panelContents.setOpaque(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		panelContents.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Curso", TitledBorder.LEADING,
				TitledBorder.TOP, FontController.getSubtitleFont(), null));
		getContentPane().add(panelContents);
		panelContents.setLayout(new GridLayout(0, 2, 0, 0));

		lblNombreCurso = new JLabel("Nombre");
		lblNombreCurso.setFont(FontController.getBoldLabelFont());
		panelContents.add(lblNombreCurso);

		txtNombre = new JDatabaseText(LibertadDatabaseConstraints.Curso_nombre_VARCHAR2);
		panelContents.add(txtNombre);

		lblProfesor = new JLabel("Profesor");
		lblProfesor.setFont(FontController.getBoldLabelFont());
		panelContents.add(lblProfesor);

		comboProfesor = new JComboBox<String>();
		panelContents.add(comboProfesor);

		panelSemana = new JPanel();
		panelSemana.setOpaque(false);
		panelSemana.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Días", TitledBorder.LEADING,
				TitledBorder.TOP, FontController.getBoldLabelFont(), null));
		panelContents.add(panelSemana);
		this.panelSemana.setLayout(new GridLayout(0, 4, 0, 0));

		chckbxDomingo = new JCheckBox("Domingo");
		this.chckbxDomingo.setFont(FontController.getRegularLabelFont());
		panelSemana.add(chckbxDomingo);
		chckbxDomingo.setOpaque(false);
		
		chckbxLunes = new JCheckBox("Lunes");
		this.chckbxLunes.setFont(FontController.getRegularLabelFont());
		panelSemana.add(chckbxLunes);
		chckbxLunes.setOpaque(false);
		
		chckbxMartes = new JCheckBox("Martes");
		this.chckbxMartes.setFont(FontController.getRegularLabelFont());
		panelSemana.add(chckbxMartes);
		chckbxMartes.setOpaque(false);
		
		chckbxMircoles = new JCheckBox("Mi\u00E9rcoles");
		this.chckbxMircoles.setFont(FontController.getRegularLabelFont());
		panelSemana.add(chckbxMircoles);
		chckbxMircoles.setOpaque(false);
		
		chckbxJueves = new JCheckBox("Jueves");
		this.chckbxJueves.setFont(FontController.getRegularLabelFont());
		panelSemana.add(chckbxJueves);
		chckbxJueves.setOpaque(false);

		chckbxViernes = new JCheckBox("Viernes");
		this.chckbxViernes.setFont(FontController.getRegularLabelFont());
		panelSemana.add(chckbxViernes);
		chckbxViernes.setOpaque(false);

		chckbxSbado = new JCheckBox("S\u00E1bado");
		this.chckbxSbado.setFont(FontController.getRegularLabelFont());
		panelSemana.add(chckbxSbado);
		chckbxSbado.setOpaque(false);

		panelHorario = new JPanel();
		panelHorario.setOpaque(false);
		panelHorario.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Horario", TitledBorder.LEADING,
				TitledBorder.TOP, FontController.getBoldLabelFont(), null));
		panelContents.add(panelHorario);
		this.panelHorario.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		spinHoraInicio = new JSpinner();
		this.spinHoraInicio.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		this.spinHoraInicio.setFont(FontController.getRegularLabelFont());
		panelHorario.add(spinHoraInicio);

		labeltime1 = new JLabel(":");
		panelHorario.add(labeltime1);
		labeltime1.setFont(FontController.getRegularLabelFont());

		spinMinutoInicio = new JSpinner();
		this.spinMinutoInicio.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		this.spinMinutoInicio.setFont(FontController.getRegularLabelFont());
		panelHorario.add(spinMinutoInicio);
		
		this.spinnerAMPMinicio = new JSpinner();
		this.spinnerAMPMinicio.setModel(new SpinnerListModel(new String[] {"AM", "PM"}));
		this.spinnerAMPMinicio.setFont(FontController.getRegularLabelFont());
		this.panelHorario.add(this.spinnerAMPMinicio);

		lblHasta = new JLabel("hasta");
		panelHorario.add(lblHasta);
		lblHasta.setFont(FontController.getRegularLabelFont());

		spinHoraFinal = new JSpinner();
		this.spinHoraFinal.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		this.spinHoraFinal.setFont(FontController.getRegularLabelFont());
		panelHorario.add(spinHoraFinal);

		labeltime2 = new JLabel(":");
		panelHorario.add(labeltime2);
		labeltime2.setFont(FontController.getRegularLabelFont());

		spinMinutoFinal = new JSpinner();
		this.spinMinutoFinal.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		this.spinMinutoFinal.setFont(FontController.getRegularLabelFont());
		panelHorario.add(spinMinutoFinal);
		
		this.spinnerAMPMfinal = new JSpinner();
		this.spinnerAMPMfinal.setModel(new SpinnerListModel(new String[] {"AM", "PM"}));
		this.spinnerAMPMfinal.setFont(FontController.getRegularLabelFont());
		this.panelHorario.add(this.spinnerAMPMfinal);

		panelCosto = new JPanel();
		panelCosto.setOpaque(false);
		panelCosto.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Costo", TitledBorder.LEADING,
				TitledBorder.TOP, FontController.getBoldLabelFont(), null));
		panelContents.add(panelCosto);
		this.panelCosto.setLayout(new BorderLayout(0, 0));

		lblColones = new JLabel("\u20A1");
		panelCosto.add(lblColones, BorderLayout.WEST);

		txtCosto = new JDatabaseText(LibertadDatabaseConstraints.Curso_costo_NUMBER);
		this.txtCosto.setFont(FontController.getRegularLabelFont());
		panelCosto.add(txtCosto);
		txtCosto.setColumns(LibertadDatabaseConstraints.Curso_costo_NUMBER);

		panelMercado = new JPanel();
		panelMercado.setOpaque(false);
		panelMercado.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "Mercado Meta",
				TitledBorder.LEADING, TitledBorder.TOP, FontController.getBoldLabelFont(), null));
		panelContents.add(panelMercado);
		panelMercado.setLayout(new BorderLayout(0, 0));

		comboMercadoMeta = new JComboBox<String>();
		comboMercadoMeta.setFont(FontController.getRegularLabelFont());
		panelMercado.add(comboMercadoMeta);

		panelBottom = new JPanel();
		panelBottom.setBackground(DesignController.getWindowBGColor());
		FlowLayout fl_panelBottom = (FlowLayout) panelBottom.getLayout();
		fl_panelBottom.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelBottom, BorderLayout.SOUTH);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(FontController.getRegularLabelFont());
		panelBottom.add(btnRegistrar);
		
	}
}

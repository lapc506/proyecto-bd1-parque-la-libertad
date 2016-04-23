package org.parquelibertad.view.general;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.model.LibertadDatabaseConstraints;
import org.parquelibertad.view.jmodels.JDatabaseText;
import org.parquelibertad.view.templates.DialogTemplate;

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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AgregarCurso extends DialogTemplate {
  private static final long serialVersionUID = 3721795951153442361L;
  private JTextField        txtCosto;
  private JPanel            panelContents;
  private JPanel            panelCosto;
  private JLabel            lblNombreCurso;
  private JLabel            lblColones;
  private JTextField        txtNombre;
  private JLabel            lblProfesor;
  private JSpinner          spinHoraInicio;
  private JLabel            labeltime1;
  private JSpinner          spinMinutoInicio;
  private JLabel            lblHasta;
  private JSpinner          spinHoraFinal;
  private JLabel            labeltime2;
  private JSpinner          spinMinutoFinal;
  private JPanel            panelMercado;
  private JComboBox<String> comboMercadoMeta;
  private JPanel            panelBottom;
  private JButton           btnConfirmar;
  private JSpinner          spinnerAMPMinicio;
  private JSpinner          spinnerAMPMfinal;
  private JLabel            lblMercadoMeta;
  private JLabel            lblHorario;
  private JCheckBox         chckbxDomingo;
  private Container         panelSemana;
  private JCheckBox         chckbxLunes;
  private JCheckBox         chckbxMartes;
  private JCheckBox         chckbxMircoles;
  private JCheckBox         chckbxJueves;
  private JCheckBox         chckbxViernes;
  private JCheckBox         chckbxSbado;
  private JLabel            lblRegistrarCurso;
  private JPanel            panel;
  private JPanel            panelProfesor;
  private JTextField        txtProfesorSelected;
  private JButton btnFiltrar;
  private JLabel lblActivo;
  private JCheckBox chkActivo;

  public AgregarCurso(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException {
    super(parent, windowName, width, height, isResizable);
    setResizable(true);
    panelContents = new JPanel();
    panelContents.setForeground(new Color(255, 255, 0));
    panelContents.setName("");
    panelContents.setFocusable(false);
    panelContents.setOpaque(false);
    getContentPane().setLayout(new BorderLayout(0, 0));
    getContentPane().add(panelContents);
    this.panelContents.setLayout(new GridLayout(0, 1, 0, -1));

    this.lblRegistrarCurso = new JLabel("Registrar Curso");
    this.lblRegistrarCurso.setHorizontalAlignment(SwingConstants.CENTER);
    this.lblRegistrarCurso.setFont(FontController.getTitleFont());
    this.panelContents.add(this.lblRegistrarCurso);

    lblNombreCurso = new JLabel("Nombre");
    this.lblNombreCurso.setHorizontalAlignment(SwingConstants.CENTER);
    this.panelContents.add(this.lblNombreCurso);
    lblNombreCurso.setFont(FontController.getBoldLabelFont());

    txtNombre = new JDatabaseText(LibertadDatabaseConstraints.Curso_nombre_VARCHAR2);
    this.txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
    this.panelContents.add(this.txtNombre);
    this.txtNombre.setColumns(LibertadDatabaseConstraints.Curso_nombre_VARCHAR2);

    lblProfesor = new JLabel("Profesor");
    this.lblProfesor.setHorizontalAlignment(SwingConstants.CENTER);
    this.panelContents.add(this.lblProfesor);
    lblProfesor.setFont(FontController.getBoldLabelFont());

    this.panelProfesor = new JPanel();
    this.panelProfesor.setBackground(DesignController.getWindowBGColor());
    this.panelContents.add(this.panelProfesor);

    this.txtProfesorSelected = new JTextField();
    this.txtProfesorSelected.setEditable(false);
    this.txtProfesorSelected.setColumns(LibertadDatabaseConstraints.Persona_nombre_VARCHAR2); // spaces
    this.panelProfesor.add(this.txtProfesorSelected);
    
    this.btnFiltrar = new JButton("Filtrar...");
    this.panelProfesor.add(this.btnFiltrar);

    this.lblHorario = new JLabel("Horario");
    this.lblHorario.setHorizontalAlignment(SwingConstants.CENTER);
    this.panelContents.add(this.lblHorario);

    this.lblHorario.setFont(FontController.getBoldLabelFont());

    panelSemana = new JPanel();
    panelSemana.setBackground(DesignController.getWindowBGColor());
    panelContents.add(panelSemana);
    this.panelSemana.setLayout(new GridLayout(0, 3, 0, 0));

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

    chckbxDomingo = new JCheckBox("Domingo");
    this.chckbxDomingo.setFont(FontController.getRegularLabelFont());
    panelSemana.add(chckbxDomingo);
    chckbxDomingo.setOpaque(false);

    this.panel = new JPanel();
    this.panel.setBackground(new Color(255, 143, 0));
    this.panelContents.add(this.panel);
    GridBagLayout gbl_panel = new GridBagLayout();
    gbl_panel.columnWidths = new int[] {
        42, 3, 42, 36, 31, 42, 3, 42, 36
    };
    gbl_panel.rowHeights = new int[] {
        20
    };
    gbl_panel.columnWeights = new double[] {
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
    };
    gbl_panel.rowWeights = new double[] {
        0.0
    };
    this.panel.setLayout(gbl_panel);

    spinHoraInicio = new JSpinner();
    this.spinHoraInicio.setBackground(UIManager.getColor("Spinner.background"));
    this.spinHoraInicio.setModel(new SpinnerNumberModel(1, 1, 12, 1));
    this.spinHoraInicio.setFont(FontController.getRegularLabelFont());
    GridBagConstraints gbc_spinHoraInicio = new GridBagConstraints();
    gbc_spinHoraInicio.anchor = GridBagConstraints.NORTHWEST;
    gbc_spinHoraInicio.insets = new Insets(0, 0, 0, 5);
    gbc_spinHoraInicio.gridx = 0;
    gbc_spinHoraInicio.gridy = 0;
    this.panel.add(this.spinHoraInicio, gbc_spinHoraInicio);

    labeltime1 = new JLabel(":");
    labeltime1.setFont(FontController.getRegularLabelFont());
    GridBagConstraints gbc_labeltime1 = new GridBagConstraints();
    gbc_labeltime1.anchor = GridBagConstraints.WEST;
    gbc_labeltime1.insets = new Insets(0, 0, 0, 5);
    gbc_labeltime1.gridx = 1;
    gbc_labeltime1.gridy = 0;
    this.panel.add(this.labeltime1, gbc_labeltime1);

    spinMinutoInicio = new JSpinner();
    this.spinMinutoInicio.setModel(new SpinnerNumberModel(0, 0, 59, 1));
    this.spinMinutoInicio.setFont(FontController.getRegularLabelFont());
    GridBagConstraints gbc_spinMinutoInicio = new GridBagConstraints();
    gbc_spinMinutoInicio.anchor = GridBagConstraints.NORTHWEST;
    gbc_spinMinutoInicio.insets = new Insets(0, 0, 0, 5);
    gbc_spinMinutoInicio.gridx = 2;
    gbc_spinMinutoInicio.gridy = 0;
    this.panel.add(this.spinMinutoInicio, gbc_spinMinutoInicio);

    this.spinnerAMPMinicio = new JSpinner();
    this.spinnerAMPMinicio.setModel(new SpinnerListModel(new String[] {
        "AM", "PM"
    }));
    this.spinnerAMPMinicio.setFont(FontController.getRegularLabelFont());
    GridBagConstraints gbc_spinnerAMPMinicio = new GridBagConstraints();
    gbc_spinnerAMPMinicio.anchor = GridBagConstraints.NORTHWEST;
    gbc_spinnerAMPMinicio.insets = new Insets(0, 0, 0, 5);
    gbc_spinnerAMPMinicio.gridx = 3;
    gbc_spinnerAMPMinicio.gridy = 0;
    this.panel.add(this.spinnerAMPMinicio, gbc_spinnerAMPMinicio);

    lblHasta = new JLabel("hasta");
    this.lblHasta.setHorizontalAlignment(SwingConstants.CENTER);
    lblHasta.setFont(FontController.getRegularLabelFont());
    GridBagConstraints gbc_lblHasta = new GridBagConstraints();
    gbc_lblHasta.anchor = GridBagConstraints.WEST;
    gbc_lblHasta.insets = new Insets(0, 0, 0, 5);
    gbc_lblHasta.gridx = 4;
    gbc_lblHasta.gridy = 0;
    this.panel.add(this.lblHasta, gbc_lblHasta);

    spinHoraFinal = new JSpinner();
    this.spinHoraFinal.setModel(new SpinnerNumberModel(1, 1, 12, 1));
    this.spinHoraFinal.setFont(FontController.getRegularLabelFont());
    GridBagConstraints gbc_spinHoraFinal = new GridBagConstraints();
    gbc_spinHoraFinal.anchor = GridBagConstraints.NORTHWEST;
    gbc_spinHoraFinal.insets = new Insets(0, 0, 0, 5);
    gbc_spinHoraFinal.gridx = 5;
    gbc_spinHoraFinal.gridy = 0;
    this.panel.add(this.spinHoraFinal, gbc_spinHoraFinal);

    labeltime2 = new JLabel(":");
    labeltime2.setFont(FontController.getRegularLabelFont());
    GridBagConstraints gbc_labeltime2 = new GridBagConstraints();
    gbc_labeltime2.anchor = GridBagConstraints.WEST;
    gbc_labeltime2.insets = new Insets(0, 0, 0, 5);
    gbc_labeltime2.gridx = 6;
    gbc_labeltime2.gridy = 0;
    this.panel.add(this.labeltime2, gbc_labeltime2);

    spinMinutoFinal = new JSpinner();
    this.spinMinutoFinal.setModel(new SpinnerNumberModel(0, 0, 59, 1));
    this.spinMinutoFinal.setFont(FontController.getRegularLabelFont());
    GridBagConstraints gbc_spinMinutoFinal = new GridBagConstraints();
    gbc_spinMinutoFinal.anchor = GridBagConstraints.NORTHWEST;
    gbc_spinMinutoFinal.insets = new Insets(0, 0, 0, 5);
    gbc_spinMinutoFinal.gridx = 7;
    gbc_spinMinutoFinal.gridy = 0;
    this.panel.add(this.spinMinutoFinal, gbc_spinMinutoFinal);

    this.spinnerAMPMfinal = new JSpinner();
    this.spinnerAMPMfinal.setModel(new SpinnerListModel(new String[] {
        "AM", "PM"
    }));
    this.spinnerAMPMfinal.setFont(FontController.getRegularLabelFont());
    GridBagConstraints gbc_spinnerAMPMfinal = new GridBagConstraints();
    gbc_spinnerAMPMfinal.anchor = GridBagConstraints.NORTHWEST;
    gbc_spinnerAMPMfinal.gridx = 8;
    gbc_spinnerAMPMfinal.gridy = 0;
    this.panel.add(this.spinnerAMPMfinal, gbc_spinnerAMPMfinal);

    panelCosto = new JPanel();
    panelCosto.setOpaque(false);
    panelContents.add(panelCosto);
    this.panelCosto.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

    lblColones = new JLabel("Costo en moneda local:");
    lblColones.setFont(FontController.getBoldLabelFont());
    panelCosto.add(lblColones);

    txtCosto = new JDatabaseText(LibertadDatabaseConstraints.Curso_costo_NUMBER);
    txtCosto.setColumns(LibertadDatabaseConstraints.Curso_costo_NUMBER);
    txtCosto.setFont(FontController.getRegularLabelFont());
    panelCosto.add(txtCosto);

    panelMercado = new JPanel();
    panelMercado.setOpaque(false);
    panelContents.add(panelMercado);
    this.panelMercado.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

    this.lblMercadoMeta = new JLabel("Mercado Meta: ");
    this.lblMercadoMeta.setFont(FontController.getBoldLabelFont());
    this.panelMercado.add(this.lblMercadoMeta);

    comboMercadoMeta = new JComboBox<String>();
    this.comboMercadoMeta.setModel(new DefaultComboBoxModel<String>(new String[] {
        "12 a 17", "18 a 24"
    }));
    comboMercadoMeta.setFont(FontController.getRegularLabelFont());
    panelMercado.add(comboMercadoMeta);
    
    this.chkActivo = new JCheckBox("\u00BFEst\u00E1 Activo?");
    this.chkActivo.setBackground(DesignController.getWindowBGColor());
    this.chkActivo.setFont(FontController.getBoldLabelFont());
    this.panelMercado.add(this.chkActivo);

    panelBottom = new JPanel();
    panelBottom.setBackground(DesignController.getWindowBGColor());
    FlowLayout fl_panelBottom = (FlowLayout) panelBottom.getLayout();
    fl_panelBottom.setAlignment(FlowLayout.RIGHT);
    getContentPane().add(panelBottom, BorderLayout.SOUTH);

    btnConfirmar = new JButton("Confirmar");
    btnConfirmar.setFont(FontController.getRegularLabelFont());
    panelBottom.add(btnConfirmar);

  }
}

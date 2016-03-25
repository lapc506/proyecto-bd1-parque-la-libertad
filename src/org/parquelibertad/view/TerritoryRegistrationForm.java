/**
 * 
 */
package org.parquelibertad.view;

import java.awt.HeadlessException;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.parquelibertad.controller.DesignStyles;
import org.parquelibertad.controller.FontController;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.view
 * 
 * @author Luis Andrés Peña Castillo 2014057250
 *         Derechos reservados bajo licencia MIT.
 *
 */
@SuppressWarnings("serial")
public class TerritoryRegistrationForm extends WindowTemplate {
  private JLabel            lblRegistroDeTerritorios;
  private JPanel            contentPane;
  private JPanel            paisPanel;
  private JPanel            provinciaPanel;
  private JPanel            cantonPanel;
  private JPanel            distritoPanel;
  private JPanel            ciudadPanel;
  private JPanel            confirmPanel;
  private JButton           btnConfirmar;
  private JCheckBox         paisChkSeleccionado;
  private JRadioButton      paisRadAgregar;
  private JRadioButton      paisRadEditar;
  private final ButtonGroup paisButtonGroup      = new ButtonGroup();
  private JCheckBox         provinciaChkSeleccionado;
  private JRadioButton      provinciaRadAgregar;
  private JRadioButton      provinciaRadEditar;
  private JCheckBox         cantonChkSeleccionado;
  private JRadioButton      cantonChkAgregar;
  private JRadioButton      cantonChkEditar;
  private JCheckBox         distritoChkSeleccionado;
  private JRadioButton      distritoRadAgregar;
  private JRadioButton      distritoRadEditar;
  private JButton           btnCerrar;
  private JCheckBox         ciudadChkSeleccionado;
  private JRadioButton      ciudadRadAgregar;
  private JRadioButton      cuidadRadEditar;
  private final ButtonGroup provinciaButtonGroup = new ButtonGroup();
  private final ButtonGroup cantonButtonGroup    = new ButtonGroup();
  private final ButtonGroup distritoButtonGroup  = new ButtonGroup();
  private final ButtonGroup ciudadButtonGroup    = new ButtonGroup();
  private JPanel            paisPanel1;
  private JComboBox         paisComboBox;
  private JTextField        paisTxtNuevo;
  private JLabel            empty1;
  private JPanel            provinciaPanel1;
  private JComboBox         provinciaComboBox;
  private JLabel            empty2;
  private JTextField        provinciaTxtNuevo;
  private JPanel            panel;
  private JComboBox         cantonComboBox;
  private JLabel            empty3;
  private JTextField        cantonTxtNuevo;
  private JPanel            panel_1;
  private JComboBox         dsitritoComboBox;
  private JLabel            empty4;
  private JTextField        distritoTxtNuevo;
  private JPanel            panel_2;
  private JComboBox         ciudadComboBox;
  private JLabel            empty5;
  private JTextField        ciudadTxtNuevo;

  public TerritoryRegistrationForm(String windowName, int width, int height,
      boolean isVisible, boolean isResizable) throws HeadlessException {
    super(windowName, width, height, isVisible, isResizable);
    getContentPane().setLayout(new BorderLayout(0, 0));

    this.lblRegistroDeTerritorios = new JLabel("Registro de Territorios");
    if (FontController.getTitleFont() != null) {
      this.lblRegistroDeTerritorios.setFont(FontController.getTitleFont());
    }
    this.lblRegistroDeTerritorios.setHorizontalAlignment(SwingConstants.CENTER);
    this.lblRegistroDeTerritorios
        .setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    getContentPane().add(this.lblRegistroDeTerritorios, BorderLayout.NORTH);

    this.contentPane = new JPanel();
    this.contentPane.setBackground(DesignStyles.getWindowBGColor());
    getContentPane().add(this.contentPane, BorderLayout.CENTER);
    this.contentPane.setLayout(new BoxLayout(this.contentPane, BoxLayout.Y_AXIS));

    this.paisPanel = new JPanel();
    FlowLayout flowLayout_2 = (FlowLayout) this.paisPanel.getLayout();
    flowLayout_2.setVgap(0);
    flowLayout_2.setHgap(0);
    this.paisPanel
        .setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null),
            "Pa\u00EDs", TitledBorder.LEADING, TitledBorder.TOP,
            FontController.getBoldLabelFont(), DesignStyles.getFontColor()));
    this.paisPanel.setBackground(DesignStyles.getWindowBGColor());
    this.contentPane.add(this.paisPanel);

    this.paisPanel1 = new JPanel();
    this.paisPanel1.setBackground(DesignStyles.getWindowBGColor());
    this.paisPanel.add(this.paisPanel1);
    this.paisPanel1.setLayout(new GridLayout(2, 1, 0, 10));

    this.paisChkSeleccionado = new JCheckBox("Seleccionado?");
    this.paisChkSeleccionado.setFont(FontController.getRegularLabelFont());
    this.paisPanel1.add(this.paisChkSeleccionado);
    this.paisChkSeleccionado.setBackground(DesignStyles.getWindowBGColor());

    this.paisRadAgregar = new JRadioButton("Agregar");
    this.paisRadAgregar.setFont(FontController.getRegularLabelFont());
    this.paisPanel1.setFont(FontController.getRegularLabelFont());
    this.paisPanel1.add(this.paisRadAgregar);
    paisButtonGroup.add(this.paisRadAgregar);
    this.paisRadAgregar.setBackground(DesignStyles.getWindowBGColor());

    this.paisRadEditar = new JRadioButton("Editar");
    this.paisRadEditar.setFont(FontController.getRegularLabelFont());
    this.paisPanel1.setFont(FontController.getRegularLabelFont());
    this.paisPanel1.add(this.paisRadEditar);
    paisButtonGroup.add(this.paisRadEditar);
    this.paisRadEditar.setBackground(DesignStyles.getWindowBGColor());

    this.paisComboBox = new JComboBox();
    this.paisPanel1.add(this.paisComboBox);

    this.empty1 = new JLabel(" ");
    this.paisPanel1.add(this.empty1);

    this.paisTxtNuevo = new JTextField();
    this.paisPanel1.setFont(FontController.getRegularLabelFont());
    this.paisPanel1.add(this.paisTxtNuevo);
    this.paisTxtNuevo.setColumns(10);

    this.provinciaPanel = new JPanel();
    FlowLayout flowLayout_1 = (FlowLayout) this.provinciaPanel.getLayout();
    flowLayout_1.setVgap(0);
    flowLayout_1.setHgap(0);
    this.provinciaPanel
        .setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null),
            "Provincia", TitledBorder.LEADING, TitledBorder.TOP,
            FontController.getBoldLabelFont(), DesignStyles.getFontColor()));
    this.provinciaPanel.setBackground(DesignStyles.getWindowBGColor());
    this.contentPane.add(this.provinciaPanel);

    this.provinciaPanel1 = new JPanel();
    this.provinciaPanel1.setBackground(DesignStyles.getWindowBGColor());
    this.provinciaPanel.add(this.provinciaPanel1);
    this.provinciaPanel1.setLayout(new GridLayout(2, 1, 0, 10));

    this.provinciaChkSeleccionado = new JCheckBox("Seleccionado?");
    this.provinciaChkSeleccionado.setFont(FontController.getRegularLabelFont());
    this.provinciaPanel1.add(this.provinciaChkSeleccionado);
    this.provinciaChkSeleccionado.setBackground(DesignStyles.getWindowBGColor());

    this.provinciaRadAgregar = new JRadioButton("Agregar");
    this.provinciaRadAgregar.setFont(FontController.getRegularLabelFont());
    this.provinciaPanel1.setFont(FontController.getRegularLabelFont());
    this.provinciaPanel1.add(this.provinciaRadAgregar);
    provinciaButtonGroup.add(this.provinciaRadAgregar);
    this.provinciaRadAgregar.setBackground(DesignStyles.getWindowBGColor());

    this.provinciaRadEditar = new JRadioButton("Editar");
    this.provinciaRadEditar.setFont(FontController.getRegularLabelFont());
    this.provinciaPanel1.add(this.provinciaRadEditar);
    provinciaButtonGroup.add(this.provinciaRadEditar);
    this.provinciaRadEditar.setBackground(DesignStyles.getWindowBGColor());

    this.provinciaComboBox = new JComboBox();
    this.provinciaPanel1.add(this.provinciaComboBox);

    this.empty2 = new JLabel(" ");
    this.provinciaPanel1.add(this.empty2);

    this.provinciaTxtNuevo = new JTextField();
    this.provinciaTxtNuevo.setColumns(10);
    this.provinciaPanel1.add(this.provinciaTxtNuevo);

    this.cantonPanel = new JPanel();
    FlowLayout flowLayout_3 = (FlowLayout) this.cantonPanel.getLayout();
    flowLayout_3.setHgap(0);
    flowLayout_3.setVgap(0);
    this.cantonPanel
        .setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null),
            "Cant\u00F3n", TitledBorder.LEADING, TitledBorder.TOP,
            FontController.getBoldLabelFont(), DesignStyles.getFontColor()));
    this.cantonPanel.setBackground(DesignStyles.getWindowBGColor());
    this.contentPane.add(this.cantonPanel);

    this.panel = new JPanel();
    this.panel.setBackground(DesignStyles.getWindowBGColor());
    this.cantonPanel.add(this.panel);
    this.panel.setLayout(new GridLayout(2, 1, 0, 10));

    this.cantonChkSeleccionado = new JCheckBox("Seleccionado?");
    this.cantonChkSeleccionado.setFont(FontController.getRegularLabelFont());
    this.panel.add(this.cantonChkSeleccionado);
    this.cantonChkSeleccionado.setBackground(DesignStyles.getWindowBGColor());

    this.cantonChkAgregar = new JRadioButton("Agregar");
    this.cantonChkAgregar.setFont(FontController.getRegularLabelFont());
    this.panel.add(this.cantonChkAgregar);
    cantonButtonGroup.add(this.cantonChkAgregar);
    this.cantonChkAgregar.setBackground(DesignStyles.getWindowBGColor());

    this.cantonChkEditar = new JRadioButton("Editar");
    this.cantonChkEditar.setFont(FontController.getRegularLabelFont());
    this.panel.add(this.cantonChkEditar);
    cantonButtonGroup.add(this.cantonChkEditar);
    this.cantonChkEditar.setBackground(DesignStyles.getWindowBGColor());

    this.cantonComboBox = new JComboBox();
    this.panel.add(this.cantonComboBox);

    this.empty3 = new JLabel(" ");
    this.panel.add(this.empty3);

    this.cantonTxtNuevo = new JTextField();
    this.cantonTxtNuevo.setColumns(10);
    this.panel.add(this.cantonTxtNuevo);

    this.distritoPanel = new JPanel();
    FlowLayout flowLayout_4 = (FlowLayout) this.distritoPanel.getLayout();
    flowLayout_4.setHgap(0);
    flowLayout_4.setVgap(0);
    this.distritoPanel
        .setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null),
            "Distrito", TitledBorder.LEADING, TitledBorder.TOP,
            FontController.getBoldLabelFont(), DesignStyles.getFontColor()));
    this.distritoPanel.setBackground(DesignStyles.getWindowBGColor());
    this.contentPane.add(this.distritoPanel);

    this.panel_1 = new JPanel();
    this.panel_1.setBackground(DesignStyles.getWindowBGColor());
    this.distritoPanel.add(this.panel_1);
    this.panel_1.setLayout(new GridLayout(2, 1, 0, 10));

    this.distritoChkSeleccionado = new JCheckBox("Seleccionado?");
    this.distritoChkSeleccionado.setFont(FontController.getRegularLabelFont());
    this.panel_1.add(this.distritoChkSeleccionado);
    this.distritoChkSeleccionado.setBackground(DesignStyles.getWindowBGColor());

    this.distritoRadAgregar = new JRadioButton("Agregar");
    this.distritoRadAgregar.setFont(FontController.getRegularLabelFont());
    this.panel_1.add(this.distritoRadAgregar);
    distritoButtonGroup.add(this.distritoRadAgregar);
    this.distritoRadAgregar.setBackground(DesignStyles.getWindowBGColor());

    this.distritoRadEditar = new JRadioButton("Editar");
    this.distritoRadEditar.setFont(FontController.getRegularLabelFont());
    this.panel_1.add(this.distritoRadEditar);
    distritoButtonGroup.add(this.distritoRadEditar);
    this.distritoRadEditar.setBackground(DesignStyles.getWindowBGColor());

    this.dsitritoComboBox = new JComboBox();
    this.panel_1.setFont(FontController.getRegularLabelFont());
    this.panel_1.add(this.dsitritoComboBox);

    this.empty4 = new JLabel(" ");
    this.panel_1.add(this.empty4);

    this.distritoTxtNuevo = new JTextField();
    this.distritoTxtNuevo.setFont(FontController.getRegularLabelFont());
    this.distritoTxtNuevo.setColumns(10);
    this.panel_1.add(this.distritoTxtNuevo);

    this.ciudadPanel = new JPanel();
    FlowLayout flowLayout_5 = (FlowLayout) this.ciudadPanel.getLayout();
    flowLayout_5.setVgap(0);
    flowLayout_5.setHgap(0);
    this.ciudadPanel
        .setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null),
            "Ciudad", TitledBorder.LEADING, TitledBorder.TOP,
            FontController.getBoldLabelFont(), DesignStyles.getFontColor()));
    this.ciudadPanel.setBackground(DesignStyles.getWindowBGColor());
    this.contentPane.add(this.ciudadPanel);

    this.panel_2 = new JPanel();
    this.panel_2.setBackground(DesignStyles.getWindowBGColor());
    this.ciudadPanel.add(this.panel_2);
    this.panel_2.setLayout(new GridLayout(2, 1, 0, 10));

    this.ciudadChkSeleccionado = new JCheckBox("Seleccionado?");
    this.ciudadChkSeleccionado.setFont(FontController.getRegularLabelFont());
    this.panel_2.add(this.ciudadChkSeleccionado);
    this.ciudadChkSeleccionado.setBackground(DesignStyles.getWindowBGColor());

    this.ciudadRadAgregar = new JRadioButton("Agregar");
    this.ciudadRadAgregar.setFont(FontController.getRegularLabelFont());
    this.panel_2.add(this.ciudadRadAgregar);
    ciudadButtonGroup.add(this.ciudadRadAgregar);
    this.ciudadRadAgregar.setBackground(DesignStyles.getWindowBGColor());

    this.cuidadRadEditar = new JRadioButton("Editar");
    this.cuidadRadEditar.setFont(FontController.getRegularLabelFont());
    this.panel_2.add(this.cuidadRadEditar);
    ciudadButtonGroup.add(this.cuidadRadEditar);
    this.cuidadRadEditar.setBackground(DesignStyles.getWindowBGColor());

    this.ciudadComboBox = new JComboBox();
    this.panel_2.add(this.ciudadComboBox);

    this.empty5 = new JLabel(" ");
    this.panel_2.add(this.empty5);

    this.ciudadTxtNuevo = new JTextField();
    this.ciudadTxtNuevo.setColumns(10);
    this.panel_2.add(this.ciudadTxtNuevo);

    this.confirmPanel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) this.confirmPanel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    getContentPane().add(this.confirmPanel, BorderLayout.SOUTH);
    this.confirmPanel.setBackground(DesignStyles.getWindowBGColor());

    this.btnConfirmar = new JButton("Confirmar Acci\u00F3n");
    this.btnConfirmar.setFont(FontController.getRegularLabelFont());
    this.confirmPanel.add(this.btnConfirmar);

    this.btnCerrar = new JButton("Cerrar");
    this.btnCerrar.setFont(FontController.getRegularLabelFont());
    this.btnCerrar.addActionListener(event -> this.dispose());
    this.confirmPanel.add(this.btnCerrar);

  }

}

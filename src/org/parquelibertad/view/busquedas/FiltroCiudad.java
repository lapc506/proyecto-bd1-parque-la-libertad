/**
 * Ventana donde se pueden editar e incluír nuevos territorios en el sistema.
 * Esta ventana debe contectarse a la base de datos para cada consulta y
 * edición.
 * 
 */
package org.parquelibertad.view.busquedas;

import java.awt.HeadlessException;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;

import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.view.templates.DialogTemplate;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.view
 * 
 * @author Luis Andrés Peña Castillo 2014057250
 *         Derechos reservados bajo licencia MIT.
 *
 */
@SuppressWarnings("serial")
public class FiltroCiudad extends DialogTemplate {
  private JLabel            lblSeleccion;
  private JPanel            contentPane;
  private JPanel            paisPanel;
  private JPanel            provinciaPanel;
  private JPanel            cantonPanel;
  private JPanel            distritoPanel;
  private JPanel            ciudadPanel;
  private JPanel            confirmPanel;
  private JButton           btnConfirmar;
  private JButton           btnCerrar;
  private JComboBox<String> paisComboBox;
  private JComboBox<String> provinciaComboBox;
  private JComboBox<String> cantonComboBox;
  private JComboBox<String> distritoComboBox;
  private JComboBox<String> ciudadComboBox;

  public FiltroCiudad(JFrame parent, String windowName, int width, int height, 
      boolean isResizable) throws HeadlessException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setLayout(new BorderLayout(0, 0));

    this.lblSeleccion = new JLabel("Seleccione ciudad de origen:");
    this.lblSeleccion.setFont(FontController.getSubtitleFont());
    this.lblSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
    this.lblSeleccion
        .setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    getContentPane().add(this.lblSeleccion, BorderLayout.NORTH);

    this.contentPane = new JPanel();
    this.contentPane.setBackground(DesignController.getWindowBGColor());
    getContentPane().add(this.contentPane, BorderLayout.CENTER);
    this.contentPane.setLayout(new BoxLayout(this.contentPane, BoxLayout.Y_AXIS));

    this.paisPanel = new JPanel();
    FlowLayout flowLayout_2 = (FlowLayout) this.paisPanel.getLayout();
    flowLayout_2.setVgap(0);
    flowLayout_2.setHgap(0);
    this.paisPanel
        .setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null),
            "Pa\u00EDs", TitledBorder.LEADING, TitledBorder.TOP,
            FontController.getBoldLabelFont(), DesignController.getFontColor()));
    this.paisPanel.setBackground(DesignController.getWindowBGColor());
    this.contentPane.add(this.paisPanel);
    
        this.paisComboBox = new JComboBox<String>();
        this.paisPanel.add(this.paisComboBox);

    this.provinciaPanel = new JPanel();
    FlowLayout flowLayout_1 = (FlowLayout) this.provinciaPanel.getLayout();
    flowLayout_1.setVgap(0);
    flowLayout_1.setHgap(0);
    this.provinciaPanel
        .setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null),
            "Provincia", TitledBorder.LEADING, TitledBorder.TOP,
            FontController.getBoldLabelFont(), DesignController.getFontColor()));
    this.provinciaPanel.setBackground(DesignController.getWindowBGColor());
    this.contentPane.add(this.provinciaPanel);
    
        this.provinciaComboBox = new JComboBox<String>();
        this.provinciaPanel.add(this.provinciaComboBox);

    this.cantonPanel = new JPanel();
    FlowLayout flowLayout_3 = (FlowLayout) this.cantonPanel.getLayout();
    flowLayout_3.setHgap(0);
    flowLayout_3.setVgap(0);
    this.cantonPanel
        .setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null),
            "Cant\u00F3n", TitledBorder.LEADING, TitledBorder.TOP,
            FontController.getBoldLabelFont(), DesignController.getFontColor()));
    this.cantonPanel.setBackground(DesignController.getWindowBGColor());
    this.contentPane.add(this.cantonPanel);
    
        this.cantonComboBox = new JComboBox<String>();
        this.cantonPanel.add(this.cantonComboBox);

    this.distritoPanel = new JPanel();
    FlowLayout flowLayout_4 = (FlowLayout) this.distritoPanel.getLayout();
    flowLayout_4.setHgap(0);
    flowLayout_4.setVgap(0);
    this.distritoPanel
        .setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null),
            "Distrito", TitledBorder.LEADING, TitledBorder.TOP,
            FontController.getBoldLabelFont(), DesignController.getFontColor()));
    this.distritoPanel.setBackground(DesignController.getWindowBGColor());
    this.contentPane.add(this.distritoPanel);
    
        this.distritoComboBox = new JComboBox<String>();
        this.distritoPanel.add(this.distritoComboBox);

    this.ciudadPanel = new JPanel();
    FlowLayout flowLayout_5 = (FlowLayout) this.ciudadPanel.getLayout();
    flowLayout_5.setVgap(0);
    flowLayout_5.setHgap(0);
    this.ciudadPanel
        .setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null),
            "Ciudad", TitledBorder.LEADING, TitledBorder.TOP,
            FontController.getBoldLabelFont(), DesignController.getFontColor()));
    this.ciudadPanel.setBackground(DesignController.getWindowBGColor());
    this.contentPane.add(this.ciudadPanel);
    
        this.ciudadComboBox = new JComboBox<String>();
        this.ciudadPanel.add(this.ciudadComboBox);

    this.confirmPanel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) this.confirmPanel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    getContentPane().add(this.confirmPanel, BorderLayout.SOUTH);
    this.confirmPanel.setBackground(DesignController.getWindowBGColor());

    this.btnConfirmar = new JButton("Confirmar Acci\u00F3n");
    this.btnConfirmar.setFont(FontController.getRegularLabelFont());
    this.confirmPanel.add(this.btnConfirmar);

    this.btnCerrar = new JButton("Cerrar");
    this.btnCerrar.setFont(FontController.getRegularLabelFont());
    this.btnCerrar.addActionListener(event -> this.dispose());
    this.confirmPanel.add(this.btnCerrar);

    revalidate();
    repaint();
  }
}

/**
 * Ventana donde se pueden editar e incluír nuevos territorios en el sistema.
 * Esta ventana debe contectarse a la base de datos para cada consulta y
 * edición.
 * 
 */
package org.parquelibertad.view.adminDialogs;

import java.awt.HeadlessException;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;

import org.parquelibertad.controller.MainController;
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
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
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
public class EditarTerritorio extends DialogTemplate {
  private JLabel  lblRegistroDeTerritorios;
  private JPanel  contentPane;
  private JPanel  confirmPanel;
  private JButton btnCerrar;
  private JButton btnAgregarProvincia;
  private JButton btnAgregarPais;
  private JButton btnAgregarCanton;
  private JButton btnAgregarDistrito;
  private JButton btnAgregarCiudad;
  private JPanel  rightSide;
  private JPanel  leftSide;
  private JButton btnEditarPais;
  private JButton btnEditarProvincia;
  private JButton btnEditarCanton;
  private JButton btnEditarDistrito;
  private JButton btnEditarCiudad;

  public EditarTerritorio(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setLayout(new BorderLayout(0, 0));

    this.lblRegistroDeTerritorios = new JLabel("Registro de Territorios");
    this.lblRegistroDeTerritorios.setFont(FontController.getTitleFont());
    this.lblRegistroDeTerritorios.setHorizontalAlignment(SwingConstants.CENTER);
    this.lblRegistroDeTerritorios
        .setBorder(BorderFactory.createEmptyBorder(3, 15, 3, 15));
    getContentPane().add(this.lblRegistroDeTerritorios, BorderLayout.NORTH);

    this.contentPane = new JPanel();
    this.contentPane.setBackground(DesignController.getWindowBGColor());
    getContentPane().add(this.contentPane, BorderLayout.CENTER);
    this.contentPane.setLayout(new GridLayout(0, 2, 0, 0));

    this.leftSide = new JPanel();
    this.leftSide.setBackground(DesignController.getWindowBGColor());
    this.contentPane.add(this.leftSide);
    this.leftSide.setLayout(new GridLayout(0, 1, 0, 0));

    this.btnAgregarPais = new JButton("Agregar Pa\u00EDs");
    this.btnAgregarPais
        .addActionListener(event -> MainController.getInstance().showAddPais());
    this.btnAgregarPais.setFont(FontController.getRegularLabelFont());
    this.leftSide.add(this.btnAgregarPais);

    this.btnAgregarProvincia = new JButton("Agregar Provincia");
    this.btnAgregarProvincia.setFont(FontController.getRegularLabelFont());
    this.leftSide.add(this.btnAgregarProvincia);

    this.btnAgregarCanton = new JButton("Agregar Cant\u00F3n");
    this.btnAgregarCanton.setFont(FontController.getRegularLabelFont());
    this.leftSide.add(this.btnAgregarCanton);

    this.btnAgregarDistrito = new JButton("Agregar Distrito");
    this.btnAgregarDistrito.setFont(FontController.getRegularLabelFont());
    this.leftSide.add(this.btnAgregarDistrito);

    this.btnAgregarCiudad = new JButton("Agregar Ciudad");
    this.btnAgregarCiudad.setFont(FontController.getRegularLabelFont());
    this.leftSide.add(this.btnAgregarCiudad);

    this.rightSide = new JPanel();
    this.rightSide.setBackground(DesignController.getWindowBGColor());
    this.contentPane.add(this.rightSide);
    this.rightSide.setLayout(new GridLayout(0, 1, 0, 0));

    this.btnEditarPais = new JButton("Editar Pa\u00EDs");
    this.btnEditarPais.setFont(FontController.getRegularLabelFont());
    this.btnEditarPais
        .addActionListener(event -> MainController.getInstance().showEditPais());
    this.rightSide.add(this.btnEditarPais);

    this.btnEditarProvincia = new JButton("Editar Provincia");
    this.btnEditarProvincia.setFont(FontController.getRegularLabelFont());
    this.rightSide.add(this.btnEditarProvincia);

    this.btnEditarCanton = new JButton("Editar Cant\u00F3n");
    this.btnEditarCanton.setFont(FontController.getRegularLabelFont());
    this.rightSide.add(this.btnEditarCanton);

    this.btnEditarDistrito = new JButton("Editar Distrito");
    this.btnEditarDistrito.setFont(FontController.getRegularLabelFont());
    this.rightSide.add(this.btnEditarDistrito);

    this.btnEditarCiudad = new JButton("Editar Ciudad");
    this.btnEditarCiudad.setFont(FontController.getRegularLabelFont());
    this.rightSide.add(this.btnEditarCiudad);

    this.confirmPanel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) this.confirmPanel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    getContentPane().add(this.confirmPanel, BorderLayout.SOUTH);
    this.confirmPanel.setBackground(DesignController.getWindowBGColor());

    this.btnCerrar = new JButton("Cerrar");
    this.btnCerrar.setFont(FontController.getRegularLabelFont());
    this.btnCerrar.addActionListener(event -> this.dispose());
    this.confirmPanel.add(this.btnCerrar);
  }
}

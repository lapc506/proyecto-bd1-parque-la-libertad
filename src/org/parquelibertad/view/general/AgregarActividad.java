package org.parquelibertad.view.general;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.parquelibertad.controller.QueryController;
import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.model.LibertadDatabaseConstraints;
import org.parquelibertad.view.jmodels.JDatabaseText;
import org.parquelibertad.view.templates.DialogTemplate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

public class AgregarActividad extends DialogTemplate {

  private static final long serialVersionUID = -6898829432408750711L;
  private JDatabaseText     txtDescripcion;
  private JPanel            panelDetalles;
  private JLabel            lblRegistrarCurso;
  private JLabel            lblDescripcion;
  private JLabel            lblTipo;
  private JComboBox<String> comboTipoActividad;
  private JButton           btnRegistrar;
  private JPanel            panel;
  private JButton           btnCancelar;
  private JCheckBox         chkActiva;
  private Vector<Integer>   idsTiposActividad;
  private JLabel label;
  private JLabel label_1;

  public AgregarActividad(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException, SQLException {
    super(parent, windowName, width, height, isResizable);
    BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
    borderLayout.setVgap(10);
    borderLayout.setHgap(10);

    this.lblRegistrarCurso = new JLabel("Registrar Actividad");
    this.lblRegistrarCurso.setHorizontalAlignment(SwingConstants.CENTER);
    this.lblRegistrarCurso.setFont(FontController.getTitleFont());
    getContentPane().add(this.lblRegistrarCurso, BorderLayout.NORTH);

    panel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) panel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    panel.setOpaque(false);
    getContentPane().add(panel, BorderLayout.SOUTH);

    btnRegistrar = new JButton("Registrar");
    btnRegistrar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
          QueryController.insertarActividad(txtDescripcion.getText(),
              idsTiposActividad.elementAt(comboTipoActividad.getSelectedIndex()),
              chkActiva.isSelected());
          dispose();
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(rootPane, e.getMessage(),
              "Error a la hora de confirmar inserción.", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    btnRegistrar.setFont(FontController.getRegularLabelFont());
    panel.add(btnRegistrar);

    btnCancelar = new JButton("Cancelar");
    btnCancelar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        dispose();
      }
    });
    btnCancelar.setFont(FontController.getRegularLabelFont());
    panel.add(btnCancelar);

    this.panelDetalles = new JPanel();
    this.panelDetalles.setOpaque(false);
    getContentPane().add(this.panelDetalles);
    panelDetalles.setLayout(new BoxLayout(panelDetalles, BoxLayout.Y_AXIS));

    lblDescripcion = new JLabel("Descripci\u00F3n");
    lblDescripcion.setFont(FontController.getBoldLabelFont());
    this.panelDetalles.add(lblDescripcion);

    txtDescripcion = new JDatabaseText(
        LibertadDatabaseConstraints.Actividad_descripcion_VARCHAR2);
    txtDescripcion.setFont(FontController.getRegularLabelFont());
    // txtDescripcion.setColumns(10);
    this.panelDetalles.add(this.txtDescripcion);

    lblTipo = new JLabel("Tipo de Actividad");
    lblTipo.setFont(FontController.getBoldLabelFont());
    this.panelDetalles.add(lblTipo);

    comboTipoActividad = new JComboBox<String>();
    comboTipoActividad.setFont(FontController.getRegularLabelFont());
    this.panelDetalles.add(comboTipoActividad);

    chkActiva = new JCheckBox("Est\u00E1 activa?");
    chkActiva.setFont(FontController.getBoldLabelFont());
    chkActiva.setOpaque(false);
    panelDetalles.add(chkActiva);
    
    label = new JLabel("  ");
    getContentPane().add(label, BorderLayout.WEST);
    
    label_1 = new JLabel("  ");
    getContentPane().add(label_1, BorderLayout.EAST);

    loadConnections();
  }

  private void loadConnections() throws SQLException {
    idsTiposActividad = new Vector<Integer>();
    HashMap<Integer, String> tiposActividad = QueryController.getTiposActividad();
    Vector<String> textTipos = new Vector<String>();
    for (Integer x : tiposActividad.keySet()) {
      idsTiposActividad.addElement(x);
      textTipos.addElement(tiposActividad.get(x));
    }
    comboTipoActividad.setModel(new DefaultComboBoxModel<String>(textTipos));
  }
}

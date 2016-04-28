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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;

import org.parquelibertad.controller.QueryController;
import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.view.jmodels.DatabaseTableModel;
import org.parquelibertad.view.templates.DialogTemplate;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
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
public class FiltroDistrito extends DialogTemplate {
  private Integer           selectedDistritoID = -1;

  private JLabel            lblSeleccion;
  private JPanel            contentPane;
  private JPanel            paisPanel;
  private JPanel            provinciaPanel;
  private JPanel            cantonPanel;
  private JPanel            distritoPanel;
  private JPanel            confirmPanel;
  private JButton           btnConfirmar;
  private JButton           btnCerrar;
  private JComboBox<String> comboBoxPaises;
  private JComboBox<String> comboBoxProvincias;
  private JComboBox<String> comboBoxCantones;
  private JComboBox<String> comboBoxDistrito;
  private JCheckBox         checkPais;
  private JCheckBox         checkProvincia;
  private JCheckBox         checkCanton;

  private Vector<Integer> idsProvincias;

  private Vector<Integer> idsPaises;

  private Vector<Integer> idsCantones;

  private Vector<Integer> idsDistritos;

  public FiltroDistrito(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException, SQLException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setLayout(new BorderLayout(0, 0));

    this.lblSeleccion = new JLabel("Seleccione ciudad de origen:");
    this.lblSeleccion.setFont(FontController.getSubtitleFont());
    this.lblSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
    this.lblSeleccion.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
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

    this.comboBoxPaises = new JComboBox<String>();
    this.paisPanel.add(this.comboBoxPaises);

    this.checkPais = new JCheckBox("Confirmado");
    this.checkPais.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent arg0) {
        if (checkPais.isSelected()) {
          try {
            HashMap<Integer, String> provincias = QueryController.getProvinciasPorPais(idsPaises.get(comboBoxPaises.getSelectedIndex()));
            Vector<String> contents = new Vector<String>();
            for (Integer x : provincias.keySet()) {
              idsProvincias.addElement(x);
              contents.addElement(provincias.get(x));
            }
            comboBoxPaises.setEnabled(false); // Para mantener consistencia
            comboBoxProvincias.setEnabled(true);
            comboBoxProvincias.setModel(new DefaultComboBoxModel<String>(contents));
            checkProvincia.setEnabled(true);
          } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "SQL Error",
                JOptionPane.ERROR_MESSAGE);
          }
          ;
        } else {
          comboBoxProvincias.setModel(new DefaultComboBoxModel<>());
          idsProvincias.clear();
          comboBoxPaises.setEnabled(true); // Para mantener consistencia
          comboBoxProvincias.setEnabled(false);
          checkProvincia.setEnabled(false);
        }
      }
    });
    this.checkPais.setOpaque(false);
    this.paisPanel.add(this.checkPais);

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

    this.comboBoxProvincias = new JComboBox<String>();
    this.provinciaPanel.add(this.comboBoxProvincias);

    this.checkProvincia = new JCheckBox("Confirmado");
    this.checkProvincia.setEnabled(false);
    this.checkProvincia.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent arg0) {
        if (checkProvincia.isSelected()) {
          try {
            checkPais.setEnabled(false);
            comboBoxProvincias.setEnabled(false); // Para mantener consistencia
            HashMap<Integer, String> cantones = QueryController
                .getCantonesPorProvincia(idsProvincias.get(comboBoxProvincias.getSelectedIndex()));
            Vector<String> contents = new Vector<String>();
            for (Integer x : cantones.keySet()) {
              idsCantones.addElement(x);
              contents.addElement(cantones.get(x));
            }
            
            comboBoxCantones.setEnabled(true);
            comboBoxCantones.setModel(new DefaultComboBoxModel<String>(contents));
            checkCanton.setEnabled(true);
            
          } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "SQL Error",
                JOptionPane.ERROR_MESSAGE);
          }
          ;
        } else {
          comboBoxCantones.setModel(new DefaultComboBoxModel<>());
          comboBoxCantones.setEnabled(true);
          idsCantones.clear();
          checkCanton.setEnabled(false);
          checkPais.setEnabled(true);
        }
      }
    });
    this.checkProvincia.setOpaque(false);
    this.provinciaPanel.add(this.checkProvincia);

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

    this.comboBoxCantones = new JComboBox<String>();
    this.cantonPanel.add(this.comboBoxCantones);

    this.checkCanton = new JCheckBox("Confirmado");
    this.checkCanton.setEnabled(false);
    this.checkCanton.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent arg0) {
        if (checkCanton.isSelected()) {
          try {
            checkProvincia.setEnabled(false); // Para mantener consistencia
            comboBoxCantones.setEnabled(false); // Para mantener consistencia
            HashMap<Integer, String> distritos = QueryController.getDistritosPorCanton(
                idsCantones.get(comboBoxCantones.getSelectedIndex()));
            Vector<String> contents = new Vector<String>();
            for (Integer x : distritos.keySet()) {
              idsDistritos.addElement(x);
              contents.addElement(distritos.get(x));
              // System.out.println(x + " " + cantones.get(x));
            }


            comboBoxDistrito.setEnabled(true);
            comboBoxDistrito.setModel(new DefaultComboBoxModel<String>(contents));
          } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "SQL Error",
                JOptionPane.ERROR_MESSAGE);
          }
          ;
        } else {
          comboBoxDistrito.setModel(new DefaultComboBoxModel<>());
          comboBoxDistrito.setEnabled(false);
          idsDistritos.clear();
          checkProvincia.setEnabled(true); // Para mantener consistencia
          comboBoxCantones.setEnabled(true); // Para mantener consistencia
          
          
        }
      }
    });
    this.checkCanton.setOpaque(false);
    this.cantonPanel.add(this.checkCanton);

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

    this.comboBoxDistrito = new JComboBox<String>();
    this.distritoPanel.add(this.comboBoxDistrito);

    this.confirmPanel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) this.confirmPanel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    getContentPane().add(this.confirmPanel, BorderLayout.SOUTH);
    this.confirmPanel.setBackground(DesignController.getWindowBGColor());

    this.btnConfirmar = new JButton("Seleccionar");
    this.btnConfirmar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        selectedDistritoID = idsDistritos.elementAt(comboBoxDistrito.getSelectedIndex());
        // System.out.println(selectedDistritoID);
        dispose();
      }
    });
    this.btnConfirmar.setFont(FontController.getRegularLabelFont());
    this.confirmPanel.add(this.btnConfirmar);

    this.btnCerrar = new JButton("Cerrar");
    this.btnCerrar.setFont(FontController.getRegularLabelFont());
    this.btnCerrar.addActionListener(event -> this.dispose());
    this.confirmPanel.add(this.btnCerrar);
    loadConnections();
  }
  private void loadConnections() throws SQLException {
    idsPaises = new Vector<Integer>();
    idsProvincias = new Vector<Integer>();
    idsCantones = new Vector<Integer>();
    idsDistritos = new Vector<Integer>();

    HashMap<Integer, String> paises = QueryController.getPaises();
    Vector<String> contents = new Vector<String>();
    for (Integer x : paises.keySet()) {
      idsPaises.addElement(x);
      contents.addElement(paises.get(x));
    }
    this.comboBoxPaises.setModel(new DefaultComboBoxModel<String>(contents));
  }
  public Integer getSelectedDistritoID(){
    return selectedDistritoID;
  }
}

package org.parquelibertad.view.busquedas;

import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JFrame;

import org.parquelibertad.controller.QueryController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.view.jmodels.DatabaseTableModel;
import org.parquelibertad.view.templates.DialogTemplate;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FiltroTerritorio extends DialogTemplate {
  private static final long serialVersionUID  = 59331234940240453L;

  private Integer           selectedPersonaID = -1;

  private JLabel            lblBsquedaPorTerritorio;
  private JPanel            panelActions;
  private JButton           btnBuscar;
  private JPanel            panelContent;
  private JComboBox<String> comboBoxPaises;
  private JComboBox<String> comboBoxProvincias;
  private JLabel            lblPais;
  private JCheckBox         checkProvincia;
  private JCheckBox         checkCanton;
  private JComboBox<String> comboBoxCanton;
  private JCheckBox         checkDistrito;
  private JComboBox<String> comboBoxDistrito;
  private JPanel            panel;
  private JTable            tableContents;
  private JButton           btnSeleccionar;

  private Vector<Integer>   idsPaises;

  private Vector<Integer>   idsProvincias;

  private Vector<Integer>   idsCantones;

  private Vector<Integer>   idsDistritos;

  protected String          selectedPersonaDetalle;

  public FiltroTerritorio(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException, SQLException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setLayout(new BorderLayout(0, 0));

    this.lblBsquedaPorTerritorio = new JLabel("B\u00FAsqueda por Territorio");
    this.lblBsquedaPorTerritorio.setFont(FontController.getTitleFont());
    this.lblBsquedaPorTerritorio.setHorizontalAlignment(SwingConstants.CENTER);
    getContentPane().add(this.lblBsquedaPorTerritorio, BorderLayout.NORTH);

    this.panelActions = new JPanel();
    FlowLayout flowLayout = (FlowLayout) this.panelActions.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    this.panelActions.setOpaque(false);

    getContentPane().add(this.panelActions, BorderLayout.SOUTH);

    btnSeleccionar = new JButton("Seleccionar");
    btnSeleccionar.setFont(FontController.getRegularLabelFont());
    this.btnSeleccionar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        // Asume que el modelo es un modelo concreto de AbstractTableModel
        DatabaseTableModel data = (DatabaseTableModel) tableContents.getModel();
        selectedPersonaID = data.getDBIndex(tableContents.getSelectedRow());
        // Según: QueryController.buscarPersonaTerritorios
        selectedPersonaDetalle = (String) data.getValueAt(tableContents.getSelectedRow(), 0)
            + " "
              + (String) data.getValueAt(tableContents.getSelectedRow(), 1)
              + " "
              + (String) data.getValueAt(tableContents.getSelectedRow(), 2);
        dispose();
      }
    });
    panelActions.add(btnSeleccionar);

    panel = new JPanel();
    panel.setOpaque(false);
    getContentPane().add(panel, BorderLayout.WEST);
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    this.panelContent = new JPanel();
    this.panelContent.setOpaque(false);
    this.panel.add(panelContent);

    this.lblPais = new JLabel("Pa\u00EDs");
    this.lblPais.setFont(FontController.getRegularLabelFont());
    this.lblPais.setHorizontalAlignment(SwingConstants.CENTER);
    this.panelContent.add(lblPais);

    this.panelContent.setLayout(new GridLayout(0, 2, 0, 0));

    this.comboBoxPaises = new JComboBox<String>();
    this.comboBoxPaises.setFont(FontController.getRegularLabelFont());
    this.panelContent.add(this.comboBoxPaises);

    this.checkProvincia = new JCheckBox("Provincia");
    this.checkProvincia.setFont(FontController.getRegularLabelFont());
    this.checkProvincia.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent arg0) {
        if (checkProvincia.isSelected()) {
          try {
            HashMap<Integer, String> provincias = QueryController
                .getProvinciasPorPais(idsPaises.get(comboBoxPaises.getSelectedIndex()));
            Vector<String> contents = new Vector<String>();
            for (Integer x : provincias.keySet()) {
              idsProvincias.addElement(x);
              contents.addElement(provincias.get(x));
            }
            comboBoxPaises.setEnabled(false); // Para mantener consistencia
            comboBoxProvincias.setEnabled(true);
            comboBoxProvincias.setModel(new DefaultComboBoxModel<String>(contents));
            checkCanton.setEnabled(true);
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
          checkCanton.setEnabled(false);
        }
      }
    });
    checkProvincia.setOpaque(false);
    this.checkProvincia.setHorizontalAlignment(SwingConstants.CENTER);
    panelContent.add(checkProvincia);
    // ----------------------------------
    comboBoxProvincias = new JComboBox<String>();
    comboBoxProvincias.setFont(FontController.getRegularLabelFont());
    this.comboBoxProvincias.setEnabled(false);
    comboBoxProvincias.setModel(new DefaultComboBoxModel<>());
    panelContent.add(comboBoxProvincias);
    // ----------------------------------
    checkCanton = new JCheckBox("Cant\u00F3n");
    checkCanton.setFont(FontController.getRegularLabelFont());
    this.checkCanton.setEnabled(false);
    checkCanton.setOpaque(false);
    checkCanton.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent arg0) {
        if (checkCanton.isSelected()) {
          try {
            HashMap<Integer, String> cantones = QueryController.getCantonesPorProvincia(
                idsProvincias.get(comboBoxProvincias.getSelectedIndex()));
            Vector<String> contents = new Vector<String>();
            for (Integer x : cantones.keySet()) {
              idsCantones.addElement(x);
              contents.addElement(cantones.get(x));
              // System.out.println(x + " " + cantones.get(x));
            }
            checkProvincia.setEnabled(false); // Para mantener consistencia
            comboBoxProvincias.setEnabled(false); // Para mantener consistencia

            comboBoxCanton.setEnabled(true);
            comboBoxCanton.setModel(new DefaultComboBoxModel<String>(contents));
            checkDistrito.setEnabled(true);
          } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "SQL Error",
                JOptionPane.ERROR_MESSAGE);
          }
          ;
        } else {
          comboBoxCanton.setModel(new DefaultComboBoxModel<>());
          checkProvincia.setEnabled(true); // Para mantener consistencia
          comboBoxProvincias.setEnabled(true); // Para mantener consistencia
          idsCantones.clear();
          comboBoxCanton.setEnabled(false);
          checkDistrito.setEnabled(false);
        }
      }
    });
    this.checkCanton.setHorizontalAlignment(SwingConstants.CENTER);
    panelContent.add(checkCanton);
    // ----------------------------------
    comboBoxCanton = new JComboBox<String>();
    comboBoxCanton.setFont(FontController.getRegularLabelFont());
    this.comboBoxCanton.setEnabled(false);
    panelContent.add(comboBoxCanton);
    // ----------------------------------
    checkDistrito = new JCheckBox("Distrito");
    checkDistrito.setFont(FontController.getRegularLabelFont());
    this.checkDistrito.setEnabled(false);
    checkDistrito.setOpaque(false);
    checkDistrito.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent arg0) {
        if (checkDistrito.isSelected()) {
          try {
            // System.out.println(idsCantones.get(comboBoxCanton.getSelectedIndex()));
            HashMap<Integer, String> distritos = QueryController.getDistritosPorCanton(
                idsCantones.get(comboBoxCanton.getSelectedIndex()));
            Vector<String> contents = new Vector<String>();
            for (Integer x : distritos.keySet()) {
              idsDistritos.addElement(x);
              contents.addElement(distritos.get(x));
            }
            checkCanton.setEnabled(false); // Para mantener consistencia
            comboBoxCanton.setEnabled(false);
            comboBoxDistrito.setEnabled(true);
            comboBoxDistrito.setModel(new DefaultComboBoxModel<String>(contents));

          } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "SQL Error",
                JOptionPane.ERROR_MESSAGE);
          }
          ;
        } else {
          comboBoxDistrito.setModel(new DefaultComboBoxModel<>());
          checkCanton.setEnabled(true); // Para mantener consistencia
          comboBoxCanton.setEnabled(true);
          idsDistritos.clear();
          comboBoxDistrito.setEnabled(false);
        }
      }
    });
    this.checkDistrito.setHorizontalAlignment(SwingConstants.CENTER);
    panelContent.add(checkDistrito);
    // ----------------------------------
    comboBoxDistrito = new JComboBox<String>();
    comboBoxDistrito.setFont(FontController.getRegularLabelFont());
    this.comboBoxDistrito.setEnabled(false);
    panelContent.add(comboBoxDistrito);

    this.btnBuscar = new JButton("Buscar...");
    this.btnBuscar.setFont(FontController.getRegularLabelFont());
    this.btnBuscar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent arg0) {
        try {
          // System.out.println(idsCantones.get(comboBoxCanton.getSelectedIndex()));
          int idTerritorio = -1;
          if (comboBoxPaises.isEnabled()) {

            idTerritorio = idsPaises.get(comboBoxPaises.getSelectedIndex());

          } else if (comboBoxProvincias.isEnabled()) {

            idTerritorio = idsProvincias.get(comboBoxProvincias.getSelectedIndex());

          } else if (comboBoxCanton.isEnabled()) {

            idTerritorio = idsCantones.get(comboBoxCanton.getSelectedIndex());

          } else if (comboBoxDistrito.isEnabled()) {

            idTerritorio = idsDistritos.get(comboBoxDistrito.getSelectedIndex());

          }
          tableContents.setModel(QueryController.buscarPersonaTerritorios(idTerritorio,
              comboBoxPaises.isEnabled(), comboBoxProvincias.isEnabled(),
              comboBoxCanton.isEnabled(), comboBoxDistrito.isEnabled()));
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(rootPane, e.getMessage(), "SQL Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    this.btnBuscar.setOpaque(false);
    panel.add(btnBuscar);
    // ----------------------------------
    tableContents = new JTable();
    tableContents.getTableHeader().setFont(FontController.getRegularLabelFont());
    getContentPane().add(tableContents, BorderLayout.CENTER);

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

  public Vector<Object> getSelectedPersona() {
    Vector<Object> result = new Vector<Object>();
    result.add(selectedPersonaID);
    result.add(selectedPersonaDetalle);
    return result;
  }

}

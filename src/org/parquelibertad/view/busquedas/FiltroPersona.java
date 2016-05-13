package org.parquelibertad.view.busquedas;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.parquelibertad.controller.MainController;
import org.parquelibertad.controller.QueryController;
import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.model.LibertadDatabaseConstraints;
import org.parquelibertad.view.jmodels.JDatabaseText;
import org.parquelibertad.view.templates.DialogTemplate;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

public class FiltroPersona extends DialogTemplate {
  private static final long    serialVersionUID = 5606586311814273552L;
  public static final String[] atributos        = {
      "Nombre", "Primer Apellido", "Segundo Apellido"
  };
  private JPanel               content;
  private JPanel               panelBusqueda;
  private JCheckBox            checkIdentificacion;
  private JComboBox<String>    comboTipoIdentificacion;
  private JCheckBox            checkAtributo;
  private JTextField           txtAtributo;
  private JComboBox<String>    comboAtributos;
  private JTextField           txtIdentificacion;
  private JPanel               panelTop;
  private JPanel               actions;
  private Integer              selectedPersonaID;
  private JButton              btnConfirmar;
  private JScrollPane          scrollBusqueda;
  private JTable               tablePersona;
  private JButton              btnBusqueda;

  private Vector<Integer>      idsTiposIdentidad;
  private JLabel               lblAdvertencia;
  private JLabel labelTitulo;
  private JLabel label;
  private JLabel label_1;
  private JLabel label_2;

  // Size 800 x 550 min
  public FiltroPersona(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException, SQLException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setLayout(new BorderLayout(0, 0));

    content = new JPanel();
    content.setBackground(DesignController.getWindowBGColor());
    content.setBorder(new TitledBorder(null, "Seleccionar persona:", TitledBorder.LEADING,
        TitledBorder.TOP, FontController.getSubtitleFont(), null));
    getContentPane().add(content, BorderLayout.CENTER);
    content.setLayout(new BorderLayout(0, 0));

    panelTop = new JPanel();
    panelTop.setBackground(DesignController.getWindowBGColor());
    content.add(panelTop, BorderLayout.NORTH);
    panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.Y_AXIS));

    panelBusqueda = new JPanel();
    panelTop.add(panelBusqueda);
    panelBusqueda.setBackground(DesignController.getWindowBGColor());
    panelBusqueda.setLayout(new GridLayout(0, 3, 5, 0));

    checkIdentificacion = new JCheckBox("Documento de Identidad:");
    checkIdentificacion.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent arg0) {
        checkAtributo.setEnabled(!checkIdentificacion.isSelected());
      }
    });

    checkIdentificacion.setFont(FontController.getRegularLabelFont());
    checkIdentificacion.setBackground(DesignController.getWindowBGColor());
    panelBusqueda.add(checkIdentificacion);

    comboTipoIdentificacion = new JComboBox<String>();
    comboTipoIdentificacion.setFont(FontController.getRegularLabelFont());
    panelBusqueda.add(comboTipoIdentificacion);

    txtIdentificacion = new JDatabaseText(
        LibertadDatabaseConstraints.DocumentoIdentidad_numeroIdentidad_NUMBER);
    txtIdentificacion.setColumns(10);
    panelBusqueda.add(txtIdentificacion);

    checkAtributo = new JCheckBox("Atributo por especificar:");
    checkAtributo.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent arg0) {
        checkIdentificacion.setEnabled(!checkAtributo.isSelected());
      }
    });
    checkAtributo.setFont(FontController.getRegularLabelFont());
    checkAtributo.setBackground(DesignController.getWindowBGColor());
    panelBusqueda.add(checkAtributo);

    comboAtributos = new JComboBox<String>();
    comboAtributos.setModel(new DefaultComboBoxModel<String>(atributos));
    comboAtributos.setFont(FontController.getRegularLabelFont());
    panelBusqueda.add(comboAtributos);

    txtAtributo = new JDatabaseText(LibertadDatabaseConstraints.Persona_nombre_VARCHAR2);
    panelBusqueda.add(txtAtributo);
    txtAtributo.setColumns(10);

    scrollBusqueda = new JScrollPane();
    content.add(scrollBusqueda, BorderLayout.CENTER);

    tablePersona = new JTable();
    tablePersona.getTableHeader().setFont(FontController.getRegularLabelFont());
    scrollBusqueda.setViewportView(tablePersona);

    // Final de construcción de la ventana:
    actions = new JPanel();
    getContentPane().add(actions, BorderLayout.SOUTH);
    FlowLayout fl_actions = (FlowLayout) actions.getLayout();
    fl_actions.setAlignment(FlowLayout.RIGHT);
    actions.setBackground(new Color(255, 143, 0));

    lblAdvertencia = new JLabel("");
    lblAdvertencia.setFont(FontController.getSubtitleFont());
    actions.add(lblAdvertencia);
    
    btnBusqueda = new JButton("Realizar B\u00FAsqueda");
    btnBusqueda.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        if (!(checkAtributo.isSelected() || checkIdentificacion.isSelected())){
          JOptionPane.showMessageDialog(rootPane,
              "Seleccione al menos un campo de búsqueda.",
              "Advertencia", JOptionPane.ERROR_MESSAGE);
        } else {
          try {
            tablePersona.setModel(QueryController.buscarPersonaGeneral(
                (String) comboTipoIdentificacion.getSelectedItem(),
                (Integer) idsTiposIdentidad
                    .elementAt(comboTipoIdentificacion.getSelectedIndex()),
                (txtIdentificacion.getText().equals("")
                    ? 0
                      : Integer.parseInt(txtIdentificacion.getText())),
                (String) comboAtributos.getSelectedItem(), txtAtributo.getText(),
                checkIdentificacion.isSelected(), checkAtributo.isSelected()));
            if (tablePersona.getModel().getRowCount() == 0) {
              lblAdvertencia.setText("Refine su búsqueda. Sin resultados.");
            } else {
              lblAdvertencia.setText("");
            }
          } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });
    
    btnBusqueda.setOpaque(false);
    btnBusqueda.setFont(FontController.getRegularLabelFont());
    actions.add(btnBusqueda);

    btnConfirmar = new JButton("Confirmar Selecci\u00F3n");
    btnConfirmar.setOpaque(false);
    btnConfirmar.setFont(FontController.getRegularLabelFont());
    actions.add(btnConfirmar);
    
    label_2 = new JLabel("   ");
    actions.add(label_2);
    
    labelTitulo = new JLabel("B\u00FAsqueda de Personas");
    labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    labelTitulo.setFont(FontController.getTitleFont());
    //labelTitulo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    getContentPane().add(labelTitulo, BorderLayout.NORTH);
    
    label = new JLabel("   ");
    getContentPane().add(label, BorderLayout.WEST);
    
    label_1 = new JLabel("   ");
    getContentPane().add(label_1, BorderLayout.EAST);
    loadConnections();
  }

  private void loadConnections() throws SQLException {
    idsTiposIdentidad = new Vector<Integer>();
    HashMap<Integer, String> tiposDocID = QueryController.getTiposDocumento();
    Vector<String> contents = new Vector<String>();
    for (Integer x : tiposDocID.keySet()) {
      idsTiposIdentidad.addElement(x);
      contents.addElement(tiposDocID.get(x));
    }
    comboTipoIdentificacion.setModel(new DefaultComboBoxModel<String>(contents));
  }

  public Integer getSelectedValue() {
    return selectedPersonaID;
  }

}

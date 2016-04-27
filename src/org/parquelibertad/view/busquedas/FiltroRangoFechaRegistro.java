package org.parquelibertad.view.busquedas;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;

import org.jdatepicker.JDatePanel;
import org.jdatepicker.JDatePicker;
import org.parquelibertad.controller.QueryController;
import org.parquelibertad.view.jmodels.DatabaseTableModel;
import org.parquelibertad.view.templates.DialogTemplate;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FiltroRangoFechaRegistro extends DialogTemplate {
  private static final long serialVersionUID  = 59331234940240453L;

  private Integer           selectedPersonaID = -1;

  private JLabel            lblBsquedaPorTerritorio;
  private JPanel            panelActions;
  private JButton           btnBuscar;
  private JPanel            panelContent;
  private JLabel            lblInicio;
  private JPanel            panel;
  private JTable            tableContents;
  private JButton           btnSeleccionar;

  private JLabel            lblFin;

  private JDatePanel        fechaInicio;

  private GregorianCalendar todaysDate;

  private JDatePanel        fechaFinal;

  public FiltroRangoFechaRegistro(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException, SQLException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setLayout(new BorderLayout(0, 0));

    this.lblBsquedaPorTerritorio = new JLabel("B\u00FAsqueda por Territorio");
    this.lblBsquedaPorTerritorio.setHorizontalAlignment(SwingConstants.CENTER);
    getContentPane().add(this.lblBsquedaPorTerritorio, BorderLayout.NORTH);

    this.panelActions = new JPanel();
    FlowLayout flowLayout = (FlowLayout) this.panelActions.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    this.panelActions.setOpaque(false);

    getContentPane().add(this.panelActions, BorderLayout.SOUTH);

    btnSeleccionar = new JButton("Seleccionar");
    this.btnSeleccionar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
          // Asume que el modelo es un modelo concreto de AbstractTableModel
          selectedPersonaID = ((DatabaseTableModel) tableContents.getModel())
              .getDBIndex(tableContents.getSelectedRow());
          dispose();
        } catch (java.lang.ClassCastException e) {
          JOptionPane.showMessageDialog(rootPane,
              "Favor realizar al menos una búsqueda", "Error de accionar del usuario",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    panelActions.add(btnSeleccionar);

    panel = new JPanel();
    panel.setOpaque(false);
    getContentPane().add(panel, BorderLayout.WEST);
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    this.panelContent = new JPanel();
    panel.add(panelContent);
    this.panelContent.setOpaque(false);
    panelContent.setLayout(new GridLayout(0, 2, 0, 0));
    // ----------------------------------
    this.lblInicio = new JLabel("Fecha Inicial");
    this.lblInicio.setHorizontalAlignment(SwingConstants.CENTER);
    this.panelContent.add(lblInicio);

    todaysDate = new GregorianCalendar();

    this.fechaInicio = new JDatePanel();
    this.fechaInicio.getModel().setDate(todaysDate.get(Calendar.YEAR),
        todaysDate.get(Calendar.MONTH), todaysDate.get(Calendar.DATE));
    this.panelContent.add(this.fechaInicio);

    this.lblFin = new JLabel("Fecha Final");
    this.lblFin.setHorizontalAlignment(SwingConstants.CENTER);
    this.panelContent.add(this.lblFin);

    this.fechaFinal = new JDatePanel();
    this.fechaFinal.getModel().setDate(todaysDate.get(Calendar.YEAR),
        todaysDate.get(Calendar.MONTH), todaysDate.get(Calendar.DATE));
    this.panelContent.add(this.fechaFinal);

    this.btnBuscar = new JButton("Buscar...");
    this.btnBuscar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent arg0) {
        try {
          // System.out.println(idsCantones.get(comboBoxCanton.getSelectedIndex()));
          DatabaseTableModel personas = QueryController.getPersonasPorFechasRegistro(
              ((Calendar) fechaInicio.getModel().getValue()),
              ((Calendar) fechaFinal.getModel().getValue()));
          tableContents.setModel(personas);
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
    getContentPane().add(tableContents, BorderLayout.CENTER);

  }

  public Integer getSelectedPersonaID() {
    return selectedPersonaID;
  }

}

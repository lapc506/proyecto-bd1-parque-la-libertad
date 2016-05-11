package org.parquelibertad.view.busquedas;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import org.parquelibertad.controller.QueryController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.view.jmodels.DatabaseTableModel;
import org.parquelibertad.view.templates.DialogTemplate;
import static org.assertj.core.api.Assertions.*;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class FiltroAlumnos extends DialogTemplate {
  private static final long serialVersionUID = -6188412368350772344L;
  private JLabel            lblAlumnos;
  private JPanel            panel;
  private JPanel            contents;
  private JTable            tableAlumnos;
  private JScrollPane       panelCursosXPeriodo;

  public FiltroAlumnos(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException, SQLException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setLayout(new BorderLayout(10, 10));

    lblAlumnos = new JLabel("Lista de Alumnos");
    lblAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
    lblAlumnos.setFont(FontController.getTitleFont());
    getContentPane().add(lblAlumnos, BorderLayout.NORTH);

    panel = new JPanel();
    panel.setOpaque(false);
    FlowLayout flowLayout = (FlowLayout) panel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    getContentPane().add(panel, BorderLayout.SOUTH);

    JLabel label = new JLabel("   ");
    getContentPane().add(label, BorderLayout.WEST);

    JLabel label_1 = new JLabel("   ");
    getContentPane().add(label_1, BorderLayout.EAST);

    contents = new JPanel();
    contents.setOpaque(false);
    contents.setLayout(new BoxLayout(contents, BoxLayout.Y_AXIS));
    getContentPane().add(contents, BorderLayout.CENTER);
    // =====================================
    panelCursosXPeriodo = new JScrollPane();
    panelCursosXPeriodo.setOpaque(false);
    contents.add(panelCursosXPeriodo);

    tableAlumnos = new JTable();
    panelCursosXPeriodo.setViewportView(tableAlumnos);

    loadConnections();
  }

  private void loadConnections() throws SQLException {
    tableAlumnos.setModel(QueryController.getAlumnos());
  }

}

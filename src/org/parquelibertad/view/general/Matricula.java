package org.parquelibertad.view.general;

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

public class Matricula extends DialogTemplate {
  private static final long serialVersionUID = -6188412368350772344L;
  private JLabel            lblMatrculaDeEstudiantes;
  private JPanel            panel;
  private JButton           btnMatricular;
  private JPanel            contents;
  private JTable            tableCXP;
  private JScrollPane       panelCursosXPeriodo;
  private JButton           btnActualizarPosiblesEstudiantes;
  private JScrollPane       panelAlumnos;
  private JTable            tableAlumnos;

  public Matricula(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException, SQLException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setLayout(new BorderLayout(10, 10));

    lblMatrculaDeEstudiantes = new JLabel("Matr\u00EDcula de Estudiantes");
    lblMatrculaDeEstudiantes.setHorizontalAlignment(SwingConstants.CENTER);
    lblMatrculaDeEstudiantes.setFont(FontController.getTitleFont());
    getContentPane().add(lblMatrculaDeEstudiantes, BorderLayout.NORTH);

    panel = new JPanel();
    panel.setOpaque(false);
    FlowLayout flowLayout = (FlowLayout) panel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    getContentPane().add(panel, BorderLayout.SOUTH);

    btnMatricular = new JButton("Matricular");
    btnMatricular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          assertThat(tableCXP.getSelectedRow()).isNotEqualTo(-1);
          assertThat(tableAlumnos.getSelectedRow()).isNotEqualTo(-1);
          QueryController.insertarMatricula(
              ((DatabaseTableModel) tableCXP.getModel())
              .getDBIndex(tableCXP.getSelectedRow()),
              ((DatabaseTableModel) tableAlumnos.getModel())
              .getDBIndex(tableAlumnos.getSelectedRow()));
          tableAlumnos.setModel(null);
        } catch (SQLException e1) {
          JOptionPane.showMessageDialog(rootPane, e1.getMessage(),
              "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
        } catch (AssertionError e1) {
          JOptionPane.showMessageDialog(rootPane,
              "Asegúrese de haber seleccionado al menos un curso y un alumno.",
              "Error de aplicación", JOptionPane.ERROR_MESSAGE);
        }

      }
    });
    panel.add(btnMatricular);

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
    panelCursosXPeriodo.setBorder(new TitledBorder(
        new LineBorder(new Color(184, 207, 229)), "Lista de Cursos por Per\u00EDodos",
        TitledBorder.RIGHT, TitledBorder.TOP, FontController.getSubtitleFont(), null));
    contents.add(panelCursosXPeriodo);

    tableCXP = new JTable();
    panelCursosXPeriodo.setViewportView(tableCXP);
    // =====================================
    btnActualizarPosiblesEstudiantes = new JButton("Actualizar posibles estudiantes");
    btnActualizarPosiblesEstudiantes.setFont(FontController.getSubtitleFont());
    btnActualizarPosiblesEstudiantes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
          assertThat(tableCXP.getSelectedRow()).isNotEqualTo(-1);
          tableAlumnos.setModel(QueryController
              .buscarAlumnosSinMatricular(((DatabaseTableModel) tableCXP.getModel())
                  .getDBIndex(tableCXP.getSelectedRow())));

        } catch (SQLException e) {
          JOptionPane.showMessageDialog(rootPane, e.getMessage(),
              "Error de conexión a Oracle", JOptionPane.ERROR_MESSAGE);
        } catch (AssertionError e1) {
          JOptionPane.showMessageDialog(rootPane,
              "Asegúrese de haber seleccionado al menos un curso.", "Error de aplicación",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    contents.add(btnActualizarPosiblesEstudiantes);

    panelAlumnos = new JScrollPane();
    panelAlumnos.setOpaque(false);
    panelAlumnos.setBorder(new TitledBorder(null,
        "Lista de Alumnos sin Matricular en el Curso Seleccionado:", TitledBorder.LEADING,
        TitledBorder.TOP, FontController.getSubtitleFont(), null));
    contents.add(panelAlumnos);

    tableAlumnos = new JTable();
    panelAlumnos.setViewportView(tableAlumnos);

    loadConnections();
  }

  private void loadConnections() throws SQLException {
    tableCXP.setModel(QueryController.getCursosPorPeriodos());
  }

}

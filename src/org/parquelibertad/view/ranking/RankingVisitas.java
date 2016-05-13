package org.parquelibertad.view.ranking;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import org.parquelibertad.controller.QueryController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.view.templates.DialogTemplate;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;

public class RankingVisitas extends DialogTemplate {
  private static final long serialVersionUID = -6188412368350772344L;
  private JLabel            lblAlumnos;
  private JPanel            panel;
  private JPanel            contents;
  private JTable            tableResultados;
  private JScrollPane       panelResultados;
  private JPanel            panelOptions;
  private JRadioButton      rdbtnPorActividades;
  private JRadioButton      rdbtnPorEventos;
  private JLabel            lblLmiteDeResultados;
  private JSpinner          spinner;
  private final ButtonGroup buttonGroup      = new ButtonGroup();

  public RankingVisitas(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException, SQLException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setLayout(new BorderLayout(10, 10));

    lblAlumnos = new JLabel("Ranking de Visitantes");
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
    getContentPane().add(contents, BorderLayout.CENTER);
    contents.setLayout(new BorderLayout(0, 0));
    // =====================================
    panelResultados = new JScrollPane();
    panelResultados.setOpaque(false);
    contents.add(panelResultados, BorderLayout.CENTER);

    tableResultados = new JTable();
    panelResultados.setViewportView(tableResultados);

    panelOptions = new JPanel();
    panelOptions.setOpaque(false);
    contents.add(panelOptions, BorderLayout.NORTH);

    rdbtnPorActividades = new JRadioButton("por Actividades");
    buttonGroup.add(rdbtnPorActividades);
    rdbtnPorActividades.setOpaque(false);
    rdbtnPorActividades.setFont(FontController.getRegularLabelFont());
    rdbtnPorActividades.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent arg0) {
        if (rdbtnPorActividades.isSelected()) {
          try {
            tableResultados.setModel(QueryController
                .getRankingVisitasActividades((Integer) spinner.getValue()));
          } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane,
                "No se pudo obtener el ranking.\n" + e.getMessage(),
                "Error de conexión a Oracle.", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });
    panelOptions.add(rdbtnPorActividades);

    rdbtnPorEventos = new JRadioButton("por Eventos");
    buttonGroup.add(rdbtnPorEventos);
    rdbtnPorEventos.setOpaque(false);
    rdbtnPorEventos.setFont(FontController.getRegularLabelFont());
    rdbtnPorEventos.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent arg0) {
        if (rdbtnPorEventos.isSelected()) {
          try {
            tableResultados.setModel(
                QueryController.getRankingVisitasEventos((Integer) spinner.getValue()));
          } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane,
                "No se pudo obtener el ranking.\n" + e.getMessage(),
                "Error de conexión a Oracle.", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });
    panelOptions.add(rdbtnPorEventos);

    lblLmiteDeResultados = new JLabel("L\u00EDmite de Resultados");
    lblLmiteDeResultados.setFont(FontController.getRegularLabelFont());
    panelOptions.add(lblLmiteDeResultados);

    spinner = new JSpinner();
    spinner.setFont(FontController.getRegularLabelFont());
    spinner.setModel(new SpinnerNumberModel(5, 1, 20, 1));
    panelOptions.add(spinner);

  }

}

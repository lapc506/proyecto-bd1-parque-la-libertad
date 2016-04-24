package org.parquelibertad.view.busquedas;

import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JFrame;

import org.parquelibertad.controller.QueryController;
import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.view.templates.DialogTemplate;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class FiltroTerritorio extends DialogTemplate {
  private static final long serialVersionUID = 59331234940240453L;
  private JLabel            lblBsquedaPorTerritorio;
  private JPanel            panelActions;
  private JButton           btnBuscar;
  private JPanel            panel;
  private JComboBox<String> comboBoxPaises;

  public FiltroTerritorio(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setLayout(new BorderLayout(0, 0));

    this.lblBsquedaPorTerritorio = new JLabel("B\u00FAsqueda por Territorio");
    this.lblBsquedaPorTerritorio.setHorizontalAlignment(SwingConstants.CENTER);
    getContentPane().add(this.lblBsquedaPorTerritorio, BorderLayout.NORTH);

    this.panelActions = new JPanel();
    FlowLayout flowLayout = (FlowLayout) this.panelActions.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    this.panelActions.setOpaque(false);
    ;
    getContentPane().add(this.panelActions, BorderLayout.SOUTH);

    this.btnBuscar = new JButton("Buscar...");
    this.btnBuscar.setBackground(DesignController.getWindowBGColor());
    this.panelActions.add(this.btnBuscar);

    this.panel = new JPanel();
    this.panel.setOpaque(false);
    getContentPane().add(this.panel, BorderLayout.CENTER);

    this.comboBoxPaises = new JComboBox<String>();
    try {
      DefaultComboBoxModel<String> paises = new DefaultComboBoxModel<>(
          QueryController.getPaises());
      this.comboBoxPaises.setModel(paises);
    } catch (SQLException e) {}
    this.panel.add(this.comboBoxPaises);

  }

}

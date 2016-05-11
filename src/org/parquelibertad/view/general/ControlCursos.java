package org.parquelibertad.view.general;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import org.parquelibertad.view.templates.DialogTemplate;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControlCursos extends DialogTemplate {
  private static final long serialVersionUID = 8115970722809215528L;
  private JLabel lblControlDeCursos;
  private JPanel actions;
  private JButton btnActivardesactivar;
  private JButton btnAgregarperiodo;
  private JPanel contents;

  public ControlCursos(JFrame parent, String windowName, int width, int height,
      boolean isResizable) throws HeadlessException {
    super(parent, windowName, width, height, isResizable);
    getContentPane().setLayout(new BorderLayout(0, 0));
    
    lblControlDeCursos = new JLabel("Control de Cursos");
    lblControlDeCursos.setHorizontalAlignment(SwingConstants.CENTER);
    lblControlDeCursos.setFont(null);
    getContentPane().add(lblControlDeCursos, BorderLayout.NORTH);
    
    actions = new JPanel();
    FlowLayout fl_actions = (FlowLayout) actions.getLayout();
    fl_actions.setAlignment(FlowLayout.RIGHT);
    actions.setOpaque(false);
    getContentPane().add(actions, BorderLayout.SOUTH);
    
    btnActivardesactivar = new JButton("Activar/Desactivar");
    btnActivardesactivar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    // panel.add(btnActivardesactivar);
    
    btnAgregarperiodo = new JButton("Agregar Per\u00EDodo");
    btnAgregarperiodo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        
      }
    });
    actions.add(btnAgregarperiodo);
    
    JLabel label_1 = new JLabel("   ");
    getContentPane().add(label_1, BorderLayout.WEST);
    
    JLabel label_2 = new JLabel("   ");
    getContentPane().add(label_2, BorderLayout.EAST);
    
    contents = new JPanel();
    contents.setOpaque(false);
    getContentPane().add(contents, BorderLayout.CENTER);
    
  }

}

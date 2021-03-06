/**
 * 
 */
package org.parquelibertad.view;

import java.awt.HeadlessException;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.parquelibertad.controller.MainController;
import org.parquelibertad.controller.design.FontController;
import org.parquelibertad.controller.design.ImageController;
import org.parquelibertad.metadata.customExceptions.PictureNotFound;
import org.parquelibertad.view.templates.WindowTemplate;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

/**
 * proyecto-bd1-parque-la-libertad org.parquelibertad.view
 * 
 * @author Luis Andr�s Pe�a Castillo 2014057250 Derechos reservados bajo
 *         licencia MIT.
 *
 */
public class Principal extends WindowTemplate {
  private static final long serialVersionUID = 2787942091814370720L;
  private JMenuBar          menuBar;
  private JMenu             menuAdministrador;
  private JMenuItem         mntmTerritorios;
  private JMenu             menuAnadir;
  private JMenuItem         menuAgregarPersona;
  private JMenuItem         menuAgregarCurso;
  private JMenu             menuEditar;
  private JMenuItem         menuPromoverPersona;
  private JLabel            lblLogoSistema;
  private JLabel            lblLogoParque;
  private JLabel            lblBienvenidos;
  private JPanel            panelPictures;
  private JMenu             mnBuscar;
  private JMenuItem         mntmPersonaPorTerritorio;
  private JMenuItem         mntmPersonaPorFechas;
  private AbstractButton menuAgregarActividad;
  private JMenuItem mntmControlDeCursos;
  private JMenuItem menuMatricula;
  private JMenuItem menuAlumnos;
  private JMenuItem mntmBuscarPersonas;
  private JMenuItem menuRankingVisitantes;

  /**
   * @param windowName
   *          T�tulo de la ventana
   * @param width
   *          Ancho inicial
   * @param height
   *          Alto inicial
   * @param isVisible
   *          es la ventana visible desde su inicio?
   * @param isResizable
   *          es la ventana expandible desde su inicio?
   * @throws HeadlessException
   *           Caso extremo en que no exista monitor.
   */
  public Principal(String windowName, int width, int height, boolean isVisible,
      boolean isResizable) throws HeadlessException {
    super(windowName, width, height, isVisible, isResizable);

    this.menuBar = new JMenuBar();
    setJMenuBar(this.menuBar);
    // ----------------------------------
    menuAnadir = new JMenu("A\u00F1adir");
    menuAnadir.setFont(FontController.getRegularLabelFont());
    menuBar.add(menuAnadir);
    // ----------------------------------
    menuAgregarPersona = new JMenuItem("Agregar nueva Persona...");
    menuAgregarPersona.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        MainController.getInstance().showAgregarPersona();
      }
    });
    menuAgregarPersona.setFont(FontController.getRegularLabelFont());
    menuAnadir.add(menuAgregarPersona);
    
    menuAgregarActividad = new JMenuItem("Agregar nueva Actividad...");
    menuAgregarActividad.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        MainController.getInstance().showAgregarActividad();
      }
    });
    menuAgregarActividad.setFont(FontController.getRegularLabelFont());
    menuAnadir.add(menuAgregarActividad);

    this.menuAgregarCurso = new JMenuItem("Agregar nuevo Curso...");
    this.menuAgregarCurso.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        MainController.getInstance().showAgregarCurso();
      }
    });
    this.menuAgregarCurso.setFont(FontController.getRegularLabelFont());
    this.menuAnadir.add(this.menuAgregarCurso);

    this.menuEditar = new JMenu("Editar");
    this.menuEditar.setFont(FontController.getRegularLabelFont());
    this.menuBar.add(this.menuEditar);

    this.menuPromoverPersona = new JMenuItem("Promover Persona a nueva funci\u00F3n...");
    this.menuPromoverPersona.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        MainController.getInstance().showPromoverPersona();
      }
    });
    this.menuPromoverPersona.setFont(FontController.getRegularLabelFont());
    this.menuEditar.add(this.menuPromoverPersona);
    
    mntmControlDeCursos = new JMenuItem("Control de Cursos");
    mntmControlDeCursos.setFont(FontController.getRegularLabelFont());
    mntmControlDeCursos.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        MainController.getInstance().showControlCursos();
      }
    });
    menuEditar.add(mntmControlDeCursos);
    
    menuMatricula = new JMenuItem("Matr\u00EDcula de Estudiantes");
    menuEditar.add(menuMatricula);
    menuMatricula.setFont(FontController.getRegularLabelFont());
    menuMatricula.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        MainController.getInstance().showMatricula();
      }
    });

    this.mnBuscar = new JMenu("Buscar");
    this.mnBuscar.setFont(FontController.getRegularLabelFont());
    this.menuBar.add(this.mnBuscar);
    
    mntmBuscarPersonas = new JMenuItem("Personas en General");
    mntmBuscarPersonas.setFont(FontController.getRegularLabelFont());
    mntmBuscarPersonas.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        MainController.getInstance().showBuscarPersonas();
      }
    });
    mnBuscar.add(mntmBuscarPersonas);
    
    menuRankingVisitantes = new JMenuItem("Ranking de Visitantes");
    menuRankingVisitantes.setFont(FontController.getRegularLabelFont());
    menuRankingVisitantes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        MainController.getInstance().showRankingVisitantes();
      }
    });
    
        this.mntmPersonaPorTerritorio = new JMenuItem(
            "Personas por Territorio de Origen...");
        mnBuscar.add(mntmPersonaPorTerritorio);
        this.mntmPersonaPorTerritorio.setFont(FontController.getRegularLabelFont());
        this.mntmPersonaPorTerritorio.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainController.getInstance().showBuscarPersonaTerritorio(false);
          }
        });
    
        this.mntmPersonaPorFechas = new JMenuItem(
            "Personas por Fecha de Registro...");
        mnBuscar.add(mntmPersonaPorFechas);
        this.mntmPersonaPorFechas.setFont(FontController.getRegularLabelFont());
        this.mntmPersonaPorFechas.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            MainController.getInstance().showBuscarPersonaRangosFechas();
          }
        });
    mnBuscar.add(menuRankingVisitantes);

    this.menuAdministrador = new JMenu("Administrador");
    this.menuAdministrador.setFont(FontController.getRegularLabelFont());
    this.menuBar.add(this.menuAdministrador);

    this.mntmTerritorios = new JMenuItem("A\u00F1adir y Editar Territorios");
    this.mntmTerritorios
        .addActionListener(event -> MainController.getInstance().showEditTerritories());
    this.mntmTerritorios.setFont(FontController.getRegularLabelFont());
    this.menuAdministrador.add(this.mntmTerritorios);
    
    menuAlumnos = new JMenuItem("Alumnos Registrados");
    menuAdministrador.add(menuAlumnos);
    menuAlumnos.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        MainController.getInstance().showAlumnos();
      }
    });
    menuAlumnos.setFont(FontController.getRegularLabelFont());
    getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

    lblBienvenidos = new JLabel("Bienvenidos a");
    lblBienvenidos.setFont(FontController.getTitleFont().deriveFont(50f));
    getContentPane().add(lblBienvenidos);

    this.panelPictures = new JPanel();
    getContentPane().add(this.panelPictures);

    // Basado en:
    // https://github.com/sanjoseTEC2014/Paws/blob/master/Paws/src/paws/vista/VentanaMenuPrincipal.java
    this.lblLogoSistema = new JLabel("");
    /////////////////////////////////////////////////////////////////////////
    try {
      BufferedImage logoSistema = ImageController.getLogoSistema();
      lblLogoSistema
          .setIcon(new ImageIcon(ImageController.redimensionar(logoSistema, 450, 320)));
    } catch (PictureNotFound e1) {
      lblLogoSistema.setText("LibreParque");
    }
    this.panelPictures.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    this.panelPictures.add(this.lblLogoSistema);
    /////////////////////////////////////////////////////////////////////////
    this.lblLogoParque = new JLabel("");
    try {
      BufferedImage logoParque = ImageController.getLogoParque();
      Dimension nuevoTamanio = ImageController.getNuevaDimension(230, 350,
          logoParque.getSampleModel().getWidth(),
          logoParque.getSampleModel().getHeight());
      lblLogoParque.setIcon(new ImageIcon(ImageController.redimensionar(logoParque,
          nuevoTamanio.width, nuevoTamanio.height)));
    } catch (PictureNotFound e1) {
      lblLogoParque.setText("Parque La Libertad");
    }
    this.panelPictures.setOpaque(false);
    this.panelPictures.add(this.lblLogoParque);
  }

}

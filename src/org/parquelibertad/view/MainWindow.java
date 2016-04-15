/**
 * 
 */
package org.parquelibertad.view;

import java.awt.HeadlessException;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.parquelibertad.controller.MainController;
import org.parquelibertad.controller.design.DesignController;
import org.parquelibertad.controller.design.FontController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * proyecto-bd1-parque-la-libertad org.parquelibertad.view
 * 
 * @author Luis Andrés Peña Castillo 2014057250 Derechos reservados bajo
 *         licencia MIT.
 *
 */
public class MainWindow extends WindowTemplate {
	private JMenuBar menuBar;
	private JMenu menuAdministrador;
	private JMenuItem mntmTerritorios;
	private JMenu menuAnadir;
	private JMenuItem menuAgregarPersona;
	private JMenuItem menuAgregarCurso;

	/**
	 * @param windowName
	 * @param width
	 * @param height
	 * @param isVisible
	 * @param isResizable
	 * @throws HeadlessException
	 */
	public MainWindow(String windowName, int width, int height, boolean isVisible, boolean isResizable)
			throws HeadlessException {
		super(windowName, width, height, isVisible, isResizable);

		this.menuBar = new JMenuBar();
		setJMenuBar(this.menuBar);
		// ----------------------------------
		menuAnadir = new JMenu("A\u00F1adir");
		menuAnadir.setFont(FontController.getBoldLabelFont());
		menuBar.add(menuAnadir);
		// ----------------------------------
		menuAgregarPersona = new JMenuItem("Agregar nueva Persona...");
		menuAgregarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainController.getInstance().showAgregarPersona();
			}
		});
		// Al parecer esta manera de usar métodos lambda es incorrecta:
		// mntmTerritorios.addActionListener(event -> MainController.getInstance().showAddPersona());
		menuAgregarPersona.setFont(FontController.getBoldLabelFont());
		menuAnadir.add(menuAgregarPersona);
		
		this.menuAgregarCurso = new JMenuItem("Agregar nuevo Curso...");
		this.menuAgregarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainController.getInstance().showAgregarCurso();
			}
		});
		this.menuAgregarCurso.setFont(FontController.getBoldLabelFont());
		this.menuAnadir.add(this.menuAgregarCurso);

		this.menuAdministrador = new JMenu("Administrador");
		this.menuAdministrador.setFont(FontController.getBoldLabelFont());
		this.menuBar.add(this.menuAdministrador);

		this.mntmTerritorios = new JMenuItem("A\u00F1adir y Editar Territorios");
		this.mntmTerritorios.addActionListener(event -> MainController.getInstance().showEditTerritories());
		this.mntmTerritorios.setFont(FontController.getBoldLabelFont());
		this.menuAdministrador.add(this.mntmTerritorios);

	}

}

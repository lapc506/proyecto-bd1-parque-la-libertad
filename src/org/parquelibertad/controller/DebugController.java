/**
 * 
 */
package org.parquelibertad.controller;

import javax.swing.JOptionPane;

import org.parquelibertad.metadata.Filepath;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.controller
 * 
 * @author Luis Andrés Peña Castillo 2014057250
 *         Derechos reservados bajo licencia MIT.
 *
 */
public class DebugController {
  public static String mainFont;

  public static void loadAvailableFonts() {
    for (String font : Filepath.listAvailableFonts()){
      DesignStyles.loadFont(font, 12);
    }
    for (String font : DesignStyles.listLoadedFonts()){
      System.out.println(font); // if fails fonts array is empty, check App.java 
    }
    
    /* JOptionPane.showInputDialog(null, "Choose the main system font:",
     * "Main system font selection", JOptionPane.QUESTION_MESSAGE, null,
     * fontsList, fontsList[0]); */
  }
}

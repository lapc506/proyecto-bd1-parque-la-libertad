/**
 * 
 */
package org.parquelibertad.controller.design;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.parquelibertad.metadata.Filepath;

/**
 * proyecto-bd1-parque-la-libertad org.parquelibertad.metadata
 * 
 * @author Luis Andrés Peña Castillo 2014057250 Derechos reservados bajo
 *         licencia MIT.
 *
 */
public class DesignController {
  private static Color                   windowBGColor  = new Color(255, 143, 0);
                                          //#FF8F00, based on www.parquelalibertad.org
  private static Color                   fontColor      = new Color(0, 0, 0);
  private static Hashtable<String, Font> loadedFonts    = new Hashtable<String, Font>();
  private static String                  HEX_CHARACTERS = "0123456789ABCDEF";

  public static void loadFont(String fontName, Integer size) {
    try {

      loadedFonts.put(fontName,
          Font.createFont(Font.TRUETYPE_FONT, new File(Filepath.fonts + fontName))
              .deriveFont(new Float(size)));
      GraphicsEnvironment.getLocalGraphicsEnvironment()
          .registerFont(loadedFonts.get(fontName));
    } catch (FontFormatException | IOException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Problema al cargar fuente.",
          JOptionPane.WARNING_MESSAGE, ImageController.getIconoSistema());
    }
  }

  public static Font getFont(String desiredFont) {
    return loadedFonts.get(desiredFont);
  }

  public static ArrayList<String> listLoadedFonts() {
    return Collections.list(loadedFonts.keys());
  }

  public static Color getWindowBGColor() {
    return windowBGColor;
  }
  public static void setWindowBGColor(Color value){
    windowBGColor = value;
  }
  public static Color getFontColor() {
    return fontColor;
  }
  public static void setFontColor(Color value){
    fontColor = value;
  }

  public static Color getHexColor(String colorValue) {
    // Returns color object if text marches format #FF00FF or black otherwise.
    final String HEX_PATTERN = "^#([A-Fa-f0-9]{6})$";
    Pattern pattern = Pattern.compile(HEX_PATTERN);
    ;
    Matcher matcher = pattern.matcher(colorValue);
    int red = hex2dec(colorValue.substring(1, 3));
    int green = hex2dec(colorValue.substring(3, 5));
    int blue = hex2dec(colorValue.substring(5, 7));
    // System.out.println("Generating hex color " + red + " " + green + " " + blue);
    if (matcher.matches()) { return new Color(red, green, blue); }
    return new Color(0, 0, 0);
  }

  private static int hex2dec(String hexValue) {
    hexValue = hexValue.toUpperCase();
    int decimalResult = 0;
    for (int i = 0; i < hexValue.length(); i++) {
      char digit = hexValue.charAt(i);
      int digitValue = HEX_CHARACTERS.indexOf(digit);
      decimalResult = decimalResult * 16 + digitValue;
    }
    return decimalResult;
  }

  public static void startLookAndFeel() {
    // Establece un look and feel metálico, si no lo encuentra, establece el
    // look and feel del sistema operativo.
    try {
      UIManager.setLookAndFeel(javax.swing.plaf.nimbus.NimbusLookAndFeel.class.getName());
    } catch (ClassNotFoundException |
             InstantiationException |
             IllegalAccessException |
             UnsupportedLookAndFeelException e) {
      try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (ClassNotFoundException |
               InstantiationException |
               IllegalAccessException |
               UnsupportedLookAndFeelException e2) {
        JOptionPane.showMessageDialog(null, e2.getMessage(), "System Unexpected Failure",
            JOptionPane.WARNING_MESSAGE);
      }
    }
  }

}

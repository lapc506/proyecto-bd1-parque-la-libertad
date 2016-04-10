/**
 * 
 */
package org.parquelibertad.controller.design;

import java.awt.Font;

import org.parquelibertad.metadata.Filepath;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.controller
 * 
 * @author Luis Andrés Peña Castillo 2014057250
 *         Derechos reservados bajo licencia MIT.
 *
 */
public class FontController {
  private static Font titles;
  private static int  titlesSize;
  private static Font subtitles;
  private static int  subtitlesSize;
  private static Font regularLabels;
  private static int  regularLabelsSize;
  private static Font boldLabels;
  private static int  boldLabelsSize;
  
  public static void loadDefaultFonts() {
	// singleton.showSelectFont("titles");
    setFont("titles", "PalanquinDark-Bold.ttf", 32);
    // singleton.showSelectFont("subtitles");
    setFont("subtitles", "Palanquin-Regular.ttf", 16);
    // singleton.showSelectFont("regularLabels");
    setFont("regularLabels", "Quicksand_Book.otf", 16);
    // singleton.showSelectFont("boldLabels");
    setFont("boldLabels", "Quicksand_Bold.otf", 16);
  }
  
  public static void loadAvailableFonts() {
    for (String font : Filepath.listAvailableFonts()) {
      DesignController.loadFont(font, 12);
    }
  }
  
  public static void loadFallbackFonts() {
    titles = Font.getFont("Tahoma");
    titlesSize = 48;
    subtitles = Font.getFont("Tahoma");
    subtitlesSize = 16;
    regularLabels = Font.getFont("Tahoma");
    regularLabelsSize = 12;
    boldLabels = Font.getFont("Tahoma");
    boldLabelsSize = 12;
  }

  public static void setFont(String type, String titleFont, int size) {
    switch (type) {
      case "titles":
        setTitleFont(titleFont, size);
        break;
      case "subtitles":
        setSubtitleFont(titleFont, size);
        break;
      case "regularLabels":
        setRegularLabelFont(titleFont, size);
        break;
      case "boldLabels":
        setBoldLabelFont(titleFont, size);
        break;
      default:
        throw new IllegalArgumentException("Invalid font type");
    }
  }

  public static Font getTitleFont() {
    float newSize = titlesSize;
    if (titles != null) { return titles.deriveFont(newSize); }
    return null;
  }

  public static Font getSubtitleFont() {
    float newSize = subtitlesSize;
    if (subtitles != null) { return subtitles.deriveFont(newSize); }
    return null;
  }

  public static Font getRegularLabelFont() {
    float newSize = regularLabelsSize;
    if (regularLabels != null) { return regularLabels.deriveFont(newSize); }
    return null;
  }

  public static Font getBoldLabelFont() {
    float newSize = boldLabelsSize;
    if (boldLabels != null) { return boldLabels.deriveFont(newSize); }
    return null;
  }

  public static void setTitleFont(String titleFont, int size) {
    titles = DesignController.getFont(titleFont);
    titlesSize = size;
  }

  public static void setSubtitleFont(String titleFont, int size) {
    subtitles = DesignController.getFont(titleFont);
    subtitlesSize = size;
  }

  public static void setRegularLabelFont(String titleFont, int size) {
    regularLabels = DesignController.getFont(titleFont);
    regularLabelsSize = size;
  }

  public static void setBoldLabelFont(String titleFont, int size) {
    boldLabels = DesignController.getFont(titleFont);
    boldLabelsSize = size;
  }
}

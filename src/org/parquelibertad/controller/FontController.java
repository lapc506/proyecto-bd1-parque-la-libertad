/**
 * 
 */
package org.parquelibertad.controller;

import java.awt.Font;

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
    titles = DesignStyles.getFont(titleFont);
    titlesSize = size;
  }

  public static void setSubtitleFont(String titleFont, int size) {
    subtitles = DesignStyles.getFont(titleFont);
    subtitlesSize = size;
  }

  public static void setRegularLabelFont(String titleFont, int size) {
    regularLabels = DesignStyles.getFont(titleFont);
    regularLabelsSize = size;
  }

  public static void setBoldLabelFont(String titleFont, int size) {
    boldLabels = DesignStyles.getFont(titleFont);
    boldLabelsSize = size;
  }
}

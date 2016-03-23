/**
 * 
 */
package org.parquelibertad.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;

import org.parquelibertad.metadata.customExceptions.PictureNotFound;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.controller
 * 
 * @author Luis Andrés Peña Castillo 2014057250
 *         Derechos reservados bajo licencia MIT.
 *
 */
public class ImageController {
  public static BufferedImage loadImage(String pRuta) throws PictureNotFound {
    try {
      // BufferedImage temp =
      // JOptionPane.showMessageDialog(null, pRuta + "\n" + temp.getWidth() +
      // "\n" + temp.getHeight());
      return ImageIO.read(new File(pRuta));
    } catch (IOException e) {
      throw new PictureNotFound(e.getMessage());
    }
  }

  /**
   * @return
   */
  public static Icon getIconoSistema() {
    // TODO Auto-generated method stub
    return null;
  }
}

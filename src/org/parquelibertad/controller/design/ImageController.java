/**
 * 
 */
package org.parquelibertad.controller.design;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;

import org.parquelibertad.metadata.Filepath;
import org.parquelibertad.metadata.customExceptions.PictureNotFound;

import net.coobird.thumbnailator.Thumbnails;

/**
 * proyecto-bd1-parque-la-libertad org.parquelibertad.controller
 * 
 * @author Luis Andrés Peña Castillo 2014057250 Derechos reservados bajo
 *         licencia MIT.
 * @author Chris Kroells - Thumbnailator.jar @
 *         https://github.com/coobird/thumbnailator
 */
public class ImageController {
  public static BufferedImage loadImage(String pRuta) throws PictureNotFound {
    try {
      // System.out.println(pRuta);
      return ImageIO.read(new File(pRuta));
    } catch (IOException e) {
      throw new PictureNotFound(e.getMessage());
    }
  }
  public static BufferedImage getLogoParque() throws PictureNotFound {
    return loadImage(Filepath.pictures + "parqueLogo.png");
  }
  
  public static BufferedImage getLogoSistema() throws PictureNotFound {
    return loadImage(Filepath.pictures + "sistemaLogo.png");
  }

  public static Dimension getNuevaDimension(int anchoDisponible, int altoDisponible,
      int anchoImagen, int altoImagen) {
    int nuevoAncho = anchoImagen;
    if (nuevoAncho > anchoDisponible) nuevoAncho = anchoDisponible;

    int nuevoAlto = (int) ((double) anchoImagen
        / getRelacionAspecto(anchoImagen, altoImagen));

    while (nuevoAlto > altoDisponible) {
      double porcentaje = (double) nuevoAlto / altoDisponible;
      nuevoAncho /= porcentaje;
      nuevoAlto /= porcentaje;
    }

    return new Dimension(nuevoAncho, nuevoAlto);
  }

  public static BufferedImage redimensionar(BufferedImage origen, int nuevoAncho,
      int nuevoAlto) throws PictureNotFound {
    try {
      // uses http://projects.coobird.net/thumbnailator/
      // https://github.com/coobird/thumbnailator
      return Thumbnails.of(origen).size(nuevoAncho, nuevoAlto).asBufferedImage();
    } catch (IOException e) {
      throw new PictureNotFound("No se encuentra la imagen requerida.");
    }
  }

  public static double getRelacionAspecto(int x, int y) {
    return (double) x / (double) y;
  }

  public static double getRelacionAspecto(int x, double y) {
    return (double) x / y;
  }

  public static double getRelacionAspecto(double x, int y) {
    return x / (double) y;
  }

  public static double getRelacionAspecto(double x, double y) {
    return x / y;
  }

  public static Icon getIconoSistema() {
    // TODO Auto-generated method stub
    return null;
  }
}

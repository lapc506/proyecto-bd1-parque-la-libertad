/**
 * 
 */
package org.parquelibertad.metadata.customExceptions;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.metadata
 * @author Luis Andr�s Pe�a Castillo 2014057250
 * Derechos reservados bajo licencia MIT.
 *
 */
@SuppressWarnings("serial")
public class PictureNotFound extends Exception {
  public PictureNotFound(String message) {
    super(message);
  }
}

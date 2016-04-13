/**
 * 
 */
package org.parquelibertad.view.jmodels;

import javax.swing.JTextField;
import javax.swing.text.Document;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.view.jmodels
 * @author Luis Andr�s Pe�a Castillo 2014057250
 * Derechos reservados bajo licencia MIT.
 *
 */
public class JDatabaseText extends JTextField {

  public JDatabaseText(int sizeLimit) {
    super(new DatabaseDocumentModel(sizeLimit), "", 0);
  }
  
}

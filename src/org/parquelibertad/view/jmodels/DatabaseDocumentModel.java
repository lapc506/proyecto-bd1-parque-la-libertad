/**
 * 
 */
package org.parquelibertad.view.jmodels;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.view.jmodels
 * 
 * @author Luis Andrés Peña Castillo 2014057250
 *         Derechos reservados bajo licencia MIT.
 *
 */
public class DatabaseDocumentModel extends PlainDocument {
  
  private static final long serialVersionUID = -7477175573927749064L;
  private int limit;

  DatabaseDocumentModel(int limit) {
    super();
    this.limit = limit;
  }

  public void insertString(int offset, String str, AttributeSet attr) {
    if (str == null) { return; }
    if ((getLength() + str.length()) <= limit) {
      try {
        super.insertString(offset, str, attr);
      } catch (BadLocationException e) {
        System.err.println(e.getMessage());
      }
    }
  }

}

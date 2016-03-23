/**
 * 
 */
package org.parquelibertad.metadata;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.metadata
 * @author Luis Andrés Peña Castillo 2014057250
 * Derechos reservados bajo licencia MIT.
 *
 */
public class Filepath {
	public static String project;
	public static String metadata; 
	public static String pictures;
	public static String fonts;
	
	public static String slash;
	
	public static void loadAll() {
	  slash = "";
		project = System.getProperty("user.dir");
		if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
		  slash = "\\";		}
		else {	slash = "/";	}
		
		metadata  = project + slash + "src" + slash
		            + "org" + slash
		            + "parquelibertad" + slash
		            + "metadata" + slash;
		pictures  = metadata + slash
		          + "pictures" + slash;
		fonts 	  = metadata  + slash
		          + "fonts" + slash;
	}
}

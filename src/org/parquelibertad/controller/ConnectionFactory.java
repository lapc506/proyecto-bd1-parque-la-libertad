package org.parquelibertad.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
/*
  	JDBC will connect using the hostname from ORACLE_HOME/NETWORK/ADMIN/tnsnames.ora
  	My localhost "JinxExecutor" is taken from running "hostname" command in cmd.exe
  	
  	Creation of this file is based on the link below:
	https://github.com/wi-tribe/BSSDev/blob/6a73244ceeebc4b3a452ff4140d95e5481e64fb5/BrmAPIs-login/src/java/witribe/brm/DBUtil.java
	
	Thin driver was used, as suggested in:
	http://stackoverflow.com/questions/21711085/what-is-the-differente-between-oci-and-thin-driver-connection-with-data-source-c
	
	More documentation:
	https://docs.oracle.com/cd/F49540_01/DOC/java.815/a64685/basic1.htm#1004265
	https://en.wikipedia.org/wiki/JDBC_driver Type-4 driver
	
	Troubleshooting:
	* Copy sqlnet.backup.ora, tnsnames.backup.ora, and listener.backup.ora and replace filenames.
	* Run lsnrctl, stop all listeners.
	* Wherever you find "JinxExecutor", open cmd.exe (in Windows), run 'hostname' and replace it with that.
	* Start all listeners.
	* Confirm listeners are running, validate if Oracle services are running or not in services.msc
	* Google it. Just Do It.

 */

public class ConnectionFactory {
	// 
	public static final String localhost = "JinxExecutor"; 	// according to tnsnames.ora and hostname command
	public static final String portNumber = "1521"; 		// according to tnsnames.ora
	public static final String databaseSID = "dbpqlibertad";// according to tnsnames.ora
	public static final String schemaUsername = "libertadDemoUser";
	public static final String schemaPassword = "user123";

	public static Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		String connectionURL = "";
		if (alreadyConnected()) {
			// App is running within Oracle JVM and should be using the built-in kprb driver.
			connectionURL = "jdbc:default:connection:";
			JOptionPane.showMessageDialog(null, connectionURL);
			return DriverManager.getConnection(connectionURL);
		} else {
			// App is running outside the Oracle JVM and should connect.
			// Syntax taken from: https://docs.oracle.com/cd/B28359_01/java.111/b31224/jdbcthin.htm
			connectionURL = "jdbc:oracle:thin:@" + localhost + ":" + portNumber + ":" + databaseSID;
			JOptionPane.showMessageDialog(null, connectionURL);
			return DriverManager.getConnection(connectionURL, schemaUsername, schemaPassword);
		}
	}

	private static boolean alreadyConnected() {
		String version = System.getProperty("oracle.server.version");
		return (version != null && !version.equals(""));
	}
}
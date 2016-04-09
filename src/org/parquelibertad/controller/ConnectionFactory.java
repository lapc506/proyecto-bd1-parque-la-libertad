import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection
	  (String localhost, Integer portNumber, String schemaUsername, String schemaPassword)
	    throws SQLException
	      {
        	DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            return DriverManager
              .getConnection(
                "jdbc:oracle:thin:" + localhost + "/" + portNumber.toString(),
                // Using THIN driver version as suggested in:
                // http://stackoverflow.com/questions/21711085/what-is-the-differente-between-oci-and-thin-driver-connection-with-data-source-c
                // based on https://en.wikipedia.org/wiki/JDBC_driver Type-4 driver
                  schemaUsername, schemaPassword);
        }

}

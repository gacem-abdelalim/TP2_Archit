import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	   
		String BDD = "nomBD";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "";
	    private Connection conn;
	    private static DBConnection dBConnection;
	   
	    private DBConnection()  {
			
		}
	    
	    public Connection getConn() throws SQLException {
	    	conn=DriverManager.getConnection(url, user,passwd);
			return conn;
		}
	    public static DBConnection getDBConnection() {
	    	if (dBConnection == null) {
	    		 dBConnection = new DBConnection();
	    	}
	    	return dBConnection;
	    }
		
	
}

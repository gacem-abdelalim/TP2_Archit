import java.sql.Connection;
import java.sql.SQLException;

public interface IDBConnection {
	public Connection getConn() throws SQLException;
	
	
}

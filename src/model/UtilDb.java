package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilDb {
	
	private static Connection connection = null;
	
	public static Connection getConnection() {

		String urlConnection = "jdbc:postgresql://database-lp3-n1.cgnm403exfxr.us-east-2.rds.amazonaws.com/postgres";
		String userName = "postgres";
		String password = "9tjGSBK6";
		
		// auto close connection
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(urlConnection, userName, password);
			if (connection != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}		
		} catch (SQLException e) {			
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
		return connection;
	}
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilDb {
	public static void getConnection() {

		String urlConnection = "jdbc:postgresql://database-lp3-n1.cgnm403exfxr.us-east-2.rds.amazonaws.com";
		String userName = "postgres";
		String password = "9tjGSBK6";

		// auto close connection
		try (Connection conn = DriverManager.getConnection(urlConnection, userName, password)) {			
			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}		
		} catch (SQLException e) {			
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}
}

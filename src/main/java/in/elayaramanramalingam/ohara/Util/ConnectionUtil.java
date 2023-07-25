package in.elayaramanramalingam.ohara.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionUtil {

	public static Connection getConnection() {

		Connection connection = null;

		String url = null;

		String username = null;

		String password = null;

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection  = DriverManager.getConnection(
			  "jdbc:mysql://aws.connect.psdb.cloud/ohara?sslMode=VERIFY_IDENTITY",
			  "8s8pxlyj0ledswtdr3ul",
			  "pscale_pw_D2FdRxMXHMR2Gs7H7YOcQewg4O9VHSRlLoH7SAgLsam");


		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return connection;

	}
	public static void close(Connection connection,PreparedStatement ps) {
		
		try {
			if(ps != null) {
				ps.close();
			}
			if(connection != null) {
				connection.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
public static void close(Connection connection,PreparedStatement ps,ResultSet rs) {
		
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(connection != null) {
				connection.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}

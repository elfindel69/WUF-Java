package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private static Connection connect = null;
	

	public static void doConnect() {
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         // Setup the connection with the DB
        try {
			connect = DriverManager
			         .getConnection("jdbc:mysql://localhost/wuf_data?"
			                 + "user=root&password=alpine");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	public static void doDisconnect() {
		try {
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
	}
	public static Connection getConnect() {
		return connect;
	}

	public static void setConnect(Connection connect) {
		Connect.connect = connect;
	}
}

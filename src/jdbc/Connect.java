package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de connection MySQL
 * @author elfindel69
 * @version 0.2.0
 */
public class Connect {
	/**
	 * Connection - connection à la base MySQL
	 */
	private static Connection connect = null;
	
	/**
	 * méthode de connection à la base MySQL
	 */
	public static void doConnect() {
		//récupération du driver MySQL
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        //mise en place de la connection à la base
        try {
			connect = DriverManager
			         .getConnection("jdbc:mysql://localhost/wuf_data?"
			                 + "user=root&password=alpine");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * méthode de déconnection
	 */
	public static void doDisconnect() {
		try {
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
	}
	/**
	 * getter de connect
	 * @return - Connection, connection à la base
	 */
	public static Connection getConnect() {
		return connect;
	}

	public static void setConnect(Connection connect) {
		Connect.connect = connect;
	}
}

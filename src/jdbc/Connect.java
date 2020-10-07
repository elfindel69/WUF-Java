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
	 * Connection - connection � la base MySQL
	 */
	private static Connection connect = null;
	
	/**
	 * m�thode de connection � la base MySQL
	 */
	public static void doConnect() {
		//r�cup�ration du driver MySQL
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        //mise en place de la connection � la base
        try {
			connect = DriverManager
			         .getConnection("jdbc:mysql://localhost/wuf_data?"
			                 + "user=root&password=alpine");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * m�thode de d�connection
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
	 * @return - Connection, connection � la base
	 */
	public static Connection getConnect() {
		return connect;
	}

	public static void setConnect(Connection connect) {
		Connect.connect = connect;
	}
}

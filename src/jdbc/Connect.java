package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	private static Connection connect = null;
	private static Statement statement;
	private static ResultSet resultSet = null;

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
	
	public static void testSQL() {
		try {
			statement = connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Result set get the result of the SQL query
        try {
			resultSet = statement
			        .executeQuery("select * from wuf_data.conference");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void doDisconnect() {
		try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

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

	public static ResultSet getResultSet() {
		return resultSet;
	}

	public static void setResultSet(ResultSet resultSet) {
		Connect.resultSet = resultSet;
	}
}

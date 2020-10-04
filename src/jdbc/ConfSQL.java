package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import country.Conf;

public class ConfSQL {
	private static PreparedStatement statement;
	
	public static ResultSet getData(Connection connect, String conf) throws SQLException {
		ResultSet resData = null;
		try {
			statement = connect.prepareStatement("select * from wuf_data.conference where name = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		statement.setString(1, conf);
        // Result set get the result of the SQL query
        try {
        	resData = statement
			        .executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return resData;
	}

	public static ResultSet getNames(Connection connect) {
		ResultSet resData = null;
		try {
			statement = connect.prepareStatement("select name from wuf_data.conference");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Result set get the result of the SQL query
        try {
        	resData = statement
			        .executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return resData;
	}

	public static int insertConf(Connection connect, Conf newConf) throws SQLException {
		statement = connect.prepareStatement("insert into wuf_data.conference () values (null,?,?,?,?)");
		
		statement.setString(1, newConf.getName());
		statement.setString(2, newConf.getAdj());
        statement.setInt(3, newConf.getNbMembers());
        statement.setString(4,newConf.getDate());
		
		return statement.executeUpdate();
	}
}

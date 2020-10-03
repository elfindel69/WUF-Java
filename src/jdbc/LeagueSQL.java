package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeagueSQL {
	private static PreparedStatement statement;
	
	public static ResultSet getData(Connection connect, String nation) throws SQLException {
		ResultSet resData = null;
		try {
			statement = connect.prepareStatement("select * from wuf_data.league where nation = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		statement.setString(1, nation);
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
}

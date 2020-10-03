package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchSQL {
	private static PreparedStatement statement;
	
	public static ResultSet getData(Connection connect, String nation) throws SQLException {
		ResultSet resData = null;
		try {
			String query = "select * from wuf_data.matches where nation_1 = ? or nation_2 = ? order by date_match desc limit 5";
			statement = connect.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		statement.setString(1, nation);
		statement.setString(2, nation);
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

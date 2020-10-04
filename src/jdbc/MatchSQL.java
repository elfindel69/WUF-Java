package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import matches.Match;

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

	public static int insertMatch(Connection connect, Match newMatch) throws SQLException {
		statement = connect.prepareStatement("insert into wuf_data.matches () values (null,?,?,?,?,?,?,?)");
		
		statement.setString(1, newMatch.getNat1());
		statement.setInt(2, newMatch.getSc1());
		statement.setString(3, newMatch.getNat2());
		statement.setInt(4, newMatch.getSc2());
		statement.setTimestamp(5, Timestamp.valueOf(newMatch.getDate().toLocalDateTime()));
		statement.setString(6, newMatch.getTimeZoneJava().toString());
		statement.setString(7, newMatch.getTimeZoneNet());
		
		return statement.executeUpdate();
	}
}

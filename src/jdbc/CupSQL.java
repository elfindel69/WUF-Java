package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import competition.Cup;

public class CupSQL {
	private static PreparedStatement statement;
	
	public static ResultSet getData(Connection connect, String nation) throws SQLException {
		ResultSet resData = null;
		try {
			statement = connect.prepareStatement("select * from wuf_data.cup where nation = ?");
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

	public static int insertCup(Connection connect, String nation, Cup newCup) throws SQLException {
		statement = connect.prepareStatement("insert into wuf_data.cup () values (null,?,?,?,?,?)");
		
		statement.setString(1, nation);
		statement.setString(2, newCup.getName());
        statement.setInt(3,newCup.getNbCups());
        statement.setString(4, newCup.getResult());
        statement.setString(5, newCup.getYear());
		
		return statement.executeUpdate();
		
	}

}

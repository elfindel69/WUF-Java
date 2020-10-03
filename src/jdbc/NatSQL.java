package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NatSQL {

	private static PreparedStatement statement;

	public static ResultSet getNames(Connection connect, int confId) throws SQLException {
		ResultSet resData = null;
		try {
			statement = connect.prepareStatement("select name from wuf_data.nation where conf_id = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		statement.setInt(1, confId);
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

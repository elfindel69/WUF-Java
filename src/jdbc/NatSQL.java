package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import country.Nation;

public class NatSQL {

	private static PreparedStatement statement;

	public static ResultSet getNames(Connection connect, int confId) throws SQLException {
		ResultSet resData = null;
		try {
			statement = connect.prepareStatement("select name from wuf_data.nation where conf_id = ? order by name");
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

	public static ResultSet getData(Connection connect, String nation) throws SQLException {
		ResultSet resData = null;
		try {
			statement = connect.prepareStatement("select * from wuf_data.nation where name = ?");
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

	public static int insertNation(Connection connect, Nation newNat) throws SQLException {
		statement = connect.prepareStatement("insert into wuf_data.nation () values (null,?,?,?,?,?,?,?)");

        statement.setString(1, newNat.getName());
        statement.setDouble(2, newNat.getPts());
        statement.setInt(3, newNat.getConf().getConfId());
        statement.setString(4, newNat.getStadium());
        statement.setString(5, newNat.getDate());
        statement.setInt(6, newNat.getRWuf());
        statement.setInt(7, newNat.getRConf());

        int res = statement.executeUpdate();

        return res;
	}
	
}

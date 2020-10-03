package country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.Connect;
import jdbc.NatSQL;

public class ContNation {
	public static List<String> getNatNames(int confId) throws SQLException{
		ResultSet resData = NatSQL.getNames(Connect.getConnect(), confId);
		List<String> lNames = new ArrayList<String>();
		while (resData.next()) {
			try {
				lNames.add(resData.getString("name"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		resData.close();
		return lNames;
	}
}

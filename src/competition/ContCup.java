package competition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.Connect;
import jdbc.CupSQL;

public class ContCup {
	
	public static List<Cup> getCupData(String nation) throws SQLException{
		ResultSet resData = CupSQL.getData(Connect.getConnect(), nation);
		List<Cup> lCup = new ArrayList<Cup>();
		while (resData.next()) {
			try {
				String name =resData.getString("name"); 
				int nbCups = resData.getInt("participations");
				String result = resData.getString("result");
				String year = resData.getString("year");
				lCup.add(new Cup(name, nbCups, result, year ));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		resData.close();
		return lCup;
	}
}

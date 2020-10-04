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
	
	public static List<Nation> getNatData(String nation) throws SQLException{
		ResultSet resData = NatSQL.getData(Connect.getConnect(), nation);
		List<Nation> lNat = new ArrayList<Nation>();
		while (resData.next()) {
			try {
				String name =resData.getString("name"); 
				double pts = resData.getDouble("pts");
				String stadium = resData.getString("stadium");
				String doa = resData.getString("dom");
				int rWuf = resData.getInt("r_wuf");
				int rConf  = resData.getInt("r_conf");
				lNat.add(new Nation(name, pts, null, stadium ,doa, rWuf, rConf ));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		resData.close();
		return lNat;
	}

	public static int insertNation(Nation newNat) throws SQLException {
		return NatSQL.insertNation(Connect.getConnect(), newNat);
	}
}

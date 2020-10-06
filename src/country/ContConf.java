package country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConfSQL;
import jdbc.Connect;

public class ContConf {

	public static List<String> getConfNames() throws SQLException{
		ResultSet resData = ConfSQL.getNames(Connect.getConnect());
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
	
	public static List<Conf> getConfData(String conf) throws SQLException{
		ResultSet resData = ConfSQL.getData(Connect.getConnect(), conf);
		List<Conf> lConf = new ArrayList<Conf>();
		while (resData.next()) {
			try {
				int id = resData.getInt("id");
				String name =resData.getString("name"); 
				String adj = resData.getString("adj");
				int nb = resData.getInt("nb_members");
				String doa = resData.getString("doa");
				lConf.add(new Conf(id, name, adj ,nb , doa ));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		resData.close();
		return lConf;
	}

	public static int insertConf(Conf newConf) throws SQLException {
		return ConfSQL.insertConf(Connect.getConnect(), newConf);
	}
}

package competition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.Connect;
import jdbc.LeagueSQL;

public class ContLeague {
	public static List<League> getLeagueData(String nation) throws SQLException{
		ResultSet resData = LeagueSQL.getData(Connect.getConnect(), nation);
		List<League> lLeague = new ArrayList<League>();
		while (resData.next()) {
			try {
				String name =resData.getString("name"); 
				String league = resData.getString("league");
				String result = resData.getString("result");
				String year = resData.getString("year");
				lLeague.add(new League(name, league, result, year ));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		resData.close();
		return lLeague;
	}

	public static int insertLeague(String nation, League newLeague) throws SQLException {
		
		return LeagueSQL.insertLeague(Connect.getConnect(),nation, newLeague);
	}
}

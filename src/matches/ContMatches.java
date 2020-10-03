package matches;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jdbc.Connect;
import jdbc.MatchSQL;

public class ContMatches {
	public static char[] calcResults(List<Match> lMatches, String nation) {
		char[] tabRes = new char[lMatches.size()];
		char res = 0;
		int i = 0;
		for (Match m : lMatches) {
			if (m.getSc1() == m.getSc2()) {
				res = 'N';
			}
			if (m.getNat1() == nation) {
				if(m.getSc1() > m.getSc2()) {
					res = 'V';
				}
				if (m.getSc1() < m.getSc2()) {
					res = 'D';
				}
			}
			if (m.getNat2() == nation) {
				if(m.getSc2() > m.getSc1()) {
					res = 'V';
				}
				if (m.getSc2() < m.getSc1()) {
					res = 'D';
				}
			}
			tabRes[i] = res;
			i++;
		}
		
		return tabRes;
	}
	
	public static List<Match> getMatchesData(String nation) throws SQLException{
		ResultSet resData = MatchSQL.getData(Connect.getConnect(), nation);
		List<Match> lMatches = new ArrayList<Match>();
		while (resData.next()) {
			try {
				String nat1 =resData.getString("nation_1"); 
				int score1 = resData.getInt("score_1");
				String nat2 = resData.getString("nation_2");
				int score2 = resData.getInt("score_2");
				String sDate = resData.getString("date_match");
				String timeZone = resData.getString("timeZone");
				
				ZoneId zone = ZoneId.of(timeZone);
				ZoneId utcZone = ZoneId.of("UTC");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDateTime locDate = LocalDateTime.parse(sDate, formatter);
				ZonedDateTime dom = ZonedDateTime.of(locDate, utcZone);
				lMatches.add(new Match(nat1, score1, nat2,score2, dom, zone ));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		resData.close();
		return lMatches;
	}
}

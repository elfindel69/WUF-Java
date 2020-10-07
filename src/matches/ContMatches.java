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

/**
 * Classe controller des Matches
 * @author elfindel69
 * @version 0.2.0
 *
 */
public class ContMatches {
	/**
	 * méthode de calcul des résultats (V, N, D)
	 * @param lMatches - List<Match>, liste des Matches joués
	 * @param nation - String - nom de la Nation
	 * @return char[] - tableau des résultats des Matches
	 */
	public static char[] calcResults(List<Match> lMatches, String nation) {
		//création du tableau de résultats
		char[] tabRes = new char[lMatches.size()];
		//résultat à insérer
		char res = 0;
		//index du tableau
		int i = 0;
		//calcul des résultats
		for (Match m : lMatches) {
			//match nul
			if (m.getSc1() == m.getSc2()) {
				res = 'N';
			}
			//calcul résultats
			if (m.getNat1() == nation) {
				//victoire
				if(m.getSc1() > m.getSc2()) {
					res = 'V';
				}
				//défaite 
				if (m.getSc1() < m.getSc2()) {
					res = 'D';
				}
			}
			if (m.getNat2() == nation) {
				//victoire
				if(m.getSc2() > m.getSc1()) {
					res = 'V';
				}
				//défaite
				if (m.getSc2() < m.getSc1()) {
					res = 'D';
				}
			}
			//ajout au tableau
			tabRes[i] = res;
			i++;
		}
		//retour tableau complété
		return tabRes;
	}
	/**
	 * méthode de récupération de data Matches par Nation
	 * @param nation - Nation, Nation parent
	 * @return List <Matches> - liste des Match joués
	 * @throws SQLException - exception MySQL
	 */
	public static List<Match> getMatchesData(String nation) throws SQLException{
		//récupération des data des Matches
		ResultSet resData = MatchSQL.getData(Connect.getConnect(), nation);
		//ajout à la liste
		List<Match> lMatches = new ArrayList<Match>();
		while (resData.next()) {
			try {
				String nat1 =resData.getString("nation_1"); 
				int score1 = resData.getInt("score_1");
				String nat2 = resData.getString("nation_2");
				int score2 = resData.getInt("score_2");
				String sDate = resData.getString("date_match");
				String timeZone = resData.getString("timeZone");
				String timeZone2 = resData.getString("timeZone2");
				//ajout de la date
				ZoneId zone = ZoneId.of(timeZone);
				ZoneId frZone = ZoneId.of("Europe/Paris");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDateTime locDate = LocalDateTime.parse(sDate, formatter);
				ZonedDateTime dom = ZonedDateTime.of(locDate, frZone);
				lMatches.add(new Match(nat1, score1, nat2,score2, dom, zone, timeZone2));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//fermeture objet ResultSet
		resData.close();
		//retour de la liste complétée
		return lMatches;
	}

	/**
	 * méthode d'insertion de Match
	 * @param newMatch, Match - Match à insérer
	 * @return int - nombre de lignes insérées
	 * @throws SQLException - exceptions MySQL
	 */
	public static int insertMatch(Match newMatch) throws SQLException {
		//insertion en base
		return MatchSQL.insertMatch(Connect.getConnect(),newMatch);
	}
}

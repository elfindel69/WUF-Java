package competition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.Connect;
import jdbc.LeagueSQL;

/**
 * Classe controller des League
 * @author elfindel69
 * @version 0.2.0
 */
public class ContLeague {
	/**
	 * m�thode de r�cup�ration de data League par Nation
	 * @param nation - String, nom de la Nation parent
	 * @return List<League> - Liste des Leagues r�cup�r�es
	 * @throws SQLException - exceptions MySQL
	 */
	public static List<League> getLeagueData(String nation) throws SQLException{
		//r�cup�ration des data des Leagues
		ResultSet resData = LeagueSQL.getData(Connect.getConnect(), nation);
		//ajout � la liste
		List<League> lLeague = new ArrayList<League>();
		while (resData.next()) {
			try {
				String name =resData.getString("name"); 
				String league = resData.getString("league");
				String result = resData.getString("result");
				String year = resData.getString("year");
				lLeague.add(new League(name, league, result, year ));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//fermeture de l'objet ResultSet
		resData.close();
		//retour de la liste compl�t�e
		return lLeague;
	}
	/**
	 * m�thode d'insertion de League
	 * @param nation - String, nom de la Nation parent
	 * @param newLeague - League, League � ins�rer
	 * @return int - nombre de lignes ins�r�es
	 * @throws SQLException - exceptions MySQL
	 */
	public static int insertLeague(String nation, League newLeague) throws SQLException {
		//insertion en base
		return LeagueSQL.insertLeague(Connect.getConnect(),nation, newLeague);
	}
}

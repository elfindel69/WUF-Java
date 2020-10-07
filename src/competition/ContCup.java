package competition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.Connect;
import jdbc.CupSQL;

/**
 * Classe Controller des Cup
 *  @author elfindel69
 * @version 0.2.0
 * 
 */
public class ContCup {
	/**
	 * méthode de récupération de data Cup par Nation
	 * @param nation - Nation, Nation parent
	 * @return List<Cup> - liste des Cups récupérées
	 * @throws SQLException - exceptions MySQL
	 */
	public static List<Cup> getCupData(String nation) throws SQLException{
		//récupération des data des Cups
		ResultSet resData = CupSQL.getData(Connect.getConnect(), nation);
		//ajout à la liste
		List<Cup> lCup = new ArrayList<Cup>();
		while (resData.next()) {
			try {
				String name =resData.getString("name"); 
				int nbCups = resData.getInt("participations");
				String result = resData.getString("result");
				String year = resData.getString("year");
				lCup.add(new Cup(name, nbCups, result, year ));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//fermeture de l'objet ResultSet
		resData.close();
		//retour de la liste complétée
		return lCup;
	}

	/**
	 * méthode d'insertion de Cup
	 * @param nation - Nation, Nation parent
	 * @param newCup - Cup, Cup à insérer
	 * @return int - nombre de lignes insérées
	 * @throws SQLException - exceptions MySQL
	 */
	public static int insertCup(String nation, Cup newCup) throws SQLException {
		//insertion en base
		return CupSQL.insertCup(Connect.getConnect(),nation, newCup);
	}
}

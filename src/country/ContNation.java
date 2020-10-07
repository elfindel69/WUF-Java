package country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.Connect;
import jdbc.NatSQL;

/**
 * Classe de controller Nation
 * @author elfindel69
 * @version 0.2.0
 */
public class ContNation {
	
	/**
	 *  méthode de récupération de nom des Nations par id de Conf
	 * @param confId - id de la Conf parent
	 * @return List<String> - liste des noms des Nations
	 * @throws SQLException - exceptions MySQL
	 */
	public static List<String> getNatNames(int confId) throws SQLException{
		//résultat requête de récupération des noms des Nations
		ResultSet resData = NatSQL.getNames(Connect.getConnect(), confId);
		//ajout des noms à la liste
		List<String> lNames = new ArrayList<String>();
		while (resData.next()) {
			try {
				lNames.add(resData.getString("name"));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		//fermeture de l'objet ResultSet
		resData.close();
		
		return lNames;
	}
	
	/**
	 * méthode de récupération de data Nation par nom
	 * @param nation - String, nom de la Nation à récupérer
	 * @return List<Nation> - Liste des Nations récupérées
	 * @throws SQLException - exceptions MySQL
	 */
	public static List<Nation> getNatData(String nation) throws SQLException{
		//récupération des data de la Nation
		ResultSet resData = NatSQL.getData(Connect.getConnect(), nation);
		//ajout à la liste
		List<Nation> lNat = new ArrayList<Nation>();
		while (resData.next()) {
			try {
				int id = resData.getInt("id");
				String name =resData.getString("name"); 
				double pts = resData.getDouble("pts");
				String stadium = resData.getString("stadium");
				String doa = resData.getString("dom");
				int rWuf = resData.getInt("r_wuf");
				int rConf  = resData.getInt("r_conf");
				lNat.add(new Nation(id, name, pts, null, stadium ,doa, rWuf, rConf ));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//fermeture objet ResultSet
		resData.close();
		return lNat;
	}
	/**
	 * méthode d'insertion de Nation
	 * @param newNat - Nation, Nation à insérer
	 * @return int - nombre de lignes insérées
	 * @throws SQLException - exception MySQL
	 */
	public static int insertNation(Nation newNat) throws SQLException {
		//insertion en base
		return NatSQL.insertNation(Connect.getConnect(), newNat);
	}
}

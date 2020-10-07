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
	 *  m�thode de r�cup�ration de nom des Nations par id de Conf
	 * @param confId - id de la Conf parent
	 * @return List<String> - liste des noms des Nations
	 * @throws SQLException - exceptions MySQL
	 */
	public static List<String> getNatNames(int confId) throws SQLException{
		//r�sultat requ�te de r�cup�ration des noms des Nations
		ResultSet resData = NatSQL.getNames(Connect.getConnect(), confId);
		//ajout des noms � la liste
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
	 * m�thode de r�cup�ration de data Nation par nom
	 * @param nation - String, nom de la Nation � r�cup�rer
	 * @return List<Nation> - Liste des Nations r�cup�r�es
	 * @throws SQLException - exceptions MySQL
	 */
	public static List<Nation> getNatData(String nation) throws SQLException{
		//r�cup�ration des data de la Nation
		ResultSet resData = NatSQL.getData(Connect.getConnect(), nation);
		//ajout � la liste
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
	 * m�thode d'insertion de Nation
	 * @param newNat - Nation, Nation � ins�rer
	 * @return int - nombre de lignes ins�r�es
	 * @throws SQLException - exception MySQL
	 */
	public static int insertNation(Nation newNat) throws SQLException {
		//insertion en base
		return NatSQL.insertNation(Connect.getConnect(), newNat);
	}
}

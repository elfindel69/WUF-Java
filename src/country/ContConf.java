package country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConfSQL;
import jdbc.Connect;

/**
 * Classe controller des Conf
 * @author elfindel69
 * @version 0.2.0
 */
public class ContConf {

	/**
	 * méthode de récupération de nom des Conf
	 * @return List<String> - liste de nom des Conf
	 * @throws SQLException - exceptions MySQL
	 */
	public static List<String> getConfNames() throws SQLException{
		//résultat de requête de récupération de nom des Conf
		ResultSet resData = ConfSQL.getNames(Connect.getConnect());
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
		//retour de la liste complétée
		return lNames;
	}
	
	/**
	 * méthode de récupération de data Conf par nom
	 * @param conf - String, nom de la Conf à récupérer
	 * @return List<Conf> - liste des Conf récupérées
	 * @throws SQLException - exceptions MySQL
	 */
	public static List<Conf> getConfData(String conf) throws SQLException{
		//récupération des data de la Conf
		ResultSet resData = ConfSQL.getData(Connect.getConnect(), conf);
		//ajout à la liste
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
				e.printStackTrace();
			}
		}
		//fermeture de l'objet ResultSet
		resData.close();
		//retour de la liste complétée
		return lConf;
	}
	/**
	 * méthode d'insertion de Conf
	 * @param newConf - Conf, Conf à insérer
	 * @return int - nombre de lignes insérées
	 * @throws SQLException - exceptions MySQL
	 */
	public static int insertConf(Conf newConf) throws SQLException {
		return ConfSQL.insertConf(Connect.getConnect(), newConf);
	}
}

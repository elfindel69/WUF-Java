package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import country.Nation;

/**
 * Classe de manipulation de Nation en base MySQL
 * @author elfindel69
 * @version 0.2.0
 */
public class NatSQL {
	/**
	 * PreparedStatement - requête SQL 
	 */
	private static PreparedStatement statement;

	/**
	 * méthode de récupération des noms des Nations par Conf
	 * @param connect - Connection, Connection à la base MySQL
	 * @param confId - int, id de la Conf parent
	 * @return ResultSet - résultat de la requête
	 * @throws SQLException - exceptions MySQL
	 */
	public static ResultSet getNames(Connection connect, int confId) throws SQLException {
		//résultat de la requête
		ResultSet resData = null;
		//requête de récupération des noms des Conf par ordre alphabétique et pat id de Conf parent
		try {
			statement = connect.prepareStatement("select name from wuf_data.nation where conf_id = ? order by name");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//ajout des paramètres à la requête
		statement.setInt(1, confId);
        //récupération des résultats de la requête
        try {
        	resData = statement
			        .executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        //retour des résultats
        return resData;
	}

	/**
	 * méthode de récupération des data Nation par nom
	 * @param connect - Connection, Connection à la base MySQL
	 * @param nation - String, nom de la Nation à récupérer
	 * @return ResultSet - résultats de la requête
	 * @throws SQLException - exceptions MySQL
	 */
	public static ResultSet getData(Connection connect, String nation) throws SQLException {
		//résultats de la requête
		ResultSet resData = null;
		//requête de récupération des data Nation par nom
		try {
			statement = connect.prepareStatement("select * from wuf_data.nation where name = ?");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//ajout des paramètres
		statement.setString(1, nation);
        //récupération des résultats de la requête
        try {
        	resData = statement
			        .executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        //retour des résultats
        return resData;
	}
	
	/**
	 * méthode d'insertion de Nation en base MySQL
	 * @param connect - Connection, Connection à la base MySQL
	 * @param newNat - Nation, Nation à insérer
	 * @return int - nombre de lignes insérées
	 * @throws SQLException - exceptions MySQL
	 */
	public static int insertNation(Connection connect, Nation newNat) throws SQLException {
		//requête d'insertion d'une Nation en base
		statement = connect.prepareStatement("insert into wuf_data.nation () values (null,?,?,?,?,?,?,?)");
		//ajout des paramètres de la requête
        statement.setString(1, newNat.getName());
        statement.setDouble(2, newNat.getPts());
        statement.setInt(3, newNat.getConf().getConfId());
        statement.setString(4, newNat.getStadium());
        statement.setString(5, newNat.getDate());
        statement.setInt(6, newNat.getRWuf());
        statement.setInt(7, newNat.getRConf());
        //insertion en base
        int res = statement.executeUpdate();
        //retour du nombre de lignes insérées
        return res;
	}
	
}

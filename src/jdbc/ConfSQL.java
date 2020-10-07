package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import country.Conf;

/**
 * Classe jdbc de manipulation de Conf en base MySQL
 * @author elfindel69
 * @version 0.2.0
 *
 */
public class ConfSQL {
	/**
	 * PreparedStatement - requête SQL 
	 */
	private static PreparedStatement statement;
	
	/**
	 * méthode de récupération des data Conf par nom
	 * @param connect - Connection, Connection à la base MySQL
	 * @param conf - String, nom de la Conf à récupérer
	 * @return ResultSet - résultats de la requête
	 * @throws SQLException - exceptions MySQL
	 */
	public static ResultSet getData(Connection connect, String conf) throws SQLException {
		//résultats de la requête
		ResultSet resData = null;
		//requête de récupération de data Conf par nom
		try {
			statement = connect.prepareStatement("select * from wuf_data.conference where name = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		statement.setString(1, conf);
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
	 * méthode de récupération des noms des Conf
	 * @param connect - Connection, Connection à la base MySQL
	 * @return ResultSet - résutlats de la requête
	 */
	public static ResultSet getNames(Connection connect) {
		//résultats de la requête
		ResultSet resData = null;
		//requête de récupération des noms des Conf par ordre alphabétique
		try {
			statement = connect.prepareStatement("select name from wuf_data.conference order by name");
		} catch (SQLException e) {
			e.printStackTrace();
		}
        //récupération des résultats de la requête
        try {
        	resData = statement
			        .executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        //retour des résutlats
        return resData;
	}

	/**
	 * méthode d'insertion de Conf en base MySQL
	 * @param connect - Connection, Connection à la base MySQL
	 * @param newConf - Conf, Conf à ajouter
	 * @return int - nombre de lignes insérées
	 * @throws SQLException - exceptions MySQL
	 */
	public static int insertConf(Connection connect, Conf newConf) throws SQLException {
		//requête d'insertion d'une Conf en base
		statement = connect.prepareStatement("insert into wuf_data.conference () values (null,?,?,?,?)");
		//ajout des paramètres de la requête
		statement.setString(1, newConf.getName());
		statement.setString(2, newConf.getAdj());
        statement.setInt(3, newConf.getNbMembers());
        statement.setString(4,newConf.getDate());
		//ajout en base
		return statement.executeUpdate();
	}
}

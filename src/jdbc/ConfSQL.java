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
	 * PreparedStatement - requ�te SQL 
	 */
	private static PreparedStatement statement;
	
	/**
	 * m�thode de r�cup�ration des data Conf par nom
	 * @param connect - Connection, Connection � la base MySQL
	 * @param conf - String, nom de la Conf � r�cup�rer
	 * @return ResultSet - r�sultats de la requ�te
	 * @throws SQLException - exceptions MySQL
	 */
	public static ResultSet getData(Connection connect, String conf) throws SQLException {
		//r�sultats de la requ�te
		ResultSet resData = null;
		//requ�te de r�cup�ration de data Conf par nom
		try {
			statement = connect.prepareStatement("select * from wuf_data.conference where name = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		statement.setString(1, conf);
        //r�cup�ration des r�sultats de la requ�te
        try {
        	resData = statement
			        .executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        //retour des r�sultats
        return resData;
	}

	/**
	 * m�thode de r�cup�ration des noms des Conf
	 * @param connect - Connection, Connection � la base MySQL
	 * @return ResultSet - r�sutlats de la requ�te
	 */
	public static ResultSet getNames(Connection connect) {
		//r�sultats de la requ�te
		ResultSet resData = null;
		//requ�te de r�cup�ration des noms des Conf par ordre alphab�tique
		try {
			statement = connect.prepareStatement("select name from wuf_data.conference order by name");
		} catch (SQLException e) {
			e.printStackTrace();
		}
        //r�cup�ration des r�sultats de la requ�te
        try {
        	resData = statement
			        .executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        //retour des r�sutlats
        return resData;
	}

	/**
	 * m�thode d'insertion de Conf en base MySQL
	 * @param connect - Connection, Connection � la base MySQL
	 * @param newConf - Conf, Conf � ajouter
	 * @return int - nombre de lignes ins�r�es
	 * @throws SQLException - exceptions MySQL
	 */
	public static int insertConf(Connection connect, Conf newConf) throws SQLException {
		//requ�te d'insertion d'une Conf en base
		statement = connect.prepareStatement("insert into wuf_data.conference () values (null,?,?,?,?)");
		//ajout des param�tres de la requ�te
		statement.setString(1, newConf.getName());
		statement.setString(2, newConf.getAdj());
        statement.setInt(3, newConf.getNbMembers());
        statement.setString(4,newConf.getDate());
		//ajout en base
		return statement.executeUpdate();
	}
}

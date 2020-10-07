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
	 * PreparedStatement - requ�te SQL 
	 */
	private static PreparedStatement statement;

	/**
	 * m�thode de r�cup�ration des noms des Nations par Conf
	 * @param connect - Connection, Connection � la base MySQL
	 * @param confId - int, id de la Conf parent
	 * @return ResultSet - r�sultat de la requ�te
	 * @throws SQLException - exceptions MySQL
	 */
	public static ResultSet getNames(Connection connect, int confId) throws SQLException {
		//r�sultat de la requ�te
		ResultSet resData = null;
		//requ�te de r�cup�ration des noms des Conf par ordre alphab�tique et pat id de Conf parent
		try {
			statement = connect.prepareStatement("select name from wuf_data.nation where conf_id = ? order by name");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//ajout des param�tres � la requ�te
		statement.setInt(1, confId);
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
	 * m�thode de r�cup�ration des data Nation par nom
	 * @param connect - Connection, Connection � la base MySQL
	 * @param nation - String, nom de la Nation � r�cup�rer
	 * @return ResultSet - r�sultats de la requ�te
	 * @throws SQLException - exceptions MySQL
	 */
	public static ResultSet getData(Connection connect, String nation) throws SQLException {
		//r�sultats de la requ�te
		ResultSet resData = null;
		//requ�te de r�cup�ration des data Nation par nom
		try {
			statement = connect.prepareStatement("select * from wuf_data.nation where name = ?");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//ajout des param�tres
		statement.setString(1, nation);
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
	 * m�thode d'insertion de Nation en base MySQL
	 * @param connect - Connection, Connection � la base MySQL
	 * @param newNat - Nation, Nation � ins�rer
	 * @return int - nombre de lignes ins�r�es
	 * @throws SQLException - exceptions MySQL
	 */
	public static int insertNation(Connection connect, Nation newNat) throws SQLException {
		//requ�te d'insertion d'une Nation en base
		statement = connect.prepareStatement("insert into wuf_data.nation () values (null,?,?,?,?,?,?,?)");
		//ajout des param�tres de la requ�te
        statement.setString(1, newNat.getName());
        statement.setDouble(2, newNat.getPts());
        statement.setInt(3, newNat.getConf().getConfId());
        statement.setString(4, newNat.getStadium());
        statement.setString(5, newNat.getDate());
        statement.setInt(6, newNat.getRWuf());
        statement.setInt(7, newNat.getRConf());
        //insertion en base
        int res = statement.executeUpdate();
        //retour du nombre de lignes ins�r�es
        return res;
	}
	
}

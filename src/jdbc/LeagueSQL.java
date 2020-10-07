package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import competition.League;

/**
 * classe de manipulation de League en base MySQL
 * @author elfindel69
 * @version 0.2.0
 *
 */
public class LeagueSQL {
	/**
	 * PreparedStatement - requête SQL 
	 */
	private static PreparedStatement statement;
	
	/**
	 * méthode de récupération des data League par nom Nation
	 * @param connect - Connection, connection à la base
	 * @param nation - String, nom de la Nation parent
	 * @return ResultSet - résultats de la requête
	 * @throws SQLException - exceptions MySQL
	 */
	public static ResultSet getData(Connection connect, String nation) throws SQLException {
		//résultats de la requête
		ResultSet resData = null;
		//requête de récupération des data League par nom Nation
		try {
			statement = connect.prepareStatement("select * from wuf_data.league where nation = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//ajout des paramètres
		statement.setString(1, nation);
		// récupération des résultats de la requête
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
	 * méthode d'insertion de League en base MySQL
	 * @param connect - Connection, connection à la base
	 * @param nation - String, nom de la Nation parent
	 * @param newLeague - League, League à insérer
	 * @return int - nombre de lignes insérées
	 * @throws SQLException - exceptions MySQL
	 */
	public static int insertLeague(Connection connect, String nation, League newLeague) throws SQLException {
		//requête d'insertion d'une League en base
		statement = connect.prepareStatement("insert into wuf_data.league () values (null,?,?,?,?,?)");
		//ajout des paramètres
		statement.setString(1, nation);
		statement.setString(2, newLeague.getName());
		statement.setString(3, newLeague.getLeague());
		statement.setString(4, newLeague.getResult());
		statement.setString(5, newLeague.getYear());
		//insertion en base
		return statement.executeUpdate();
	}
}

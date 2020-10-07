package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import matches.Match;

/**
 * classe de manipulation de Match en base MySQL
 * @author elfindel69
 * @version 0.2.0
 *
 */
public class MatchSQL {
	/**
	 * PreparedStatement - requête SQL 
	 */
	private static PreparedStatement statement;
	
	/**
	 * méthode de récupération des data Match par nom Nation
	 * @param connect - Connection, connection à la base
	 * @param nation - String, nom de la Nation parent
	 * @return ResultSet - résultats de la requête
	 * @throws SQLException - exceptions MySQL
	 */
	public static ResultSet getData(Connection connect, String nation) throws SQLException {
		//résultats de la requête
		ResultSet resData = null;
		//requête de récupération des data Match par nom Nation
		try {
			String query = "select * from wuf_data.matches where nation_1 = ? or nation_2 = ? order by date_match desc limit 5";
			statement = connect.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//ajout des paramètres
		statement.setString(1, nation);
		statement.setString(2, nation);
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
	 *  méthode d'insertion de Match en base MySQL
	 * @param connect - Connection, connection à la base
	 * @param newMatch - Match, Match à insérer
	 * @return int - nombre de lignes insérées
	 * @throws SQLException - exceptions MySQL
	 */
	public static int insertMatch(Connection connect, Match newMatch) throws SQLException {
		//requête d'insertion d'un Match en base
		statement = connect.prepareStatement("insert into wuf_data.matches () values (null,?,?,?,?,?,?,?)");
		//ajout des paramètres
		statement.setString(1, newMatch.getNat1());
		statement.setInt(2, newMatch.getSc1());
		statement.setString(3, newMatch.getNat2());
		statement.setInt(4, newMatch.getSc2());
		statement.setTimestamp(5, Timestamp.valueOf(newMatch.getDate().toLocalDateTime()));
		statement.setString(6, newMatch.getTimeZoneJava().toString());
		statement.setString(7, newMatch.getTimeZoneNet());
		//insertion en base
		return statement.executeUpdate();
	}
}

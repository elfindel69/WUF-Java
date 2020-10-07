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
	 * PreparedStatement - requ�te SQL 
	 */
	private static PreparedStatement statement;
	
	/**
	 * m�thode de r�cup�ration des data Match par nom Nation
	 * @param connect - Connection, connection � la base
	 * @param nation - String, nom de la Nation parent
	 * @return ResultSet - r�sultats de la requ�te
	 * @throws SQLException - exceptions MySQL
	 */
	public static ResultSet getData(Connection connect, String nation) throws SQLException {
		//r�sultats de la requ�te
		ResultSet resData = null;
		//requ�te de r�cup�ration des data Match par nom Nation
		try {
			String query = "select * from wuf_data.matches where nation_1 = ? or nation_2 = ? order by date_match desc limit 5";
			statement = connect.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//ajout des param�tres
		statement.setString(1, nation);
		statement.setString(2, nation);
		// r�cup�ration des r�sultats de la requ�te
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
	 *  m�thode d'insertion de Match en base MySQL
	 * @param connect - Connection, connection � la base
	 * @param newMatch - Match, Match � ins�rer
	 * @return int - nombre de lignes ins�r�es
	 * @throws SQLException - exceptions MySQL
	 */
	public static int insertMatch(Connection connect, Match newMatch) throws SQLException {
		//requ�te d'insertion d'un Match en base
		statement = connect.prepareStatement("insert into wuf_data.matches () values (null,?,?,?,?,?,?,?)");
		//ajout des param�tres
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

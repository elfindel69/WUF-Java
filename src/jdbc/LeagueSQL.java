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
	 * PreparedStatement - requ�te SQL 
	 */
	private static PreparedStatement statement;
	
	/**
	 * m�thode de r�cup�ration des data League par nom Nation
	 * @param connect - Connection, connection � la base
	 * @param nation - String, nom de la Nation parent
	 * @return ResultSet - r�sultats de la requ�te
	 * @throws SQLException - exceptions MySQL
	 */
	public static ResultSet getData(Connection connect, String nation) throws SQLException {
		//r�sultats de la requ�te
		ResultSet resData = null;
		//requ�te de r�cup�ration des data League par nom Nation
		try {
			statement = connect.prepareStatement("select * from wuf_data.league where nation = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//ajout des param�tres
		statement.setString(1, nation);
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
	 * m�thode d'insertion de League en base MySQL
	 * @param connect - Connection, connection � la base
	 * @param nation - String, nom de la Nation parent
	 * @param newLeague - League, League � ins�rer
	 * @return int - nombre de lignes ins�r�es
	 * @throws SQLException - exceptions MySQL
	 */
	public static int insertLeague(Connection connect, String nation, League newLeague) throws SQLException {
		//requ�te d'insertion d'une League en base
		statement = connect.prepareStatement("insert into wuf_data.league () values (null,?,?,?,?,?)");
		//ajout des param�tres
		statement.setString(1, nation);
		statement.setString(2, newLeague.getName());
		statement.setString(3, newLeague.getLeague());
		statement.setString(4, newLeague.getResult());
		statement.setString(5, newLeague.getYear());
		//insertion en base
		return statement.executeUpdate();
	}
}

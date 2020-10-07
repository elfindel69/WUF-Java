package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import competition.Cup;

/**
 * classe de manipulation de Cup en base MySQL
 * @author elfindel69
 * @version 0.2.0
 */
public class CupSQL {
	/**
	 * PreparedStatement - requ�te SQL 
	 */
	private static PreparedStatement statement;
	
	/**
	 * m�thode de r�cup�ration des data Cup par nom Nation
	 * @param connect - Connection, connection � la base
	 * @param nation - String, nom de la Nation parent
	 * @return ResultSet - r�sultats de la requ�te
	 * @throws SQLException - exceptions MySQL
	 */
	public static ResultSet getData(Connection connect, String nation) throws SQLException {
		//r�sultats de la requ�te
		ResultSet resData = null;
		//requ�te de r�cup�ration des data Cup par nom Nation
		try {
			statement = connect.prepareStatement("select * from wuf_data.cup where nation = ?");
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
	 * m�thode d'insertion de Cup en base MySQL
	 * @param connect - Connection, connection � la base
	 * @param nation - String, nom de la Nation parent
	 * @param newCup - Cup, Cup � ins�rer
	 * @return int - nombre de lignes ins�r�es
	 * @throws SQLException - exceptions MySQL
	 */
	public static int insertCup(Connection connect, String nation, Cup newCup) throws SQLException {
		//requ�te d'insertion d'une Cup en base
		statement = connect.prepareStatement("insert into wuf_data.cup () values (null,?,?,?,?,?)");
		//ajout des param�tres
		statement.setString(1, nation);
		statement.setString(2, newCup.getName());
        statement.setInt(3,newCup.getNbCups());
        statement.setString(4, newCup.getResult());
        statement.setString(5, newCup.getYear());
		//insertion en base
		return statement.executeUpdate();
		
	}

}

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
	 * PreparedStatement - requête SQL 
	 */
	private static PreparedStatement statement;
	
	/**
	 * méthode de récupération des data Cup par nom Nation
	 * @param connect - Connection, connection à la base
	 * @param nation - String, nom de la Nation parent
	 * @return ResultSet - résultats de la requête
	 * @throws SQLException - exceptions MySQL
	 */
	public static ResultSet getData(Connection connect, String nation) throws SQLException {
		//résultats de la requête
		ResultSet resData = null;
		//requête de récupération des data Cup par nom Nation
		try {
			statement = connect.prepareStatement("select * from wuf_data.cup where nation = ?");
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
	 * méthode d'insertion de Cup en base MySQL
	 * @param connect - Connection, connection à la base
	 * @param nation - String, nom de la Nation parent
	 * @param newCup - Cup, Cup à insérer
	 * @return int - nombre de lignes insérées
	 * @throws SQLException - exceptions MySQL
	 */
	public static int insertCup(Connection connect, String nation, Cup newCup) throws SQLException {
		//requête d'insertion d'une Cup en base
		statement = connect.prepareStatement("insert into wuf_data.cup () values (null,?,?,?,?,?)");
		//ajout des paramètres
		statement.setString(1, nation);
		statement.setString(2, newCup.getName());
        statement.setInt(3,newCup.getNbCups());
        statement.setString(4, newCup.getResult());
        statement.setString(5, newCup.getYear());
		//insertion en base
		return statement.executeUpdate();
		
	}

}

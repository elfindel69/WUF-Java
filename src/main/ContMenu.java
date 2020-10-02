package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import country.Conf;
import country.Country;
import country.ViewCountry;
import jdbc.ConfSQL;
import jdbc.Connect;
import points.CalcPoints;
import points.Points;
import points.ViewPoints;
import scores.CalcScores;
import scores.Scores;
import scores.ViewScores;

public class ContMenu {
	public static void execScores(Scanner sc) {
		sc.nextLine();
		System.out.println("Scores !");
		System.out.println("Pays 1:");
		Country ct1 = ViewCountry.newCountry(sc, false);
		System.out.println("Pays 2:");
		sc.nextLine();
		Country ct2 = ViewCountry.newCountry(sc, false);
		Scores scores = CalcScores.calcScores(ct1.getPts(),ct2.getPts());
		ct1.setScore(scores.getScore1());
		ct2.setScore(scores.getScore2());
		ViewScores.viewScores(ct1, ct2);
	}
	
	public static void execPoints(Scanner sc) {
		sc.nextLine();
		System.out.println("Points !");
		System.out.println("Pays 1:");
		Country ct1 = ViewCountry.newCountry(sc, true);
		System.out.println("Pays 2:");
		sc.nextLine();
		Country ct2 = ViewCountry.newCountry(sc, true);
		int coeff = ViewPoints.getCoeff(sc);
		int diff = ct1.getScore() - ct2.getScore();
		Points points = CalcPoints.calcPoints(ct1.getPts(),ct2.getPts(), coeff, diff);
		ct1.setPts(points.getPts1());
		ct2.setPts(points.getPts2());
		ViewPoints.viewPoints(ct1, ct2);
	}
	
	public static List<String> getConfNames() throws SQLException{
		ResultSet resData = ConfSQL.getNames(Connect.getConnect());
		List<String> lNames = new ArrayList<String>();
		while (resData.next()) {
			try {
				lNames.add(resData.getString("name"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		resData.close();
		return lNames;
	}
	
	public static List<Conf> getConfData(String conf) throws SQLException{
		ResultSet resData = ConfSQL.getData(Connect.getConnect(), conf);
		List<Conf> lConf = new ArrayList<Conf>();
		while (resData.next()) {
			try {
				String name =resData.getString("name"); 
				String adj = resData.getString("adj");
				int nb = resData.getInt("nb_members");
				String doa = resData.getString("doa");
				lConf.add(new Conf(name, adj ,nb , doa ));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		resData.close();
		return lConf;
	}
}

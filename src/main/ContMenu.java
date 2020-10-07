package main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import competition.ContCup;
import competition.ContLeague;
import competition.Cup;
import competition.League;
import competition.ViewCup;
import competition.ViewLeague;
import country.Conf;
import country.ContConf;
import country.ContNation;
import country.Country;
import country.Nation;
import country.ViewConf;
import country.ViewCountry;
import country.ViewNation;
import matches.ContMatches;
import matches.Match;
import matches.ViewMatches;
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
	
	public static void viewNations(Scanner sc) throws SQLException {
		List<String> lNames = ContConf.getConfNames();
		int confMenu = ViewConf.menuConf(sc,lNames);
		int confId = confMenu - 1;
		
		//Confederation
		List<Conf> lConf = ContConf.getConfData(lNames.get(confId));
		Conf conf = lConf.get(0);
		
		ViewConf.viewConf(conf);
		
		List<String> lNatNames = ContNation.getNatNames(conf.getConfId());
		int natMenu = ViewNation.menuNations(sc, lNatNames);
		int natId = natMenu - 1;
		
		//Nation
		List<Nation> lNat = ContNation.getNatData(lNatNames.get(natId));
		Nation nat = lNat.get(0);
		nat.setConf(conf);
		
		List<Cup> lCups = ContCup.getCupData(nat.getName());
		
		List<League> lLeagues = ContLeague.getLeagueData(nat.getName()); 
		League confLeague = null;
		if (lLeagues != null && lLeagues.size() > 0) {
			confLeague = lLeagues.get(0);
		}
		
		
		List<Match> tabMatches = ContMatches.getMatchesData(nat.getName());
		
		char[] results = ContMatches.calcResults(tabMatches, nat.getName());
		
		NatPage natPage = new NatPage(nat, lCups, confLeague, tabMatches, results);
		ViewNatPage.viewPage(natPage);
		sc.nextLine();
		System.out.println("Continuer: Y/N");
		String sexit = sc.nextLine();
		char exit = sexit.charAt(0);
		if (exit == 'n')
		{
			return;
		}
		//add Cup
		System.out.println("Ajout Coupe");
		addCup(sc, nat.getName());
		System.out.println("Continuer: Y/N");
		sexit = sc.nextLine();
		exit = sexit.charAt(0);
		if (exit == 'n')
		{
			return;
		}
		//add League
		System.out.println("Ajout Ligue");
		addLeague(sc, nat.getName());
	}
	
	public static void addConf(Scanner sc) throws SQLException
	{
		Conf newConf = ViewConf.addConf(sc);
		int lines = ContConf.insertConf(newConf);
		if (lines == 1)
		{
			System.out.println("insertion successful !");
		}
		else
		{
			System.out.println("insertion error !");
		}
	}
	
	public static void addNation(Scanner sc) throws SQLException
	{

		System.out.println("Ajout nation: ");
		Nation newNat = ViewNation.addNation(sc);
		int lines = ContNation.insertNation(newNat);
		if (lines == 1)
		{
			System.out.println("insertion successful: ");
		}
		else
		{
			System.out.println("insertion error: ");
		}
		System.out.println("Continuer: Y/N");
		String sexit = sc.nextLine();
		char exit = sexit.charAt(0);
		if (exit == 'n')
		{
			return;
		}
		//add Cup
		System.out.println("Ajout Coupe");
		addCup(sc, newNat.getName());
		System.out.println("Continuer: Y/N");
		sexit = sc.nextLine();
		exit = sexit.charAt(0);
		if (exit == 'n')
		{
			return;
		}
		//add League
		System.out.println("Ajout Ligue");
		addLeague(sc, newNat.getName());
	}

	public static void addCup(Scanner sc, String nation) throws SQLException
	{
		Cup newCup = ViewCup.addCup(sc);
		int lines = ContCup.insertCup(nation, newCup);
		if (lines == 1)
		{
			System.out.println("insertion successful !");
		}
		else
		{
			System.out.println("insertion error !");
		}
	}

	public static void addLeague(Scanner sc, String nation) throws SQLException
	{
		League newLeague = ViewLeague.addLeague(sc);
		int lines = ContLeague.insertLeague(nation, newLeague);
		if (lines == 1)
		{
			System.out.println("insertion successful !");
		}
		else
		{
			System.out.println("insertion error !");
		}
	}
	
	public static void addMatch(Scanner sc) throws SQLException
	{
		Match newMatch = ViewMatches.addMatch(sc);
		int lines = ContMatches.insertMatch(newMatch);
		if (lines == 1)
		{
			System.out.println("insertion successful !");
		}
		else
		{
			System.out.println("insertion error !");
		}
	}
	
	
}

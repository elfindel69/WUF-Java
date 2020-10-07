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

/**
 * Classe controller du Menu console
 * @author elfindel69
 * @version 0.2.0
 */
public class ContMenu {
	/**
	 * m�thode calcul de Score
	 * @param sc - Scanner, entr�e console
	 */
	public static void execScores(Scanner sc) {
		sc.nextLine();
		//affichage et cr�ation Country
		System.out.println("Scores !");
		System.out.println("Pays 1:");
		Country ct1 = ViewCountry.newCountry(sc, false);
		System.out.println("Pays 2:");
		sc.nextLine();
		Country ct2 = ViewCountry.newCountry(sc, false);
		//calcul du Score
		Scores scores = CalcScores.calcScores(ct1.getPts(),ct2.getPts());
		//M�J Countries
		ct1.setScore(scores.getScore1());
		ct2.setScore(scores.getScore2());
		//affichafge Scores par Country
		ViewScores.viewScores(ct1, ct2);
	}
	
	/**
	 * m�thode calcul de Points
	 * @param sc - Scanner, entr�e console
	 */
	public static void execPoints(Scanner sc) {
		sc.nextLine();
		//affichage et cr�ation Country
		System.out.println("Points !");
		System.out.println("Pays 1:");
		Country ct1 = ViewCountry.newCountry(sc, true);
		System.out.println("Pays 2:");
		sc.nextLine();
		Country ct2 = ViewCountry.newCountry(sc, true);
		//calcul des Points par Country
		int coeff = ViewPoints.getCoeff(sc);
		int diff = ct1.getScore() - ct2.getScore();
		Points points = CalcPoints.calcPoints(ct1.getPts(),ct2.getPts(), coeff, diff);
		//M�J Countries
		ct1.setPts(points.getPts1());
		ct2.setPts(points.getPts2());
		//affichage Points par Countries
		ViewPoints.viewPoints(ct1, ct2);
	}
	
	/**
	 * M�thode d'affichage des Confs et des Nations
	 * @param sc - Scanner, entr�e console
	 * @throws SQLException - exceptions MySQL
	 */
	public static void viewNations(Scanner sc) throws SQLException {
		//r�cup�ration des noms des Confs
		List<String> lNames = ContConf.getConfNames();
		//affichage des noms des Confs
		int confMenu = ViewConf.menuConf(sc,lNames);
		int confId = confMenu - 1;
		
		//r�cup�ration des data Conf par nom
		List<Conf> lConf = ContConf.getConfData(lNames.get(confId));
		Conf conf = lConf.get(0);
		//affichage data Conf
		ViewConf.viewConf(conf);
		
		//r�cup�ration des noms des Nations de la Conf
		List<String> lNatNames = ContNation.getNatNames(conf.getConfId());
		//affichage des noms des Nations
		int natMenu = ViewNation.menuNations(sc, lNatNames);
		int natId = natMenu - 1;
		
		// r�cup�ration des data Nation par nom
		List<Nation> lNat = ContNation.getNatData(lNatNames.get(natId));
		Nation nat = lNat.get(0);
		//M�J Nation - ajout de la Conf parent
		nat.setConf(conf);
		
		//r�cup�ration des Cups de la Nation
		List<Cup> lCups = ContCup.getCupData(nat.getName());
		
		//r�cup�ration des Leagues de la Nation
		List<League> lLeagues = ContLeague.getLeagueData(nat.getName()); 
		League confLeague = null;
		if (lLeagues != null && lLeagues.size() > 0) {
			confLeague = lLeagues.get(0);
		}
		
		//r�cup�ration des Matches de la Nation
		List<Match> tabMatches = ContMatches.getMatchesData(nat.getName());
		
		//calcul des r�sultats (V, N, D)
		char[] results = ContMatches.calcResults(tabMatches, nat.getName());
		
		//affichage de la Nation
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
		//ajout d'une Cup
		System.out.println("Ajout Coupe");
		addCup(sc, nat.getName());
		System.out.println("Continuer: Y/N");
		sexit = sc.nextLine();
		exit = sexit.charAt(0);
		if (exit == 'n')
		{
			return;
		}
		//ajout d'une League
		System.out.println("Ajout Ligue");
		addLeague(sc, nat.getName());
	}
	
	/**
	 * m�thode d'insertion de Conf
	 * @param sc - Scanner, entr�e console
	 * @throws SQLException
	 */
	public static void addConf(Scanner sc) throws SQLException
	{
		//cr�ation de la Conf
		System.out.println("Ajout conf�rence: ");
		Conf newConf = ViewConf.addConf(sc);
		//insertion en base
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
	/**
	 * m�thode d'insertion de Nation
	 * @param sc - Scanner, entr�e console
	 * @throws SQLException - exception MySQL
	 */
	public static void addNation(Scanner sc) throws SQLException
	{
		// cr�ation de la Nation
		System.out.println("Ajout nation: ");
		Nation newNat = ViewNation.addNation(sc);
		//insertion en base
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
		//ajout d'une Cup
		System.out.println("Ajout Coupe");
		addCup(sc, newNat.getName());
		System.out.println("Continuer: Y/N");
		sexit = sc.nextLine();
		exit = sexit.charAt(0);
		if (exit == 'n')
		{
			return;
		}
		//ajout d'une League
		System.out.println("Ajout Ligue");
		addLeague(sc, newNat.getName());
	}

	/**
	 * m�thode d'ajout de Cup
	 * @param sc - Scanner, entr�e console
	 * @param nation - String, nom de la Nation parent
	 * @throws SQLException - exceptions MySQL
	 */
	public static void addCup(Scanner sc, String nation) throws SQLException
	{
		//cr�ation de la Cup
		Cup newCup = ViewCup.addCup(sc);
		//insertion en base
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

	/**
	 * m�thode d'ajout de League
	 * @param sc - Scanner, entr�e console
	 * @param nation - String, nom de la Nation parent
	 * @throws SQLException - exceptions MySQL
	 */
	public static void addLeague(Scanner sc, String nation) throws SQLException
	{
		//cr�ation de la League
		League newLeague = ViewLeague.addLeague(sc);
		//insertion en base
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

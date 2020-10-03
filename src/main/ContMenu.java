package main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import competition.ContCup;
import competition.ContLeague;
import competition.Cup;
import competition.League;
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
		for (Conf c : lConf) {
			ViewConf.viewConf(c);
		}
		if (confMenu > 1) {
			++confMenu;
		}
		List<String> lNatNames = ContNation.getNatNames(confMenu);
		int natMenu = ViewNation.menuNations(sc, lNatNames);
		int natId = natMenu - 1;
		
		//Nation
		List<Nation> lNat = ContNation.getNatData(lNatNames.get(natId));
		Nation nat = lNat.get(0);
		nat.setConf(lConf.get(0));
		
		List<Cup> lCups = ContCup.getCupData(lNatNames.get(natId));
		
		List<League> lLeagues = ContLeague.getLeagueData(lNatNames.get(natId)); 
		League confLeague = null;
		if (lLeagues != null && lLeagues.size() > 0) {
			confLeague = lLeagues.get(0);
		}
		
		
		List<Match> tabMatches = ContMatches.getMatchesData(lNatNames.get(natId));
		
		char[] results = ContMatches.calcResults(tabMatches, lNatNames.get(natId));
		
		NatPage natPage = new NatPage(nat, lCups, confLeague, tabMatches, results);
		ViewNatPage.viewPage(natPage);
	}
	
	
}

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
import country.Nation;
import country.ViewConf;
import country.ViewNation;
import jdbc.Connect;
import matches.ContMatches;
import matches.Match;

public class Main {

	public static void main(String[] args) throws SQLException {
		Connect.doConnect();
		char exit = 'n';
		Scanner sc = new Scanner(System.in);
		do { 
			//menu principal
			int startMenu = ViewMenu.startMenu(sc);
			//scores
			if (startMenu == 1) {
				ContMenu.execScores(sc);
			}
			//points
			if (startMenu == 2) {

				ContMenu.execPoints(sc);
			}
			//view nations
			if (startMenu == 3) {
				List<String> lNames = ContConf.getConfNames();
				int confMenu = ViewConf.menuConf(sc,lNames);
				int confId = confMenu - 1;
				
				//Confederation
				List<Conf> lConf = ContConf.getConfData(lNames.get(confId));
				for (Conf c : lConf) {
					ViewConf.viewConf(c);
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
				League euLeague = lLeagues.get(0);	
				
				List<Match> tabMatches = ContMatches.getMatchesData(lNatNames.get(natId));
				
				char[] results = ContMatches.calcResults(tabMatches, lNatNames.get(natId));
				
				NatPage pageFr = new NatPage(nat, lCups, euLeague, tabMatches, results);
				ViewNatPage.viewPage(pageFr);
				
			}
			sc.nextLine();
			
			System.out.println("Quitter ? y/n");
			String sexit = sc.nextLine();
			exit = sexit.charAt(0);
		}while (exit != 'y');
		sc.close();
		Connect.doDisconnect();
	}

}

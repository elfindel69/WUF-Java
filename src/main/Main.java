package main;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
			//nations
			if (startMenu == 3) {
				List<String> lNames = ContConf.getConfNames();
				int confMenu = ViewConf.menuConf(sc,lNames);
				int confId = confMenu - 1;
				ZoneId utcZone = ZoneId.of("UTC");
				//Europe
				if (confMenu == 1) {
					List<Conf> lConf = ContConf.getConfData(lNames.get(confId));
					for (Conf c : lConf) {
						ViewConf.viewConf(c);
					}
					ZoneId zoneEurope = ZoneId.of("Europe/Paris");
					List<String> lNatNames = ContNation.getNatNames(confMenu);
					int natMenu = ViewNation.menuNations(sc, lNatNames);
					//France
					if (natMenu == 1) {
						Nation france = new Nation("France", 302.40, lConf.get(confId), "Stade de France", "2018", 10, 3 );
						
						Cup worldCup = new Cup("World Cup", 0, "qualifications", "2021");
						String confCup = france.getConf().getAdj()+" Cup";
						Cup euCup = new Cup (confCup, 1, "finalist", "2019");
						List<Cup> lCups = new ArrayList<Cup>();
						lCups.add(worldCup);
						lCups.add(euCup);
						
						String confLeague = "League of Nations - "+france.getConf().getName();
						League euLeague = new League(confLeague, "1A", "N/A", "2020");	
						
						ArrayList<Match> tabMatches = new ArrayList<Match>();
						LocalDateTime locDate1 = LocalDateTime.parse("2020-03-06T20:00:00");
						ZonedDateTime zoneDate1 = ZonedDateTime.of(locDate1, utcZone);
						tabMatches.add(new Match("France", 18, "Albania", 9, zoneDate1,zoneEurope));
					
						LocalDateTime locDate2 = LocalDateTime.parse("2020-02-12T20:00:00");
						ZonedDateTime zoneDate2 = ZonedDateTime.of(locDate2, utcZone);
						tabMatches.add(new Match("France", 23, "Cyprus", 9, zoneDate2,zoneEurope));
						
						LocalDateTime locDate3 = LocalDateTime.parse("2020-02-07T20:00:00");
						ZonedDateTime zoneDate3 = ZonedDateTime.of(locDate3, utcZone);
						tabMatches.add(new Match("France", 23, "Israel", 9, zoneDate3,zoneEurope));
						
						LocalDateTime locDate4 = LocalDateTime.parse("2020-01-08T20:00:00");
						ZonedDateTime zoneDate4 = ZonedDateTime.of(locDate4, utcZone);
						tabMatches.add(new Match("France", 23, "Moldova", 16, zoneDate4,zoneEurope));
						
						LocalDateTime locDate5 = LocalDateTime.parse("2020-01-03T20:00:00");
						ZonedDateTime zoneDate5 = ZonedDateTime.of(locDate5, utcZone);
						tabMatches.add(new Match("France", 23, "Italy", 13, zoneDate5,zoneEurope));
						
						char[] results = ContMatches.calcResults(tabMatches, "France");
						
						NatPage pageFr = new NatPage(france, lCups, euLeague, tabMatches, results);
						ViewNatPage.viewPage(pageFr);
					}
					
					//Italy
					if (natMenu == 2) {
						Nation italy = new Nation("Italy", 127.58, lConf.get(confId), "Stadio Olympico", "2018", 31, 11 );

						Cup worldCup = new Cup ("World Cup", 0, "qualifications", "2021");
						String confCup = italy.getConf().getAdj()+" Cup";
						Cup euCup = new Cup (confCup, 1, "quarter-finalist", "2019");
						List<Cup> lCups = new ArrayList<Cup>();
						lCups.add(worldCup);
						lCups.add(euCup);
						
						String confLeague = "League of Nations - "+italy.getConf().getName();
						League euLeague = new League(confLeague, "2A", "N/A","2020");
						
						
						List<Match> tabMatches = new ArrayList<Match>();
						
						LocalDateTime locDate1 = LocalDateTime.parse("2020-03-06T20:00:00");
						ZonedDateTime zoneDate1 = ZonedDateTime.of(locDate1, utcZone);
						tabMatches.add(new Match("Italy", 18, "Cyprus", 13, zoneDate1,zoneEurope));
						
						LocalDateTime locDate2 = LocalDateTime.parse("2020-02-12T20:00:00");
						ZonedDateTime zoneDate2 = ZonedDateTime.of(locDate2, utcZone);
						tabMatches.add(new Match("Italy", 18, "Albania", 9, zoneDate2,zoneEurope));
						
						LocalDateTime locDate3 = LocalDateTime.parse("2020-02-07T20:00:00");
						ZonedDateTime zoneDate3 = ZonedDateTime.of(locDate3, utcZone);
						tabMatches.add(new Match("Italy", 16, "Moldova", 9, zoneDate3,zoneEurope));
						
						LocalDateTime locDate4 = LocalDateTime.parse("2020-01-08T20:00:00");
						ZonedDateTime zoneDate4 = ZonedDateTime.of(locDate4, utcZone);
						tabMatches.add(new Match("Italy", 18, "Israel", 13, zoneDate4,zoneEurope));
						
						LocalDateTime locDate5 = LocalDateTime.parse("2020-01-03T20:00:00");
						ZonedDateTime zoneDate5 = ZonedDateTime.of(locDate5, utcZone);
						tabMatches.add(new Match("France", 23, "Italy", 13, zoneDate5,zoneEurope));
						
						char[] results = ContMatches.calcResults(tabMatches, "Italy");
						
						NatPage pageIt = new NatPage(italy, lCups, euLeague, tabMatches, results);
						ViewNatPage.viewPage(pageIt);
					}
				}
				
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

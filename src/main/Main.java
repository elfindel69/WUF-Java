package main;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import competition.Cup;
import competition.League;
import competition.ViewCup;
import competition.ViewLeague;
import country.Conf;
import country.Nation;
import country.ViewConf;
import country.ViewNation;
import matches.ContMatches;
import matches.Match;
import matches.ViewMatches;


public class Main {

	public static void main(String[] args) {
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
				int confMenu = ViewConf.menuConf(sc);
				//Europe
				ZoneId utcZone = ZoneId.of("UTC");
				if (confMenu == 1) {
					Conf europe = new Conf("Europe", "European", 55, "2018");
					ViewConf.viewConf(europe);
					ZoneId zoneEurope = ZoneId.of("Europe/Paris");
					int natMenu = ViewNation.menuNations(sc);
					//France
					if (natMenu == 1) {
						Nation france = new Nation("France", 302.40, europe, "Stade de France", "2018", 10, 3 );
						ViewNation.viewNation(france);
						Cup worldCup = new Cup("World Cup", 0, "qualifications", "2021");
						ViewCup.viewCup(worldCup);
						String confCup = france.getConf().getAdj()+" Cup";
						Cup euCup = new Cup (confCup, 1, "finalist", "2019");
						ViewCup.viewCup(euCup);
						String confLeague = "League of Nations - "+france.getConf().getName();
						League euLeague = new League(confLeague, "1A", "N/A", "2020");
						ViewLeague.viewLeague(euLeague);
						
						ArrayList<Match> tabMatches = new ArrayList<Match>();
						LocalDateTime locDate1 = LocalDateTime.parse("2020-03-06T20:00:00");
						ZonedDateTime zoneDate1 = ZonedDateTime.of(locDate1, utcZone);
						tabMatches.add(new Match("France", 18, "Albania", 9, zoneDate1));
					
						LocalDateTime locDate2 = LocalDateTime.parse("2020-02-12T20:00:00");
						ZonedDateTime zoneDate2 = ZonedDateTime.of(locDate2, utcZone);
						tabMatches.add(new Match("France", 23, "Cyprus", 9, zoneDate2));
						
						LocalDateTime locDate3 = LocalDateTime.parse("2020-02-07T20:00:00");
						ZonedDateTime zoneDate3 = ZonedDateTime.of(locDate3, utcZone);
						tabMatches.add(new Match("France", 23, "Israel", 9, zoneDate3));
						
						LocalDateTime locDate4 = LocalDateTime.parse("2020-01-08T20:00:00");
						ZonedDateTime zoneDate4 = ZonedDateTime.of(locDate4, utcZone);
						tabMatches.add(new Match("France", 23, "Moldova", 16, zoneDate4));
						
						LocalDateTime locDate5 = LocalDateTime.parse("2020-01-03T20:00:00");
						ZonedDateTime zoneDate5 = ZonedDateTime.of(locDate5, utcZone);
						tabMatches.add(new Match("France", 23, "Italy", 13, zoneDate5));
						
						char[] results = ContMatches.calcResults(tabMatches, "France");
						
						for (int i=0; i < results.length; i++) {
							System.out.print(results[i]);
						}
						System.out.print("\n\n");
						
						for(Match item : tabMatches) {
							ViewMatches.viewMatches(item,zoneEurope);
						}
					}
					
					//Italy
					if (natMenu == 2) {
						Nation italy = new Nation("Italy", 127.58, europe, "Stadio Olympico", "2018", 31, 11 );
						ViewNation.viewNation(italy);
						Cup worldCup = new Cup ("World Cup", 0, "qualifications", "2021");
						ViewCup.viewCup(worldCup);
						String confCup = italy.getConf().getAdj()+" Cup";
						Cup euCup = new Cup (confCup, 1, "quarter-finalist", "2019");
						ViewCup.viewCup(euCup);
						String confLeague = "League of Nations - "+italy.getConf().getName();
						League euLeague = new League(confLeague, "2A", "N/A","2020");
						ViewLeague.viewLeague(euLeague);
						
						List<Match> tabMatches = new ArrayList<Match>();
						
						LocalDateTime locDate1 = LocalDateTime.parse("2020-03-06T20:00:00");
						ZonedDateTime zoneDate1 = ZonedDateTime.of(locDate1, utcZone);
						tabMatches.add(new Match("Italy", 18, "Cyprus", 13, zoneDate1));
						
						LocalDateTime locDate2 = LocalDateTime.parse("2020-02-12T20:00:00");
						ZonedDateTime zoneDate2 = ZonedDateTime.of(locDate2, utcZone);
						tabMatches.add(new Match("Italy", 18, "Albania", 9, zoneDate2));
						
						LocalDateTime locDate3 = LocalDateTime.parse("2020-02-07T20:00:00");
						ZonedDateTime zoneDate3 = ZonedDateTime.of(locDate3, utcZone);
						tabMatches.add(new Match("Italy", 16, "Moldova", 9, zoneDate3));
						
						LocalDateTime locDate4 = LocalDateTime.parse("2020-01-08T20:00:00");
						ZonedDateTime zoneDate4 = ZonedDateTime.of(locDate4, utcZone);
						tabMatches.add(new Match("Italy", 18, "Israel", 13, zoneDate4));
						
						LocalDateTime locDate5 = LocalDateTime.parse("2020-01-03T20:00:00");
						ZonedDateTime zoneDate5 = ZonedDateTime.of(locDate5, utcZone);
						tabMatches.add(new Match("France", 23, "Italy", 13, zoneDate5));
						
						char[] results = ContMatches.calcResults(tabMatches, "Italy");
						
						for (int i=0; i < results.length; i++) {
							System.out.print(results[i]);
						}
						System.out.print("\n\n");
						
						for(Match item : tabMatches) {
							ViewMatches.viewMatches(item,zoneEurope);
						}
					}
				}
				
			}
			sc.nextLine();
			
			System.out.println("Quitter ? y/n");
			String sexit = sc.nextLine();
			exit = sexit.charAt(0);
		}while (exit != 'y');
		sc.close();

	}

}

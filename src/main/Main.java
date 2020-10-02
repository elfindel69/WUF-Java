package main;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import competition.ViewCup;
import competition.ViewLeague;
import country.Conf;
import country.Nation;
import country.ViewConf;
import country.ViewNation;
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
				Conf europe = new Conf("Europe", "European", 54, "2018");
				ViewConf.viewConf(europe);
				ZoneId zoneEurope = ZoneId.of("Europe/Paris");
				if (confMenu == 1) {
					int natMenu = ViewNation.menuNations(sc);
					//France
					if (natMenu == 1) {
						Nation france = new Nation("France", 302.40, 0, europe, "Stade de France", "2018", 10, 3 );
						ViewNation.viewNation(france);
						ViewCup.viewCup("World Cup", 0, "qualifications", "2021");
						String confCup = france.getConf().getAdj()+" Cup";
						ViewCup.viewCup(confCup, 1, "finalist", "2019");
						String confLeague = "League of Nations - "+france.getConf().getName();
						ViewLeague.viewLeague(confLeague, "1A", "N/A");
						char[] results = new char[5];
						for (int i=0; i < results.length; i++) {
							results[i] = 'V';
						}
						for (int i=0; i < results.length; i++) {
							System.out.print(results[i]);
						}
						System.out.print("\n\n");
						ArrayList<Match> tabMatches = new ArrayList<Match>();
						
						LocalDateTime locDate1 = LocalDateTime.parse("2020-03-06T21:00:00");
						ZonedDateTime zoneDate1 = ZonedDateTime.of(locDate1, zoneEurope);
						tabMatches.add(new Match("France", 18, "Albania", 9, zoneDate1));
					
						LocalDateTime locDate2 = LocalDateTime.parse("2020-02-12T21:00:00");
						ZonedDateTime zoneDate2 = ZonedDateTime.of(locDate2, zoneEurope);
						tabMatches.add(new Match("France", 23, "Cyprus", 9, zoneDate2));
						
						LocalDateTime locDate3 = LocalDateTime.parse("2020-02-07T21:00:00");
						ZonedDateTime zoneDate3 = ZonedDateTime.of(locDate3, zoneEurope);
						tabMatches.add(new Match("France", 23, "Israel", 9, zoneDate3));
						
						LocalDateTime locDate4 = LocalDateTime.parse("2020-01-08T21:00:00");
						ZonedDateTime zoneDate4 = ZonedDateTime.of(locDate4, zoneEurope);
						tabMatches.add(new Match("France", 23, "Moldova", 16, zoneDate4));
						
						LocalDateTime locDate5 = LocalDateTime.parse("2020-01-03T21:00:00");
						ZonedDateTime zoneDate5 = ZonedDateTime.of(locDate5, zoneEurope);
						tabMatches.add(new Match("France", 23, "Italy", 13, zoneDate5));
						
						for(Match item : tabMatches) {
							ViewMatches.viewMatches(item);
						}
					}
					
					//Italy
					if (natMenu == 2) {
						Nation italy = new Nation("Italy", 127.58, 0, europe, "Stadio Olympico", "2018", 31, 11 );
						ViewNation.viewNation(italy);
						ViewCup.viewCup("World Cup", 0, "qualifications", "2021");
						String confCup = italy.getConf().getAdj()+" Cup";
						ViewCup.viewCup(confCup, 1, "quarter-finalist", "2019");
						String confLeague = "League of Nations - "+italy.getConf().getName();
						ViewLeague.viewLeague(confLeague, "2A", "N/A");
						char[] results = new char[5];
						results[0] = 'V';
						results[1] = 'V';
						results[2] = 'V';
						results[3] = 'V';
						results[4] = 'D';
						for (int i=0; i < results.length; i++) {
							System.out.print(results[i]);
						}
						System.out.print("\n\n");
						Match[] tabMatches = new Match[5];
						
						LocalDateTime locDate1 = LocalDateTime.parse("2020-03-06T21:00:00");
						ZonedDateTime zoneDate1 = ZonedDateTime.of(locDate1, zoneEurope);
						tabMatches[0] = new Match("Italy", 18, "Cyprus", 13, zoneDate1);
						
						LocalDateTime locDate2 = LocalDateTime.parse("2020-02-12T21:00:00");
						ZonedDateTime zoneDate2 = ZonedDateTime.of(locDate2, zoneEurope);
						tabMatches[1] = new Match("Italy", 18, "Albania", 9, zoneDate2);
						
						LocalDateTime locDate3 = LocalDateTime.parse("2020-02-07T21:00:00");
						ZonedDateTime zoneDate3 = ZonedDateTime.of(locDate3, zoneEurope);
						tabMatches[2] = new Match("Italy", 16, "Moldova", 9, zoneDate3);
						
						LocalDateTime locDate4 = LocalDateTime.parse("2020-01-08T21:00:00");
						ZonedDateTime zoneDate4 = ZonedDateTime.of(locDate4, zoneEurope);
						tabMatches[3] = new Match("Italy", 18, "Israel", 13, zoneDate4);
						
						LocalDateTime locDate5 = LocalDateTime.parse("2020-01-03T21:00:00");
						ZonedDateTime zoneDate5 = ZonedDateTime.of(locDate5, zoneEurope);
						tabMatches[4] = new Match("France", 23, "Italy", 13, zoneDate5);
						
						for(int i=0; i < tabMatches.length; i++) {
							ViewMatches.viewMatches(tabMatches[i]);
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

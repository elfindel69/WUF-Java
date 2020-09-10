package main;

import java.util.Scanner;

import country.Country;
import country.Nation;
import country.ViewCountry;
import country.ViewNation;
import matches.Match;
import matches.ViewMatches;
import points.CalcPoints;
import points.Points;
import points.ViewPoints;
import scores.CalcScores;
import scores.Scores;
import scores.ViewScores;

public class Main {

	public static void main(String[] args) {
		char exit = 'n';
		Scanner sc = new Scanner(System.in);
		do { 
			//menu principal
			int startMenu = ViewMenu.startMenu(sc);
			//scores
			if (startMenu == 1) {

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
			//points
			if (startMenu == 2) {

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
			//nations
			if (startMenu == 3) {
				int natMenu = ViewNation.menuNations(sc);
				//France
				if (natMenu == 1) {
					Nation france = new Nation("France", 302.40, 0, "Europe", "Stade de France", "2018", 10, 3 );
					ViewNation.viewNation(france);
					System.out.println("\n World Cup:");
					System.out.println("appearances: 0");
					System.out.println("best result: qualifications (2021) \n");
					System.out.println("European Cup:");
					System.out.println("appearances: 1");
					System.out.println("best result: finalist (2019) \n");
					System.out.println("League of Nations - "+france.getConf() +" :");
					System.out.println("current League: 1A");
					System.out.println("best result: N/A \n");
					char[] results = new char[5];
					for (int i=0; i < results.length; i++) {
						results[i] = 'V';
					}
					for (int i=0; i < results.length; i++) {
						System.out.print(results[i]);
					}
					System.out.print("\n\n");
					Match[] tabMatches = new Match[5];
					tabMatches[0] = new Match("France", 18, "Albania", 9);
					tabMatches[1] = new Match("France", 23, "Cyprus", 9);
					tabMatches[2] = new Match("France", 23, "Israel", 9);
					tabMatches[3] = new Match("France", 23, "Moldova", 16);
					tabMatches[4] = new Match("France", 23, "Italy", 13);
					
					for(int i=0; i < tabMatches.length; i++) {
						ViewMatches.viewMatches(tabMatches[i]);
					}
				}
				
				//Italy
				if (natMenu == 2) {
					Nation italy = new Nation("Italy", 127.58, 0, "Europe", "Stadio Olympico", "2018", 31, 11 );
					ViewNation.viewNation(italy);
					System.out.println("\n World Cup:");
					System.out.println("appearances: 0");
					System.out.println("best result: qualifications (2021) \n");
					System.out.println("European Cup:");
					System.out.println("appearances: 1");
					System.out.println("best result: quarter-finalist (2019) \n");
					System.out.println("League of Nations - "+italy.getConf() +" :");
					System.out.println("current League: 2A");
					System.out.println("best result: N/A \n");
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
					tabMatches[0] = new Match("Italy", 18, "Cyprus", 13);
					tabMatches[1] = new Match("Italy", 18, "Albania", 9);
					tabMatches[2] = new Match("Italy", 16, "Moldova", 9);
					tabMatches[3] = new Match("Italy", 18, "Israel", 13);
					tabMatches[4] = new Match("France", 23, "Italy", 13);
					
					for(int i=0; i < tabMatches.length; i++) {
						ViewMatches.viewMatches(tabMatches[i]);
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

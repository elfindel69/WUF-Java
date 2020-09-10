package main;

import java.util.Scanner;

import country.Country;
import country.ViewCountry;
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
			sc.nextLine();
			
			System.out.println("Quitter ? y/n");
			String sexit = sc.nextLine();
			exit = sexit.charAt(0);
		}while (exit != 'y');
		sc.close();

	}

}

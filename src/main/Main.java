package main;

import java.sql.SQLException;
import java.util.Scanner;

import jdbc.Connect;

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
				ContMenu.viewNations(sc);
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

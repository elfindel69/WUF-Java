package main;

import java.sql.SQLException;
import java.util.Scanner;

import jdbc.Connect;

/**
 * Classe principale
 * affichage console
 * @author elfindel69
 * @version 0.2.0
 *
 */
public class Main {

	/**
	 * méthode principale
	 * affichage console
	 * @param args - String[], arguments console
	 * @throws SQLException - exceptions MySQL
	 */
	public static void main(String[] args) throws SQLException {
		//connection sql
		Connect.doConnect();
		
		//touche pour quitter
		char exit = 'n';
		
		//entrée console
		Scanner sc = new Scanner(System.in);
		
		//affichage console
		do { 
			//menu principal
			int startMenu = ViewMenu.startMenu(sc);
			//affichage scores
			if (startMenu == 1) {
				ContMenu.execScores(sc);
			}
			//affichage points
			if (startMenu == 2) {
				ContMenu.execPoints(sc);
			}
			//affichage nations
			if (startMenu == 3) {
				ContMenu.viewNations(sc);
			}
			//ajout Conf
			if (startMenu == 4)
			{
				ContMenu.addConf(sc);
			}
			//ajout Nation
			if (startMenu == 5)
			{
				ContMenu.addNation(sc);
			}
			//ajout Match
			if (startMenu == 6)
			{
				ContMenu.addMatch(sc);
			}
			sc.nextLine();
			
			//menu quitter
			System.out.println("Quitter ? y/n");
			String sexit = sc.nextLine();
			exit = sexit.charAt(0);
		}while (exit != 'y');
		//fermeture Scanner
		sc.close();
		//déconnection sql
		Connect.doDisconnect();
	}

}

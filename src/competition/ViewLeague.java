package competition;

import java.util.Scanner;

/**
 * Classe d'affichage des Leagues
 * @author elfindel69
 * @version 0.2.0
 */
public class ViewLeague {

	/**
	 * menu d'affichage de League
	 * @param league - League, League à afficher
	 */
	public static void viewLeague(League league) {
		System.out.println(league.getName()+" :");
		System.out.println("current League: "+league.getLeague());
		System.out.println("best result: "+ league.getResult()+" - "+ league.getYear() + "\n");
		
	}

	/**
	 * menu d'ajout de League
	 * @param sc - Scanner, entrée console
	 * @return League - League créée
	 */
	public static League addLeague(Scanner sc) {
		
		sc.nextLine();
		//création de League
		System.out.println("New League:");
		System.out.println("name: ");
        String name = sc.nextLine();
        System.out.println("league: ");
        String league = sc.nextLine();
        System.out.println("Best result: ");
        String result = sc.nextLine();
        System.out.println("year: ");
        String year = sc.nextLine();
        //retour de la League créée
        return new League(name, league, result, year);
	}
}

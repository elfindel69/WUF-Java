package country;

import java.util.List;
import java.util.Scanner;

/**
 * Classe d'affichage des Conf
 * @author elfindel69
 * 
 */
public class ViewConf {
	/**
	 * menu d'affichage des noms des Conf
	 * @param sc - Scanner, entrée console
	 * @param lNames - List<String>, liste des noms de Conf à afficher
	 * @return int - index de la Conf sélectionnée
	 */
	public static int menuConf (Scanner sc, List<String> lNames) {
		//affichage de la liste
		System.out.println("Confederations:");
		int id = 1;
		for (String s : lNames) {
			System.out.println(id+" - "+s);
			++id;
		}
		//sélection de la Conf
		sc.nextLine();
		int choice = sc.nextInt();
		return choice;
	}

	/**
	 * menu d'affichage Conf
	 * @param conf - Conf, Conf à afficher
	 */
	public static void viewConf(Conf conf) {
		System.out.println("Confederation:");
		System.out.println("name: "+conf.getName());
		System.out.println("affiliation: WUF");
		System.out.println("sport: United Football");
		System.out.println("date of creation: "+conf.getDate());
		System.out.println("nb of members: "+conf.getNbMembers());
		
	}

	/**
	 * menu d'ajout de Conf
	 * @param sc - Scanner, entrée console
	 * @return Conf - Conf créée
	 */
	public static Conf addConf(Scanner sc) {
		//création Conf
		sc.nextLine();
		System.out.println("New Confederation:");
		System.out.println("name: " );
		String name = sc.nextLine();
		System.out.println("adj: ");
		String adj = sc.nextLine();
		System.out.println("date of creation: ");
		String year = sc.nextLine();
		System.out.println("nb of members: ");
		int nbMembers = sc.nextInt();
		//retour Conf créée
		return new Conf(0, name, adj, nbMembers, year);
	}
}

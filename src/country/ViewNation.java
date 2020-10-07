package country;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe d'affichage des Nations
 * @author elfindel69
 * @version 0.2.0
 *
 */
public class ViewNation {

	/**
	 * menu d'affichage des noms de Nation
	 * @param sc - Scanner, entrée console
	 * @param lNatNames - List<String>, liste des noms de Nations à afficher
	 * @return int - index de la Nation sélectionnée
	 */
	public static int menuNations(Scanner sc, List<String> lNatNames) {
		//affichage de la liste
		System.out.println("Nations:");
		int id = 1;
		for (String s : lNatNames) {
			System.out.println(id+" - "+s);
			++id;
		}
		//sélection de la Nation
		sc.nextLine();
		int choice = sc.nextInt();
		return choice;
	}
	
	/**
	 * menu d'affichage Nation
	 * @param nat - Nation, Nation à afficher
	 */
	public static void viewNation(Nation nat) {
		System.out.println("Nation:");
		System.out.println("name: "+nat.getName());
		System.out.println("confederation: "+nat.getConf().getName());
		System.out.println("date of adhesion: "+nat.getDate());
		System.out.println("main stadium: "+nat.getStadium());
		System.out.println("WUF Ranking: "+nat.getRWuf());
		System.out.println("WUF "+nat.getConf().getName() +" Ranking: "+nat.getRConf());
		System.out.println("points: "+nat.getPts());
	}
	
	/**
	 * menu d'ajout de Nation
	 * @param sc, Scanner - entrée console
	 * @return Nation - nation créée
	 * @throws SQLException - Exception MySQL
	 */
	public static Nation addNation(Scanner sc) throws SQLException
    {
		//début création Nation (classe Country)
		sc.nextLine();
		System.out.println("New Nation:");
		System.out.println("name: ");
		String name = sc.nextLine();
		System.out.println("points: ");
		double pts  = sc.nextDouble();
		//récupération de la liste des noms des Conf
		List<String> lNames = ContConf.getConfNames();
		int confMenu = ViewConf.menuConf(sc, lNames);
		int confId = confMenu - 1;

		//récupération des data de la Conf sélectionnée
		List<Conf> lConf = ContConf.getConfData(lNames.get(confId));
		Conf conf = lConf.get(0);
		if (confMenu > 1)
		{
			++confMenu;
		}
		//fin création Nation (classe Nation)
		conf.setConfId(confMenu);
		sc.nextLine();
		System.out.println("date of adhesion: ");
		String year = sc.nextLine();
		System.out.println("stadium: ");
		String stadium = sc.nextLine();;
		System.out.println("WUF Ranking:");
		int rWuf = sc.nextInt();
		sc.nextLine();
		System.out.println("Conf Ranking:");
		int rConf = sc.nextInt();
		sc.nextLine();
		//retour de la Nation créée
		return new Nation(0, name, pts, conf,stadium, year, rWuf, rConf);
	}
}

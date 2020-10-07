package competition;

import java.util.Scanner;

/**
 * Classe d'affichage des Cups
 * @author elfindel69
 * @version 0.2.0
 *
 */
public class ViewCup {

	/**
	 * menu d'affichage Cup
	 * @param cup - Cup, Cup � afficher
	 */
	public static void viewCup(Cup cup) {
		System.out.println("\n"+ cup.getName()+":");
		System.out.println("appearances: "+cup.getNbCups());
		System.out.println("best result: "+cup.getResult()+ "("+cup.getYear()+") \n");
		
	}

	/**
	 * menu d'ajout de Cup
	 * @param sc - Scanner, entr�e console
	 * @return Cup - Cup cr��e
	 */
	public static Cup addCup(Scanner sc) {
		//cr�ation Cup
		sc.nextLine();
		System.out.println("New Cup:");
		System.out.println("name: ");
        String name = sc.nextLine();
        System.out.println("nbCups: ");
        int nbCups = sc.nextInt(); 
        System.out.println("Best result: ");
        sc.nextLine();
        String result = sc.nextLine();
        System.out.println("year: ");
        String year = sc.nextLine();
        //retour Cup cr��e
        return new Cup(name, nbCups, result, year);
	}
}

package points;

import java.util.Scanner;

import country.Country;
/**
 * Classe d'affichage de Points
 * @author elfindel69
 * @version 0.2.0
 *
 */
public class ViewPoints {
	/**
	 * méthode d'affichage de coefficients
	 * @param sc - Scanner, entrée console
	 * @return int - index sélectionné
	 */
	public static int getCoeff(Scanner sc) {
		sc.nextLine();
		System.out.println("Coeff");
		System.out.println("20");
		System.out.println("30");
		System.out.println("40");
		System.out.println("50");
		System.out.println("60");
		int coeff= sc.nextInt();
		
		return coeff;
	}
	
	/**
	 * méthode d'affichage de points par Country
	 * @param ct1 - Country, Country 1
	 * @param ct2 - Country, Country 2
	 */
	public static void viewPoints(Country ct1, Country ct2) {
		System.out.println("Pays 1:");
		System.out.println("nom:"+ct1.getName());
		System.out.println("points: "+ct1.getPts());
		System.out.println("Pays 2:");
		System.out.println("nom:"+ct2.getName());
		System.out.println("points: "+ct2.getPts());
	}
}

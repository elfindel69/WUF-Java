package scores;

import country.Country;

/**
 * Classe d'affichage des scores
 * @author elfindel69
 * @version 0.2.0
 *
 */
public class ViewScores {
	/**
	 * méthode d'affichage de scores par Country
	 * @param ct1 - Country, Country 1
	 * @param ct2 - Country, Country 2
	 */
	public static void viewScores (Country ct1, Country ct2) {
		System.out.println("Pays 1:");
		System.out.println("nom:"+ct1.getName());
		System.out.println("score: "+ct1.getScore());
		System.out.println("Pays 2:");
		System.out.println("nom:"+ct2.getName());
		System.out.println("score: "+ct2.getScore());
	}
}

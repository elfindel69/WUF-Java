package scores;

import country.Country;

public class ViewScores {
	public static void viewScores (Country ct1, Country ct2) {
		System.out.println("Pays 1:");
		System.out.println("nom:"+ct1.getName());
		System.out.println("score: "+ct1.getScore());
		System.out.println("Pays 2:");
		System.out.println("nom:"+ct2.getName());
		System.out.println("score: "+ct2.getScore());
	}
}

package country;

import java.util.Scanner;

/**
 * Classe d'affichage de Country
 * @author elfindel69
 * @version 0.2.0
 */
public class ViewCountry {
	/**
	 * menu d'ajout de nation
	 * @param sc - Scanner, entrée console
	 * @param scoreB - boolean, ajout de score
	 * @return
	 */
	public static Country newCountry(Scanner sc, boolean scoreB) {
		//création de Country
		System.out.println("nom Pays");
		String name = sc.nextLine();
		System.out.println("points Pays");
		double pts = sc.nextDouble();
		//ajout du score
		int scoreI = 0;
		if (scoreB) {
			sc.nextLine();
			System.out.println("score Pays");
			scoreI = sc.nextInt();
		}
		//retour Country créé
		return new Country(name, pts, scoreI);
	}
}

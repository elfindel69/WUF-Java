package country;

import java.util.Scanner;

public class ViewCountry {
	public static Country newCountry(Scanner sc, boolean scoreB) {
		System.out.println("nom Pays");
		String name = sc.nextLine();
		System.out.println("points Pays");
		double pts = sc.nextDouble();
		int scoreI = 0;
		if (scoreB) {
			sc.nextLine();
			System.out.println("score Pays");
			scoreI = sc.nextInt();
		}
		return new Country(name, pts, scoreI);
	}
}

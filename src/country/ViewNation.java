package country;

import java.util.Scanner;

public class ViewNation {

	public static int menuNations(Scanner sc) {
		System.out.println("Nations:");
		System.out.println("1- France");
		System.out.println("2- Italy");
		sc.nextLine();
		int choice = sc.nextInt();
		return choice;
	}
	
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
}

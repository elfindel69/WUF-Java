package country;

import java.util.List;
import java.util.Scanner;

public class ViewNation {

	public static int menuNations(Scanner sc, List<String> lNatNames) {
		System.out.println("Nations:");
		int id = 1;
		for (String s : lNatNames) {
			System.out.println(id+" - "+s);
			++id;
		}
		
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

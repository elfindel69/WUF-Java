package country;

import java.util.List;
import java.util.Scanner;

public class ViewConf {
	public static int menuConf (Scanner sc, List<String> lNames) {
		System.out.println("Confederations:");
		int id = 1;
		for (String s : lNames) {
			System.out.println(id+" - "+s);
		}
		sc.nextLine();
		int choice = sc.nextInt();
		return choice;
	}

	public static void viewConf(Conf conf) {
		System.out.println("Confederation:");
		System.out.println("name: "+conf.getName());
		System.out.println("affiliation: WUF");
		System.out.println("sport: United Football");
		System.out.println("date of creation: "+conf.getDate());
		System.out.println("nb of members: "+conf.getNbMembers());
		
	}
}

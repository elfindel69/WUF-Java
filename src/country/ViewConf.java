package country;

import java.util.Scanner;

public class ViewConf {
	public static int menuConf (Scanner sc) {
		System.out.println("Confederations:");
		System.out.println("1- Europe");
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

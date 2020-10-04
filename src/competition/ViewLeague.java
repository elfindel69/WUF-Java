package competition;

import java.util.Scanner;

public class ViewLeague {

	public static void viewLeague(League league) {
		System.out.println(league.getName()+" :");
		System.out.println("current League: "+league.getLeague());
		System.out.println("best result: "+ league.getResult()+" - "+ league.getYear() + "\n");
		
	}

	public static League addLeague(Scanner sc) {
		
		sc.nextLine();
		
		System.out.println("New League:");
		System.out.println("name: ");
        String name = sc.nextLine();
        System.out.println("league: ");
        String league = sc.nextLine();
        System.out.println("Best result: ");
        String result = sc.nextLine();
        System.out.println("year: ");
        String year = sc.nextLine();
        return new League(name, league, result, year);
	}
}

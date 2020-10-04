package competition;

import java.util.Scanner;

public class ViewCup {

	public static void viewCup(Cup cup) {
		System.out.println("\n"+ cup.getName()+":");
		System.out.println("appearances: "+cup.getNbCups());
		System.out.println("best result: "+cup.getResult()+ "("+cup.getYear()+") \n");
		
	}

	public static Cup addCup(Scanner sc) {
		
		sc.nextLine();
		System.out.println("New Cup:");
		System.out.println("name: ");
        String name = sc.nextLine();
        System.out.println("nbCups: ");
        int nbCups = sc.nextInt(); 
        System.out.println("Best result: ");
        sc.nextLine();
        String result = sc.nextLine();
        System.out.println("year: ");
        String year = sc.nextLine();
        
        return new Cup(name, nbCups, result, year);
	}
}

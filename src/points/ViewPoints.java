package points;

import java.util.Scanner;

import country.Country;

public class ViewPoints {
	public static int getCoeff(Scanner sc) {
		sc.nextLine();
		System.out.println("Coeff");
		System.out.println("20");
		System.out.println("30");
		System.out.println("40");
		System.out.println("50");
		System.out.println("60");
		int coeff= sc.nextInt();
		
		return coeff;
	}
	
	public static void viewPoints(Country ct1, Country ct2) {
		System.out.println("Pays 1:");
		System.out.println("nom:"+ct1.getName());
		System.out.println("points: "+ct1.getPts());
		System.out.println("Pays 2:");
		System.out.println("nom:"+ct2.getName());
		System.out.println("points: "+ct2.getPts());
	}
}

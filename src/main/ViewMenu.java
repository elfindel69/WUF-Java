package main;

import java.util.Scanner;
/**
 * Classe d'affichage de menus console
 * @author elfindel69
 *
 */
public class ViewMenu {
	/**
	 * menu principal
	 * @param sc - Scanner, entrée console
	 * @return int - action sélectionnée
	 */
	static int startMenu(Scanner sc) {
		System.out.println("Menu:");
		System.out.println("1. scores...");
		System.out.println("2. points...");
		System.out.println("3. view nations...");
		System.out.println("4. add conf...");
		System.out.println("5. add nation...");
		System.out.println("6. add match...");
		int choice = sc.nextInt();
		return choice;
	}
}

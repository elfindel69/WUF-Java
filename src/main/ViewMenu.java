package main;

import java.util.Scanner;

public class ViewMenu {
	static int startMenu(Scanner sc) {
		System.out.println("Menu:");
		System.out.println("1. scores...");
		System.out.println("2. points...");
		System.out.println("3. nations...");
		int choice = sc.nextInt();
		return choice;
	}
}

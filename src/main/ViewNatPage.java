package main;

import competition.Cup;
import competition.ViewCup;
import competition.ViewLeague;
import country.ViewNation;
import matches.Match;
import matches.ViewMatches;

public class ViewNatPage {

	public static void viewPage(NatPage page) {
		ViewNation.viewNation(page.getNat());
		
		for (Cup c: page.getlCups()) {
			ViewCup.viewCup(c);
		}
		
		ViewLeague.viewLeague(page.getLeague());
		
		for (int i=0; i < page.getTabResults().length; i++) {
			System.out.print(page.getTabResults()[i]);
		}
		System.out.print("\n\n");
		
		for(Match item : page.getlMatches()) {
			ViewMatches.viewMatches(item);
		}
	}

}

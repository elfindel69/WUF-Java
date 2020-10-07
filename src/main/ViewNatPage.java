package main;

import competition.Cup;
import competition.ViewCup;
import competition.ViewLeague;
import country.ViewNation;
import matches.Match;
import matches.ViewMatches;
/**
 * Classe d'affichage de NatPage
 * @author elfindel69
 * @version 0.2.0
 */
public class ViewNatPage {

	/**
	 * méthode d'affichage de NatPage
	 * @param page - NatPage, NatPage à afficher
	 */
	public static void viewPage(NatPage page) {
		ViewNation.viewNation(page.getNat());
		
		for (Cup c: page.getlCups()) {
			ViewCup.viewCup(c);
		}
		if (page.getLeague() != null) {
			ViewLeague.viewLeague(page.getLeague());
		}
		
		for (int i=0; i < page.getTabResults().length; i++) {
			System.out.print(page.getTabResults()[i]);
		}
		System.out.print("\n\n");
		
		for(Match item : page.getlMatches()) {
			ViewMatches.viewMatches(item);
		}
	}

}

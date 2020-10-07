package main;

import java.util.ArrayList;
import java.util.List;

import competition.Cup;
import competition.League;
import country.Nation;
import matches.Match;

/**
 * Classe de data page de Nation
 * @author elfindel69
 * @version 0.2.0
 *
 */
public class NatPage {
	/**
	 * Nation - nation � afficher
	 */
	private Nation nat;
	/**
	 * List<Cup> - liste des Cups � afficher
	 */
	private List<Cup> lCups = new ArrayList<Cup>();
	/**
	 * League - League � afficher
	 */
	private League league;
	/**
	 * List<Match> - liste des Matches � afficher
	 */
	private List<Match> lMatches = new ArrayList<Match>();
	/**
	 * char[] - tableau des r�sultats � afficher
	 */
	private char[] tabResults = new char[5];
	
	/**
	 * cr�ation de NatPage
	 * @param nat - Nation, Nation � afficher
	 * @param lCups - List<Cup>, liste des Cups � afficher
	 * @param league - League, League � afficher
	 * @param lMatches - List<Matches>, liste des Match � afficher
	 * @param tabResults - char[], tableau des r�sultats � afficher
	 */
	public NatPage(Nation nat, List<Cup> lCups, League league, List<Match> lMatches, char[] tabResults) {
		this.nat = nat;
		this.lCups = lCups;
		this.league = league;
		this.lMatches = lMatches;
		this.tabResults = tabResults;
	}
	/**
	 * getter nat
	 * @return Nation - Nation � afficher
	 */
	public Nation getNat() {
		return nat;
	}
	/**
	 * setter nat
	 * @param nat - Nation, nouvelle Nation
	 */
	public void setNat(Nation nat) {
		this.nat = nat;
	}
	/**
	 * getter lCups
	 * @return List<Cup> - liste des Cups � afficher
	 */
	public List<Cup> getlCups() {
		return lCups;
	}
	/**
	 * setter lCups
	 * @param lCups - List<Cup>, nouvelle liste de coupes
	 */
	public void setlCups(List<Cup> lCups) {
		this.lCups = lCups;
	}
	/**
	 * getter league
	 * @return League - League � afficher
	 */
	public League getLeague() {
		return league;
	}
	/**
	 * setter league
	 * @param league - League, nouvelle League
	 */
	public void setLeague(League league) {
		this.league = league;
	}
	/**
	 * getter lMatches
	 * @return List<Match> - liste des Matches � afficher
	 */
	public List<Match> getlMatches() {
		return lMatches;
	}
	/**
	 * setter lMatches
	 * @param lMatches - List<Match> - nouvelle liste de Match
	 */
	public void setlMatches(List<Match> lMatches) {
		this.lMatches = lMatches;
	}
	/**
	 * getter tabResults
	 * @return char[] - tableau de r�sultats � afficher
	 */
	public char[] getTabResults() {
		return tabResults;
	}
	/**
	 * setter tabResults
	 * @param tabResults - char[], nouveau tableau de r�sultats
	 */
	public void setTabResults(char[] tabResults) {
		this.tabResults = tabResults;
	}
}

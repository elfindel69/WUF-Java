package main;

import java.util.ArrayList;
import java.util.List;

import competition.Cup;
import competition.League;
import country.Nation;
import matches.Match;

public class NatPage {
	private Nation nat;
	private List<Cup> lCups = new ArrayList<Cup>();
	private League league;
	private List<Match> lMatches = new ArrayList<Match>();
	private char[] tabResults = new char[5];
	
	public NatPage(Nation nat, List<Cup> lCups, League league, List<Match> lMatches, char[] tabResults) {
		this.nat = nat;
		this.lCups = lCups;
		this.league = league;
		this.lMatches = lMatches;
		this.tabResults = tabResults;
	}

	public Nation getNat() {
		return nat;
	}

	public void setNat(Nation nat) {
		this.nat = nat;
	}

	public List<Cup> getlCups() {
		return lCups;
	}

	public void setlCups(List<Cup> lCups) {
		this.lCups = lCups;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public List<Match> getlMatches() {
		return lMatches;
	}

	public void setlMatches(List<Match> lMatches) {
		this.lMatches = lMatches;
	}

	public char[] getTabResults() {
		return tabResults;
	}

	public void setTabResults(char[] tabResults) {
		this.tabResults = tabResults;
	}
}

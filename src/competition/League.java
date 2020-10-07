package competition;

/**
 * Classe de data des ligues
 * @author elfindel69
 * @version 0.2.0
 */
public class League {
	/**
	 * String - nom de la ligue
	 */
	private String name;
	/**
	 * String - meilleure ligue atteinte
	 */
	private String league;
	/**
	 * String - meilleur r�sultat
	 */
	private String result;
	/**
	 * String - ann�e du meilleur r�sultat
	 */
	private String year;
	
	/**
	 * cr�ation de data League
	 * @param name - String, nom de la ligue
	 * @param league - String, meilleure ligue atteinte
	 * @param result - String, meilleur r�sultat
	 * @param year - String, ann�e du meilleur r�sultat
	 */
	public League(String name, String league, String result, String year) {
		this.name = name;
		this.league = league;
		this.result = result;
		this.year = year;
	}

	/**
	 * getter de name
	 * @return String - nom de la League
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter de name
	 * @param name - String, nouveau nom
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter de league
	 * @return String - meilleure ligue atteinte
	 */
	public String getLeague() {
		return league;
	}

	/**
	 * setter de league 
	 * @param league - String, nouvelle meilleure ligue
	 */
	public void setLeague(String league) {
		this.league = league;
	}
	
	/**
	 * getter de result
	 * @return String - meilleur r�sultat
	 */
	public String getResult() {
		return result;
	}

	/**
	 * setter de result
	 * @param result - String, nouveau meilleur r�sultat
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * getter de year
	 * @return String - meilleure ann�e
	 */
	public String getYear() {
		return year;
	}

	/**
	 * setter de year
	 * @param year - String, nouvelle meilleure ann�e
	 */
	public void setYear(String year) {
		this.year = year;
	}
}

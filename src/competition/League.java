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
	 * String - meilleur résultat
	 */
	private String result;
	/**
	 * String - année du meilleur résultat
	 */
	private String year;
	
	/**
	 * création de data League
	 * @param name - String, nom de la ligue
	 * @param league - String, meilleure ligue atteinte
	 * @param result - String, meilleur résultat
	 * @param year - String, année du meilleur résultat
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
	 * @return String - meilleur résultat
	 */
	public String getResult() {
		return result;
	}

	/**
	 * setter de result
	 * @param result - String, nouveau meilleur résultat
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * getter de year
	 * @return String - meilleure année
	 */
	public String getYear() {
		return year;
	}

	/**
	 * setter de year
	 * @param year - String, nouvelle meilleure année
	 */
	public void setYear(String year) {
		this.year = year;
	}
}

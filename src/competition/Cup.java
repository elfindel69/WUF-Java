package competition;

/**
 * Classe de data des coupes
 * @author elfindel69
 * @version 0.2.0
 */
public class Cup {
	/**
	 * String - nom de la coupe
	 */
	private String name;
	/**
	 * int - nombre d'�ditions jou�es
	 */
	private int nbCups;
	/**
	 * String - meilleur r�sultat
	 */
	private String result;
	/**
	 * String - ann�e du meilleur r�sultat
	 */
	private String year;
	
	/**
	 * cr�ation de data Cup
	 * @param name - String, nom de la Coupe
	 * @param nbCups - int, nombre d'�ditions jou�es
	 * @param result - String, meilleur r�sultat
	 * @param year - String, ann�e du meilleur r�sultat
	 */
	public Cup(String name, int nbCups, String result, String year) {
		this.name = name;
		this.nbCups = nbCups;
		this.result = result;
		this.year = year;
	}
	
	/**
	 * getter de name
	 * @return String, nom de la Cup
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
	 * getter de nbCups
	 * @return int - nombre de Cups jou�es
	 */
	public int getNbCups() {
		return nbCups;
	}

	/**
	 * setter de nbCups
	 * @param nbCups - int, nouveau nombre de Cups jou�es
	 */
	public void setNbCups(int nbCups) {
		this.nbCups = nbCups;
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
	 * @param year - nouvelle meilleure ann�e
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	
	
}

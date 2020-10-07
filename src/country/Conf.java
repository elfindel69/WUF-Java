package country;

/**
 * Classe de data des conférences
 * @author elfindel69
 * @verion 0.2.0
 *
 */
public class Conf {
	/**
	 * int - id de la conférence
	 */
	private int confId;
	/**
	 * String - nom de la conférence
	 */
	private String name;
	/**
	 * String - adjectif de la conférence
	 */
	private String adj;
	/**
	 * int - nombre de membres
	 */
	private int nbMembers;
	/**
	 * String - année d'adhésion
	 */
	private String date;
	
	/**
	 * création de data Conf
	 * @param id - int, id de la conférence
	 * @param name - String, nom de la conférence
	 * @param adj - String, adjectif de la conférence
	 * @param nbMembers - int, nombre de membres
	 * @param date - String, année d'adhésion
	 */
	public Conf(int id, String name, String adj, int nbMembers, String date) {
		this.setConfId(id);
		this.setName(name);
		this.setAdj(adj);
		this.setNbMembers(nbMembers);
		this.setDate(date);
	}

	/**
	 * getter de name
	 * @return String - nom de la Conf
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
	 * getter d'adj
	 * @return String - adjectif de la Conf
	 */
	public String getAdj() {
		return adj;
	}

	/**
	 * setter d'adj
	 * @param adj - nouvel adjectif de la Conf
	 */
	public void setAdj(String adj) {
		this.adj = adj;
	}

	/**
	 * getter de nbMembers
	 * @return int - nombre de membres
	 */
	public int getNbMembers() {
		return nbMembers;
	}

	/**
	 * setter de nbMembers
	 * @param nbMembers - int, nouveau nombre de membres
	 */
	public void setNbMembers(int nbMembers) {
		this.nbMembers = nbMembers;
	}

	/**
	 * getter de date
	 * @return String - année d'adhésion
	 */
	public String getDate() {
		return date;
	}

	/**
	 * setter de date
	 * @param date - String, nouvelle année d'adhésion
	 */
	public void setDate(String date) {
		this.date = date;
	}

	public int getConfId() {
		return confId;
	}

	public void setConfId(int confId) {
		this.confId = confId;
	}
}

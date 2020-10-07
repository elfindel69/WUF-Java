package country;

/**
 * Classe data de nation WUF
 * @author elfindel69
 * @version 0.2.0
 * @see Country - classe parent pays
 */
public class Nation extends Country {
	/**
	 * int - id de la nation
	 */
	private int id;
	/**
	 * Conf - conférence parent
	 */
	private Conf conf;
	/**
	 * String - date d'adhésion
	 */
	private String date;
	/**
	 * String - nom du stade
	 */
	private String stadium;
	/**
	 * int - rang classement mondial WUF
	 */
	private int rWuf;
	/**
	 * int - ranfg classment conférence
	 */
	private int rConf;
	
	/**
	 * création de data Nation
	 * @param id - int, id de la nation
	 * @param name - String, nom de la nation
	 * @param pts - int, points de la nation
	 * @param conf - Conf, Conf parent
	 * @param stadium - String, nom du stade
	 * @param date - String, date d'adhésion
	 * @param rWuf - int, rang classement WUF
	 * @param rConf - int, rang classement Conf
	 */
	public Nation(int id, String name, double pts, Conf conf, String stadium, String date, int rWuf, int rConf) {
		super(name, pts, 0);
		this.id = id;
		this.conf = conf;
		this.stadium = stadium;
		this.date = date;
		this.rWuf = rWuf;
		this.rConf = rConf;
		
	}
	/**
	 * getter de conf
	 * @return Conf - Conf parent
	 */
	public Conf getConf() {
		return conf;
	}
	/**
	 * setter de conf
	 * @param conf - Conf, nouvelle Conf parent
	 */
	public void setConf(Conf conf) {
		this.conf = conf;
	}
	/**
	 * getter de date
	 * @return String - date d'adhésion
	 */
	public String getDate() {
		return date;
	}
	/**
	 * setter de date
	 * @param date - String, nouvelle date d'adhésion
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * getter stadium
	 * @return - String, nom du stade
	 */
	public String getStadium() {
		return stadium;
	}
	/**
	 * setter stadium
	 * @param stadium - String, nouveau stade
	 */
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	/**
	 * getter rWuf
	 * @return int - rang classement WUF
	 */
	public int getRWuf() {
		return rWuf;
	}
	/**
	 * setter rWuf
	 * @param rWuf - int, nouveau classement WUF
	 */
	public void setRWuf(int rWuf) {
		this.rWuf = rWuf;
	}
	/**
	 * getter rConf
	 * @return int - rang classement Conf
	 */
	public int getRConf() {
		return rConf;
	}
	/**
	 * setter rConf
	 * @param rConf - int, nouveau classement Conf
	 */
	public void setRConf(int rConf) {
		this.rConf = rConf;
	}
	/**
	 * getter id
	 * @return int - id de la Nation
	 */
	public int getId() {
		return id;
	}
	/**
	 * setter id
	 * @param id - int, nouvel id
	 */
	public void setId(int id) {
		this.id = id;
	}

}

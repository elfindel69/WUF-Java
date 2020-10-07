package country;

/**
 * Classe de data pays 
 * @author elfindel69
 * @version 0.2.0
 *
 */
public class Country {
	/**
	 * String - nom du pays
	 */
	protected String name;
	/**
	 * double - points du pays
	 */
	protected double pts;
	/**
	 * int - score du pays
	 */
	protected int score;
	
	/**
	 * création de data country
	 * @param name - String, nom du pays
	 * @param pts - double, points du pays
	 * @param score - int, score du pays
	 */
	public Country(String name, double pts, int score) {
		this.setName(name);
		this.setPts(pts);
		this.setScore(score);
	}

	/**
	 * getter de name
	 * @return String - nom du pays
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
	 * getter de pts
	 * @return double - nombre de points
	 */
	public double getPts() {
		return pts;
	}

	/**
	 * setter de pts
	 * @param pts - double, nouveau nom de points
	 */
	public void setPts(double pts) {
		this.pts = pts;
	}

	/**
	 * getter de score
	 * @return int - score du pays
	 */
	public int getScore() {
		return score;
	}

	/**
	 * setter de score
	 * @param score - int, nouveau score
	 */
	public void setScore(int score) {
		this.score = score;
	}
}

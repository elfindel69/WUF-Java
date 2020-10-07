package points;

/**
 * Classe de data de points WUF
 * @author elfindel69
 * @version 0.2.0
 */
public class Points {
	/**
	 * double - points Country 1
	 */
	private double pts1;
	/**
	 * double - points Country 2
	 */
	private double pts2;
	
	/**
	 * création de data Points
	 * @param pts1 - double, points Country 1
	 * @param pts2 - double, points Country 2
	 */
	Points(double pts1, double pts2) {
		this.setPts1(pts1);
		this.setPts2(pts2);
	}

	/**
	 * getter pts1
	 * @return double - points Country 1
	 */
	public double getPts1() {
		return pts1;
	}
	/**
	 * setter pts1
	 * @param pts1 - double, points Country 1
	 */
	public void setPts1(double pts1) {
		this.pts1 = pts1;
	}

	/**
	 * getter pts2
	 * @return double - points Country 2
	 */
	public double getPts2() {
		return pts2;
	}

	/**
	 * setter pts2
	 * @param pts2 - double, points Country 2
	 */
	public void setPts2(double pts2) {
		this.pts2 = pts2;
	}
}

package points;
/**
 * Classe de calcul des Points
 * @author elfindel69
 * @version 0.2.0
 *
 */
public class CalcPoints {
	
	/**
	 * m�thode de calcul des Points
	 * @param pts1 - double, points Country 1
	 * @param pts2 - double, points Country 2
	 * @param coeff - int, coefficient WUF
	 * @param diff - int, diff�rence de score
	 * @return Points - Points calcul�s
	 */
	public static Points calcPoints(double pts1, double pts2, int coeff, int diff) {
		//nouveaux points Country 1
		double newPts1 = 0;
		//nouveaux points Country 2
	    double newPts2 = 0;

	    // calcul de G
	    double lDiff = calcDiff(diff);

	    // calcul de Delta
	    double delta = pts1 - pts2;
	    delta = delta / 400;
	    delta = Math.pow(10, delta) + 1;
	    delta = 1 / delta;

	    delta = delta * coeff * lDiff;

	    // attribution des points
	    if (diff > 0) {
	        newPts1 = roundToTwo(pts1 + delta);
	        newPts2 = roundToTwo(pts2 - delta);
	    }
	    if (diff == 0) {
	        newPts1 = roundToTwo(pts1 + delta);
	        newPts2 = roundToTwo(pts2 + delta);
	    }
	    if (diff < 0) {
	        newPts1 = roundToTwo(pts1 - delta);
	        newPts2 = roundToTwo(pts2 + delta);
	    }
	    
	    
	    //retour des Points calcul�s
	    Points points = new Points(newPts1, newPts2);

	    return points;
	}
	
	/**
	 * calcul du coefficient G
	 * @param diff - diff�rence de score
	 * @return double - coefficient calcul�
	 */
	private static double calcDiff(int diff) {
	    int lDiff = Math.abs(diff);
	    double res = 0;
	    if (lDiff <= 5) {
	        res = 1;
	    }
	    if (lDiff > 5 && lDiff <= 10) {
	        res = 1.5;
	    }
	    if (lDiff > 10) {
	        res = 1.75 + (lDiff - 3) / 8;
	    }

	    return res;
	}
	
	/**
	 * m�thode de troncature � deux d�cimales
	 * @param num - double, nombre � tronquer
	 * @return double - nombre tronqu�
	 */
	private static double roundToTwo(double num) {
	    return (double)Math.round(num * 100d) / 100d;
	}
}

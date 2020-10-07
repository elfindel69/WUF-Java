package scores;

import utils.Random;

/**
 * Classe de calcul des Scores
 * @author elfindel69
 * @version 0.2.0
 */
public class CalcScores {
	/**
	 * méthode de calcul des scores
	 * @param pts1 - double, points Country 1
	 * @param pts2 - double, points Country 2
	 * @return Scores - scores calculés
	 */
	public static Scores calcScores(double pts1, double pts2) {
		//score Country 1
		int score1 = 0;
		//score Country 2
	    int score2 = 0;
	    
	    //attribution des coeffs random
	    int rng1 = getRng(pts1);
	    int rng2 = getRng(pts2);
	    
	    //calcul des scores
	    Math.random();
	    score1 = Random.RNG5(rng1) + Random.RNG2(rng1);
	    score1 = fixScores(score1);

	    Math.random();
	    score2 = Random.RNG5(rng2) + Random.RNG2(rng2);
	    score2 = fixScores(score2);

	    //retour des scores calculés
	    Scores scores = new Scores(score1, score2);
	    return scores;
	}
	
	/**
	 * méthode de correction des scores
	 * @param pScore - int score à corriger
	 * @return int - score corrigé
	 */
	private static int fixScores(int pScore) {
		 int rScore = 0;
		    if (pScore == 1) {
		        rScore = 2;
		    } else if (pScore == 3 && pScore <= 5) {
		        rScore = 2;
		    } else {
		        rScore = (int) Math.floor(pScore);
		    }

		    return rScore;
	}
	/**
	 * méthode de calcul de coefficient random
	 * @param pts - double, points à calculer
	 * @return int - coeff random
	 */
	private static int getRng(double pts) {
		int rng = 0;

	    if (pts <= 0) {
	        rng = 1;
	    } else if (pts < 1 && pts <= 25) {
	        rng = 3;
	    } else if (pts < 26 && pts <= 50) {
	        rng = 5;
	    } else if (pts < 51 && pts <= 75) {
	        rng = 8;
	    } else if (pts < 76 && pts <= 100) {
	        rng = 13;
	    } else {
	        rng = 20;
	    }

	    return rng;
	}
}

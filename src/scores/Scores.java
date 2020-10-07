package scores;

/**
 * Classe data de scores
 * @author elfindel69
 * @version
 */
public class Scores {
	/**
	 * int - score Country 1
	 */
	private int score1;
	/**
	 * int - score Country2
	 */
	private int score2;
	
	/**
	 * création data Scores
	 * @param score1 - score Country 1
	 * @param score2 - score Country 2
	 */
	public Scores(int score1, int score2){
		this.score1 = score1;
		this.score2 = score2;
	}
	
	/**
	 * getter score1
	 * @return int - score Country 1
	 */
	public int getScore1() {
		return score1;
	}
	
	/**
	 * getter score2
	 * @return int - score Country 2
	 */
	public int getScore2() {
		return score2;
	}
}

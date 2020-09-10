package country;

public class Country {
	private String name;
	private double pts;
	private int score;
	
	public Country(String name, double pts, int score) {
		this.setName(name);
		this.setPts(pts);
		this.setScore(score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPts() {
		return pts;
	}

	public void setPts(double pts) {
		this.pts = pts;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

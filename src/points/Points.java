package points;

public class Points {
	private double pts1;
	private double pts2;
	
	Points(double pts1, double pts2) {
		this.setPts1(pts1);
		this.setPts2(pts2);
	}

	public double getPts1() {
		return pts1;
	}

	public void setPts1(double pts1) {
		this.pts1 = pts1;
	}

	public double getPts2() {
		return pts2;
	}

	public void setPts2(double pts2) {
		this.pts2 = pts2;
	}
}

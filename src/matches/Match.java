package matches;

public class Match {
	private String nat1;
	private String nat2;
	private int sc1;
	private int sc2;
	public Match(String nat1, int sc1, String nat2, int sc2) {
		this.setNat1(nat1);
		this.setSc1(sc1);
		this.setNat2(nat2);
		this.setSc2(sc2);
	}
	public String getNat1() {
		return nat1;
	}
	public void setNat1(String nat1) {
		this.nat1 = nat1;
	}
	public String getNat2() {
		return nat2;
	}
	public void setNat2(String nat2) {
		this.nat2 = nat2;
	}
	public int getSc1() {
		return sc1;
	}
	public void setSc1(int sc1) {
		this.sc1 = sc1;
	}
	public int getSc2() {
		return sc2;
	}
	public void setSc2(int sc2) {
		this.sc2 = sc2;
	}

}

package country;

public class Conf {
	private String name;
	private String adj;
	private int nbMembers;
	private String date;
	
	public Conf(String name, String adj, int nbMembers, String date) {
		this.setName(name);
		this.setAdj(adj);
		this.setNbMembers(nbMembers);
		this.setDate(date);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdj() {
		return adj;
	}

	public void setAdj(String adj) {
		this.adj = adj;
	}

	public int getNbMembers() {
		return nbMembers;
	}

	public void setNbMembers(int nbMembers) {
		this.nbMembers = nbMembers;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}

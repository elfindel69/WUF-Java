package competition;

public class Cup {
	private String name;
	private int nbCups;
	private String result;
	private String year;
	
	public Cup(String name, int nbCups, String result, String year) {
		this.name = name;
		this.nbCups = nbCups;
		this.result = result;
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbCups() {
		return nbCups;
	}

	public void setNbCups(int nbCups) {
		this.nbCups = nbCups;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	
	
}

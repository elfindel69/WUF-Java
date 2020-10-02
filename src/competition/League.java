package competition;

public class League {
	private String name;
	private String league;
	private String result;
	private String year;
	
	public League(String name, String league, String result, String year) {
		this.name = name;
		this.league = league;
		this.result = result;
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
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

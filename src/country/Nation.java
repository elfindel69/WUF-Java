package country;

public class Nation extends Country {
	private String conf;
	private String date;
	private String stadium;
	private int rWuf; 
	private int rConf;
	public Nation(String name, double pts, int score, String conf, String stadium, String date, int rWuf, int rConf) {
		super(name, pts, score);
		this.conf = conf;
		this.stadium = stadium;
		this.date = date;
		this.rWuf = rWuf;
		this.rConf = rConf;
		
	}
	public String getConf() {
		return conf;
	}
	public void setConf(String conf) {
		this.conf = conf;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	public int getRWuf() {
		return rWuf;
	}
	public void setRWuf(int rWuf) {
		this.rWuf = rWuf;
	}
	public int getRConf() {
		return rConf;
	}
	public void setRConf(int rConf) {
		this.rConf = rConf;
	}

}
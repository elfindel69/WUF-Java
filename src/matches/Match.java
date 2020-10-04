package matches;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Match {
	private String nat1;
	private String nat2;
	private int sc1;
	private int sc2;
	private ZonedDateTime date;
	private ZoneId timeZoneJava;
	private String timeZoneNet;
	
	public Match(String nat1, int sc1, String nat2, int sc2, ZonedDateTime zoneDate1, ZoneId timeZone, String timeZoneNet) {
		this.setNat1(nat1);
		this.setSc1(sc1);
		this.setNat2(nat2);
		this.setSc2(sc2);
		this.setDate(zoneDate1);
		this.setTimeZoneJava(timeZone);
		this.setTimeZoneNet(timeZoneNet);
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
	public ZonedDateTime getDate() {
		return date;
	}
	public void setDate(ZonedDateTime date) {
		this.date = date;
	}
	public ZoneId getTimeZoneJava() {
		return timeZoneJava;
	}
	public void setTimeZoneJava(ZoneId timeZone) {
		this.timeZoneJava = timeZone;
	}
	public String getTimeZoneNet() {
		return timeZoneNet;
	}
	public void setTimeZoneNet(String timeZoneNet) {
		this.timeZoneNet = timeZoneNet;
	}
	
	

}

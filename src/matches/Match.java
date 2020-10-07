package matches;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Classe de data de matchs
 * @author elfindel69
 * @version 0.2.0
 *
 */
public class Match {
	/**
	 * String - nom de la Nation à domicile
	 */
	private String nat1;
	/**
	 * String - nom de la Nation à l'extérieur
	 */
	private String nat2;
	/**
	 * int - score de la Nation à domicile
	 */
	private int sc1;
	/**
	 * int - score de la nation à l'extérieur
	 */
	private int sc2;
	/**
	 * ZonedDateTime - date du match
	 */
	private ZonedDateTime date;
	/**
	 * ZoneId - time zone de la date du match (tz)
	 */
	private ZoneId timeZoneJava;
	/**
	 * String - time zone de la date du match (.Net)
	 */
	private String timeZoneNet;
	
	/**
	 * création de data Match
	 * @param nat1 - String, nom de la Nation à domicile
	 * @param sc1 - int, score de la Nation à domicile
	 * @param nat2 - String, nom de la Nation à l'extérieur
	 * @param sc2 - int, score de la nation à l'extérieur
	 * @param zoneDate1 - ZonedDateTime, date du match
	 * @param timeZone - ZoneID, time zone format Java
	 * @param timeZoneNet - String, time zone format .Net
	 */
	public Match(String nat1, int sc1, String nat2, int sc2, ZonedDateTime zoneDate1, ZoneId timeZone, String timeZoneNet) {
		this.setNat1(nat1);
		this.setSc1(sc1);
		this.setNat2(nat2);
		this.setSc2(sc2);
		this.setDate(zoneDate1);
		this.setTimeZoneJava(timeZone);
		this.setTimeZoneNet(timeZoneNet);
	}
	/**
	 * getter nat1
	 * @return String - nom de la Nation à domicile
	 */
	public String getNat1() {
		return nat1;
	}
	/**
	 * setter nat1
	 * @param nat1 - String, nouvelle nation à domicile
	 */
	public void setNat1(String nat1) {
		this.nat1 = nat1;
	}
	/**
	 * getter nat2
	 * @return String - nom de la Nation à l'extérieur
	 */
	public String getNat2() {
		return nat2;
	}
	/**
	 * setter nat2
	 * @param nat2 - String, nouvelle nation à l'extérieur
	 */
	public void setNat2(String nat2) {
		this.nat2 = nat2;
	}
	/**
	 * getter sc1
	 * @return int - score Nation à domicile
	 */
	public int getSc1() {
		return sc1;
	}
	/**
	 * setter sc1
	 * @param sc1 - int, nouveau score domicile
	 */
	public void setSc1(int sc1) {
		this.sc1 = sc1;
	}
	/**
	 * getter sc2
	 * @return int - score Nation à l'extérieur
	 */
	public int getSc2() {
		return sc2;
	}
	/**
	 * setter sc2
	 * @param sc2 - int, nouveau score extérieur
	 */
	public void setSc2(int sc2) {
		this.sc2 = sc2;
	}
	/**
	 * getter date
	 * @return ZonedDateTime - date du match
	 */
	public ZonedDateTime getDate() {
		return date;
	}
	/**
	 * setter date
	 * @param date, ZonedDateTime - nouvelle date
	 */
	public void setDate(ZonedDateTime date) {
		this.date = date;
	}
	/**
	 * getter timeZoneJava
	 * @return ZoneId - time zone format Java
	 */
	public ZoneId getTimeZoneJava() {
		return timeZoneJava;
	}
	/**
	 * setter timeZoneJava
	 * @param timeZone - ZoneId, nouvelle time zone Java
	 */
	public void setTimeZoneJava(ZoneId timeZone) {
		this.timeZoneJava = timeZone;
	}
	/**
	 * getter timeZoneNet
	 * @return String - time zone format .Net
	 */
	public String getTimeZoneNet() {
		return timeZoneNet;
	}
	/**
	 * setter timeZoneNet
	 * @param timeZoneNet - String, nouvelle time zone .Net
	 */
	public void setTimeZoneNet(String timeZoneNet) {
		this.timeZoneNet = timeZoneNet;
	}
	
	

}

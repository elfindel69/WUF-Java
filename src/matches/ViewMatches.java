package matches;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ViewMatches {

	public static void viewMatches(Match match, ZoneId timeZone) {
		System.out.println(match.getNat1()+" vs "+match.getNat2());
		System.out.println(match.getSc1()+" - "+match.getSc2());
		ZonedDateTime locDateTime = match.getDate().withZoneSameInstant(timeZone);
		System.out.println("date: "+ locDateTime);
	}
}

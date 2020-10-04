package matches;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ViewMatches {

	public static void viewMatches(Match match) {
		System.out.println(match.getNat1()+" vs "+match.getNat2());
		System.out.println(match.getSc1()+" - "+match.getSc2());
		ZonedDateTime locDateTime = match.getDate().withZoneSameInstant(match.getTimeZoneJava());
		System.out.println("date: "+ locDateTime);
	}

	public static Match addMatch(Scanner sc) {
		
		sc.nextLine();
		System.out.println("New Match:");
		System.out.println("nation 1: ");
        String nat1 = sc.nextLine();
        System.out.println("score 1: ");
        int score1 = sc.nextInt();
        sc.nextLine();
        System.out.println("nation 2: ");
        String nat2 = sc.nextLine();
        System.out.println("score 2: ");
        int score2 = sc.nextInt();
        sc.nextLine();
        System.out.println("date yyyy-MM-dd HH:mm:ss (French Time) :");
        String sDate = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime locDate = LocalDateTime.parse(sDate, formatter);
        System.out.println("timeZone .Net :");
        String sTimeZone1 = sc.nextLine();
        System.out.println("timeZone Java :");
        String sTimeZone2 = sc.nextLine();
        ZoneId zone = ZoneId.of(sTimeZone2);
        ZoneId frZone = ZoneId.of("Europe/Paris");
        ZonedDateTime dom = ZonedDateTime.of(locDate, frZone);
        return new Match(nat1, score1, nat2, score2, dom,zone, sTimeZone1);
	}
}

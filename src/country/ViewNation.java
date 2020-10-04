package country;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ViewNation {

	public static int menuNations(Scanner sc, List<String> lNatNames) {
		System.out.println("Nations:");
		int id = 1;
		for (String s : lNatNames) {
			System.out.println(id+" - "+s);
			++id;
		}
		
		sc.nextLine();
		int choice = sc.nextInt();
		return choice;
	}
	
	public static void viewNation(Nation nat) {
		System.out.println("Nation:");
		System.out.println("name: "+nat.getName());
		System.out.println("confederation: "+nat.getConf().getName());
		System.out.println("date of adhesion: "+nat.getDate());
		System.out.println("main stadium: "+nat.getStadium());
		System.out.println("WUF Ranking: "+nat.getRWuf());
		System.out.println("WUF "+nat.getConf().getName() +" Ranking: "+nat.getRConf());
		System.out.println("points: "+nat.getPts());
	}
	
	public static Nation addNation(Scanner sc) throws SQLException
    {
		
		sc.nextLine();
		System.out.println("New Nation:");
		System.out.println("name: ");
		String name = sc.nextLine();
		System.out.println("points: ");
		double pts  = sc.nextDouble();
		List<String> lNames = ContConf.getConfNames();
		int confMenu = ViewConf.menuConf(sc, lNames);
		int confId = confMenu - 1;

		//Confederation
		List<Conf> lConf = ContConf.getConfData(lNames.get(confId));
		Conf conf = lConf.get(0);
		if (confMenu > 1)
		{
			++confMenu;
		}
		conf.setConfId(confMenu);
		sc.nextLine();
		System.out.println("date of adhesion: ");
		String year = sc.nextLine();
		System.out.println("stadium: ");
		String stadium = sc.nextLine();;
		System.out.println("WUF Ranking:");
		int rWuf = sc.nextInt();
		sc.nextLine();
		System.out.println("Conf Ranking:");
		int rConf = sc.nextInt();
		sc.nextLine();

		return new Nation(name, pts, conf,stadium, year, rWuf, rConf);
	}
}

package competition;

public class ViewLeague {

	public static void viewLeague(League league) {
		System.out.println(league.getName()+" :");
		System.out.println("current League: "+league.getLeague());
		System.out.println("best result: "+ league.getResult()+" - "+ league.getYear() + "\n");
		
	}
}

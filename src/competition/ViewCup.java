package competition;

public class ViewCup {

	public static void viewCup(Cup cup) {
		System.out.println("\n"+ cup.getName()+":");
		System.out.println("appearances: "+cup.getNbCups());
		System.out.println("best result: "+cup.getResult()+ "("+cup.getYear()+") \n");
		
	}
}

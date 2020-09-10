package competition;

public class ViewCup {
	public static void  viewCup(String name, int nb, String result, String date) {
		System.out.println("\n"+ name+":");
		System.out.println("appearances: "+nb);
		System.out.println("best result: "+result+ "("+date+") \n");
	}
}

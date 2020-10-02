package matches;

import java.util.List;

public class ContMatches {
	public static char[] calcResults(List<Match> lMatches, String nation) {
		char[] tabRes = new char[lMatches.size()];
		char res = 0;
		int i = 0;
		for (Match m : lMatches) {
			if (m.getSc1() == m.getSc2()) {
				res = 'N';
			}
			if (m.getNat1() == nation) {
				if(m.getSc1() > m.getSc2()) {
					res = 'V';
				}
				if (m.getSc1() < m.getSc2()) {
					res = 'D';
				}
			}
			if (m.getNat2() == nation) {
				if(m.getSc2() > m.getSc1()) {
					res = 'V';
				}
				if (m.getSc2() < m.getSc1()) {
					res = 'D';
				}
			}
			tabRes[i] = res;
			i++;
		}
		
		return tabRes;
	}
}

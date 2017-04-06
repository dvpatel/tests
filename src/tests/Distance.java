package tests;

public class Distance {
	public static void main(String...args) {
		System.out.println("Levenshtein Distance:  :  " + ldist("kitten", "sitting"));
	}
	public static int ldist(String x, String y) {

		x = "0" + x;
		y = "0" + y ;

		int d[][] = new int[x.length()][y.length()] ;

		for (int i = 1; i < d.length; i++) {
			char s = x.charAt(i) ;
			for (int j = 1; j < d[i].length; j++) {
				char t = y.charAt(j) ;

				//System.out.println(s + ", " + t) ;
				int cost = 0 ;
				if (s == t) {
					cost = 0 ;
				} else {
					cost = 1 ;
				}

				//printDistance(d, i, j) ;
				int i_dist = d[i-1][j] + 1;
				int j_dist = d[i][j-1] + 1 ;
				int k_equi = d[i-1][j-1] + cost ;

				d[i][j] = Integer.min(Integer.min(i_dist,  j_dist),  k_equi) ;

				//System.out.println(i_dist + ", " + j_dist + ", " + k_equi + ", d("+i + ", " + j + "):  " + d[i][j]);
				//System.out.println("====================================================");
			}
		}

		return d[x.length()-1][y.length()-1] ;
	}
	public static void printDistance(int d[][], int i, int j) {
		for (int ii = 0; ii <= i; ii++) {
			for (int jj = 0; jj <= j; jj++) {
				System.out.println("Distances:  " + ii + ", " + jj + ":  " + d[ii][jj]); ;
			}
		}
	}
}
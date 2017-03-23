package tests;

public class NGE {

	public static void main(String[] args) {
		int[] i = {11, 13, 21, 3} ;
		printNGE(i) ;		
	}
	
	public static void printNGE(int[] inp) {
		for (int i = 0; i < inp.length; i++ ) {
			int next = -1 ;
			
			for (int j = i+1; j < inp.length; j++) {
				
				System.out.println("i:  " +i + ", :" + inp[i] + ",  j: " +j+ ":" + inp[j]);
				
				if (inp[i] < inp[j]) {
					next = inp[j] ;
					break ;
				}				
			}
			System.out.println(inp[i] + " -- " + next);
			
		}
		
	}

}

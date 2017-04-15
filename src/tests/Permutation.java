package tests;

/*
 * Permutation example based on
 * Steinhaus Johnson Trotter algorithm
 */

public class Permutation {
	
	public static void main(String... args) {

		String[] result = permutation("123") ;
		
		System.out.println("Permutations:  " + result.length) ;
		for (String r : result) {
			System.out.println(r);
		}
		
	}
	
	public static String[] permutation(String inp) {
		

		char[] c = inp.toCharArray() ;

		String[] result = null  ;
		for (int i = 0; i < c.length; i++) {		
			
			if (i == 0) {
				result = new String[1] ;
				result[0] = String.valueOf(c[0]) ;
			} else {			
				result = subPermutation(c[i], result, i+1) ;
			}
			
		}
		
		return result ;

	}

	public static String[] subPermutation(char c, String[] prev, int pos) {
		
		String[] result = new String[factorial(pos)] ;
		int count = 0 ;

		for (int i = 0; i < prev.length; i++) {						
			char[] prevChars = (prev[i]).toCharArray() ;

			//  merge prevChars and c from left to right, every other spot
			String[] mr = null ;
			if ((i%2) == 0) {
				 mr = mergeRightLeft(prevChars, c) ;
			} else {
				mr = mergeLeftRight(prevChars, c) ;
			}

			//  Append sub-permutations to result ;							
			for (int j = 0; j < mr.length; j++) {
				result[count++] = mr[j] ;
			}			
		}		
		
		return result ;		
	}
	
	public static String[] mergeRightLeft(char[] pc, char c) {
		
		String[] result = new String[pc.length+1] ;
		
		// init and append c to pc ;
		char[] r = new char[pc.length+1] ;
		
		// cp pc to r ;
		r[r.length-1] = c ;
		for (int j = 0; j < (r.length-1); j++) {
			r[j] = pc[j] ;
		}		
		
		int j = 0 ;
		result[j++] = new String(r) ;		
		for(int i = pc.length; i > 0; i--) {
			//  i-1 .. 0
			swap(r, i-1, i) ;
			result[j++] = new String(r) ;			
		}
		
		return result ;		
	}
	

	public static String[] mergeLeftRight(char[] pc, char c) {	
		
		String[] result = new String[pc.length+1] ;
		
		// init and prepend c to pc ;
		char[] r = new char[pc.length+1] ;
		
		// cp pc to r ;
		r[0] = c ;
		for (int j = 1; j < r.length; j++) {
			r[j] = pc[j-1] ;
		}		
		
		int j = 0 ;
		result[j++] = new String(r) ;		
		for(int i = 0; i < pc.length; i++) {
			// 0 .. i-1 ;
			swap(r, i, i+1) ;
			result[j++] = new String(r) ;			
		}
		
		return result ;						
	}

	
	public static int factorial(int inp) {		
		int r = 1 ;				
		for (int i = inp; i > 0; i--) {			
			r = r * i ;
		}		
		return r ;		
	}
	
	public static void swap(char[] c, int i, int j) {
		char t = c[i] ;
		c[i] = c[j] ;
		c[j] = t ;		
	}
	
}

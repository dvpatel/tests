package tests;

import java.util.ArrayList;
import java.util.Hashtable;

/*
 * Given NxN grid, get all paths to move robot from 0,0 to N,N 
 * using only right (R) and down (D) movements.
 */
public class RobotMove {

	static int count = 0 ;
	static Hashtable<String, Boolean> h = new Hashtable<String, Boolean>() ;
	
	public static void main(String[] args) {
		
		//  in a 4x4 matrix, max 3 Rights, and 3 Downs ;
		int M = 4 ;
		int N = 4 ;

		char[] arr = getArr(M, N) ;
		int n = arr.length ;
		gen(arr, n) ;

		// filter coordinates
		int[] x = {1, 2} ;
		int[] y = {2, 3} ;
		filter(x, y) ;

		System.out.println(count + " unique paths for " + M + " x " + N + " matrix.") ; 
		for (String p : h.keySet()) {
			System.out.println(p);
		}
		
	}
	
	public static void filter(int[] x, int[] y) {
		
		/*
		 * any path that crosses x, y combination automatically becomes
		 * invalid
		 */
		
		ArrayList<String> rmItems = new ArrayList<String>() ;
		for (String p : h.keySet()) {
			boolean r = isPathValid(p, x, y) ;
			if (!r) {
				//System.out.println("Filtering:  " + p);
				--count ;
				rmItems.add(p) ;
			}
		}
		
		for(String p : rmItems) {
			h.remove(p) ;
		}
		
	}
	
	public static boolean isPathValid(String p, int[] x, int[] y) {

		int i = 0 ;
		int j = 0 ;

		for (char c : p.toCharArray()) {
			
			if (c == 'R')
				++i ;
			
			if (c == 'D') 
				++j ;
						
			//  have our coordinates ;
			for (int indx = 0; indx < x.length; indx++) {
				if (x[indx] == i && y[indx] == j) {
					return false ;
				}
			}
		}

		return true ;
	}
	
	public static char[] getArr(int i, int j) { 
		
		i = i-1 ;
		j = j-1 ;
		int c = i+j ;
		char[] arr = new char[c] ;

		int _i = 0 ;
		for (; _i < i; _i++) {
			arr[_i] = 'R' ;
		}
		
		for(; _i < (i+j); _i++)
		{
			arr[_i] = 'D' ;
		}
		
		return arr ;
		
	}
	
	public static void gen(char[] arr, int n) {
		
		if (n == 1) {
			String s = new String(arr) ;
			if (h.get(s) == null) {
				count++ ;
				h.put(s, true) ;
			} 
		} else {
			for (int i = 0; i < n; i++) {
				gen(arr, n-1) ;
				//  if n is odd, swap 0 with n ;
				if (n%2 != 0) {
					swap(arr, 0, n-1) ;
				} else {
					swap(arr, i, n-1) ;
				}
			}
		}
		
	}
	
	public static void swap(char[] arr, int i, int j) {
		char t = arr[i] ;
		arr[i] = arr[j] ;
		arr[j] = t ;
	}
}
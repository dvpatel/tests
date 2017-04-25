package tests;

import java.util.HashSet;
import java.util.Set;

public class ParenthesisPairs {

	public static void main(String[] args) {
		char[] arr = {'(', ')', '(', ')', '(', ')'} ;
		int len = arr.length ;
		gen(arr, len) ;
		for (String s : results) {
			System.out.println(s);
		}
	}
	
	public static boolean isValid(char[] arr) {
		int i = 0 ;
		for(char c : arr) {
			int v = (c == '(') ? 1 : -1 ;
			i = i + v ;
			
			if (i < 0) {
				return false ;
			}			
		}		
		return true ;
	}

	static Set<String> results = new HashSet<String>() ;
	public static void gen(char[] arr, int n) {		
		if (n == 1) {
			String k = new String(arr) ;
			if (!results.contains(k) && isValid(arr)) {
				//System.out.println(k);				
				results.add(k) ;
			} else {
				//  System.out.println("Failed:  " + new String(arr));	
			}
			
		} else {
			for (int i = 0; i < n; i++) {
				gen(arr, n-1) ;
			
				//  if odd ; swap 0, n
				//  if even, swap i, n ;
				if (n%2 == 1) {
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

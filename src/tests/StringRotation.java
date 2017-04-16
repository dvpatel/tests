package tests;

import java.util.Hashtable;

/**
 * Test for string rotation.
 * ie.  boy.isRoration(oyb) ==> true
 * @author dipesh
 *
 */
public class StringRotation {
	
	private char[] s ; 
	
	private Hashtable<Character, Integer> h = new Hashtable<Character, Integer>() ;
	
	public StringRotation(String inp) {
		this.s = inp.toCharArray() ;
		
		int count = 0 ;
		for (char c : s) {
			h.put(c, count++) ;
		}
		
	}
	
	public boolean isRoration(String inp) {

		char[] c = inp.toCharArray() ;		
		if (c.length != s.length) {
			return false ;
		}
		
		//  compare character with offsite info ;		
		int offset = h.get(c[0]) ;
		for (int i = 0; i < c.length; i++) {
			
			offset = offset % c.length ;			
			if (c[i] != s[offset++]) {				
				return false ;
			}
			
		}
		
		return true ;
	}

	public static void main(String[] args) {
		String inp = "cinema" ;
		StringRotation sr = new StringRotation(inp) ;
				
		String[] inputs = Permutation.permutation(inp) ;
		for (String i : inputs) {
			if (sr.isRoration(i)) {
				System.out.println(inp + " is rotation of "+ i +":  " + sr.isRoration(i));
			}
		}

	}

}

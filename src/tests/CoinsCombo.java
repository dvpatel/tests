package tests;

import java.util.LinkedHashSet;
import java.util.Set;

/*
 * Find all the quarters, dimes, nickels, pennies combinations for
 * given input value
 */
public class CoinsCombo {
	
	public static void main(String[] args) {
		int i = 16 ;
		
		Coins[] c = new Coins[4] ;
		
		c[0] = getQuarterCombo(i) ;		
		c[1] = getDimeCombo(i) ;
		c[2] = getNickelCombo(i) ;
		c[3] = getPennyCombo(i) ;

		for (Coins _c : c) {
			genQuartersToDimesCombo(_c) ;	
		}
		
		printSet(i) ;		
	}
	
	public static Set<String> combo = new LinkedHashSet<String>() ; 
	
	public static class Coins {
		public int q, d, n, p ;
		
		public int value() {
			return q*25 + d*10 + n*5 + p ;
		}
		
		public String toString() {
			return q + "q, " + d + "d, " + n + "n, " + p + "p" ;
		}
	}

	public static void printSet(int i) {
		System.out.println(combo.size() + " combinations for " + i + "\u00A2"); 
		for(String c : combo) {
			System.out.println(c); 
		}
	}
	
	public static void addToSet(Coins c) {
		combo.add(c.toString()) ;
	}
	
	/*
	 * Get starting point.  This value will be used
	 * to get other coin combinations starting with quarters
	 */
	public static Coins getQuarterCombo(int p) {
		
		Coins c = new Coins() ;
		
		int qr = p % 25 ;
		c.q = p / 25 ;
		
		int dr = qr % 10 ;
		c.d = qr / 10 ;
		
		int nr = dr % 5 ;
		c.n = dr / 5 ;
		
		c.p = nr ;
		
		return c ;		
	}
	
	public static Coins getDimeCombo(int p) {
		
		Coins c = new Coins() ;
		
		int dr = p % 10 ;
		c.d = p / 10 ;
		
		int nr = dr % 5 ;
		c.n = dr / 5 ;
		
		c.p = nr ;
		
		return c ;		
	}

	public static Coins getNickelCombo(int p) {
		
		Coins c = new Coins() ;
		
		int nr = p % 5 ;
		c.n = p / 5 ;
		
		c.p = nr ;
		
		return c ;		
	}
	
	public static Coins getPennyCombo(int p) {
		
		Coins c = new Coins() ;
		
		c.p = p ;
		
		return c ;		
	}

	
	/*
	 * Quarter combinations.  For each quarter, get d, n, penny combos ;
	 */
	public static void genQuartersToDimesCombo(Coins c) {
		if (c.q > 0) {			

			addToSet(c);
			
			c.q = c.q-1 ;			
			c.d = c.d + 2 ;
			c.n = c.n + 1 ;			
			
			genDimesToNickelsCombo(c) ;		
			
			if (c.q > 0)
				genQuartersToDimesCombo(c) ;			
			
		} else {
			genDimesToNickelsCombo(c) ;			
		}
	}

	/*
	 *  Dime combinations.  For each dime, get n, penny combinations.
	 */
	public static void genDimesToNickelsCombo(Coins c) {
		if (c.d > 0) {
			addToSet(c);
			
			c.d = c.d-1 ;
			c.n = c.n+2 ;	
			genNickelsToPenniesCombo(c) ;
			
			if (c.d > 0)
				genDimesToNickelsCombo(c) ;
			
		} else {
			genNickelsToPenniesCombo(c) ;
		}
	}
	
	/*
	 * Nickel combinations.  For each nickel, get pennies ;
	 */
	public static void genNickelsToPenniesCombo(Coins c) {		
		if (c.n > 0) {
			addToSet(c);
			
			c.n = c.n-1 ;
			c.p = c.p + 5 ;			
			genPennies(c) ;
			
			if (c.n > 0)
				genNickelsToPenniesCombo(c) ;		
			
		} else {
			genPennies(c) ;		
		}
	}
	
	/*
	 * Pennies.
	 */
	public static void genPennies(Coins c) {		
		addToSet(c);
	}	
}

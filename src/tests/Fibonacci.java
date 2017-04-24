package tests ;

public class Fibonacci {

	public static void main(String[] args) {		
		for (int i = 0; i < 8; i++) {
			//System.out.print(generate(i) + " ");
			System.out.print(gen(0, i, 0, 0) + " ");
		}		
	}
	
	/**
	 * recursive operation to calculate "n" fib value
	 * @param m,  starting index
	 * @param n,  nth fib position
	 * @param p,  previous position value
	 * @param pp, previous, previous position value
	 * @return
	 */
	public static int generate(int n) {
		int p = 0 ;
		int pp = 0 ;
		int r = 0 ;
		for (int i = 0; i < n; i++) {
			// n:  0 1 2 3 4 5 6 7 8
			// v:  0 1 1 2 3 5 8 13

			if (i == 0) {
				p = 1 ;
				pp = 0 ;
			}

			r = p + pp ;			
			if (i > 0) {
				pp = p ;
				p = r ;		
			}
		}
		
		return r ;
	}
	
	public static int gen(int i, int n, int p, int pp) {
				
		if (n == 0) {
			return 0 ;
		}
		
		if (n == 1) {
			return 1 ;
		}
		
		if (i == 2) {
			p = 1 ;
			pp = 0 ;
		}
		
		if (i < n) {
			return gen(++i, n, p+pp, p) ;			
		}
		
		return p+pp ;
	}
}

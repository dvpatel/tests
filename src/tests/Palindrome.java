package tests;

/*
 * Find x*y so that it is a max palindrome result 
 */
public class Palindrome {

	public static void main(String[] args) {
		int n = 999;
		Result r = max(n) ;
		System.out.println("N:  " + n + ", x:  " + r.x + ", y:  " + r.y + ", Result:  " + r.r) ;
	}
	
	static class Result {
		public int x ;
		public int y ;
		public int r ;
	}
	
	public static Result max(int n) {
		
		Result r = new Result() ;
		for (int i = n; i > 0; i--) {
			for (int j = n; j > 0; j--) {
				
				int m = i*j ;				
				if (isPalindrome(m) && m > r.r) {
					//System.out.println("I:  " + i + ", J:  " + j + ", R:  " + m) ;
					r.r = m ;
					r.x = i ;
					r.y = j ;
				}				
			}
		}		
		
		return r ;
	}

	public static boolean isPalindrome(int n) {
		/*
		 * n = 252 ; 252 / 10 --> 25, R2 ; t = 2 ; 25 / 10 --> 2, r5 --> t=t*10
		 * + 5 --> 25 2 / 10 --> 0, r 2; --> t = t*10 + 2 --> 250+2 = 252 ;
		 * 
		 * n = 345 345 / 10 --> 34, r 5 --> t = 5 ; 34/10 --> 3, r 4 --> t =
		 * t*10 + 4 --> t = 54 3 / 10 --> 0, r 3 --> t*10 + 3 --> 540+3 = 543 ;
		 * 
		 */

		int t = 0;
		int inp = n;
		while (true) {

			if (inp == 0) {
				break;
			}

			int quotient = inp / 10;
			int remainder = inp % 10;

			t = t * 10 + remainder;
			inp = quotient;
		}

		return t == n;
	}

}
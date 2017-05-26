package euler;

/**
 * Euler problem 2
 * Example to print Nth Fibonacci odd, even, all numbers
 * Add all even fib numbers up to seq less than 4000000 
 * @author Dipesh
 */
public class Fibonacci {

	public static void main(String[] args) {
		int max = 50;
		fib(0, max, 0, 0, Num.EVEN);
	}

	public enum Num {
		ODD, EVEN, ALL;
	}

	public static long t = 0 ;
	public static void fib(long i, long max, long p, long pp, Num n) {

		// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
		if (i < max) {

			long r = (i == 1) ? 1 : p + pp;
			
			switch (n) {
			
			case ALL:
				// print all numbers ;
				System.out.print(" " + r);
				fib(++i, max, r, p, Num.ALL);
				break ;

			case EVEN:
				if (r % 2 == 0 && r < 4000000) {
					t = t + r ;
					System.out.println("N:  " + i + ", Val:  " + r + ", Total:  " + t);
				}

				fib(++i, max, r, p, Num.EVEN);
				break ;

			case ODD:
				if (r % 2 == 1)
					System.out.println("N:  " + i + ", Val:  " + r);

				fib(++i, max, r, p, Num.ODD);
			}
		}

	}
}
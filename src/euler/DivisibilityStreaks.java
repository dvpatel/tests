package euler;

/*
 *  Euler 601 problem.
 *  Find total divisibility streak from P(1, 4) to P(31, 4^31)
 */

import java.util.HashMap;

public class DivisibilityStreaks {

	public static void main(String... args) {
		buildMap();
		streaksSum();
	}

	/*
	 * Sum total number of streaks from i = 1 to 31 ;
	 */
	public static void streaksSum() {
		long sum = 1;
		
		for (int streak = 2; streak <= 31; streak++) {
			long range = pow(4, streak);
			long multiplier = multiplesMap.get(streak);

			long c = streakCount(range, multiplier, streak);
			sum = sum + c;
			
			System.out.println("Range:  " + range + ", Streak:  " + streak + ", Multiplier:  " + multiplier
					+ ", Count:  " + c + ", Sum:  " + sum);
		}
	}

	/*
	 * Get total number of streaks for a given range
	 */
	public static long streakCount(long range, long multiple, int streak) {

		long count = 0;
		long n = 1 + multiple;
		
		while (n < range) {
			
			long r = streaks(n, 0);
			if (r == streak) {
				count++;
			}
			
			n = n + multiple;
		}
		
		return count;
	}

	/*
	 * Get streak count given number n ;
	 */
	public static long streaks(long n, int k) {
		long t = (n + k) % (k + 1);
		if (t != 0) {
			return k;
		} else {
			return streaks(n, ++k);
		}
	}

	public static HashMap<Integer, Long> multiplesMap = new HashMap<Integer, Long>();

	/*
	 * Build map to get multiples from i = 1 to 31 ;
	 */
	public static void buildMap() {
		long s = 1;
		int str = 2;
		for (int c = 1; c <= 31; c++) {
			long m = multiple(s, str);
			multiplesMap.put(str, m);
			str++;
			s = m;
		}
	}

	public static long multiple(long m, int streak) {
		long n = 1 + m;
		while (true) {
			double r = streaks(n, 0);
			if (r >= streak) {
				return n - 1;
			} else {
				n = n + m;
			}
		}
	}

	public static long pow(long a, int b) {
		if (b == 0)
			return 1;

		if (b == 1)
			return a;

		if (b % 2 == 0)
			return pow(a * a, b / 2); // even a=(a^2)^b/2
		else
			return a * pow(a * a, b / 2); // odd a=a*(a^2)^b/2
	}
}
package tests;

import java.util.ArrayList;
import java.util.List;

/*
 * Sample based on Sieve of Eratosthenes algorithm.
 * For number 1 - 10000, find all the prime numbers
 * while maximizing space and time.
 * 
 * Sample 2:  find n that is a factor of 3, 5, and 7
 */
public class PrimeNumbers {

	public static void main(String[] args) {
		
		int size = 10000;
		long s = System.currentTimeMillis();		
		List<Integer> p = primeNumbers(size);
		long end = System.currentTimeMillis();
		System.out.println(p.size() + ", Counter:  " + counter + ", Time: " + (end - s) + " mSec");
		//System.out.println(p);
		
		System.out.println("----------------------------------------------------");
		
		int[] f = { 3, 5, 7 };
		
		for (int i = 1; i < size; i++) {
		
			List<Integer> out = new ArrayList<Integer>();
			
			boolean result = primeFactorTest(i, f, 0, out);			
			if (result) {
				System.out.println("Value:  " + i + ", Factors:  " + out);
			}
			
		}
	}

	/*
	 * tests number n if a factor of 3, 5, 7
	 */
	public static boolean primeFactorTest(int n, int[] factors, int indx, List<Integer> out) {
		
		counter++;
		// if n is a prime and > 7, then return false
		// All prime numbers are factor of itself and one ;
		if (indx > factors.length - 1) {
			return false;
		}

		for (int i = 0; i < factors.length; i++) {
			if (n == factors[i]) {
				out.add(n);
				return true;
			}
		}
		
		int r = n / factors[indx];
		int re = n % factors[indx];
		if (re != 0) {
			// try next one
			return primeFactorTest(n, factors, ++indx, out);
		} else {
			out.add(factors[indx]);
			return primeFactorTest(r, factors, indx, out);
		}

	}

	public static long counter;

	public static List<Integer> primeNumbers(int size) {
		
		List<Integer> r = getNumbers(size);

		for (int i = 0; i < r.size(); i++) {
			for (int j = i; j < r.size(); j++) {
				counter++;

				int iVal = r.get(i);
				int jVal = r.get(j);
				if ((jVal % iVal) == 0 && i != j) {
					r.remove(new Integer(jVal));
				}
			}
		}
		
		return r;
		
	}

	public static List<Integer> getNumbers(int size) {
		
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 1; i < size; i++) {
			l.add(new Integer(i + 1));
		}
		return l;
		
	}

	public static void printNumbers(int[] n) {
		
		for (int i = 0; i < n.length; i++) {
			System.out.println(n[i]);
		}
		
	}

}
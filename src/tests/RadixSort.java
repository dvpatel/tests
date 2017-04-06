package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/*
 * RadixSort example (simple)
 */

public class RadixSort {
	private int[] input ;
	private TreeMap<Integer, ArrayList<Integer>> buckets = new TreeMap<Integer, ArrayList<Integer>>() ;
	private TreeMap<Integer, ArrayList<Integer>> results = new TreeMap<Integer, ArrayList<Integer>>() ;

	public RadixSort(int[] inp) {
		this.input = inp ;
	}
	public static void main(String[] args) {
		/*
		 * General approach:
		 * 1.  distribute input keys into buckets by least significant digit, keep buckets in order ;
		 * 2.  distribute bucket keys by most significant digit ;
		 */
		int[] input = {45, 21, 57, 99, 53, 24, 20, 75, 2, 56, 12} ;

		System.out.println(Arrays.toString(input)) ;

		RadixSort r = new RadixSort(input) ;
		r.sort();
	}
	private void sort() {
		this.distributeByLeastSignificantDigit() ;
		this.distributeByMostSignificantDigit() ;
		this.printResults() ;
	}
	/*
	 * first pass:  Distribute input keys into buckets by least significant digit, keep bucket order
	 */
	private void distributeByLeastSignificantDigit() {
		for (int i: input) {
			int lsd = i % 10 ;
			ArrayList<Integer> al = this.buckets.get(lsd) ;
			//  bucket does not exist; create a new bucket ;
			if (al == null) {
				al = new ArrayList<Integer>() ;
				this.buckets.put(lsd, al) ;
			} 
			al.add(i) ;
		}
	}

	/*
	 * 2nd pass:  distribute bucket items by most significant digit ;
	 */
	private void distributeByMostSignificantDigit() {
		for (Integer bucketKey : this.buckets.keySet()) {
			ArrayList<Integer> items = this.buckets.get(bucketKey) ;
			for (Integer i: items) {
				int msd = i / 10 ;

				//  bucket does not exist; create a new bucket ;
				ArrayList<Integer> al = this.results.get(msd) ;
				if (al == null) {
					al = new ArrayList<Integer>() ;
					this.results.put(msd, al) ;
				} 
				al.add(i) ;
			}
		}
	}

	private void printResults() {
		System.out.print("["); 
		for (Integer bucketKey : this.results.keySet()) {
			for (Integer i: this.results.get(bucketKey)) {
				System.out.print(i + " ") ;
			}
		}
		System.out.print("]"); 
	}

}
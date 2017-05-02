package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class BucketSort {

	public static void main(String[] args) {
		int[] arr = { 100, 150, 101, 90, 190, 95, 110 };
		System.out.println(Arrays.toString(arr) + ", Counter:  " + counter);
		sort(arr);
		System.out.println(Arrays.toString(arr) + ", Counter:  " + counter);
	}

	public static int counter;

	public static void sort(int[] arr) {

		/*
		 * Put elements into buckets 0 - 9 ;
		 */
		TreeMap<Integer, List<Integer>> buckets = new TreeMap<Integer, List<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			counter++;
			int bid = arr[i] / 10;
			List<Integer> al = buckets.get(bid);
			if (al == null) {
				al = new ArrayList<Integer>();
				al.add(arr[i]);
				buckets.put(bid, al);
			} else {
				buckets.get(bid).add(arr[i]);
			}
		}

		/*
		 * Sort each bucket ;
		 */
		TreeMap<Integer, List<Integer>> results = new TreeMap<Integer, List<Integer>>();
		for (Integer key : buckets.keySet()) {
			counter++;
			List<Integer> al = buckets.get(key);
			Integer[] bucketArr = new Integer[al.size()];
			al.toArray(bucketArr);
			sort(bucketArr, 0, bucketArr.length - 1);
			List<Integer> l = Arrays.asList(bucketArr);
			results.put(key, l);
		}
		
		/*
		 * Update arr with aggregated results
		 */
		int c = 0;
		for (Integer i : results.keySet()) {
			List<Integer> l = results.get(i);
			if (l != null) {
				for (int ii : l) {
					counter++;
					arr[c++] = ii;
				}
			}
		}
	}

	public static void sort(Integer[] arr, int x, int y) {
		int i = x;
		int j = y;
		int m = x + (y - x) / 2;
		int pivot = arr[m];
		boolean isSwap = false;
		
		while (i < j) {

			while (arr[i] < pivot) {
				i++;
			}
			while (pivot < arr[j]) {
				j--;
			}
			if (i < j) {
				isSwap = true;
				swap(arr, i, j);
			}
		}
		
		if (isSwap) {
			sort(arr, x, j);
			sort(arr, i, y);
		}
	}

	public static void swap(Integer[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
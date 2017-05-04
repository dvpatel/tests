package tests;

import java.util.Arrays;

public class SearchRotatedArray {

	public static void main(String[] args) {
		int[][] arr = {
			{1, 3, 5, 6, 7, 9, 10,11},
			{6, 7, 9, 10, 11, 1, 3, 5},
			{3, 5, 6, 7, 9, 10, 11, 1},
			{10, 11, 1, 3, 5, 6, 7, 9},
			{5, 6, 7, 9, 10, 11, 1, 3}
		} ;
		
		int val = 1 ;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]) + ":  "+val+" @ Indx " + binarySearch(arr[i], 0, arr[i].length, val) + ", count: " + count);
			count = 0 ;
		}
	}
		
	static int count = 0 ;
	
	public static int binarySearch(int[] arr, int x, int y, int s) {
		
		++count ;
		
		int i = x ;
		int j = y ;
		int m = x + (y-x)/2 ;		
		int midVal = arr[m] ;
						
		if (s == midVal) {
			return m ;		
		} else {			
			/*  {6, 7, 9, 10, 1, 3, 5}
			 *   mid < a[max]  -->  min is on left, range is on right
			 *   mid > a[max[ -->  min is on right, range is on left ;
			 */
			
			if (arr[i] == s) {
				return i ;
			}
			
			if (arr[j-1] == s) {
				return j-1 ;
			}
			
			if (midVal < arr[j-1]) {
				if (midVal < s && s < arr[j-1]) {
					return binarySearch(arr, m+1, j-1, s) ;
				} else {
					return binarySearch(arr, 0, m, s) ;
				}
				
			} else {
				
				if (arr[i] < s && s < arr[m]) {
					return binarySearch(arr, 0, m, s) ;
				} else {
					return binarySearch(arr, m+1, j-1, s) ;
				}
			}						
		}
	}
}

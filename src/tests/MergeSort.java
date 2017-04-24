package tests;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] arr = {13, 4, 1, 5, 6, 22} ;
		int x = 0 ;
		int y = arr.length-1 ;
		
		System.out.println(Arrays.toString(arr));
		sort(arr, x, y) ;		
		System.out.println(Arrays.toString(arr));

	}
	
	public static void sort(int[] arr, int x, int y) {
		//  divide and conquer ;
		
		if (x < y) {

			int m = x + (y-x)/2 ;
			
			//  sort left side ;  x, m
			//  sort right side ; m+1, y
			//  merge ;
			
			sort(arr, x, m) ;
			sort(arr, m+1, y) ;
			merge(arr, x, y, m) ;			
		}		
	}
	
	public static void merge(int[] arr, int x, int y, int m) {

		int[] t = new int[arr.length] ;
		for (int i = 0; i < arr.length; i++) {
			t[i] = arr[i] ;
		}

		int i = x ;
		int j = m+1 ;		
		int k = x ;

		//  a1 : [1, 3, 5]
		//  b1 : [2, 4, 6]
		//  compare and update array ;		
		while (i <= m && j <= y) {
			if (t[i] <= t[j]) {
				arr[k++] = t[i++] ;
			} else {
				arr[k++] = t[j++] ;
			}			
		}
		
		while (i <= m) {
			arr[k++] = t[i++] ;
		}
		
		while (j <= y) {
			arr[k++] = t[j++] ;
		}
		
		// System.out.println("---" + Arrays.toString(arr)); ;		
	}


}
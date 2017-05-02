package tests;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 100, 150, 101, 90, 190, 95, 110 };
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr) + ", Counter:  " + counter + ", ArrayLen:  " + arr.length);
	}

	public static int counter;

	public static void sort(int[] arr) {
		boolean cont = false;
		for (int j = 1; j < arr.length; j++) {
			counter++;

			int i = j - 1;
			// compare arr[i] and arr[j] ;
			// swap if less ;
			if (arr[j] < arr[i]) {
				swap(arr, i, j);
				cont = true;
			}
		}
		
		if (cont) {
			sort(arr);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
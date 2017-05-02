package tests;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 100, 100, 150, 101, 90, 190, 95, 110 };
		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr[0]);
		System.out.println(Arrays.toString(arr) + ", Counter:  " + counter + ", ArrayLength:  " + arr.length);
	}

	public static int counter;

	public static void sort(int[] arr, int x, int compVal) {
		counter++;

		int min = compVal;
		int indx = -1;
		for (int i = x; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				indx = i;
			}
		}
		
		if (indx != -1)
			swap(arr, x, indx);

		if (x < arr.length - 1) {
			sort(arr, x + 1, arr[x + 1]);
		}
		
	}

	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
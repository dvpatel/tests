package tests;

public class RotatedSearchArray {

	public static void main(String[] args) {
		int[] arr = { 10, 11, 13, 1, 3, 4, 6, 8, 9 };

		for (int i = 0; i < arr.length; i++) {
			int indx = rotatedSearch(arr, arr[i]);
			System.out.println("Val:  " + arr[i] + " @ Index " + indx + ", count:  " + counter);
			counter = 0;
		}

	}

	public static int rotatedSearch(int[] arr, int searchVal) {

		// 0..len
		int len = arr.length - 1;
		return binarySearch(arr, 0, len, searchVal);
	}

	public static int counter;

	public static int binarySearch(int[] arr, int x, int y, int searchVal) {
		++counter;
		int i = x;
		int j = y;
		int m = x + (y - x) / 2;
		int midVal = arr[m];
		
		if (midVal == searchVal) {
			return m;
		} else {
			
			if (searchVal == arr[i]) {
				return i;
			}
			
			if (searchVal == arr[j]) {
				return j;
			}
			
			// min is from a[0] .. a[m] ; range is from a[m+1] .. a[j]
			if (searchVal >= arr[m + 1] && searchVal <= arr[j]) {
				return binarySearch(arr, m + 1, j, searchVal);
			} else {
				return binarySearch(arr, i, m, searchVal);
			}
		}
	}

}
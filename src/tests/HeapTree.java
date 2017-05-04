package tests;

/*
 * Min and Max HeapTree processing for create, insert, and delete.
 */

public class HeapTree {

	public static void main(String[] args) {
		int[] arr = { 35, 33, 42, 10, 14, 19, 27, 44, 26, 31 };
		printArr(arr);

		/* minimum tree ; */
		counter = 0;
		createMinTree(arr);
		printArr(arr);

		// delete min ;
		counter = 0;
		int[] rr = deleteMinTree(arr);
		printArr(rr);

		/* Insert new value ; */
		counter = 0;
		int[] r = insertForMin(arr, 5);
		printArr(r);
	}

	public static int counter;

	/*
	 * Delete root and rearrange a minmum heap tree ;
	 */
	public static int[] deleteMaxTree(int[] arr) {
		
		// arr[0] is min ;
		int[] n = new int[arr.length - 1];
		System.arraycopy(arr, 1, n, 0, n.length);
		
		// Test for min heap property ;
		compareAndSwapMax(n, n.length - 1);

		// return new result ;
		return n;
	}

	/*
	 * Delete root and rearrange a minmum heap tree ;
	 */
	public static int[] deleteMinTree(int[] arr) {
		
		// arr[0] is min ;
		int[] n = new int[arr.length - 1];
		System.arraycopy(arr, 1, n, 0, n.length);

		// Test for min heap property ;
		compareAndSwapMin(n, n.length - 1);

		return n ;
	}

	/*
	 * Insert new value; ASSUME input is a heap tree ;
	 */
	public static int[] insertForMin(int[] arr, int val) {
		
		int[] r = new int[arr.length + 1];
		System.arraycopy(arr, 0, r, 0, arr.length);
		
		r[r.length - 1] = val;
		compareAndSwapMin(r, r.length - 1);
		return r;
		
	}

	/*
	 * Insert new value; ASSUME input is a heap tree ;
	 */
	public static int[] insertForMax(int[] arr, int val) {
		
		int[] r = new int[arr.length + 1];
		System.arraycopy(arr, 0, r, 0, arr.length);
		
		r[r.length - 1] = val;
		compareAndSwapMax(r, r.length - 1);
		
		return r;
	}

	public static void createMaxTree(int[] arr) {
		
		int[] htree = new int[arr.length + 1];
		
		for (int i = 0; i < arr.length; i++) {
			counter++;
			htree[i + 1] = arr[i];
			compareAndSwapMax(htree, i + 1);
		}
		
		System.arraycopy(htree, 1, arr, 0, arr.length);
	}

	public static void compareAndSwapMax(int[] htree, int pos) {
		
		// pos: event --> 2k
		// pos: odd --> 2k+1

		// find parent given position ;
		int parent = -1;
		
		if (pos % 2 == 0) {
			parent = pos / 2;
		} else {
			parent = (pos - 1) / 2;
		}
		
		// go up tree and compare ;
		if (pos > 0) {
			if (htree[parent] < htree[pos]) {
				counter++;
				swap(htree, parent, pos);
				compareAndSwapMax(htree, parent);
			}
			if (htree[parent] < htree[pos - 1]) {
				counter++;
				swap(htree, parent, pos - 1);
				compareAndSwapMax(htree, parent);
			}
		}
		
	}

	public static void createMinTree(int[] arr) {
		
		int[] htree = new int[arr.length + 1];
		
		System.arraycopy(arr, 0, htree, 1, arr.length);
		
		for (int i = 0; i < arr.length; i++) {
			counter++;
			compareAndSwapMin(htree, i + 1);
		}
		
		System.arraycopy(htree, 1, arr, 0, arr.length);
	}

	public static void compareAndSwapMin(int[] htree, int pos) {
		
		// pos: event --> 2k
		// pos: odd --> 2k+1

		// find parent given position ;
		int parent = -1;
		
		if (pos % 2 == 0) {
			parent = pos / 2;
		} else {
			parent = (pos - 1) / 2;
		}
		
		// go up tree and compare ;
		if (pos > 0) {

			if (htree[parent] > htree[pos]) {
				counter++;
				swap(htree, parent, pos);
				compareAndSwapMin(htree, parent);
			}
		
			if (htree[parent] > htree[pos - 1]) {
				counter++;
				swap(htree, parent, pos - 1);
				compareAndSwapMin(htree, parent);
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
		
		System.out.print(" , Counter:  " + counter);
		
		System.out.println("");
	}
}
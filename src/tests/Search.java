package tests;

/**
 * Sample search to find starting, ending index for given array
 * Solution based on binary search
 * @author dipesh patel
 *
 */
public class Search {
	
	public static void main(String[] args) {
		
		// Input tests ;
		int[][] tests = {
				{8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 8, 8, 8, 9, 10, 10, 12, 13, 14},
				{1, 8, 8, 8, 8, 8, 8, 8, 10, 11},
				{1, 3, 4, 5, 6, 7, 8, 8, 8, 9},
				{1, 2, 3, 4, 5, 6, 7, 9, 10, 11}
		} ;

		//  search value ;
		//int[] vals = {8, 4, 10000000} ;
		int[] vals = {8} ;
		
		//  Run tests against various arrays ;
		for (int i = 0; i < tests.length; i++) {
			int[] x = tests[i] ;
			
			// for each val, run test
			for (int v = 0; v < vals.length; v++) {
				int val = vals[v] ;
				printRange(x, 0, x.length-1, val) ;				
				count = 0 ;				
			}
			
		}		
	}

	

	/*
	 * Break problem into 2 parts, each binary search
	 */
	public static void printRange(int arr[], int i, int j, int val) {

		
		// -1 means no value found		
		int x  = -1 ;
		int y  = -1 ;

		int m = i + (j-i)/ 2 ;		
		if (val < arr[m] ) {		

			//  Search only left side ;
			x = leftSideRange(arr, 0, m, val, x) ;
			y = rightSideRange(arr, x, m, val, x) ;
			
		} else if (val > arr[m]) {
			
			//  search only right side ;
			x = leftSideRange(arr, m+1, arr.length, val, x) ;
			y = rightSideRange(arr, m, arr.length, val, x) ;
			
		} else {
			
			//  Right in the middle ;
			x = leftSideRange(arr, 0, m, val, x) ;
			y = rightSideRange(arr, m+1, arr.length, val, x) ;
			
		}
		
		System.out.println("InputLength:  " + arr.length + ", LoopCount:  " + count + ", Value:  " + val + " found in Range(" + x + ", " + y + ")") ;		
	}
	
	
	public static int leftSideRange(int arr[], int i, int j, int val, int prevIndx)
	{
		int t = binarySearch(arr, i, j, val) ;		
		if (t != -1) {
			return leftSideRange(arr, i, t, val, t) ;			
		} else {
			return prevIndx ;
		}
	}
	
	public static int rightSideRange(int arr[], int i, int j, int val, int prevIndx)
	{		
		int t = binarySearch(arr, i, j, val) ;			
		if (t != -1) {
			return rightSideRange(arr, t+1, j, val, t) ;			
		} else {
			return prevIndx ;
		}		
	}

	static int count ;
	public static int binarySearch(int arr[], int x, int y, int val) {
		
		//  simple count tracker
		count++ ;
		
		if (x >= y) {
			return -1  ;
		}
		
		int mid = x + (y-x) / 2 ;
		int i = x;
		int j = mid+1 ;
		
		if (mid < 0) {
			return -1 ;
		}
		
		if (val < arr[mid]) {
			return binarySearch(arr, i, mid, val ) ;
		} else if (val > arr[mid]) {
			return binarySearch(arr, j, y, val) ;			
		} else {
			return mid ;			
		}				

	}
}

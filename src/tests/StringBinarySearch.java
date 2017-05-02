package tests;

public class StringBinarySearch {

	public static void main(String[] args) {
		String[] arr = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "", "", "sad", "", "", ""} ;
		int len = arr.length ;
		
		for (int i = 0; i < arr.length; i++) {
			String searchVal = arr[i] ;
			
			if (!searchVal.equals("")) {
				int r = binarySearch(arr, 0, len, searchVal) ; 
				System.out.println("Found value: " + searchVal + " @ Index:  " + r + ", count:  " + counter + ", len:  " + len);
				System.out.println("-----------------------------------------------------------");
				counter = 0 ;
			}
		}
		
	}
	
	public static int counter ;
	public static int binarySearch(String[] arr, int x, int y, String searchVal) {
		
		++counter ;
		
		int i = x ;
		int j = y ;
		
		if (i == j) {
			return -1 ;
		}
		
		int m = i + (j-i) / 2 ;
		String midVal = arr[m] ;

		/*
		if (midVal.equals(searchVal)) {
			return m ;
		}*/
		
		/*
		 * check midvalue ;
		 * if "", search both side;
		 * else search left of right ;
		 */
					
		if (midVal.equals("")) {
			int r = binarySearch(arr, i, m, searchVal) ;
			if (r == -1) 
				return binarySearch(arr, m+1, j, searchVal) ;
			else
				return r ;
			
		} else {
			int c = searchVal.compareTo(midVal) ;			
			if(c == 0) {
				return m ;
			} else if (c < 0) {
				//  found text, less than ;
				return binarySearch(arr, i, m, searchVal) ;			
			} else {
				//  found text on right ;
				return binarySearch(arr, m+1, j, searchVal) ;
			}			
		}

	}

}

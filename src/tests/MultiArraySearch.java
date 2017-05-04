package tests;

public class MultiArraySearch {

	public static void main(String[] args) {
		int[][] arr = {
				{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}				
		} ;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				MatrixResult r = search(arr, arr[i][j]) ;
				System.out.println(r + ", Counter:  " + counter);		
				counter = 0 ;
			}
		}
		
	}
	
	public static int counter ;
	public static MatrixResult search(int[][] arr, int searchVal) {
		
		MatrixResult m = new MatrixResult() ;
		m.r = -1 ;
		m.c = -1 ;
		m.v = -1 ;
		
		for (int i = 0; i < arr.length; i++) {
			counter++ ;

			int midVal = arr[0][i] ;
			
			if (searchVal == midVal) {
				m = new MatrixResult() ;
				m.r = 0 ;
				m.c = i ;
				m.v = midVal ;				
			}
			
			if (arr[i][0] <= searchVal && searchVal <= arr[i][i]) {
				if (searchVal < midVal) {					
					//  if midVal < searchVal -->  search row i ; constant i, var col 
					m = binarySearchRow(arr, i, 0, i, searchVal) ;					
				} else if (searchVal > midVal){					
					//  if midVal > searchVal -->  search col j ;  constant j, var i ;
					m = binarySearchCol(arr, i, 1, i, searchVal) ;					
				}				
			}

			if (m.v == searchVal) {
				break ;
			}

		}
						
		return m ;
	}

	
	public static MatrixResult binarySearchRow(int arr[][], int row, int x, int y, int searchVal) {
		
		counter++ ;
		
		int i = x ;
		int j = y ;
		
		//  (row, i) ..  (row,j) ;
		
		MatrixResult mr = new MatrixResult() ;
		int m = i + (j-x)/2 ;
		int midVal = arr[row][m] ;

		if (midVal == searchVal) {
			mr.r = row ;
			mr.c = m ;
			mr.v = midVal ;
			return mr ;
		}
		
		if (i >= j) {
			mr.r = -1 ;
			mr.c = -1 ;
			mr.v = -1 ;
			
			return mr ;
		}
		
		if (searchVal < midVal) {			
			return binarySearchRow(arr, row, i, m, searchVal) ;			
		} else {
			return binarySearchRow(arr, row, m+1, y, searchVal) ;						
		}
						
	}
	
	public static MatrixResult binarySearchCol(int arr[][], int col, int x, int y, int searchVal) {
		
		counter++ ;
		
		int i = x ;
		int j = y ;

		//  (i, col) ..  (j, col) ;

		int m = i + (j-i)/2 ;
		int midVal = arr[m][col] ;

		MatrixResult mr = new MatrixResult() ;		

		if (midVal == searchVal) {
			mr.r = m ;
			mr.c = col ;
			mr.v = midVal ;
			return mr ;
		}
		
		if (i >= j) {
			mr.r = -1 ;
			mr.c = -1 ;
			mr.v = -1 ;
			return mr ;
		}

		if (searchVal < midVal) {			
			return binarySearchCol(arr, col, i, m, searchVal) ;			
		} else {
			return binarySearchCol(arr, col, m+1, y, searchVal) ;						
		}
		
	}	
	
	static class MatrixResult {
		public int r ;
		public int c ;
		public int v ;
		
		public String toString() {
			return "(" + r + ", " + c + "), Val:  " + v ;
		}
	}	
}
package tests;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * given matrix MxN, set cell's row, column to 0 if cell is zero
 */
public class ZeroMatrixTest {

	public static void main(String[] args) {
		
		int[][] matrix = {
				{1, 2, 3, 5},
				{4, 5, 6, 0},
				{7, 8, 0},
				{11, 12, 13, 14},
				{15, 16, 17, 18}} ;
	
		System.out.println(Arrays.deepToString(matrix));
		zeroTestUpdate(matrix);
		System.out.println(Arrays.deepToString(matrix));

	}
	
	public static void zeroTestUpdate(int[][] matrix) {
		
		List<Integer> row = new LinkedList<Integer>() ;
		List<Integer> col = new LinkedList<Integer>() ;
				
		/*
		 * look for zero in each cell starting with 0,0;  add to row, col if 0
		 */		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {			
					row.add(i) ;
					col.add(j) ;										
				}
			}			
		}
		
		//  set all elements of row, col of zero cell to 0 ;
		for (int i = 0; i < row.size(); i++) {						
			
			int r = row.get(i) ;
			int c = col.get(i) ; 		

			matrix[r] = new int[matrix[r].length] ;
			for (int t = 0; t < matrix.length; t++) {
				if (c < matrix[t].length)
					matrix[t][c] = 0 ;
			}
			
		}
	}

}

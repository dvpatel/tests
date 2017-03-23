package tests;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		int[] inp = {45,23,11,89,77,98,4,28,65,43};

		System.out.println(Arrays.toString(inp)) ;
		Merge m = new Merge() ;
		System.out.println(Arrays.toString(m.sort(inp))); ;
		
	}
	
	static private class Merge {
		private int[] input ;
		
		public int[] sort(int[] inp) {
			
			this.input = inp ;						
			mergeSort(0, input.length-1) ;
			return input ;
			
		}
		
		private void mergeSort(int i, int j) {
			
			//  already sorted ;
			if (i == j) {
				return ;
			}
			
			if (i < j) {
				int middle = i + (j-i)/2 ;
				mergeSort(i, middle) ;
				mergeSort(middle+1, j) ;				
				merge(i, middle, j) ;
			}
			
		}

		private void merge(int start, int middle, int end) {

			int[] r = new int[input.length] ;
			for (int i = start; i <= end; i++ ) {
				r[i] = input[i] ;
			}

			int i = start;
			int j = middle+1 ;
			int k = start ;
									
			while(i <= middle && j <= end) {
				if (r[i] <= r[j]) {
					this.input[k] = r[i] ;
					i++ ;
				} else {
					this.input[k] = r[j] ;
					j++ ;
				}

				k++ ;
			}
			
			while(i <= middle) {
				this.input[k] = r[i] ;
				i++ ;
				k++ ;
			}

			while(j <= end) {
				this.input[k] = r[j] ;
				j++ ;
				k++ ;
			}
			
		}

	}
}
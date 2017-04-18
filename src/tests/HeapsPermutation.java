package tests;

/*
 * Implementation of Heap's Algorithm
 * to calculate permutation of n
 */
public class HeapsPermutation {

	public static void main(String[] args) {
		
		char[] arr = "abcd".toCharArray() ;
		int n = arr.length ;
		
		generatePermutations(arr, n) ;
	}
	
	public static void generatePermutations(char[] arr, int n) {
		
		if (n == 1) {		
			System.out.println(arr);			
		} else {
			for (int i = 0; i < n; i++) {							
				generatePermutations(arr, n-1) ;
				
				if (n % 2 != 0) {						
					//  swap 0, n-1
					swap(arr, 0, n-1) ;					
				} else {					
					//  swap i, n-1
					swap(arr, i, n-1) ;					
				}				
			}
		}	
		
	}
	
	public static void swap(char[] arr, int i, int j) {		
		char t = arr[j] ;
		arr[j] = arr[i] ;
		arr[i] = t ;		
	}

}

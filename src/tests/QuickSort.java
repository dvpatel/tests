package tests;

public class QuickSort {

	public static void main(String...args) {
		int[] input = {24, 20, 45, 21, 57, 75, 2, 56, 99, 53, 12} ;
		printArr(input) ;
		sort(input) ;
	}

	private static void sort(int[] arr) {
		int i = 0 ;
		int j = arr.length - 1 ;
		quickSort(i, j, arr) ;
		printArr(arr) ;
	}

	private static void quickSort(int p, int q, int[] arr) {

		int i = p ;
		int j = q ;
		int pivot = arr[p+(q-p)/2] ;


		while (i <= j) {
			while(arr[i] < pivot) {
				i++ ;
			}

			while(pivot < arr[j]) {
				j-- ;
			}

			if (i <= j) {
				swapArr(i, j, arr) ;
				i++ ;
				j-- ;
			}

			//printArr(arr) ;
		}


		//  p .. j;  q .. i

		if (p < j)
			quickSort(p, j, arr) ;

		if (i < q)
			quickSort(i, q, arr) ;

	}

	private static void swapArr(int i, int j, int[] arr) {
		int temp = arr[i] ;
		arr[i] = arr[j] ;
		arr[j] = temp ;
	}

	private static void printArr(int[] arr) {
		for(int i:arr){
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.print("\n") ;
	}


}
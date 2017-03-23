package tests;

public class Kadane {

	public static void main(String...args) {
		//  int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4} ;
		
		int[] a = {1, 1, 2, -5, 5, 1};
		System.out.println("Max Sum:  " + getMaxSum(a));
	}
	
	public static int getMaxSum(int[] inp) {
		int max_ending_here = 0;
		int max_so_far = 0 ;
		for (int i = 0; i < inp.length; i++) {
			max_ending_here = Integer.max(0,  max_ending_here + inp[i]) ;
			max_so_far = Integer.max(max_so_far,  max_ending_here) ;
			
			System.out.println("MaxEndingHere("+i+"):  " + max_ending_here + ",  MaxSoFar:  " + max_so_far);
		}
		
		return max_so_far ;
	}
	
	public static int getMaxSum2(int[] inp) {
		int maxSum = Integer.MIN_VALUE ;
		int maxLeft = 0 ;
		int maxRight = 0 ;
		int currentMax = 0 ;
		int left = 0 ;
		int right = 0 ;
		
		for (int i = 0; i < inp.length; i++) {
			currentMax += inp[i] ;
			if (currentMax > maxSum) {
				maxSum = currentMax;
				right = i ;
				maxLeft = left ;
				maxRight = right ;
			}
			
			if (currentMax < 0) {
				currentMax = 0 ;
				left = i+1 ;
				right = i+1 ;				
			}
		}

		System.out.println("MaxLeft:  " + maxLeft) ;
		System.out.println("MaxRight: " + maxRight);
		System.out.println("MaxSum:  " + maxSum);
		
		return maxSum ;
	}

}

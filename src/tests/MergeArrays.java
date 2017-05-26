package tests;

/*
 * Given 2 arrays, one with enough buffer to fill 2nd array,
 * sort the two in ascending order ;
 */
public class MergeArrays {

	public static void main(String[] args) {
		int[] a1 = {1, 3, 5, 0, 0, 0} ;
		int[] a2 = {2, 4, 6} ;
		mergeArrays(a1, a2) ;
		System.out.println(a1);
	}

	public static void mergeArrays(int[] a1, int[] a2) {
		
		int[] t = new int[a1.length] ;
		for (int i = 0; i < a1.length; i++) {
			
			if (i < a2.length)
				t[i] = a1[i] ;
			else
				t[i] = a2[a2.length-i] ;			
		}
		
		
		int i = a1.length ;
		int j = a2.length ;
		
				
		
		
		
	}
}

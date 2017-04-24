package tests;

import java.util.Stack;

/**
 * sort  in ascending order using single stack
 * @author Dipesh Patel
 *
 */
public class SortedStack {

	public static void main(String[] args) {
		int[] arr = {3, 5, 1, 4, 2} ;
		Stack<Integer> s = new Stack<Integer>() ;
		for (int i = 0; i < arr.length; i++) {
			s.add(arr[i]) ;
		}
		
		System.out.println(s);		
		sort(s) ;		
		System.out.println(s);

	}
	
	public static void sort(Stack<Integer> s) {		
		if (!s.isEmpty()) {
			int t = s.pop() ;
			sort(s) ;
			insert(s, t) ;
		}		
	}
		
	public static void insert(Stack<Integer> s, int t) {
	
		/*
		 * simply push if s is empty ;
		 * if t > s.peek -->  5 > 3 ;   simply push ;
		 * if t < s.peek -->  1 < 5 ;   swap with previous stack value, test again
		 */
		
		if (s.isEmpty() || t > s.peek()) {
			s.push(t) ;
		} else {
			
			System.out.println(t + ", " + s.peek() + ", " + s);
			
			int u = s.pop() ;
			insert(s, t) ;
			s.push(u) ;			
		}				
	}

}

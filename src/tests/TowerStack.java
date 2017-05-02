package tests;

import java.util.Stack;

/*
 * Given set of height, weight, for a tower that maximizes the height.
 * Condition:  base height must be greater then base+1.  For equal height, go with lower weight ;
 * Find max tower size
 */
public class TowerStack {

	public static void main(String[] args) {
		Stack<Node> s = getStack();
		// printStack(s) ;
		System.out.println("Items:  " + s.size());
		sort(s);
		System.out.println("Max Height:  " + s.size());
		printStack(s);
		System.out.println("Counter:  " + counter);
	}

	public static int counter;

	public static void sort(Stack<Node> s) {
		counter++;
		if (!s.isEmpty()) {
			Node t = s.pop();
			sort(s);
			insert(s, t);
		}
	}

	public static void insert(Stack<Node> s, Node n) {
		counter++;
		if (s.isEmpty() || n.height > s.peek().height) {
			s.push(n);
		} else if (n.height == s.peek().height) {
			// drop one with lower weight ;
			if (n.weight < s.peek().weight) {
				Node x = s.pop();
				System.out.println("Dropping:  " + x);
				s.push(n);
			}
		} else {
			Node u = s.pop();
			insert(s, n);
			s.push(u);
		}
	}

	public static Stack<Node> getStack() {
		int[] h = { 65, 70, 65, 56, 75, 60, 68 };
		int[] w = { 100, 150, 101, 90, 190, 95, 110 };
		Stack<Node> s = new Stack<Node>();
		for (int i = 0; i < h.length; i++) {
			Node n = new Node();
			n.height = h[i];
			n.weight = w[i];
			s.push(n);
		}
		return s;
	}

	public static void printStack(Stack<Node> s) {
		for (int i = 0; i < s.size(); i++) {
			System.out.println(s.get(i));
		}
	}
}

class Node {
	public int height;
	public int weight;

	public String toString() {
		return "(" + this.height + ", " + this.weight + ")";
	}
}
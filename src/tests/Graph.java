package tests;

//Java program to print BFS traversal from a given source vertex.
//BFS(int s) traverses vertices reachable from s.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	public static void main(String[] args) {

		Graph graph = new Graph() ;

		//  Utility method to create graph of nodes ;
		ArrayList<Node> nodes = createGraph(graph) ;

		graph.bfs(nodes.get(0)) ;
		System.out.println(" ");
		graph.dfs(nodes.get(0)); 
	}
	
	public Graph() {
		
	}
	
	public static ArrayList<Node> createGraph(Graph g) {
		ArrayList<Node> nodes = new ArrayList<Node>() ;
		Node n0 = new Node(0) ;
		Node n1 = new Node(1) ;
		Node n2 = new Node(2) ;
		Node n3 = new Node(3) ;
		n0.edges.add(n1) ;
		n0.edges.add(n2) ;
		n1.edges.add(n2) ;
		n2.edges.add(n0) ;
		n2.edges.add(n3) ;
		n3.edges.add(n3) ;

		nodes.add(n0) ;
		nodes.add(n1) ;
		nodes.add(n2) ;
		nodes.add(n3) ;
		return nodes ;
	}
	
	public void bfs(Node root) {

		ArrayList<Node> visited = new ArrayList<Node>() ;

		Queue<Node> q = new LinkedList<Node>() ;
		q.add(root) ;

		//  Set first node as visited;
		visited.add(root) ;
		while(!q.isEmpty()) {
			Node n = q.poll() ;
			System.out.print(" " + n.value) ;
			for(Node e : n.edges) {
				if (!visited.contains(e)) {
					q.add(e) ;
					visited.add(e) ;
				}
			}
		}
	}
	
	public void dfs(Node root) {
		ArrayList<Node> visited = new ArrayList<Node>() ;
		Stack<Node> stack = new Stack<Node>() ;
		stack.add(root) ;
		visited.add(root) ;
		while(!stack.isEmpty()) {
			Node n = stack.pop() ;
			System.out.print(" " + n.value); ;

			for (Node _n : n.edges) {
				if (!visited.contains(_n)) {
					visited.add(_n) ;
					stack.add(_n) ;
				}
			}
		}
	}
	
	public static class Node {
		
		public int value ;
		
		public ArrayList<Node> edges ;
		
		public Node(int value) {
			this.value = value ;
			this.edges = new ArrayList<Node>() ;
		}
		
	}

}
package tests;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Tree {

	private boolean isTempSet = false ;
	private int temp ;
	private boolean isBST = true ;
	
	public static int counter ;

	/**
	 * Create TreeNode given input array
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public TreeNode toTree(int arr[], int start, int end) {
		if (start > end)
			return null;

		// same as (start+end)/2, avoids overflow.
		int mid = start + (end - start) / 2;

		TreeNode node = new TreeNode(arr[mid]);
		node.left = toTree(arr, start, mid-1);
		node.right = toTree(arr, mid+1, end);
		return node;
	}



	/**
	 * Create tree from array
	 * @param Integer Array
	 * @return TreeNode
	 */
	public TreeNode createTree(int[] inp) {

		TreeNode root = new TreeNode(inp[0]) ;
		for (int i = 1; i < inp.length; i++) {
			insertTreeNode(root, inp[i]) ;			
		}

		return root ;
	}

	private void insertTreeNode(TreeNode root, int value) {

		if (value < root.value) {
			if (root.left == null) {
				root.left = new TreeNode(value) ;								
			} else {
				insertTreeNode(root.left, value) ;
			}

		} else {
			if (root.right == null) {
				root.right = new TreeNode(value) ;								
			} else {
				insertTreeNode(root.right, value) ;
			}						
		}
	}


	/**
	 * Test for Binary Tree ;
	 * @param t
	 * @return
	 */
	public boolean isBST(TreeNode t) {
		this.bstTest(t); ;
		return isBST ;
	}

	private void bstTest(TreeNode t) {

		if (t != null) {
			bstTest(t.left) ;

			if (!isTempSet) {
				isTempSet = true ;
				temp = t.value ;				
			} else {

				if (!(temp < t.value)) {
					isBST = false ;					
					return ;					
				} else {
					temp = t.value ;
				}

			}

			bstTest(t.right) ;
		}		
	}


	/**
	 * Left Order ;  
	 * @param t
	 */
	public void printLeftOrder(TreeNode t) {
		if (t != null) {
			printLeftOrder(t.left) ;
			System.out.println(t.value) ;
		}
	}

	/**
	 * Right side..
	 * @param t
	 */
	public void printRightOrder(TreeNode t) {
		if (t != null) {
			System.out.println(t.value) ;
			printRightOrder(t.right) ;
		}
	}

	/**
	 * Pre-Order;  value; left, right
	 * @param t
	 */
	public void printPreOrder(TreeNode t) {
		if (t != null) {
			System.out.println(t.value) ;
			printPreOrder(t.left) ;            
			printPreOrder(t.right) ;
		}
	}

	/**
	 * pre-order but using iteration / stack ;
	 * @param t
	 */
	public void printPreOrderIter(TreeNode t) {
		//  val;
		//  left
		//  right

		//  LIFO ;
		Stack<TreeNode> q = new Stack<TreeNode>() ;
		q.push(t) ;

		while(!q.isEmpty()) {
			TreeNode v = q.pop() ;
			System.out.println(v.value); ;

			if (v.right != null) {
				q.add(v.right) ;    			
			}    		

			if (v.left != null) {
				q.add(v.left) ;
			}

		}

	}

	/**
	 * InOrder print
	 * @param root
	 */
	public void printInOrder(TreeNode root) {

		if (root != null) {
			printInOrder(root.left) ;
			System.out.println(root.value) ;
			printInOrder(root.right) ;
		}

	}

	/**
	 * Post order print
	 * @param t
	 */
	public void printPostOrder(TreeNode t) {
		if (t != null) {
			printPostOrder(t.left) ;
			printPostOrder(t.right) ;
			System.out.println(t.value) ;               
		}
	}

	/**
	 * Level order print using Queue
	 * @param t
	 */
	public void printLevelOrderTraversal(TreeNode t) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
		queue.add(t) ;
		while(!queue.isEmpty()) {

			TreeNode _t = queue.poll() ;
			System.out.println(_t.value) ;

			if(_t.left!=null)
				queue.add(_t.left) ;

			if (_t.right!=null)
				queue.add(_t.right) ;

		}
	}

	/**
	 * Find value i in tree;
	 * @param root
	 * @param i
	 * @return
	 */

	public TreeNode find(TreeNode root, int i) {

		TreeNode current = root ;
		while(current != null) {

			if (i == current.value) {
				return current ;				
			}

			if (i < current.value) {  //  go left ;
				current = current.left ;
			} else if (i > current.value) {  //  go right;
				current = current.right ;
			}			

		}

		return null ;		
	}

	/**
	 * Get Tree Depth
	 * @param t
	 * @param level
	 * @return
	 */
	public int getDepth(TreeNode t, int level) {

		//  found leaf ;
		if (t.left == null && t.right == null) {
			return level ;			
		}

		int l = 0 ;
		int r = 0 ;
		level++ ;

		if (t.left != null) {
			l = getDepth(t.left, level) ;
		}

		if (t.right != null) {
			r = getDepth(t.right, level) ;
		}

		return (l > r) ? l : r ;		
	}

	/**
	 * Spiral print...Right to left
	 * @param t
	 */
	public void spiralTree(TreeNode t) {

		Stack<TreeNode> q = new Stack<TreeNode>() ;
		q.add(t);

		boolean dirRL = true ;
		while(!q.isEmpty()) {

			Stack<TreeNode> temp = new Stack<TreeNode>() ;

			while(!q.isEmpty()) {

				TreeNode _t = q.pop() ;
				System.out.print(" " + _t.value);

				if (dirRL) {
					if (_t.left != null) {
						temp.push(_t.left) ;
					}

					if (_t.right != null) {
						temp.push(_t.right) ;
					}

				} else {

					if (_t.right != null) {					
						temp.push(_t.right) ;
					}

					if (_t.left != null ) {
						temp.push(_t.left) ;
					}

				}
			}

			dirRL = !dirRL ;
			q = temp ;

		}

	}
	
	
	/**
	 * Print reverse nodes ;
	 * @param t
	 */
	
	public void printReverseLevelOrder(TreeNode t) {
		Queue<TreeNode> q = new LinkedList<TreeNode>() ;
		q.add(t) ;
		
		Stack<TreeNode> r = new Stack<TreeNode>() ;

		while(!q.isEmpty()) {
			
			TreeNode _t = q.poll() ;			
			if (_t.right != null) {
				q.add(_t.right) ;				
			}
			
			if (_t.left!= null) {
				q.add(_t.left) ;
			}	
			
			r.push(_t) ;
		}

		while(!r.isEmpty()) {
			System.out.println(r.pop().value);
		}
		
	}

	/**
	 *  Minimum value in tree ;
	 * @param t
	 * @return
	 */
	public int getMin(TreeNode t) {
		Queue<TreeNode> q = new LinkedList<TreeNode>() ;
		q.add(t) ;

		int min = Integer.MAX_VALUE ;
		while(!q.isEmpty()) {
			TreeNode _t = q.poll() ;

			if (_t.value < min) {
				min = _t.value ;
			}			

			if (_t.left != null) 
				q.add(_t.left) ;

			if (_t.right != null)
				q.add(_t.right) ;
		}

		return min ;

	}

	/**
	 * Left size / count
	 * @param t
	 * @return
	 */
	public int leafSize(TreeNode t) {

		int count = 0 ;
		Queue<TreeNode> q = new LinkedList<TreeNode>() ;
		q.add(t) ;
		while(!q.isEmpty()) {

			TreeNode _t = q.poll() ;

			if (_t.left == null && _t.right == null) {
				count++ ;
				System.out.println(_t.value);
			}

			if (_t.left != null) {
				q.add(_t.left) ;
			}

			if (_t.right != null) {
				q.add(_t.right) ;
			}			
		}
		return count ;

	}

	/**
	 * Total number of nodes.
	 * @param t
	 * @return
	 */

	public int totalNodes(TreeNode t) {
		Queue<TreeNode> q = new LinkedList<TreeNode>() ;

		q.add(t) ;

		int c = 0 ;
		while(!q.isEmpty()) {
			c++ ;

			TreeNode _t = q.poll() ;

			if (_t.left != null) {
				q.add(_t.left) ;				
			}

			if (_t.right != null) {
				q.add(_t.right) ;
			}			
		}

		return c ;

	}

	/**
	 * Print root to leaf
	 * @param t
	 * @param path
	 * @param start
	 */
	public void printRootToLeaf(TreeNode t, int[] path, int start) {
		
		//  At leaf.
		if (t != null && t.right == null && t.left == null) {						
			path[start] = t.value ;
			for (int i = 0; i <= start; i++ ) {
				System.out.print(" " + path[i]); ;
			}
			System.out.println("");
		}
		
		//  Bump counter and keep iterating ;
		if (t != null) {
			
			path[start] = t.value ;
			++start ;
			
			printRootToLeaf(t.left, path, start) ;			
			printRootToLeaf(t.right, path, start) ;		
			
		}		
		
	}
	
	/**
	 * Print vertical sum for binary tree ;
	 * @param t
	 * @param total
	 * @param level
	 */
	public void printVerticalSum(TreeNode t, Map<Integer, Integer> total, int level) {

		/*
		 * For each node, calculate total value based on
		 * t.value and stored value in Map
		 */
		int _t = (total.get(level) == null) ? 0 : total.get(level) ; 			
		total.put(level, _t + t.value) ;			

		if (t.left != null) {
			//  shift left ;
			printVerticalSum(t.left, total, level-1) ;
		}
			
		if (t.right != null) {
			printVerticalSum(t.right, total, level+1) ;			
		}
		
	}
	
	/**
	 * Print sum each level ;
	 * @param t
	 */
	public void printHorizontalSum(TreeNode t) {
		
		Queue<TreeNode> q = new LinkedList<TreeNode>() ;
		q.add(t) ;
		
		int total = 0 ;
		while(!q.isEmpty()) {
			
			Queue<TreeNode> tempQueue = new LinkedList<TreeNode>() ;			
			while(!q.isEmpty()) {
				TreeNode _t = q.poll() ;
				total = total + _t.value ;
				
				if (_t.left != null) {
					tempQueue.add(_t.left) ;
				}
				
				if (_t.right != null) {
					tempQueue.add(_t.right) ;
				}
			}

			System.out.println(total); ;		
			total = 0 ;
			q = tempQueue ;			
		}		
	}
	
	
	/**
	 * Print bound numbers 
	 * @param t
	 */
	public void printTreeBoundary(TreeNode t) {
		//  print left edge, excluding leaf
		//  print leaf ;
		//  print right edge, excluding leaf ;
		
		System.out.print(" " + t.value);	
		printLeftEdge(t.left) ;

		printLeaf(t) ;
				
		printRightEdge(t.right) ;
		System.out.println(" ") ;
				
	}
	
	private void printLeaf(TreeNode t) {
		
		if (t != null) {

			if (t.left == null && t.right == null) {
				System.out.print("-" + t.value);				
			}
			
			printLeaf(t.left) ;
			printLeaf(t.right) ;
		}
		
	}
	
	private void printLeftEdge(TreeNode t) {
		
		if (t != null && t.left != null) {
			System.out.print("-" + t.value) ;			
			printLeftEdge(t.left) ;			
		}

		if (t != null && t.left == null && t.right != null) {
			System.out.print("-" + t.value) ;
			printLeftEdge(t.right) ;
		}

	}

	private void printRightEdge(TreeNode t) {
		
		if (t != null && t.right != null) {
			System.out.print("-" + t.value) ;
			printRightEdge(t.right) ;
		}
		
		if (t != null && t.left != null && t.right == null) {
			System.out.print("-" + t.value) ;
			printRightEdge(t.left) ;
		}
		
	}

	/**
	 * Find lowest common ancestory between 2 nodes, a and b ;
	 */
	public TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b) {
		
		counter++ ;
		
		if (root == null) {	
			return null ;
		}
		
		int lval = a.value ;
		int rval = b.value ;
		int rootVal = root.value ;
		
		if (lval < rootVal && rval < rootVal) {
			//  go left ;
			return findLCA(root.left, a, b) ;
		} else if (lval > rootVal && rval > rootVal) {
			return findLCA(root.right, a, b) ;			
		} else if (lval < rootVal && rootVal < rval){
			return root ;
		}
		
		return null ;
	}
	
	/**
	 * Calculate diameter between max nodes;
	 * @param t
	 * @return
	 */
	public int diameter(TreeNode t) {
		
		if (t == null) 
			return 0;

	    int lheight = height(t.left);
	    int rheight = height(t.right);

	    int ldiameter = diameter(t.left);
	    int rdiameter = diameter(t.right);
	    
	    return Math.max(lheight + rheight + 1,
		       Math.max(ldiameter,rdiameter));
		
	}
	
	public int height(TreeNode t) {
		if (t == null) {
            return 0;
		}

		return 1 + Math.max(height(t.left), height(t.right));		
	}
	
}

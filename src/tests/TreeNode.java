package tests;

public class TreeNode {

	public int value ;
	public TreeNode left ;
	public TreeNode right ;

	public TreeNode(int val) {
		this.value = val ;
	}

	public boolean isLeaf() {
		return (this.left == null && this.right == null) ;
	}
	
	public String toString() {
		return "NodeVal: "  + this.value ;
	}
}

package tests;

import java.util.Map;
import java.util.TreeMap;

public class TreeTest {

	public static void main(String[] args) {
		
		//int[] i = {40, 20, 60, 10, 30, 50, 70} ;

		//int[] i = {40, 20, 60, 10, 30, 50, 70, 5, 55, 45} ;

		//int[] i = {40, 20, 60, 10, 30, 50, 70, 5} ;
		
		//int[] i = {11, 6, 8, 19, 4, 10, 5, 17, 43, 49, 31} ;

        Tree tu = new Tree() ;
        TreeNode root = createTree();
        
        
        
        //System.out.println(tu.getDepth(root, 0)) ;
        
        //tu.printLevelOrderTraversal(root);        
        //System.out.println(tu.isBST(t)) ;        
        
        //isBTS(t) ;
        //System.out.println("IsBST:  " + isBST) ;
        

        /*
		Map<Integer, Integer> total = new TreeMap<Integer, Integer>() ;		
        tu.printVerticalSum(root, total, 0);
        for (Integer k : total.keySet()) {        	
        	System.out.println("K  " + k + ", V:  " + total.get(k));
        }*/
        
        
        int[] path = new int[100] ;
        tu.printRootToLeaf(root, path, 0);

        System.out.println("-------------- ");
        

        System.out.println("Diameter:  " + tu.diameter(root));
        
        System.out.println("-------------- ");
        
        tu.printTreeBoundary(root);

        System.out.println("-------------- ");

        System.out.println("LCA(5, 30):  " + tu.findLCA(root,  new TreeNode(5),  new TreeNode(30)).value + ", Counter:  " + tu.counter)  ;

	}

    private static TreeNode createTree() {
    	
    	TreeNode t40 = new TreeNode(40) ;    	
    	TreeNode t20 = new TreeNode(20) ;
    	TreeNode t60 = new TreeNode(60) ;
    	t40.left = t20 ;
    	t40.right = t60 ;

    	TreeNode t10 = new TreeNode(10) ;
    	TreeNode t30 = new TreeNode(30) ;

    	t20.left = t10 ;
    	t20.right = t30 ;
    	
    	TreeNode t50 = new TreeNode(50) ;
    	TreeNode t70 = new TreeNode(70) ;

    	t60.left = t50 ;
    	t60.right = t70 ;    	
    	
    	TreeNode t5 = new TreeNode(5) ;
    	TreeNode t55 = new TreeNode(55) ;
    	
    	t10.left = t5 ;
    	t50.right = t55 ;
    	    	
        return t40;
    }
	
}

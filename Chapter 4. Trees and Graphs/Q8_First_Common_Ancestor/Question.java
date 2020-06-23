package Q8_First_Common_Ancestor;

public class Question {
	/*
		Chapter 4 Problem 8
		Design an algorithm and write code to find the first common ancestor of two nodes
		in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This
		is not necessarily a binary search tree.
		

		Time Complexity:  O()
		Space Complexity: O()
	*/

	public static void main(String[] args) {
		//create test data
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int num1, num2;
		num1 = 3;
		num2 = 9;
		if(args.length > 1){
			num1 = Integer.parseInt(args[0]);
			num2 = Integer.parseInt(args[1]);
		}
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode p = root.find(num1);
		TreeNode q = root.find(num2);
		//output tree
		root.print();
		System.out.println("Looking for first common ancestor of "+num1+" and "+num2+":");
		//solve
		TreeNode ancestor = commonAncestor(root, p, q);
		//output results
		if (ancestor != null) {
			System.out.println(ancestor.data);
		} else {
			System.out.println("null");
		}
	}

	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Result r = commonAncestorHelper(root, p, q);
		if (r.isAncestor) {
			return r.node;
		}
		return null;
	}

	public static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return new Result(null, false);
		}
		if (root == p && root == q) {
			return new Result(root, true);
		}
		
		Result rx = commonAncestorHelper(root.left, p, q);
		if (rx.isAncestor) { // Found common ancestor
			return rx;
		}
		
		Result ry = commonAncestorHelper(root.right, p, q);
		if (ry.isAncestor) { // Found common ancestor
			return ry;
		}
		
		if (rx.node != null && ry.node != null) {
			return new Result(root, true); // This is the common ancestor
		} else if (root == p || root == q) {
			/* If we're currently at p or q, and we also found one of those
			 * nodes in a subtree, then this is truly an ancestor and the
			 * flag should be true. */
			boolean isAncestor = rx.node != null || ry.node != null;
			return new Result(root, isAncestor);
		} else {
			return new Result(rx.node != null ? rx.node : ry.node, false);
		}
	}	
	

	/*Wrapper Result Class
		This aids to distinguish between two cases
		 Case 1: p is a child of q (or q is a child of p)
		 Case 2: p is in the tree but q is not (or q is in the tree and p is not)
	*/
	public static class Result {
		public TreeNode node;
		public boolean isAncestor;
		public Result(TreeNode n, boolean isAnc) {
			node = n;
			isAncestor = isAnc;
		}
	}


}
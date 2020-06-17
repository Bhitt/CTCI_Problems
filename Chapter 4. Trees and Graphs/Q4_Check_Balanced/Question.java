package Q4_Check_Balanced;

public class Question {
	/*
		Chapter 4 Problem 4
		Implement a function to check if a binary tree is balanced. For the purpose of this
		question, a balanced tree is defined to be a tree such that the heights of the two
		subtrees of any node never differ by more than one.


		Time Complexity:  O(N)
		Space Complexity: O(H) where H is the height of the tree
	*/

	public static void main(String[] args){
		//create the test data (balanced tree)
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);

		//output
		System.out.println();
		root.print();
		System.out.println("Is balanced: " + isBalanced(root));
		
		//make inbalanced by adding a 4
		root.insertInOrder(4);

		//order
		System.out.println();
		root.print();
		System.out.println("Is balanced: " + isBalanced(root));
		
	}

	public static boolean isBalanced(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	public static int checkHeight(TreeNode root) {
		if (root == null) {
			return -1;
		}
		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Propagate error up
		
		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Propagate error up
		
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE; // Found error -> pass it back
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}
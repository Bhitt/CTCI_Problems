package Q5_Validate_BST;

public class Question {
	/*
		Chapter 4 Problem 5
		Implement a function to check if a binary tree is a binary search tree.


		Time Complexity:  O(N)
		Space Complexity: O(log N) if it is balanced
	*/

	public static void main(String[] args) {
		//create test data
		int[] array = {1, 2, 3, 4,5,6,7,8,9,10};
		TreeNode node = TreeNode.createMinimalBST(array);
		//output
		node.print();
		System.out.println(checkBST(node));

		//test();  //This will test if it works on values that are equal
	}

	public static Integer lastPrinted = null;

	public static boolean checkBST(TreeNode node) {
		return checkBST(node, true);
	}

	// Allow "equal" value only for left child. This validates the BST property.
	public static boolean checkBST(TreeNode n, boolean isLeft) {
		if (n == null) {
			return true;
		}
		
		// Check / recurse left
		if (!checkBST(n.left, true)) {
			return false;
		}
		
		// Check current
		if (lastPrinted != null) {
			if (isLeft) {
				// left child "is allowed" be equal to parent.
				if (n.data < lastPrinted) {
					return false;
				}
			} else {
				// Right child "is not allowed" be equal to parent.
				if (n.data <= lastPrinted) {
					return false;
				}
			}
		}
		lastPrinted = n.data;
		
		// Check / recurse right
		if (!checkBST(n.right, false)) {
			return false;
		}
		return true;
	}

	public static void test() {
		TreeNode node;
		boolean condition;
		System.out.println("test cases for equals condition.");

		/* Expect true: for left child: node.data <= last_printed.
   2
  / \
 /   \
 2   3
      \
      4
		*/
		int[] array2 = {1, 2, 3, 4};
		node = TreeNode.createMinimalBST(array2);
		node.left.data = 2;
		node.print();
		lastPrinted = null;
		condition = checkBST(node);
		System.out.println("should be true: " + condition);

		/* Expect false: for right child: node.data <= last_printed.
   2
  / \
 /   \
 1   2
      \
      4
		 */
		int[] array3 = {1, 2, 3, 4};
		node = TreeNode.createMinimalBST(array3);
		node.right.data = 2;
		node.print();
		lastPrinted = null;
		condition = checkBST(node);
		System.out.println("should be false: " + condition);
	}
}
package Q10_Check_Subtree;

public class Question {
	/*
		Chapter 4 Problem 10
		T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create
		an algorithm to determine if T2 is a subtree of T1.
		
		Time Complexity:  O(n + m), where n and m are the number of nodes in T1 and T2
		Space Complexity: O(n + m)

		NOTE: another solution exists that uses O(logn + logm) memory and possibly less
		runtime depending on assumptions made.
	*/

	public static void main(String[] args) {
		// t2 is a subtree of t1
		int[] array1 = {1, 2, 1, 3, 1, 1, 5};
		int[] array2 = {2, 3, 1};
		
		TreeNode t1 = createTreeFromArray(array1);
		TreeNode t2 = createTreeFromArray(array2);

		System.out.println("T1:");
		t1.print();
		System.out.println();

		System.out.println("T2:");
		t2.print();
		System.out.println();

		if (containsTree(t1, t2)) {
			System.out.println("T2 is a subtree of T1 \n");
		} else {
			System.out.println("T2 is not a subtree of T1 \n");
		}

		// t4 is not a subtree of t3
		int[] array3 = {1, 2, 3};
		TreeNode t3 = createTreeFromArray(array1);
		TreeNode t4 = createTreeFromArray(array3);

		System.out.println("T3:");
		t3.print();
		System.out.println("\n");

		System.out.println("T4:");
		t4.print();
		System.out.println("\n");

		if (containsTree(t3, t4)) {
			System.out.println("T4 is a subtree of T3");
		} else {
			System.out.println("T4 is not a subtree of T3");
		}
		
	}

	public static boolean containsTree(TreeNode t1, TreeNode t2) {
		StringBuilder string1 = new StringBuilder();
		StringBuilder string2 = new StringBuilder();
		
		getOrderString(t1, string1);
		getOrderString(t2, string2);
		
		return string1.indexOf(string2.toString()) != -1;
	}

	public static void getOrderString(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("X");             // Add null indicator
			return;
		}
		sb.append(node.data);           // Add root 
		getOrderString(node.left, sb);  // Add left
		getOrderString(node.right, sb); // Add right
	}

	/* Creates tree by mapping the array left to right, top to bottom. */
	public static TreeNode createTreeFromArray(int[] array) {
		if (array.length > 0) {
			TreeNode root = new TreeNode(array[0]);
			java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
			queue.add(root);
			boolean done = false;
			int i = 1;
			while (!done) {
				TreeNode r = (TreeNode) queue.element();
				if (r.left == null) {
					r.left = new TreeNode(array[i]);
					i++;
					queue.add(r.left);
				} else if (r.right == null) {
					r.right = new TreeNode(array[i]);
					i++;
					queue.add(r.right);
				} else {
					queue.remove();
				}
				if (i == array.length) {
					done = true;
				}
			}
			return root;
		} else {
			return null;
		}
	}

}
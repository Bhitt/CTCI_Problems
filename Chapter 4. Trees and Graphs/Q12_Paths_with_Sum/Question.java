package Q12_Paths_with_Sum;

import java.util.HashMap;

public class Question {
	/*
		Chapter 4 Problem 12
		You are given a binary tree in which each node contains an integer value (which
		might be positive or negative). Design an algorithm to count the number of paths
		that sum to a given value. The path does not need to start or end at the root or
		a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
		
		Time Complexity:  O(N) because we visit each node once, doing O(1) work
		Space Complexity: O(logn) for a balanced tree, it grows to O(N) in an unbalanced tree
	*/

	public static void main(String[] args) {
		//create test data
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);		
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(-8);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);	
		root.right.left.left = new TreeNode(0);
		root.print();
		System.out.println("Target Sum: 0");
		System.out.print("Paths with sum: ");
		System.out.println(countPathsWithSum(root, 0));
		
		
		/*TreeNode root = new TreeNode(-7);
		root.left = new TreeNode(-7);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(20);
		root.right.right.left = new TreeNode(0);
		root.right.right.left.left = new TreeNode(-3);
		root.right.right.left.left.right = new TreeNode(2);
		root.right.right.left.left.right.left = new TreeNode(1);
		root.print();
		System.out.println("Target Sum: 0");
		System.out.print("Paths with sum: ");
		System.out.println(countPathsWithSum(root, 0));*/
		
		/*TreeNode root = new TreeNode(0);
		root.left = new TreeNode(0);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.left.right = new TreeNode(0);
		root.right.right = new TreeNode(0);
		root.print();
		System.out.println("Target Sum: 0");
		System.out.print("Paths with sum:");
		System.out.println(countPathsWithSum(root, 0));
		System.out.println("Target Sum: 4");
		System.out.print("Paths with sum:");
		System.out.println(countPathsWithSum(root, 4));*/
	}

	public static int countPathsWithSum(TreeNode root, int targetSum) {
		return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
	}
	
	public static int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
		if (node == null) return 0; // Base case
		
		runningSum += node.data;
		
		/* Count paths with sum ending at the current node. */
		int sum = runningSum - targetSum;
		int totalPaths = pathCount.getOrDefault(sum, 0);
		
		/* If runningSum equals targetSum, then one additional path starts at root. Add in this path.*/
		if (runningSum == targetSum) {
			totalPaths++;
		}

		/* Add runningSum to pathCounts. */
		incrementHashTable(pathCount, runningSum, 1);
		
		/* Count paths with sum on the left and right. */
		totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
		totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
		
		incrementHashTable(pathCount, runningSum, -1); // Remove runningSum
		return totalPaths;
	}

	public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
		int newCount = hashTable.getOrDefault(key, 0) + delta;
		if (newCount == 0) { // Remove when zero to reduce space usage
			hashTable.remove(key);
		} else {
			hashTable.put(key, newCount);
		}
	}


}
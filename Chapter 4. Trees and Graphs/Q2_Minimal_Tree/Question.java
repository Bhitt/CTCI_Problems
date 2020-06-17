package Q2_Minimal_Tree;

public class Question{
	/*
		Chapter 4 Problem 2
		Given a sorted (increasing order) array with unique integer elements, write an
		algorithm to create a binary search tree with  minimal height.
		
	*/

	public static void main(String[] args){
		//create the test data
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		//output
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root: " + root.data);
		System.out.println("Created BST: " + root.isBST());
		System.out.println("Height: " + root.height());
		System.out.println();
		root.print();
	}
}
package Q3_List_of_Depths;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class QuestionBFS {
	/*
		Chapter 4 Problem 3
		Given a binary tree, design an algorithm which creates a linked list
		of all the nodes at each depth (e.g., if you have a tree depth D, 
		you'll have D linked lists).

		Time Complexity:  O(N)
		Space Complexity: O(N)
	*/

	public static void main(String[] args){
		//create the test data
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = createTreeFromArray(nodes_flattened);
		//solve problem
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		//output
		root.print();
		printResult(list);
	}

	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		//create an array list of linked lists (containing tree nodes) as a result
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		/* "Visit" the root */
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if (root != null) {
			current.add(root);
		}
		
		while (current.size() > 0) {
			result.add(current); // Add previous level
			LinkedList<TreeNode> parents = current; // Go to next level
			current = new LinkedList<TreeNode>(); 
			for (TreeNode parent : parents) {
				/* Visit the children */
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}

		return result;
	}
	
	public static void printResult(ArrayList<LinkedList<TreeNode>> result){
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
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
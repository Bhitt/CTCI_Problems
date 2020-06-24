package Q11_Random_Node;

public class Question {
	/*
		Chapter 4 Problem 11
		You are implementing a binary tree class from scratch which, in addition to insert,
		find, and delete, has a method getRandomNode() which returns a random node from the
		tree. All nodes should be equally likely to be chosen. Design and implement an 
		algorithm for getRandomNode(), and explain how you would implement the rest of 
		the methods.
		
		Time Complexity:  O(logn) for balanced tree, O(D) otherwise where D is the depth
	*/

	public static void main(String[] args) {
		//create test data
		int[] counts = new int[10];
		for (int i = 0; i < 1000000; i++) {
			Tree tree = new Tree();
			int[] array = {1, 0, 6, 2, 3, 9, 4, 5, 8, 7};
			for (int x : array) {
				tree.insertInOrder(x);
			}
			int d = tree.getRandomNode().data;
			counts[d]++;
		}
		
		//output results
		for (int i = 0; i < counts.length; i++) {
			//the counts should all be close to the same value
			System.out.println(i + ": " + counts[i]);
		}
		
	}

}
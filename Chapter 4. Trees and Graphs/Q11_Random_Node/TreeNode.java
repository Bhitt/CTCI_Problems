package Q11_Random_Node;

import java.util.Random;

/* One node of a binary tree. The data element is stored in a single character */
public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	public int size = 0;

	public TreeNode(int d){
		data = d;
		size = 1;
	}

	public void insertInOrder(int d){
		if(d <= data){
			if(left == null){
				left  =  new TreeNode(d);
			} else {
				left.insertInOrder(d);
			}
		} else {
			if(right == null){
				right = new TreeNode(d);
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}

	public int size(){
		return size;
	}

	public TreeNode find(int d){
		if(d == data){
			return this;
		} else if(d <= data){
			return left != null ? left.find(d) : null;
		} else if(d > data){
			return right != null ? right.find(d) : null;
		}
		return null;
	}

	public TreeNode getRandomNode(){
		//find the size of the left sub-tree
		int leftSize = left == null ? 0 : left.size();
		Random random = new Random();
		int index = random.nextInt(size);
		//if the index is less than the left sub-tree, grab it from the left
		if(index < leftSize){
			return left.getRandomNode();
		} else if (index == leftSize){ //if the index is equal, then grab the current node
			return this;
		} else {
			return right.getRandomNode();
		}
	}

	public TreeNode getIthNode(int i){
		int leftSize = left == null ? 0 : left.size();
		if(i < leftSize) {
			//must be on the left side
			return left.getIthNode(i);
		} else if(i == leftSize) {
			//this is the correct node, so return it
			return this;
		} else {
			//skip the left side, or in other words skip the leftSize + 1 nodes
			return right.getIthNode(i - (leftSize + 1));
		}
	}
}
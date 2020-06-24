package Q11_Random_Node;

import java.util.Random;

public class Tree {
	TreeNode root = null;

	public void insertInOrder(int value){
		if(root == null){
			root = new TreeNode(value);
		} else {
			root.insertInOrder(value);
		}
	}

	public int size(){
		return root == null ? 0 : root.size();
	}

	public TreeNode getRandomNode(){
		//no data in tree
		if(root == null) return null;
		//grab the ith node
		Random random = new Random();
		int i = random.nextInt(size());
		return root.getIthNode(i);
	}
}
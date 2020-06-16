public class DeleteMiddleNode {
	/*
		Chapter 2 Problem 3
		Implement an algorithm to delete a node in the middle (i.e. any node but
		the first and last node, not necessarily the exact middle) of a singly linked
		list, given access to only the first node
		Example: 
			Input: node c from list a -> b -> c -> d -> e -> f
			Result: 				a -> b -> d -> e -> f
	*/

	/*
		Time Complexity: O(1)
		Space Complexity: O(1)
	*/
	public static void main(String[] args){
		//create the sample data
		LinkedListNode head = createLinkedList();
		printLinkedList(head);
		int nodePosition = 4;
		if(args.length > 0) nodePosition = Integer.parseInt(args[0]);
		LinkedListNode chosenNode = getNthNode(head, nodePosition);
		//output the results
		System.out.println("DeleteMiddleNode: "+chosenNode.data);
		solution(chosenNode);
		printLinkedList(head);
	}

	public static void solution(LinkedListNode n){
		//check for null
		if(n == null || n.next == null) return;
		//otherwise, copy the data from the next node to the current node
		n.data = n.next.data;
		//delete the next node (point next at the following node)
		n.next = n.next.next;
	}

	/*
		Note, this would not be possible to delete the last node. You would
		need to be able to mark it as a dummy or something along those lines.
	*/

	public static LinkedListNode getNthNode(LinkedListNode node, int n){
		//starting from the head
		for(int i=0;i<n-1;i++){
			if(node == null) return null;
			node = node.next;
		}
		//return the nth node if it exists
		return node;
	}


	public static LinkedListNode createLinkedList(){
		//create the head node
		LinkedListNode head = new LinkedListNode(1);
		//add more nodes
		for(int i=1;i<10;i++){
			head.appendToTail(i+1);
		}
		//return the head node
		return head;
	}

	public static void printLinkedList(LinkedListNode node){
		LinkedListNode current = node;
		while(current != null){
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println();
	}
}

/* NOTE
This node class for a singly linked list does not contain a wrapper class 'LinkedList' since
we are assuming that only one object will be using a reference to the head node which
could be changed. In other implementations, it might be necessary to include the
wrapper class which always maintains a reference to the head node.
*/
class LinkedListNode {
	public LinkedListNode next;
	public int data;


	public LinkedListNode(int d){
		data = d;
	}

	public LinkedListNode(){}

	public void appendToTail(int d){
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}
}
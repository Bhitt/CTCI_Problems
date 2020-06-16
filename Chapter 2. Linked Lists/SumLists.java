import java.util.Random;
public class SumLists {
	/*
		Chapter 2 Problem 5
		You have two numbers represented by a linked list, where each node contains a
		single digit. The digits are stored in reverse order, such that the 1's digit
		is at the head of the list. Write a function that adds the two numbers and
		returns the sum as a linked list.

		Example
			Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
			Output: 2 -> 1 -> 9. That is, 912. 
	*/

	/*
		Time Complexity: O(n)
		Space Complexity: O(n)
	*/
	public static void main(String[] args){
		//create test data
		LinkedListNode head1 = createLinkedList();
		LinkedListNode head2 = createLinkedList();
		printLinkedList(head1);
		printLinkedList(head2);
		System.out.println("Sum of the Lists: ");
		printLinkedList(addLists(head1,head2,0));
	}

	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry){
		//end of summing
		if(l1 == null && l2 == null && carry == 0) return null;
		//create a new node
		LinkedListNode result = new LinkedListNode();
		//hold onto the carry
		int value = carry;
		//add the two values if they exist
		if(l1 != null) value += l1.data;
		if(l2 != null) value += l2.data;
		//the result is the second digit of the total
		result.data = value %10;
		//recursive call
		if(l1 != null || l2 != null){
			LinkedListNode more = addLists(l1 == null ? null : l1.next,
											l2 == null ? null : l2.next,
											value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	}

	public static LinkedListNode createLinkedList(){
		//Random seed
		Random rand = new Random();
		//create the head node
		LinkedListNode head = new LinkedListNode(rand.nextInt(9));
		//determine the amount of nodes for the number (3 or 4 total including head node)
		int nodeCount = rand.nextInt(2) + 2;
		//add more nodes
		for(int i=0;i<nodeCount;i++){
			head.appendToTail(rand.nextInt(10));
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
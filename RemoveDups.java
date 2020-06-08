import java.util.Random;
import java.util.*; 

public class RemoveDups {
	/*
		Chapter 2 Problem 1
		Write code to remove duplicates from an unsorted linked list.
	*/

	/*
		Time Complexity: O(n)
		Space Complexity: O(n)
	*/
	public static void main(String[] args){
		//output results
		LinkedListNode head = createLinkedList();
		printLinkedList(head);
		System.out.println("Removing Duplicates: ");
		solution(head);
		printLinkedList(head);
	}

	public static void solution(LinkedListNode n){
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous  = null;
		while(n != null){
			if(set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		} 

	}

	/*
		If we did not have a buffer, we would instead iterate with two pointers: current
		which iterates through the linked list, and runner which checks all subsequent nodes
		for duplciates. This code runs in O(1) space but O(n^2) time.
	*/

	public static LinkedListNode createLinkedList(){
		//Random seed
		Random rand = new Random();
		//create the head node
		LinkedListNode head = new LinkedListNode(rand.nextInt(10));
		//add more nodes
		for(int i=0;i<9;i++){
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




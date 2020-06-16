import java.util.Random;

public class Partition {
/*
		Chapter 2 Problem 4
		Write code to partition a linked list around a value x, such that all
		nodes less than x come before all nodes greater than or equal to x. If
		x is contained within the list, the values of x only need to be after
		the elements less than x. The partition element x can appear anywhere
		in the "right partition"; it does not need to appear between the left
		and right partitions.

		Example:
			Input: 	3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
			Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
	*/

	/*
		Time Complexity: O()
		Space Complexity: O()
	*/
	public static void main(String[] args){
		//creating the sample data
		LinkedListNode head = createLinkedList();
		printLinkedList(head);
		int x = 5;
		if(args.length > 0){
			x = Integer.parseInt(args[0]);
		}
		//output the results
		System.out.println("Partition:"+x);
		head = solution(head,x);
		printLinkedList(head);
	}

	public static LinkedListNode solution(LinkedListNode n, int x){
		//check for null
		if(n == null || n.next == null) return null;
		//use two pointers to separate elements based on the partition
		LinkedListNode head = n;
		LinkedListNode tail = n;
		//loop through and add nodes to either side
		while(n != null){
			LinkedListNode next = n.next;
			if(n.data < x){
				//insert at the head
				n.next = head;
				head = n;
			} else {
				//insert at the tail
				tail.next = n;
				tail = n;
			}
			n = next;
		}
		tail.next = null;
		//the head changed so return it to the user
		return head;
	}

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
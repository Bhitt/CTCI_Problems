public class LoopDetection {
	/*
		Chapter 2 Problem 8
		Given a circular linked list, implement an algorithm that returns the node
		at the beginning of the loop

		Definition:
			Circular linked list: A (corrupt) linked list in which the node's next pointer
			points to an earlier node, so as to make a loop in the linked list.

		Example:
			Input: A -> B -> C -> D -> E -> C [the same C as earlier]
			Output: C
	*/

	/*
		Time Complexity: O(n)
		Space Complexity: O(1)
	*/
	public static void main(String[] args){
		//create the test data
		LinkedListNode head = createLinkedList();
		LinkedListNode tail = getTail(head);
		int c = 3;
		if(args.length > 0) c = Integer.parseInt(args[0]);
		corruptList(head, tail, c);
		printLinkedList(head);
		//output the solution
		System.out.println("Detecting the Loop: ");
		System.out.print(solution(head).data);
	}

	public static LinkedListNode solution(LinkedListNode n){
		//two pointer method to find where they collide
		LinkedListNode fast = n;
		LinkedListNode slow = n;
		//follow pointers until collision if a loop exists or null if it doesn't
		//collision should be at LOOP_SIZE - k steps
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast) break; //collision
		}
		//error checking, no meeting point means no loop
		if(fast == null || fast.next == null) return null;
		//move slow to head, keep fast at meeting point, each are now k steps
		//from the loop start
		slow = n;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		//both should now point to the start of the loop
		return fast;
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

	public static void corruptList(LinkedListNode head, LinkedListNode tail, int c){
		//move forward to node c and connect the tail to that node
		for(int i=0;i<c-1;i++){
			if(head.next == null) return;
			head = head.next;
		}
		tail.next = head;
	}

	public static LinkedListNode getTail(LinkedListNode node){
		while(node.next != null){
			node  = node.next;
		}
		return node;
	}

	public static void printLinkedList(LinkedListNode node){
		System.out.println("Printing 20 nodes...");
		LinkedListNode current = node;
		for(int i=0;i<20;i++){
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
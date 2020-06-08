public class ReturnKthToLast {
	/*
		Chapter 2 Problem 2
		Implement an algorithm to find the kth to last element of a singly 
		linked list
	*/

	/*
		Time Complexity: O(n)
		Space Complexity: O(1)
	*/
	public static void main(String[] args){
		//creating the sample data
		LinkedListNode head = createLinkedList();
		printLinkedList(head);
		int k = 2;
		if(args.length > 0){
			k = Integer.parseInt(args[0]);
		}
		//output the results
		System.out.println("Return kth to last, k:"+k);
		System.out.println(solution(head,k).data);
	}

	public static LinkedListNode solution(LinkedListNode n, int k){
		//hold two pointers
		LinkedListNode p1 = n;
		LinkedListNode p2 = n;
		//move the first pointer k steps forward
		for(int i=0;i<k;i++){
			if(p1 == null) return null; //out of bounds
			p1 = p1.next;
		}
		/*move both pointers at the same time until the first pointer
		hits the end */
		while(p1 != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		//return the second pointer which should now be the Length - k node
		return p2;
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
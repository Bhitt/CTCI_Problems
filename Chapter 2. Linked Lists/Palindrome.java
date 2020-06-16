import java.util.*; 
public class Palindrome {
	/*
		Chapter 2 Problem 6
		Implement a function to check if a linked list is a palindrome
	*/

	/*
		Time Complexity: O(n)
		Space Complexity: O(n)
	*/

	public static void main(String[] args){
		//create test data
		String s = "aibohphobia";
		if(args.length > 0) s = args[0];
		//output results
		LinkedListNode head = createLinkedList(s);
		printLinkedList(head);
		System.out.println("Is "+s+" a palindrome?: ");
		System.out.println(solution(head));
	}

	public static boolean solution(LinkedListNode n){
		//make sure the list has nodes
		if(n == null ) return false;
		//create two pointers to navigate the linked list
		LinkedListNode slow = n;
		LinkedListNode fast = n;
		//create a stack to store half the linked list
		Stack<Character> stack = new Stack<Character>();
		//push elements to the stack until you reach the center
		while(fast != null){
			//add p1 node data to the stack
			stack.push(slow.data);
			//increment p1 by one and p2 by two
			slow = slow.next;
			if(fast.next == null) {
				stack.pop();
				fast = null;
			} else fast = fast.next.next;
		}
		//pop elements and check if they match the remaining elements in the list
		while(slow != null){
			if(slow.data != stack.pop()) {
				return false;
			}
			slow = slow.next;
		}
		//return true if they match
		return true;
	}

	public static LinkedListNode createLinkedList(String s){
		//create the head node
		LinkedListNode head = new LinkedListNode(s.charAt(0));
		//add more nodes
		for(int i=1;i<s.length();i++){
			head.appendToTail(s.charAt(i));
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
	public char data;


	public LinkedListNode(char d){
		data = d;
	}

	public LinkedListNode(){}

	public void appendToTail(char d){
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}
}
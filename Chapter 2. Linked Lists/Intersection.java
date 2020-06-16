import java.util.Random;
public class Intersection {
	/*
		Chapter 2 Problem 7
		Given two (singly) linked lists, determine if the two lists intersect. Return
		the intersecting node. Note that the intersection is defined based on reference,
		not value. That is, if the kth node of the first linked list is the exact same
		node (by reference) as the jth node of the second list, they are intersecting.
	*/

	/*
		Time Complexity: O(A + B), O(n)
		Space Complexity: O(1)
	*/
	public static void main(String[] args){
		//create the test data
		LinkedListNode head1 = createLinkedList();
		LinkedListNode head2 = createLinkedList();
		boolean doIntersect = true;
		if(args.length > 0) doIntersect = false;
		if(doIntersect) createIntersection(head1, head2);
		printLinkedList(head1);
		printLinkedList(head2);
		//output results of solution
		System.out.println("Checking for intersecting node: ");
		System.out.println(findIntersection(head1,head2).data);
	}

	public static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2){
		if(list1 == null || list2 ==null) return null;
		//get the tails and sizes of the lists
		Result result1 = getTailAndSize(list1);
		Result result2 = getTailAndSize(list2);
		//check if the tails are the same node
		if(result1.tail != result2.tail) return null;
		//set pointers to the start of each linked list
		LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
		LinkedListNode longer = result1.size < result2.size ? list2 : list1;
		//advance the pointer for the longer linked list by difference in lengths
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));
		//move both pointers until you have a collision
		while(shorter != longer){
			shorter = shorter.next;
			longer = longer.next;
		}
		//return either one
		return longer;
	}

	public static LinkedListNode createLinkedList(){
		//Random seed
		Random rand = new Random();
		//create the head node
		LinkedListNode head = new LinkedListNode(rand.nextInt(10));
		//add more nodes (2 or 3)
		int nodeCount = rand.nextInt(2)+2;
		for(int i=0;i<nodeCount;i++){
			head.appendToTail(rand.nextInt(10));
		}
		//return the head node
		return head;
	}

	public static void createIntersection(LinkedListNode head1, LinkedListNode head2){
		//Random seed
		Random rand = new Random();
		//get the tails
		while(head1.next != null){
			head1 = head1.next;
		}
		while(head2.next != null){
			head2 = head2.next;
		}
		//add the intersection node
		LinkedListNode intersection = new LinkedListNode(rand.nextInt(10));
		head1.next = intersection;
		head2.next = intersection;
		//add some more nodes after the intersection
		for(int i=0;i<4;i++){
			intersection.appendToTail(rand.nextInt(10));
		}
	}

	public static void printLinkedList(LinkedListNode node){
		LinkedListNode current = node;
		while(current != null){
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println();
	}

	public static Result getTailAndSize(LinkedListNode list){
		if(list == null) return null;

		int size = 1;
		LinkedListNode current = list;
		while(current.next != null){
			size++;
			current  = current.next;
		}
		return new Result(current, size);
	}

	public static LinkedListNode getKthNode(LinkedListNode head, int k){
		LinkedListNode current = head;
		while(k > 0 && current != null){
			current = current.next;
			k--;
		}
		return current;
	}
}

//Result wrapper class
class Result {
	public LinkedListNode tail;
	public int size;
	public Result(LinkedListNode tail, int size){
		this.tail = tail;
		this.size = size;
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
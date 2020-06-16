package Q4_Queue_via_Stacks;

public class Question {
	/*
		Chapter 3 Problem 4
		Implement a MyQueue class which implements a queue using two stacks
	*/

	public static void main(String[] args){
		//create the test data
		MyQueue queue = new MyQueue();
		int[] array = {2,1,3,1,4,6,1,2,4,1};
		for(int val: array){
			queue.add(val);
		}
		//output results
		System.out.println("MyQueue via stacks: ");
		for(int i=0;i<array.length;i++){
			System.out.println("Popped:"+queue.remove());
		}
		
	}
}
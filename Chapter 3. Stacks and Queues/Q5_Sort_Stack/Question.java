package Q5_Sort_Stack;

import java.util.Stack;

public class Question {
	/*
		Chapter 3 Problem 5
		Write a program to sort a stack such that the smallest items are on
		the top. You can use an additional temporary stack, but you may not copy
		the elements into any other data structure (such as an array). The stack
		supports the following operations: push, pop, peek, and isEmpty.
	*/

	/*
		Time Complexity: O(n^2)
		Space Complexity: O(n)
	*/

	public static void main(String[] args){
		//create the test data
		Stack<Integer> stack = new Stack();
		int[] array = {2,1,3,1,4,6,1,2,4,1};
		for(int val: array){
			stack.push(val);
			System.out.println("Pushed:"+val);
		}
		//output results
		solution(stack);
		System.out.println("Sort Stack: ");
		for(int i=0;i<array.length;i++){
			System.out.println("Popped:"+stack.pop());
		}
		
	}

	public static void solution(Stack<Integer> s){
		//temporary stack
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()){
			/* Insert each element in s in sorted order into r. */
			int temp = s.pop(); //grab the top element of s
			while(!r.isEmpty() && r.peek() > temp){
				s.push(r.pop());
			}
			r.push(temp);
		}

		while(!r.isEmpty()){
			s.push(r.pop());
		}
	}

}
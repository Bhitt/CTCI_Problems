package Q4_Queue_via_Stacks;

import java.util.Stack;

public class MyQueue<T>{
	Stack<T> stackNewest;
	Stack<T> stackOldest;

	public MyQueue() {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}

	public int size(){
		return stackNewest.size() + stackOldest.size();
	}

	public void add(T value){
		//push onto stackNewest, which always has the newest element on top
		stackNewest.push(value);
	}

	/* Move elements from stackNewest into stackOldest. This is usually done
	so that we can do operations on stackOldest. */
	private void shiftStacks(){
		if(stackOldest.isEmpty()){
			while(!stackNewest.isEmpty()){
				stackOldest.push(stackNewest.pop());
			}
		}
	}

	public T peek(){
		shiftStacks(); //Ensure stackOldest has the current elements
		return stackOldest.peek();
	}

	public T remove(){
		shiftStacks();
		return stackOldest.pop();
	}
}
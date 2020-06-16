import java.util.Stack;

public class StackMin {
	/*
		Chapter 3 Problem 2
		How would you design a stack which, in addition to push and pop, has
		a function min which returns the minimum element? Push, pop, and min
		should all operate in O(1) time.
	*/

	/*
		Time Complexity: O(1)
		Space Complexity: O(n)
	*/
	public static void main(String[] args){
		//create the test data
		StackWithMin stack = new StackWithMin();
		int[] array = {2,1,3,1};
		for(int value: array){
			stack.push(value);
		}
		//output results
		System.out.println("StackMin: ");
		for(int i=0;i<array.length;i++){
			System.out.println("Popped " + stack.pop());
			System.out.println("New min is " + stack.min());
		}
	}


}


/*
	Utilize a second stack to keep track of the mins
*/

class StackWithMin extends Stack<Integer> {
	Stack<Integer> s2;

	public StackWithMin(){
		s2 = new Stack<Integer>();
	}

	public void push(int value){
		if(value <= min()){
			s2.push(value); //push to second stack
		}
		//always push to main stack
		super.push(value);
	}

	public Integer pop(){
		int value = super.pop();
		if(value == min()){
			s2.pop();
		}
		return value;
	}

	public int min(){
		if(s2.isEmpty()){
			return Integer.MAX_VALUE; //error value
		} else {
			return s2.peek();
		}
	}
}

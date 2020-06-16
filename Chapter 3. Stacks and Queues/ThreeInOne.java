public class ThreeInOne {
	/*
		Chapter 3 Problem 1
		Describe how you could use a single array to implement three stacks
	*/


	public static void main(String[] args){
		//create the test data
		FixedMultiStack stack = new FixedMultiStack(5);
		fillStack(stack);
		//output results
		System.out.println("Three stacks in one array: ");
		printStack(stack);
	}

	public static void fillStack(FixedMultiStack stack){
		//add three elements to each stack 
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				stack.push(i,(j+1+(i*3)));
			}
		}
	}

	public static void printStack(FixedMultiStack stack){
		for(int i=0;i<3;i++){
			while(!stack.isEmpty(i)){
				System.out.print(stack.pop(i));
			}
			System.out.println();
		}
	}
}

/*
NOTE
This solution works for a fixed division only. A more flexible division requires a lot
more code to implement but could be achieved by growing capacity of the blocks and shifting
elements.
*/

class FixedMultiStack {
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;

	public FixedMultiStack(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[numberOfStacks];
	}

	//PUSH operation
	public void push(int stackNum, int value) { /*throws FullStackException*/
		//check if you have space
		if(isFull(stackNum)){
			// throw new FullStackException();
		}
		//increment stack pointer and then update top value
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}

	//POP operation
	public int pop(int stackNum){
		//check for empty stack
		if(isEmpty(stackNum)){
			// throw new EmptyStackException();
		}
		//grab the item at the top of the stack and return it
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNum]--;
		return value;
	}

	//PEEK operation
	public int peek(int stackNum){
		//check for empty
		if(isEmpty(stackNum)){
			// throw new EmptyStackException();
		}
		return values[indexOfTop(stackNum)];
	}

	//ISEMPTY operation
	public boolean isEmpty(int stackNum){
		return sizes[stackNum] == 0;
	}

	//ISFULL operation
	public boolean isFull(int stackNum){
		return sizes[stackNum] == stackCapacity;
	}

	//returns index of the top of the stack
	private int indexOfTop(int stackNum){
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}

}


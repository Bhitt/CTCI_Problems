public class Question {
	/*
		Chapter 5 Problem 6
		Write a function to determine the number of bits you would need
		to flip to convert integer A to integer B.

		Example:
			Input : 29 (or: 11101), 15 (or: 01111)
			Output: 2
		

		Time Complexity:  O(b), where b is the bits that need to be flipped
		Space Complexity: O(1)
	*/

	public static void main(String[] args) {
		//create test data
		int a = 3187;
		int b = 2563;
		if(args.length > 1){
			a = Integer.parseInt(args[0]);
			b = Integer.parseInt(args[1]);
		}
		//output results
		System.out.println("A:"+a+" , (or: "+Integer.toBinaryString(a)+")");
		System.out.println("B:"+b+" , (or: "+Integer.toBinaryString(b)+")");
		System.out.println("Bit Flips Required: "+bitSwapRequired(a,b));
		
	}

	/*
		First XOR num A and num B. This will leave 1's in the bits that need
		to be flipped and zeros elsewhere. Increment count. Next    c = c & (c-1)
		will clear the least significant '1' bit. Repeat until the number is zero.
	*/
	public static int bitSwapRequired(int a, int b){
		int count = 0;
		for(int c = a ^ b;c !=0; c = c & (c-1)){
			count++;
		}
		return count;
	}
}
public class Question {
	/*
		Chapter 5 Problem 
		You have an integer and you can flip exactly from a 0 to a 1. Write code
		to find the length of the longest sequences of 1s you could create.
		
		Example:
			Input: 1775 (or: 11011101111)
			Output: 8

		Time Complexity:  O(b), where b is the number of bits
		Space Complexity: O(1)
	*/

	public static void main(String[] args) {
		//create test data
		int num = 1775;
		if(args.length > 0) num = Integer.parseInt(args[0]);
		int result = flipBit(num);
		//output
		System.out.println("Number:"+num+"  Binary:"+Integer.toBinaryString(num));
		System.out.println("The longest sequence: "+result);
	}

	public static int flipBit(int a) {
		/* If all 1s, this is already the longest sequence. */
		if (~a == 0) return Integer.BYTES * 8;
		
		int currentLength = 0;
		int previousLength = 0;
		int maxLength = 1; // We can always have a sequence of at least one 1
		while (a != 0) {
			if ((a & 1) == 1) {
				currentLength++;
			} else if ((a & 1) == 0) {
				/* Update to 0 (if next bit is 0) or currentLength (if next bit is 1). */
				previousLength = (a & 2) == 0 ? 0 : currentLength;
				currentLength = 0;
			}
			maxLength = Math.max(previousLength + currentLength + 1, maxLength);
			a >>>= 1;
		}
		return maxLength;
	}
}

public class Question {
	/*
		Chapter 5 Problem 7
		Write a program to swap odd and even bits in an integer with as few instructions
		as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and 3 are swapped, and so on).
		
		Time Complexity:  O(1)
		Space Complexity: O(1)
	*/

	public static void main(String[] args) {
		//create test data
		int num  = 885;
		if(args.length > 0) num = Integer.parseInt(args[0]);
		System.out.println("Number: "+num+" (or: "+Integer.toBinaryString(num)+")");
		//output results
		int result = swapOddEvenBits(num);
		System.out.println("Result: "+result+" (or: "+Integer.toBinaryString(result)+")");
	}

	/*
		Use masks for the odd and even bits. Move the even bits to the left, and the
		odd bits to the right.
		ODD mask  = 0xaaaaaaaa    for  101010101010...
		EVEN mask = 0x55555555	  for  010101010101...	
	*/
	public static int swapOddEvenBits(int num){
		return(((num & 0xaaaaaaaa)>>>1) | ((num & 0x55555555) << 1));
	}

}
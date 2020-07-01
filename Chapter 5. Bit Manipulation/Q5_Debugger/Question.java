
public class Question {
	/*
		Chapter 5 Problem 5
		Explain what the following code does:
			((n & (n-1)) == 0)
		
	*/

	public static void main(String[] args) {
		//test operation
		System.out.println("\n ((n & (n-1)) == 0) \n");
		for(int num=0;num<34;num++){
			System.out.println(num+" (binary: "+Integer.toBinaryString(num)+") -> "+mystery(num));
		}
	}

	/*
		This function determines if the given integer is a power of 2

		Example : 	8 in binary is 1000
					8 - 1  = 7 which in binary is 0111
					1000 & 0111 = 0
					This will only occur if the original number has only a single 1 bit
	*/
	public static boolean mystery(int n){
		return ((n & (n-1)) == 0);
	}

}
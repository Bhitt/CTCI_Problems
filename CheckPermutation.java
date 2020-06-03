public class CheckPermutation {
	/*
		Chapter 1 Problem 2
		Given two strings, write a method to decide if one is a permutation of the other
	*/

	/*
		Time Complexity: O(n)
		Space Complexity: O(1)
	*/
	public static void main(String[] args){
		//Test strings
		String testString1 = "aba", testString2 = "baa";
		//get input from args
		if(args.length > 1){
			testString1 = args[0]; 
			testString2 = args[1];
		} 
		//output result
		System.out.println("Checking Permuations: "+testString1+" , "+testString2);
		System.out.println(solution(testString1,testString2));
	}

	public static boolean solution(String s, String t){
		//first check if the strings are the same length
		if(s.length() != t.length()) return false;
		//create a hashtable representation of possible characters
		int[] letters = new int[128]; //assuming ascii
		//increment based on the first string's characters
		for(int i=0;i<s.length();i++){
			letters[s.charAt(i)]++;
		}
		//decrement based on the second string's characters
		for(int i=0;i<t.length();i++){
			letters[t.charAt(i)]--;
			if(letters[t.charAt(i)]<0) return false;
		}
		return true;

	}

	/*
		Another possible solution is to sort both strings. They should be the same after
		sorting since they are the same letters but in a different order. This is not as
		efficient but is easy to implement and may do the job
	*/
}
public class PalindromePermutation {
	/*
		Chapter 1 Problem 4
		Given a string, check to see if it is a permutation of a palindrome.
	*/

	/*
		Time Complexity: O(n)
		Space Complexity: O(1)
	*/
	public static void main(String[] args){
		//Test strings
		String testString = "Tact Coa";
		//get input from args
		if(args.length > 0){
			testString = args[0]; 
		} 
		//output result
		System.out.println("Permutation of Palindrome check: "+testString);
		System.out.println(solution(testString));
	}

	public static boolean solution(String s){
		//create a hashtable of possible characters
		int[] letters = new int[128]; //assuming ascii
		//check for odd/even string
		int oddCount = s.length();
		//increment based on characters in the string
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == ' '){
				oddCount--;
			}else{
				letters[Character.toLowerCase(s.charAt(i))]++;
			}
		}
		oddCount%=2;
		//check for even numbers
		for(int i=0;i<s.length();i++){
			if(letters[Character.toLowerCase(s.charAt(i))] %2 != 0) {				if(s.charAt(i) == ' ') continue;
				oddCount--;
				if(oddCount < 0) return false;
			}
		}
		return true;
	}

	/*
		There exists another solution of O(n) that only uses one integer for space.
		You toggle bits in the integer based off the characters and then look at the
		resulting integer.
	*/
}
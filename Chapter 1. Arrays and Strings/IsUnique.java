public class IsUnique {
	/* 
	Chapter 1 Problem 1: Implement an algorithm to determine if a string 
	has all unique characters. What if you cannot use additional data structures?
	*/

	/*
		Time Complexity: O(n) or possibly O(1) since it won't go passed 128 chars
		Space Complexity: O(1)
	*/

	public static void main(String[] args){
		//Test string
		String testString = "default";
		//get input from args
		if(args.length > 0 ) testString = args[0];
		//Output result
		System.out.println("Testing String for all unique characters: "+testString);
		System.out.println(solution(testString));
	}

	//testing for all unique characters (assuming all lowercase and ascii)
	public static boolean solution(String s){
		//first check if there are too many characters which means overlap
		if(s.length() > 128) return false;
		//create a boolean set to represent the possible characters
		boolean[] char_set = new boolean[128];
		//toggle the boolean to true the first time, and return false on the second time
		for(int i=0;i<s.length();i++){
			//get the characters index
			int val = s.charAt(i);
			//character already exists
			if(char_set[val]) return false;
			//first time
			char_set[val] = true;
		}
		return true;
	}
}
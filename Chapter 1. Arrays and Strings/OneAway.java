public class OneAway {
	/*
		Chapter 1 Problem 5
		There are three types of edits that can be performed on strings: insert a character,
		remove a character, or replace a character. Given two strings, write a function to
		check if they are one edit (or zero edits) away.
	*/

	/*
		Time Complexity: O(n)
		Space Complexity: O(n)
	*/
	public static void main(String[] args){
		//Test strings
		String testString1 = "pale", testString2 = "ple";
		//get input from args
		if(args.length > 1){
			testString1 = args[0]; 
			testString2 = args[1];
		} 
		//output result
		System.out.println("One edit away: "+testString1+" , "+testString2);
		System.out.println(solution(testString1,testString2));
	}

	public static boolean solution(String s, String t){
		//test for string lengths
		if(Math.abs(s.length()-t.length())>1) return false;
		//find the shorter and longer strings
		String s1 = s.length() < t.length() ? s : t;
		String s2 = s.length() < t.length() ? t : s;
		//pass through strings and compare
		boolean foundDifference = false;
		int index1=0,index2=0;
		while(index2 < s2.length() && index1 < s1.length()){
			//
			if(s1.charAt(index1) != s2.charAt(index2)){
				if(foundDifference) return false;
				foundDifference = true;

				if(s1.length() == s2.length()){
					//character replaced
					index1++;
				}
				/*insertion or deletion edits have the same result with 
				a shift of index on the larger string */
			} else {
				//characters match so move small string pointer
				index1++; 
			}
			index2++; //always increment big string pointer
		}
		return true;
	}
}
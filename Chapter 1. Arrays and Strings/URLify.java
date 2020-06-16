public class URLify {
	/*
		Chapter 1 Problem 3
		Write a method to replace all spaces in a string with '%20'. You may assume
		that the string has sufficient space at the end to hold the additional characters,
		and that you are given the "true" length of the string. (Note: in Java, use a 
		character array so that you can perform this operation in place.)
	*/

	/*
		Time Complexity: O(n)
		Space Complexity: O(1)
	*/
	public static void main(String[] args){
		//Test strings
		String testString = "Mr John Smith    ";
		int input = 13;
		//get input from args
		if(args.length > 1){
			testString = args[0]; 
			input = Integer.parseInt(args[1]);
		} 
		//output result
		System.out.println("URLifying: "+testString+" , "+input);
		System.out.println(solution(testString.toCharArray(),input));
	}

	public static char[] solution(char[] s, int trueLength){
		//variables
		int spaceCount = 0, index, i=0;
		//first scan for number of spaces
		for(i=0;i<trueLength;i++){
			if(s[i] == ' ')spaceCount++;
		}
		//increase index based on number of spaces
		index = trueLength + spaceCount*2;
		if(trueLength < s.length) s[trueLength] = '\0'; //end array
		//second scan (in reverse) replaces spaces with '%20' or copy original character
		for(i=trueLength-1;i>=0;i--){
			if(s[i] == ' '){
				s[index-1] = '0';
				s[index-2] = '2';
				s[index-3] = '%';
				index -= 3;
			} else {
				s[index-1] = s[i];
				index--;
			}
		}
		return s;
	}
}
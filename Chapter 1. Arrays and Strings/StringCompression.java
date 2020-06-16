public class StringCompression {
	/*
		Chapter 1 Problem 6
		Implement a method to perform basic string compression using the counts
		of repeated characters. For example, the string aabcccccaaa would become
		a2b1c5a3. If the compressed string would not become smaller than the original
		string, your method should return the original string. You can assume the
		string has only has only uppercase and lowercase letters (a-z).
	*/

	/*
		Time Complexity: O()
		Space Complexity: O()
	*/
	public static void main(String[] args){
		//Test strings
		String testString = "aabcccccaaa";
		//get input from args
		if(args.length > 0){
			testString = args[0];
		} 
		//output result
		System.out.println("String Compression: "+testString);
		System.out.println(solution(testString));
	}

	public static String solution(String s){
		//Use a string builder to avoid copying a new string everytime we append
		StringBuilder result = new StringBuilder();
		int count=1;
		for(int i=0;i<s.length()-1;i++){
			if(s.charAt(i) == s.charAt(i+1)){
				count++;
			} else {
				result.append(""+s.charAt(i)+count);
				count=1;
			}
		}
		//add the last char
		result.append(""+s.charAt(s.length()-1)+count);
		return result.toString().length() < s.length() ? result.toString() : s;

	}

	/* another way of implementing this is to check for repeated characters first to 
	determine if the resulting string would be larger. This repeats code but saves on
	creating strings that might not be used (strings without many repeated characters).
	Another benefit of this is that you can determine the StringBuilder's capacity
	at its initialization which saves it from working to double its capacity in the
	background */
}
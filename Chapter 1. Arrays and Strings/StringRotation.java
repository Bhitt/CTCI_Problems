public class StringRotation {
	/*
		Chapter 1 Problem 9
		Assume you have a method isSubstring which checks if one word is a substring
		of another. Given two strings, s1 and s2, write code to check if s2 is a 
		rotation of s1 using only one call to isSubstring(e.g., "waterbottle" is
		a rotation of "erbottlewat").
	*/

	/*
		Time Complexity: O(n) if isSubstring method is assumed to run in O(A+B), 
		where A and B are string lengths.
	*/
	public static void main(String[] args){
		//Test strings
		String s1 = "waterbottle", s2 = "erbottlewat";
		//get input from args
		if(args.length > 1){
			s1 = args[0]; 
			s2 = args[1];
		} 
		//output result
		System.out.println("String Rotation check: "+s1+" , "+s2);
		System.out.println(isRotation(s1,s2));
	}

	public static boolean isRotation(String s1, String s2){
		int len = s1.length();
		//check that both strings are equal length and not empty
		if( len == s2.length() && len > 0){
			//concatenate s1 with s1
			String s1s1 = s1 + s1;
			return s1s1.contains(s2);
		}
		return false;
	}

	/*
		Explanation: if s1 = xy = waterbottle
					 	x = wat
					 	y = erbottle
						s2 = yx = erbottlewat

					 then yx should always be a substring of xyxy
					   or s2 should always be a substring of s1s1
	*/
}
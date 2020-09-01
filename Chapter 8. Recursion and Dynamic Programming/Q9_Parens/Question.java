import java.util.ArrayList;

public class Question {
	/*
		Chapter 8 Problem 9
		Implement an algorithm to print all valid (e.g., properly opened and closed) combinations
		of n pairs of parentheses.

		Example:

		Input: 3
		Output: ((())), (()()), (())(), ()(()), ()()()
		
		Time Complexity: O()


	*/

	public static void main(String[] args) {
		//decide how many parens
		int n = 6;
		if(args.length > 0) n = Integer.parseInt(args[0]);
		//generate the parens with a recursive approach
		ArrayList<String> list = generateParens(n);
		//output the resulting list of parens
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println(list.size());
	}

	public static ArrayList<String> generateParens(int count) {
		//create a string to hold a combination of parens
		char[] str = new char[count*2];
		//create the list for all strings/combinations
		ArrayList<String> list = new ArrayList<String>();
		//call add parens recursively, using the number of left and right parens to generate
		addParen(list, count, count, str, 0);
		//return the list of combinations
		return list;
	}

	public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
		if (leftRem < 0 || rightRem < leftRem) return; // invalid state
		
		if (leftRem == 0 && rightRem == 0) { /* all out of left and right parentheses */
			list.add(String.copyValueOf(str));
		} else {
			str[index] = '('; // Add left and recurse
			addParen(list, leftRem - 1, rightRem, str, index + 1);
			
			str[index] = ')'; // Add right and recurse
			addParen(list, leftRem, rightRem - 1, str, index + 1);
		}
	}


}
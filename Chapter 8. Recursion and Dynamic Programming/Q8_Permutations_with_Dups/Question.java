import java.util.ArrayList;
import java.util.HashMap;

public class Question {
	/*
		Chapter 8 Problem 8
		Write a method to compute all permutations of a string whose characters are not
		necessarily unique. The list of permutations should not have duplicates.

		Time Complexity: O(n!)


	*/

	public static void main(String[] args) {
		//create test data
		String unique = "aabbccc";
		if(args.length > 0) unique = args[0];
		//compute
		ArrayList<String> list = printPerms(unique);
		//output
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
	}

	public static HashMap<Character, Integer> buildFreqTable(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
		return map;
	}
	
	public static void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
		if (remaining == 0) {
			result.add(prefix);
			return;
		}
		
		for (Character c : map.keySet()) {
			int count = map.get(c);
			if (count > 0) {
				map.put(c,  count - 1);
				printPerms(map, prefix + c, remaining - 1, result);
				map.put(c,  count);
			}
		}
	}
	
	public static ArrayList<String> printPerms(String s) {
		ArrayList<String> result = new ArrayList<String>();
		HashMap<Character, Integer> map = buildFreqTable(s);
		printPerms(map, "", s.length(), result);
		return result;
	}



}
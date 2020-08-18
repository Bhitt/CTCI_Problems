import java.util.*;

public class Question {
	/*
		Chapter 8 Problem 4
		Write a method to return all subsets of a set.

		Time Complexity: O(2^n)
		Space Complexity: O(2^n)

		Solution: Start at base case, add those sets, then clone the sets and add the
		next case to that.

	*/

	public static void main(String[] args) {
		//create test data
		ArrayList<Integer> list = new ArrayList<Integer>();
		int numElem = 3;
		if(args.length > 0){
			numElem = Integer.parseInt(args[0]);
		}
		for (int i = 0; i < numElem; i++) {
			list.add(i);
		}
		ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);
		System.out.println("Initial Set: "+list.toString());
		System.out.println("Power Set: "+subsets.toString());	
	}

	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) { // Base case - add empty set
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); 
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset); 
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}

}
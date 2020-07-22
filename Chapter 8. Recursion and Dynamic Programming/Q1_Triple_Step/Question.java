import java.util.Arrays;

public class Question {
	/*
		Chapter 8 Problem 1
		A child is running up a staircase with n steps and can hop either 1 step,
		2 steps, or 3 steps at a time. Implement a method to count how many possible
		ways the child can run up the stairs.
		
		Time Complexity:  O(n)
		Space Complexity: O(n)

		NOTE: THIS OVERFLOWS THE INTEGER AROUND n = 37
	*/

	public static void main(String[] args) {
		//create test data
		int stepCount = 20;
		if(args.length > 0) stepCount = Integer.parseInt(args[0]);
		//compute and output results
		int ways = countWays(stepCount);
		System.out.println("There are "+ways+" ways to run up the "+stepCount+" steps.");
	}

	public static int countWays(int n) {
		//begin by creating a hashmap to contain steps already counted
		int[] map = new int[n + 1];
		Arrays.fill(map, -1);
		//call countways recursively
		return countWays(n, map);
	}

	public static int countWays(int n, int[] memo) {
		if (n < 0) {	//base case
			return 0;
		} else if (n == 0) { //base case
			return 1;
		} else if (memo[n] > -1) { //we have computed this value already
			return memo[n];
		} else {
			//new value
			memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
			return memo[n];
		}
	}	

	

}
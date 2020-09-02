public class Question {
	/*
		Chapter 8 Problem 11
		Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents),
		and pennies (1 cent), write code to calculate the number of ways of representing n cents.

		Time Complexity: O()


	*/


	public static void main(String[] args) {
		/* input the cent total: n */
		int n = 10;
		if(args.length > 0) n = Integer.parseInt(args[0]);
		/* find the combinations */
		int[] denoms = {25, 10, 5, 1};
		int ways = makeChange(n, denoms);
		/* output result */
		System.out.println("There are "+ways+" ways to make change for "+n+" cents.");
	}

	public static int makeChange(int n, int[] denoms){
		/* create a 2d array to store previously computed values */
		int [][] map = new int[n+1][denoms.length];
		/*call the recursive function */
		return makeChangeHelper(n, denoms, 0, map);
	}

	public static int makeChangeHelper(int total, int[] denoms, int index, int[][] map){
		/* check cache for prior result */
		if(map[total][index] > 0){ //retrieve value
			return map[total][index];
		}

		int coin = denoms[index];
		if(index == denoms.length -1){
			int remaining = total % coin;
			return remaining == 0 ? 1 : 0;
		}

		int numberOfWays = 0;
		/* Try 1 coin, then 2, then 3... (recurse each time on rest). */
		for(int amount = 0; amount <= total; amount += coin){
			numberOfWays += makeChangeHelper(total - amount, denoms, index+1, map); //go to next denom
		}

		/* Update cache with current result. */
		map[total][index] = numberOfWays;

		return numberOfWays;
	}
	
}
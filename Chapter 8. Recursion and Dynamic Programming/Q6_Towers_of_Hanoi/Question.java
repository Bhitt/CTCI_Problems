package Q6_Towers_of_Hanoi;

public class Question {
	/*
		Chapter 8 Problem 6
		In the classic problem of Towers of Hanoi, you have 3 towers and N disks of different sizes which
		can slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top
		to bottom (i.e., each disk sits on top of an even larger one). You have the following constraints:
		1) Only one disk can be moved at a time.
		2) A disk is slid off the top of one tower onto another tower.
		3) A disk cannot be placed on top of a smaller disk.
		Write a program to move the disks from the first tower to the last using stacks.

		Time Complexity: O(2^n)

		

	*/

	public static void main(String[] args) {
		/* create test data */
		Tower source = new Tower();
		Tower destination = new Tower();
		Tower buffer = new Tower();
		
		source.name = "s";
		destination.name = "d";
		buffer.name = "b";
		
		/* Load up tower */
		int numberOfDisks = 5;
		for (int disk = numberOfDisks - 1; disk >= 0; disk--) {
			source.add(disk);
		}
		
		/* Move the disks */
		source.print();
		source.moveDisks(numberOfDisks, destination, buffer);
		destination.print();
	}

}
package Q2_Robot_in_a_Grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Question {
	/*
		Chapter 8 Problem 2
		Imagine a robot sitting on the upper left corner of a grid with r rows and c columns.
		The robot can only move in two directions, right and down, but certain cells are
		"off limits" such that the robot cannot step on them. Design an algorithm to find a
		path for the robot from the top left to the bottom right.
		
		Time Complexity:  O()
		Space Complexity: O()
	*/

	public static void main(String[] args) {
		//create test data
		int size = 20;
		boolean[][] maze = randomBooleanMatrix(size, size, 80);
		
		printMatrix(maze);
		//output results
		ArrayList<Point> path = getPath(maze);
		if (path != null) {
			System.out.println(path.toString());
		} else {
			System.out.println("No path found.");
		}
		
	}

	public static boolean[][] randomBooleanMatrix(int M, int N, int percentTrue) {
		boolean[][] matrix = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = randomBoolean(percentTrue);
			}
		}
		return matrix;
	}

	public static boolean randomBoolean() {
		return randomIntInRange(0, 1) == 0;
	}

	public static boolean randomBoolean(int percentTrue) {
		return randomIntInRange(1, 100) <= percentTrue;
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}

	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static void printMatrix(boolean[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j]) {
					System.out.print("1");
				} else {
					System.out.print("0");
				}
			}
			System.out.println();
		}
	}

	public static ArrayList<Point> getPath(boolean[][] maze) {
		if (maze == null || maze.length == 0) return null;
		ArrayList<Point> path = new ArrayList<Point>();
		HashSet<Point> failedPoints = new HashSet<Point>();
		if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
			return path;
		}
		return null;
	}
	
	public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
		/* If out of bounds or not available, return.*/
		if (col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}
		
		Point p = new Point(row, col);
		
		/* If we've already visited this cell, return. */
		if (failedPoints.contains(p)) { 
			return false;
		}	
		
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		/* If there's a path from the start to my current location, add my location.*/
		if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)) {
			path.add(p);
			return true;
		}
		
		failedPoints.add(p); // Cache result
		return false;
	}

}
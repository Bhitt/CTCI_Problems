import java.util.Arrays;

public class Question {
	/*
		Chapter 8 Problem 3
		A magic index in an array A[0...n-1] is defined to be an index such that A[i] = i.
		Given a sorted array of distinct integers, write a method to find a magic index, if
		one exists, in array A.

		Follow Up: What if the elements are not distinct?
		
		Solution: similar to binary search for distinct
	*/

	public static void main(String[] args) {
		//create test data
		for (int i = 0; i < 1000; i++) {
			int size = randomIntInRange(5, 20);
			int[] array = getSortedArray(size);
			int v2 = magicFast(array);
			if (v2 == -1 && magicSlow(array) != -1) {
				int v1 = magicSlow(array);
				System.out.println("Incorrect value: index = -1, actual = " + v1 + " " + i);
				System.out.println(arrayToString(array));
				break;
			} else if (v2 > -1 && array[v2] != v2) {
				System.out.println("Incorrect values: index= " + v2 + ", value " + array[v2]);
				System.out.println(arrayToString(array));
				break;
			}
		}
	}


	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}

	public static String arrayToString(int[] array) {
		if (array == null) return "";
		return arrayToString(array, 0, array.length - 1);
	}
	
	public static String arrayToString(int[] array, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i <= end; i++) {
			int v = array[i];
			sb.append(v + ", ");
		}
		return sb.toString();
	}

	public static int[] randomArray(int N, int min, int max) {
		int[] array = new int[N];
		for (int j = 0; j < N; j++) {
			array[j] = randomIntInRange(min, max);
		}
		return array;
	}

	/* Creates an array that is sorted */
	public static int[] getSortedArray(int size) {
		int[] array = randomArray(size, -1 * size, size);
		Arrays.sort(array);
		return array;
	}

	public static int magicSlow(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}
	
	public static int magicFast(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		/* Search left */
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFast(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}
		
		/* Search right */
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFast(array, rightIndex, end);
		
		return right;
	}
	
	public static int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}
	

}
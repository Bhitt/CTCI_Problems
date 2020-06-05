public class RotateMatrix {
		/*
		Chapter 1 Problem 7
		Given an image represented by an NxN matrix, where each pixel in the image
		is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this
		in place?
	*/

	/*
		Time Complexity: O(n^2)
		Space Complexity: O(1)
	*/
	public static void main(String[] args){
		//Test matrix
		int[][] testMatrix = {
			{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
		};
		//output result
		System.out.println("Matrix Rotation: ");
		printMatrix(testMatrix);
		System.out.println("****************");
		System.out.println(solution(testMatrix));
		printMatrix(testMatrix);
	}

	public static boolean solution(int[][] matrix){
		if(matrix.length == 0 || matrix.length != matrix[0].length) return false;
		int n = matrix.length;
		for(int layer = 0; layer < n/2; layer++){
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++){
				int offset = i - first;
				//save top
				int top = matrix[first][i];

				//left -> top
				matrix[first][i] = matrix[last-offset][first];

				//bottom -> left
				matrix[last-offset][first] = matrix[last][last-offset];

				//right -> bottom
				matrix[last][last-offset] = matrix[i][last];

				//top -> right
				matrix[i][last] = top;
			}
		}
		return true;
	}

	public static void printMatrix(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(" "+matrix[i][j]+", ");
			}
			System.out.println();
		}
	}

}
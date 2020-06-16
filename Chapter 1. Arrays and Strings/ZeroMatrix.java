public class ZeroMatrix {
	/*
		Chapter 1 Problem 8
		Write an algorithm such that if an element in an MxN matrix is 0, its
		entire row and column are set to 0.
	*/

	/*
		Time Complexity: O(n^2)
		Space Complexity: O(1)
	*/
	public static void main(String[] args){
		//Test matrix
		int[][] testMatrix = {
			{1,2,0,4},{5,6,7,8},{0,10,11,12},{13,14,15,16}
		};
		//output result
		System.out.println("Zero the Matrix: ");
		printMatrix(testMatrix);
		System.out.println("****************");
		solution(testMatrix);
		printMatrix(testMatrix);
	}

	public static void solution(int[][] matrix){
		boolean rowHasZero = false;
		boolean colHasZero = false;

		//Check if first row has a zero
		for(int j=0;j<matrix[0].length;j++){
			if(matrix[0][j] == 0){
				rowHasZero = true;
				break;
			}
		}

		//Check if first col has a zero
		for(int i=0;i<matrix.length;i++){
			if(matrix[i][0] == 0){
				colHasZero = true;
				break;
			}
		}

		//check for zeros in the rest of the array
		for(int i=1;i<matrix.length;i++){
			for(int j=1;j<matrix[0].length;j++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		//nullify rows based on values in the first column
		for(int i=1;i<matrix.length;i++){
			if(matrix[i][0] == 0){
				nullifyRow(matrix, i);
			}
		}

		//nullify cols based on values in the first row
		for(int j=1;j<matrix[0].length;j++){
			if(matrix[0][j] == 0){
				nullifyColumn(matrix, j);
			}
		}

		//nullify the first row
		if(rowHasZero) nullifyRow(matrix, 0);

		//nullify the first column
		if(colHasZero) nullifyColumn(matrix, 0);


	}

	public static void printMatrix(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(" "+matrix[i][j]+", ");
			}
			System.out.println();
		}
	}

	public static void nullifyRow(int[][] matrix, int row){
		for(int j=0;j<matrix[0].length;j++){
			matrix[row][j] = 0;
		}
	}

	public static void nullifyColumn(int[][] matrix, int col){
		for(int i=0;i<matrix.length;i++){
			matrix[i][col] = 0;
		}
	}
}
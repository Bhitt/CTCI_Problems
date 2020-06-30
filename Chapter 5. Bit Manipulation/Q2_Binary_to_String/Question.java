public class Question {
	/*
		Chapter 5 Problem 2
		Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double,
		print the binary representation. If the number cannot be represented accurately
		in binary with at most 32 characters, print "ERROR".
		
		Time Complexity:  O()
		Space Complexity: O()
	*/

	public static void main(String[] args) {
		System.out.println("DEC : BIN" );
		for (int i = 0; i < 1000; i++) {
			double num = i / 1000.0;
			String binary = printBinary(num);
			if (!binary.equals("ERROR") ) {
				System.out.println(num + " : " + binary);
			}
		}
	}

	public static String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
	
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() > 32) {
				return "ERROR";
			}
			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}

}
package com.dudi.array.strings;

public class CountOccurencesOf101 {

	public static void main(String[] args) {
//		 String str = "100001abc101";
		String str = "1001ab010abc01001";
//		 String str =  "1001010001";

		int len = str.length();
		boolean oneSeen = false;
		int count = 0; // Initialize result
		for (int i = 0; i < len; i++) {
			char getChar = str.charAt(i);

			// Check if encountered '1' forms a valid pattern as specified
			if (getChar == '1' && oneSeen == true && str.charAt(i - 1) == '0') {
					count++;
			}

			// if 1 encountered for first time set oneSeen to 1
			if (getChar == '1' && oneSeen == false)
				oneSeen = true;

			// Check if there is any other character other than '0' or '1'. If so then set
			// oneSeen to 0 to search again for new pattern

//			if (getChar != '0' && str.charAt(i) != '1')
//				oneSeen = false;
			
			if(oneSeen && (getChar != '0' && getChar != '1')) {
				oneSeen = false;
			}
		}
		
		System.out.println(count);
		
	}
	

}

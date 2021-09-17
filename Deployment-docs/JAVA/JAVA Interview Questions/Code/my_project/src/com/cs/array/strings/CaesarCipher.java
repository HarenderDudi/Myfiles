package com.cs.array.strings;

public class CaesarCipher {

	public static void main(String[] args) {
		 String text = "ATTACKATONCE";
	        int s = 4;
	        System.out.println("Text  : " + text);
	        System.out.println("Shift : " + s);
	        System.out.println("Cipher: " + encrypt(text, s));
	}
	
	public static StringBuffer encrypt(String text, int s)
    {
		StringBuffer result = new StringBuffer();
		for(int i =0 ; i < text.length() ; i++) {
			if(Character.isUpperCase(text.charAt(i))) {
				char ch = (char)(((int)text.charAt(i) + s - 'A') %26 + 'A');
				result.append(ch);
			} else {
				char ch = (char)(((int)text.charAt(i) + s - 'a') %26 + 'a');
				result.append(ch);
			}
		}
		
		return result;
    }

}
// for A -> ((65 + 4) - 65) %26 + 65 ----> 4 % 26 + 65 ----> 4 + 65 ----> 69 (E)
// for T -> ((84 + 4) - 65) %26 + 65 ----> 23 % 26 + 65 ----> 23 + 65 ----> 88 (X)
// for Y -> ((89 + 4) - 65) %26 + 65 ----> 28 % 26 + 65 ----> 2 + 65 ----> 67 (C)
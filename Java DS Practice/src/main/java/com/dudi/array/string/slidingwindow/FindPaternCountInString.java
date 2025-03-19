package com.dudi.array.string.slidingwindow;

public class FindPaternCountInString {

	public static void main(String[] args) {
		char[] t = {'c', 'o', 'd' , 'e', 'N', 'c', 'o', 'd'};
		char[] p = {'c', 'o', 'd', 'e'};
		
		int tl = t.length;
		int pl = p.length;
		
		for(int i = 0; i <= tl - pl ; i++) {
			boolean matchFound = true;
			for(int j=0 ; j < pl ; j++) {
				if(t[j + i] != p[j]) {
					matchFound = false;
				}
			}
			
			if(matchFound) {
				System.out.println("Match Found At: " + i);
			}
		}
		
	}

}

package com.cs.main;

public class Private_Final_Abst_constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrivateFinal f = new PrivateFinal();
		String s = f.s;
	}

}


class PrivateFinal {
	
	protected String s = "hello";
	
	public  PrivateFinal() {
		// TODO Auto-generated constructor stub
	}
	
}
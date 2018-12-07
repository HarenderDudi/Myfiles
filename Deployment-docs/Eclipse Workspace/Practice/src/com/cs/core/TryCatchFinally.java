package com.cs.core;

import java.io.FileNotFoundException;

public class TryCatchFinally {

	public static void main(String[] args) throws FileNotFoundException {
		new TryCatchFinally().m1();
	}
	
	private String m1() throws FileNotFoundException{
		try{
			System.out.println("\n1");
			if(true){
				throw new FileNotFoundException();
			}
			System.out.println("2");
			return null;
		} catch(Exception e){
			System.out.println(e);
			throw e;
		}finally {
			System.out.println("3");
		}
		//System.out.println("4");
		//return null;
	}

}

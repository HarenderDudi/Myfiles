package com.cs.main;

public class FinalizeMethod {

	public static void main(String[] args) {
		PersonFinalizeMethod p = new HarenderFinalizeMethod();
		try {
			p.finalize();
			p.sysout();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}

class PersonFinalizeMethod{
	
	public void sysout(){
		System.out.println("in person class");
	}
	
	@Override
    public void finalize() throws Throwable {
        try{
            System.out.println("Finalize of Person Class");
        }catch(Throwable t){
            throw t;
        }
      
    }
}

class HarenderFinalizeMethod extends PersonFinalizeMethod {
	
//	@Override
//	public void sysout() {
//		System.out.println("in harender class");
//	}
	
	@Override
    public void finalize() throws Throwable {
        try{
            System.out.println("Finalize of Harender Class");
        }catch(Throwable t){
            throw t;
        }
      
    }
}

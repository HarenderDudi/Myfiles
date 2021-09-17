package com.cs.main;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<String[]> operationOBIDs = new ArrayList<String[]>();
		String operation1_oid = "op1";
        String operation1_usageLink_oid = "op_ul_1";
		extracted(operation1_oid, operation1_usageLink_oid, operationOBIDs,"","");
		extracted(operation1_oid, operation1_usageLink_oid, operationOBIDs,operation1_usageLink_oid,",");
        
        
//        String operation3_oid = "op3";
//        String operation3_usageLink_oid = "op_ul_3";
//        
//        String[] OBID_op3 = new String[2];
//        OBID_op3[0] = operation3_oid;
//        OBID_op3[1] = operation1_usageLink_oid + "," + operation3_usageLink_oid;
//        operationOBIDs.add(OBID_op3);
        
//        ArrayList<String> operation_oids = new ArrayList<String>();
//        ArrayList<String> operation_ul_oids = new ArrayList<String>();
//        
//        operation_oids.add(operation1_oid);
//        operation_oids.add(operation3_oid);
        
       	
        
        for (String[] string : operationOBIDs) {
        	System.out.println(string[0]);
        	System.out.println(string[1]);
		}
        
        
        
        
		/*Main m = new Main();
		int i = m.romanToDecimal("MCMIV");
		System.out.println(i);*/
	}

	private static void extracted(String operation1_oid, String operation1_usageLink_oid, ArrayList<String[]> operationOBIDs, String prefix, String delimiter) {
		
        String[] OBID_op1 = new String[2];
        OBID_op1[0] = operation1_oid;
        OBID_op1[1] = prefix + delimiter + operation1_usageLink_oid;
        operationOBIDs.add(OBID_op1);
	}

	int value(char r) {
		if (r == 'I')
			return 1;
		if (r == 'V')
			return 5;
		if (r == 'X')
			return 10;
		if (r == 'L')
			return 50;
		if (r == 'C')
			return 100;
		if (r == 'D')
			return 500;
		if (r == 'M')
			return 1000;
		return -1;
	}

	int romanToDecimal(String str) 
    { 
        int res = 0; 
  
        for (int i=0; i<str.length(); i++) 
        { 
            int s1 = value(str.charAt(i)); 
  
            if (i+1 <str.length()) 
            { 
                int s2 = value(str.charAt(i+1)); 
  
                if (s1 >= s2) 
                { 
                    res = res + s1; 
                } 
                else
                { 
                    res = res + s2 - s1; 
                    i++; 
                } 
            } 
            else
            { 
                res = res + s1; 
                i++; 
            } 
        }
        
        return res;
        
    }
}
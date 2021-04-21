/*
 * This file gives example of Ternary operators in Java. 
 * Student need to understand the program and find out the output 
 * first without running the program and then verify answers 
 * after executing the program.
 */


package corejavarefresher.operators;

public class TernaryOperator {
	
	public static void main(String[] args) {
	    int weight = 59;
        
        String allowed;
        
        boolean allowedWeight = (weight < 60);
        allowed = allowedWeight ? "Yes" : "No";  /* "?" - ternary - three way operator */
   
        System.out.println("Is the given weight allowed? Answer is - " + allowed);
        
        /* It is equivalent of writing the following if statement  
        
         if (allowedWeight)
        	result = value1;
        else
        	result = value2;*/
        
        
	}

}

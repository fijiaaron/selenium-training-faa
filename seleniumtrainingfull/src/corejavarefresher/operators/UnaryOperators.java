/*
 * This file gives example of compound assignment operators 
 * and increment and decrement operator in Java. 
 * Student need to understand the program and find out the output 
 * first without running the program and then verify answers 
 * after executing the program.
 */


package corejavarefresher.operators;

public class UnaryOperators {

	public static void main(String[] args) {
		int value = 3;
		
		value += 1;        	/* Compound Assignment Operators equivalent of doing -  value = value + 1; */
		System.out.println(value);

		value -= 1;			/* Compound Assignment Operators equivalent of doing -  value = value - 1; */
		System.out.println(value);
		
		value =+ 1;			/* Note the difference. This is not compound operators - value = value; */
		System.out.println(value);

		value =- 1;			/* Note the difference. This is not compound operators - value = -value; */
		System.out.println(value);
		
		value--;			/* decrement operator - value = value - 1; */
        System.out.println(value);
        
        value++;			/* increment operator - value = value + 1; */
        System.out.println(value);
        
        boolean success = false;
        
        boolean failure = !success; 			/* Logic unary NOT operator converts true to false and vise-versa */
        System.out.println(!success);
        System.out.println(failure);
        
        
	}

}

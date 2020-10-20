/*
 * This file gives example of arithmetic operators in Java.
 * Student need to understand the program and find out the output 
 * first without running the program and then verify answers 
 * after executing the program.
 */

package corejavarefresher.operators;

public class ArithmaticOperators {
		
	public static void main(String[] args) {
		int sum;
		int multiply;
		int divide;
		int modulus;
		
		sum = 25 + 20;
		
		System.out.println("Sum of the two numbers is - " + sum);
	
		multiply  = sum * 2;
		
		System.out.println("Multiplication of the two numbers is - " + multiply);
		
        divide = multiply / 2;
        
        System.out.println("Division of the two numbers is - " + divide);
        
        modulus = divide % 7;
        
        System.out.println("Modulus of the division of two numbers is - " + modulus);
           
	}

}
/*
 * This file gives example of Equality and relational operators in Java
 * And also serves as an example of if else statement.
 * Student need to understand the program and find out the output 
 * first without running the program and then verify answers 
 * after executing the program.
 */


package corejavarefresher.operators;

class EqalityAndRelationalOperators {

    public static void main(String[] args){
        int noOfBananas = 2;
        int noOfApples = 1;
        if(noOfBananas == noOfApples) /* Note that if statement is not enclosed in curly braces */
        	System.out.println("The basket contains equal number of apples and bananas");
            noOfBananas++ ;  /* Note the indentation is deceptive and even if 
             				   if statement does not execute above line will. */
        if(noOfBananas != noOfApples)
            System.out.println("No. of apples are not equal to no. of bananas in the basket");        	
        else if(noOfBananas > noOfApples) {/* Not that if statement contains curly braces */
            System.out.println("value1 > value2");
            noOfApples = 9;		/* This line will get executed if - if statement is true */
        }
        if(noOfBananas < noOfApples)
            System.out.println("No. of bananas are less than no. of apples in the basket");        
        if(noOfBananas <= noOfApples)
            System.out.println("No. of bananas are less than or equal to no. of apples in the basket");
        else
        	System.out.println("No. of bananas are more than no. of apples in the basket");
        
    }
}
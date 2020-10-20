/*
 * This file gives example of Conditional AND and OR operators in Java.
 * Student need to understand the program and find out the output 
 * first without running the program and then verify answers 
 * after executing the program.
 */


package corejavarefresher.operators;

class ConditionalAndAndOR {

    public static void main(String[] args){
        int noOfBananas = 1;
        int noOfApples = 2;
        if(((noOfBananas == 1) && (noOfApples > 1)) ) {
            System.out.println("No. of bananas are 1 AND No. of apples are 2");
        	noOfBananas = noOfApples-1;       
        }        
        if((noOfBananas == 1) || (noOfApples <= 2))  
            System.out.println("No. of bananas are 1 OR noOfApples are 1");
        noOfApples = noOfBananas + 1;   
    }
}
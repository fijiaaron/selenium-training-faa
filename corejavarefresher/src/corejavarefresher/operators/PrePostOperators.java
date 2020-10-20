/*
 * This file gives example of arithmetic operators in Java. 
 * Student need to understand the program and find out the output 
 * first without running the program and then verify answers 
 * after executing the program.
 */

package corejavarefresher.operators;

public class PrePostOperators {

	public static void main(String[] args) {
		int i = 3;

		/* The below increment is in postfix form */
		i++;
		System.out.println(i);

		/* The below increment is in prefix form */
		++i;

		/*
		 * Above both pre- and post are not part of expression so postfix and
		 * prefix does not have and difference.
		 * But below when they are used in expression like println or assignment
		 * they differ
		 */

		System.out.println(i);
		System.out.println(++i);
		System.out.println(i++);
        
		int j = ++i;
		j = i++;
		System.out.println("Value of j is - " + j);
		System.out.println(i);
		
		i = 3;
		j = ++i + i++;
		System.out.println(j);
		j = i + ++i + i++ + j++;
		System.out.println(j);
		System.out.println(i);

	}

}

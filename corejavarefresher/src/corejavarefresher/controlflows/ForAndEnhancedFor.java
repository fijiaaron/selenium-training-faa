/*
 * This file gives example of For and Enhanced For loop.
 * Student need to understand the program and find out the output 
 * first without running the program and then verify answers 
 * after executing the program.
 */

package corejavarefresher.controlflows;

class ForAndEnhancedFor {

	public static void main(String[] args) {

		/* Simple For loop */
		for (int i = 1; i <= 10; i++) {

			System.out.println("Value of i is - " + i);
		}

		/* Simple For loop variation with use of continue*/
		int i;
		for (i = 0; i <= 7; i++) {
			if (i>4)
				continue;
			System.out.println("Value of i is - " + i);
		}
		System.out.println(i);

		/* Enhanced For loop */
		int[] circleRadius = { 3, 4, 9, 3, 1, 54, 89, 30, 2, 8, 21, 9, 31, 45 };
		for (int radius : circleRadius) {
			double area = radius * radius * Math.PI;
			System.out.println("Area of the cirle with raidus " + radius
					+ " is " + area);
		}
		/* Simple for loop for the above example is given below */
		/* This also highlights the use of break inside the loops */
		// int l = 5;
		for (i = 0; i < circleRadius.length; i++) {
			double area = circleRadius[i] * circleRadius[i] * Math.PI;
			System.out.println("Area of the cirle with raidus "
					+ circleRadius[i] + " is " + area);
			if (area > 1000)
				break;
		}
		
		/* nested For loop */
		for (i = 1; i <= 3; i++) {
	        for (int j = 1; j <= 5; j++) {
	            if (i / j == 0 || j / i == 0) {
	                System.out.print("> "); 
	            }
	            else {
	                System.out.print("< "); 
	            }
	        }
	        System.out.println(i);
	    }

	}
}
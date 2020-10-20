/*
 * This file gives example of While and DO While loop.
 * Student need to understand the program and find out the output 
 * first without running the program and then verify answers 
 * after executing the program.
 */

package corejavarefresher.c_controlFlows;

class WhileAndDoWhile {
	public static void main(String[] args) {

		/* Simple while loop */
		int temperature = 101;
		while (temperature <= 105) {
			System.out.println("While - The current temperature is - "
					+ temperature);
			++temperature;
		}

		/* Do While Loop */
		do {
			System.out.println("Do-While - The current teamperature is - "
					+ temperature);
			temperature++;

		} while (temperature <= 55);
		System.out.println("Final temperature is - " + temperature);

	}
}
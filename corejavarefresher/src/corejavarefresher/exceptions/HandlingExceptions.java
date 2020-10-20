/*
 * This file provides example of handling exceptions
 * using try, catch block, handling multiple exceptions
 * and use finally and throws clause. 
 */
package corejavarefresher.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HandlingExceptions {

	public static void main(String[] args) {
		/* See how you can catch multiple exceptions */
		try {
			double a = Double.parseDouble(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid Number");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Please provide the input parameter");
		} finally {
			System.out.println("This block will always gets executed");
		}

	}

	/*
	 * Understand the difference between putting try catch and putting "throws
	 * IOExceotion clause
	 */
	public void handleIOException() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			System.out.println("Sum is :" + (a + b));
		} catch (IOException e) {
			System.out.println("Problem with reading from the console");
		}
	}
}
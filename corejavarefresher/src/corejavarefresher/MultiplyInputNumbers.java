/*
 * The following program is a simple Java program
 * which accepts values from the command line and 
 * multiplies the numbers
 */

package corejavarefresher;

public class MultiplyInputNumbers {

	public static void main(String[] args) {

		int multiplyInputNumbers = 0;

		System.out.println("No. of Arguments are:" + args.length);
		for (int i = 0; i < args.length; i++) {
			multiplyInputNumbers = multiplyInputNumbers
					* Integer.parseInt(args[i]);
		}
		System.out
				.println("The Total after multiplication of all the arguments passed is "
						+ multiplyInputNumbers);

	}
}
/*
 * This example explains the unchecked and checked exceptions
 * in Java
 */

package corejavarefresher.exceptions;

public class CheckedAndUncheckedExceptions {

	public static void main(String[] args) {
		/* Example of unchecked exception */

		int monthlyFees = 5000;
		int feesPerDay;
		int noOfDaysWorked = 0;
		/* Below line will generate ArithmeticException */
		feesPerDay = monthlyFees / noOfDaysWorked;

		System.out.println("Per dat fees are - " + feesPerDay);

		/*
		 * uncomment the below code to understand what checked exceptions are
		 * done
		 */

		// Thread.sleep(3000);

	}

}

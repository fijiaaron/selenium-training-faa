/*
 * The following program is a simple Java program
 * which accepts personal details via console or 
 * command line and prints the details back to console/command line
 */
package corejavarefresher;

import java.util.Scanner;

public class InputFromConsole
{
	public static void main( String[] args )
	{
		Scanner inputFromConsole;
		inputFromConsole = new Scanner(System.in);		
		String name;
		String surname;
		String profession;
		double noOfYearsOfExperience;
		
		System.out.print( "Please Enter Your Name: " );
		name = inputFromConsole.next();

		System.out.print( "Please Enter Your Surname: " );
		surname = inputFromConsole.next();

		System.out.print( "Please Enter Your Profession: " );
		profession = inputFromConsole.next();
		System.out.print( "Please enter your experience in years and months (e.g. 5.4):  " );
		noOfYearsOfExperience = inputFromConsole.nextDouble();
        System.out.println( "Your Name is : " + name + " " + surname);
        System.out.println("You are " + profession + " professional with " + noOfYearsOfExperience + " years of experience" );
        inputFromConsole.close();
	}	
}
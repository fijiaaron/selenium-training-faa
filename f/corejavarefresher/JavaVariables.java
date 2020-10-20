/*
 * The following program gives example of 
 * primitive variables in Java and String class
 */

package corejavarefresher;

public class JavaVariables {

	public static void main(String[] args) {

		/* Integer type primitive data types */
		
		byte monthInNumber;			/* 8 bits signed. saves memory in large array. Signed -128 to 127 */
		short yearInNumber; 		/* 16 bit signed */
		int accountNumber;			/* 32 bit signed */
		long accountBalance; 		/* 64 bit signed */

		int salary;  				/* Declaring the variable salary of type integer */
		salary = 100000; 			/* initializing the variable sum */
		salary = 1500000; 			/* assigning a value to the variable sum */

		int bonus = 10000;			/* declaring and initializing in single line */
		System.out.println("Revised Salary is - " + salary + "And the bonus is - " + bonus);
		
		/* boolean primitive data type */
		boolean seleniumIsEasy, javaIsDifficult;
		seleniumIsEasy = true;
		javaIsDifficult = false;
				
		/* char type primitive data types */
		//char holds single character. Enclosed by single quotes. It is 16 bit
		char employeeCode;/* Permanent - P, On Contract - C */
		employeeCode ='P';
	
		/* floating point types primitive data types*/
		float volume;		//32 bit - single precision floating point
		
		double area;		//64 bit - double precision floating point
		
		/* String is a class and it does not come under primitive data type */
		
		String name = "Cedric";
		String surname = "Beust";
		
		/* Method chaining in Java. */
		boolean nameInUpperCase = name.toUpperCase().equals("CEDRIC");
		
		/* If we do not use method chaining then the expression above have to be split in two lines as given below */
		String upper = name.toUpperCase();
		boolean checkThis = upper.equals("CEDRIC");
		
		/*
		 Data Type 	Default Value
			byte 	0
			short 	0			
			int 	0
			long 	0L
			
			boolean 	false
			
			char 	'\u0000'
			
			float 	0.0f
			double 	0.0d
			
			String (or any object)   	null
		 */	
		
	}

}

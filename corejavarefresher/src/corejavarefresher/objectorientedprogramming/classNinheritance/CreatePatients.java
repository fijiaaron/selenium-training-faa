/*
 * This file creates objects of type Patient class.
 * Uses all the methods via object reference
 */

package corejavarefresher.objectorientedprogramming.classNinheritance;

public class CreatePatients {

	public static void main(String[] args) {
		/* Declaring the patients object references */
		Patient patient1, patient2;

		/* Will below line compile? */
		// System.out.println(patient1.getName());

		patient1 = null;
		/* What happens if below line is compiled */
		// System.out.println(patient1.getName());

		/* Creating objects of Patient class */
		patient1 = new Patient("Mr. Vemore B. Bhave", 57, "Fever");
		patient2 = new Patient("Mr. Cuke L. Lambada", 42);
		Patient patient3 = new Patient("Mr. K. C. Verma");

		/*
		 * Using the object references to access methods of the class
		 */

		System.out
				.println(patient1.getName() + " is " + patient1.getAge()
						+ " years old and is diagnosed with "
						+ patient1.getDiagnosis());
		System.out
				.println(patient2.getName() + " is " + patient2.getAge()
						+ " years old and is diagnosed with "
						+ patient2.getDiagnosis());
		patient3.setAge(83);
		patient3.setDiagnosis("low BP");
		System.out
				.println(patient3.getName() + " is " + patient3.getAge()
						+ " years old and is diagnosed with "
						+ patient3.getDiagnosis());
		System.out.println();
		patient3.displayPatientDetails();

		/* What does below statement indicate? */
		patient1 = patient3;

		/* what happens if we execute the below code */

		patient1.setDiagnosis("skin disease");

		System.out.println(patient3.getName() + " is suffering from "
				+ patient3.getDiagnosis());

	}

}

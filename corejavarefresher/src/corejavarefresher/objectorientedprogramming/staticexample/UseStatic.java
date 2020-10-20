/*
 * The file shows the example of using static methods
 */

package corejavarefresher.objectorientedprogramming.staticexample;

import corejavarefresher.objectorientedprogramming.classNinheritance.Patient;

public class UseStatic {

	public static void main(String[] args) {

		Patient patient1, patient2;
		patient1 = new Patient("Mr. Vishu Gupta");

		/* What is the difference between below statements */
		System.out.println(patient1.getNoOfPatients());
		System.out.println(Patient.getNoOfPatients());
		
		/* see what happens after creating second object */
		patient2 = new Patient("Mrs. Veena Merchant");
		System.out.println(patient1.getNoOfPatients());
		System.out.println(patient2.getNoOfPatients());
		System.out.println(Patient.getNoOfPatients());
	}

}

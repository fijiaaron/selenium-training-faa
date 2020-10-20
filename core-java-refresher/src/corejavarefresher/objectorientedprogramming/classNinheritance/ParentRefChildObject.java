/*
 * Java allows the parent object reference to 
 * point to a child object. This has a very significant 
 * benefit programming in Java. This is also called
 * subtype polymorphism. 
 */

package corejavarefresher.objectorientedprogramming.classNinheritance;

public class ParentRefChildObject {

	public static void main(String[] args) {
		

		Patient patient1 = new AdmittedPatient("Mr. Vasva Dona", 45, "fever",
				345, "Dr. Desai");
		AdmittedPatient patient2 = new AdmittedPatient("Mrs. Shruti Kotecha");
		patient1.displayPatientDetails();

		/* Why the below call is not a valid call */
		// patient1.getRoomNo();
		patient2.getRoomNo();

		patient1 = patient2;
		/* After above statement still the below call is not a valid call, why? */
		// patient1.getRoomNo();

	}

}

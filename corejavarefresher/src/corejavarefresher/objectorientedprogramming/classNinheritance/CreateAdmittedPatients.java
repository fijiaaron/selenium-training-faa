/*
 * This file creates objects of type AdmittedPatient class.
 * Uses all the methods via object reference.
 */

package corejavarefresher.objectorientedprogramming.classNinheritance;

public class CreateAdmittedPatients {

	public static void main(String[] args) {

		AdmittedPatient aPatient1, aPatient2;
		aPatient1 = new AdmittedPatient("Mr. Ameer Vasan", 82, "Asthama", 302,
				"Dr. A. B. Chavre");
		aPatient1.displayPatientDetails();
		System.out.println(aPatient1.getName() + " is in room No. "
				+ aPatient1.getRoomNo() + " and "
				+ aPatient1.getAssignedDoctor() + " is assigned to him/her.");

	}

}

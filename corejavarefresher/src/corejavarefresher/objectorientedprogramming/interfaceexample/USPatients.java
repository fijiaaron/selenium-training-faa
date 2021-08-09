/*
 * The class USPatients implements PatientInterface
 * It has to implement both the methods in the interface.
 * This class also has its own instance variables and other
 * methods applicable
 */
package corejavarefresher.objectorientedprogramming.interfaceexample;

public class USPatients implements PatientInterface {
	String name;
	String SSN;
	boolean admitted;
	public static int noOfPatients;

	public USPatients(String name, String ssn) {
		this.name = name;
		this.SSN = ssn;
		noOfPatients++;
	}

	@Override
	public void displayPatientDetails() {
		System.out.println("Patient Name: " + name);
		System.out.println("Patient SSN: " + SSN);
	}

	@Override
	public void dischargePatient() {
		admitted = false;
		noOfPatients--;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String SSN) {
		this.SSN = SSN;
	}

	public boolean isAdmitted() {
		return admitted;
	}

	public void setAdmitted(boolean admitted) {
		this.admitted = admitted;
	}

	public static int getNoOfPatients() {
		return noOfPatients;
	}

}

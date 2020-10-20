package corejavarefresher.objectorientedprogramming.interfaceexample;

public class IndianPatients implements PatientInterface {
	String name;
	String adharNumber;
	boolean admitted;
	public static int noOfPatients;

	public IndianPatients(String name, String adharNumber) {
		this.name = name;
		this.adharNumber = adharNumber;
		noOfPatients++;
	}

	@Override
	public void displayPatientDetails() {
		System.out.println("Patient Name: " + name);
		System.out.println("Patient Adhar Card Number: " + adharNumber);
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

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
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

	public static void setNoOfPatients(int noOfPatients) {
		IndianPatients.noOfPatients = noOfPatients;
	}

}

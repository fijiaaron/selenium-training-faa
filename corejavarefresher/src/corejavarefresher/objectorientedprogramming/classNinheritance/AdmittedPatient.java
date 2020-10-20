/*
 * This file creates a simple java class which inherits Patient class.
 * In this example, AdmittedPatient is a subclass and Patient 
 * is super class. 
 */

package corejavarefresher.objectorientedprogramming.classNinheritance;

public class AdmittedPatient extends Patient {

	/* These are additional instance variables for AdmittedPatient */
	private int roomNo;
	private String doctorAssigned;

	/* Constructors need to accept instance variables of parent as well */
	public AdmittedPatient(String name, int patientAge, String diagnosis,
			int roomNo, String doctorAssigned) {
		/*
		 * Using super keyword parents class constructor with 3 parameters is
		 * invoked
		 */
		super(name, patientAge, diagnosis);
		this.roomNo = roomNo;
		this.doctorAssigned = doctorAssigned;
	}

	/* Overloaded constructor */
	public AdmittedPatient(String name, int patientAge, int roomNo) {
		super(name, patientAge);
		this.roomNo = roomNo;
		this.doctorAssigned = "Dr. Mohan V David";
	}

	/* Overloaded constructor */
	public AdmittedPatient(String name) {
		super(name);
		this.roomNo = 0;
		this.doctorAssigned = "Dr. Mohan V David";
	}

	/* Getter and setter methods for doctor */
	public void changeDoctor(String newDoctor) {
		this.doctorAssigned = newDoctor;
	}

	public String getAssignedDoctor() {
		return doctorAssigned;
	}

	/* Getter and setter methods for Room Number */
	public void changeRoomNo(int newRoomNo) {
		this.roomNo = newRoomNo;
	}

	public int getRoomNo() {
		return roomNo;
	}

	@Override
	public boolean displayPatientDetails() {
		System.out.println("Patient Name: " + getName());
		System.out.println("Patient Age: " + getAge());
		System.out.println("Patient Diagnosis: " + getDiagnosis());
		System.out.println("Patient Room No: " + roomNo);
		System.out.println("Doctor attending: " + doctorAssigned);
		return true;
	}

}

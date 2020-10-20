/*
 * This file gives example of a creating a simple java class.
 * Typically a java class contains, instance variables
 * class variables, constructors, and business methods
 */

package corejavarefresher.objectorientedprogramming.classNinheritance;

public class Patient {

	/*
	 * the Patient class has three instance variable. Typically instance
	 * variables are declare as private. They are accessed via their getter and
	 * setter methods
	 */
	private String name;
	private int age;
	private String diagnosis;
	private boolean admitted = false;
	private static int noOfPatients = 0;

	/* First constructor of the Patient class accepts all the values */
	public Patient(String name, int patientAge, String diagnosis) {

		this.name = name;
		age = patientAge;
		this.diagnosis = diagnosis;
		admitted = true;
		noOfPatients++;
	}

	/*
	 * Second constructor (constructor overloading) of the Patient class does
	 * not take diagnosis as input
	 */
	public Patient(String name, int patientAge) {

		this.name = name;
		age = patientAge;
		this.diagnosis = "Asthma";
		admitted = true;
		noOfPatients++;
	}

	/*
	 * Third constructor/default constructor of the Patient class accepting only
	 * name as input
	 */
	public Patient(String name) {
		this.name = name;
		age = 0;
		this.diagnosis = "Not Applicable";
		admitted = true;
		noOfPatients++;
	}

	/* Setter and Getter Method for name instance variable */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* Setter and Getter Method for age instance variable */
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/* Setter and Getter Method for diagnosis instance variable */
	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	/* Method to display patient details */
	public boolean displayPatientDetails() {
		if (admitted) {
			System.out.println("Patient Name: " + name);
			System.out.println("Patient Age: " + age);
			System.out.println("Patient Diagnosis: " + diagnosis);
			return true;
		} else
			return false;
	}

	public void dischargePatient() {
		admitted = false;
		noOfPatients--;
	}

	public static void setNoOfPatients(int newValue) {
		noOfPatients = newValue;
	}

	public static int getNoOfPatients() {
		return noOfPatients;
	}

	/* Will below code compile? */

	/*
	 * public static void setPatientAgeHere(int newValue) { age = newValue; }
	 */

}

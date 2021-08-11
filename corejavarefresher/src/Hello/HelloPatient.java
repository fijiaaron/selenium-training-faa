package Hello;

import Person.Patient;
import Person.Person;

public class HelloPatient
{
	
	
	public static void main(String[] args)
	{
		Person doctor = new Person("Aaron Evans", 46, "male");
		Patient patient = new AdmittedPatient("Kelsey Evans", 21, "female");
		patient.assignDoctor(doctor);
		
		System.out.println("Hello, " + patient.name + " I'm doctor " + patient.getDoctor());
		System.out.println("What seems to be the problem?");
	}
}

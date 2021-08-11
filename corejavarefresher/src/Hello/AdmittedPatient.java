package Hello;

import Person.Patient;
import Person.Person;

public class AdmittedPatient extends Patient
{
	public AdmittedPatient(String fullName, int age, String gender)
	{
		super(fullName, age, gender);
	}

	@Override
	public void assignDoctor(Person doctor)
	{
		this.doctor = "Dr. " + doctor.lastName;
	}
	
}

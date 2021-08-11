package Person;

public abstract class Patient extends Person
{
	protected String doctor;
	
	public Patient(String fullName, int age, String gender)
	{
		super(fullName, age, gender);
	} 
	
	@Override
	public int getAge()
	{
		return this.age;
	}
	
	public abstract void assignDoctor(Person doctor);
	
	public String getDoctor()
	{
		return this.doctor;
	}
}

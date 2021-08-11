package Person;

public class Person
{
	public String name;
	public String lastName;
	protected int age;
	private String gender;
	
	public Person(String fullName, int age, String gender)
	{
		String[] names = fullName.split(" ");
		this.name = names[0];
		this.lastName = names[1];
		this.age = age;
		this.gender = gender;
	}
	
	public Person(String name, String lastName, int age, String gender)
	{
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public int getAge()
	{
		if (gender == "male")
		{
			return age;
		}
		else
		{
			return 21;
		}
	}
}

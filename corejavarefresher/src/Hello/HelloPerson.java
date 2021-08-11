package Hello;

import java.util.ArrayList;
import java.util.List;

import Person.Person;

public class HelloPerson
{
	public static void main(String[] args)
	{
		Person aaron = new Person("Aaron", "Evans", 46, "male");
		Person kelsey = new Person("Kelsey", "Evans", 49, "female");
	
		List<Person> people = new ArrayList<>();
		people.add(aaron);
		people.add(kelsey);
		
		for(Person person : people)
		{
			System.out.println("Hello, " + person.name);
			
			if (person.getGender() == "male")
			{
				System.out.println("Nice to meet you Mr. " + person.lastName); 
			}
			else 
			{
				System.out.println("Nice to meet you Mrs. " + person.lastName); 
			}
			
			if ( person.getAge() > 40)
			{
				System.out.println("I can't believe you're that old");
			}
			
		}
	}
}
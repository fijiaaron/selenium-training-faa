import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Greeter
{
	public static void main(String[] args) throws IOException
	{
		String name = "Aaron";
		System.out.println("Hello, " + name);
		
		if (args.length > 0)
		{
			name = args[0];
		}
		else 
		{
			name = "World";
		}
		System.out.println("Hello again, " + name);
		
		System.out.println("Are you male or female?");
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		String gender = reader.readLine();
	
		System.out.printf("You're a %s, %s!\n", gender.equalsIgnoreCase("male") ? "Wizard" : "Witch", name);
		
		
		System.out.println("What is your last name?");
		Scanner scanner = new Scanner(System.in);
		String lastName = scanner.next();
		System.out.println("Nice to meet you, Mr. " + lastName);
		
		System.out.println("How old are you?"); 
		int age = scanner.nextInt();
		scanner.close();
		
		System.out.println("Well, happy birthday!");
		
		if (age == 11)
		{
			System.out.println("Congratulations, you've been accepted to Hogwarts!");
			System.out.println("There's no time to lose, it's off to Diagon Alley with you, to purchase school your school supplies");
		}
	}
	
	public void foo() {}
	
	public void far( ) {}
}
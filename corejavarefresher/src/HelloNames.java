public class HelloNames
{
	public static void main(String[] args)
	{
		String name = "World";
		
		if (args.length > 0)
		{
			for (int i=0; i<args.length; i++)
			{
				name = args[i];
				System.out.println("Hello, " + name);
				System.out.println("How are you?");
			}
		}
		else 
		{
			System.out.println("Hello, " + name);
		}
	}
}

public class Math
{
	public static void main(String[] args) throws Exception
	{
		int a = 5;
		int b = 0; 
		
		try 
		{
			int c = a / b;
			System.out.println("the total is " + c);
		}
		catch (Exception e)
		{
			System.out.println("Sorry, I can't calculate ");
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Have a nice day!");
			throw new Exception("illegal denominator!!!!");
		}
	}
}

import java.util.Scanner;



public class fact {



	
	
	

	
	
	
	
	
	

	
	static int factorial(int n)

	{

		if(n<=1)

		{

			System.out.println("Base case");

			return 1;

		}

		else

		{

			System.out.println("n="+n);

			return n*factorial(n-1);

		}

	}

	

	

	
	static int fibonacci(int n)

	{

		if(n==1 || n==0)

		{

			System.out.println("Base case");

			return 1;

		}

		else

		{

			System.out.println("Computing " + n + "th fibonacci number...");

			return fibonacci(n-1) + fibonacci(n-2);

		}

	}

	

	public static void main(String [] args)

	{

		
		Scanner cin = new Scanner(System.in);

		

		int n = cin.nextInt();

		

		
		System.out.println(fibonacci(n));

		

		cin.close();

		

	}

}
package pkg;

public class Recursion {
	static public int num(int n)
	{
		if(n==0||n==1)
		{
			return 1;
		}
		else
		{
			return n*num(n-1);
		}
	
	}

	public static void main(String[] args)
	{
		System.out.println("Hi");
		int n=5;
		System.out.println(num(5));
	}
}
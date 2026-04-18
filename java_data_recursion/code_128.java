package Java.Mouritech.Venkat1;

public class Recursion_Factorial {
	public static int m1(int n) {
		if(n==1)
			return 1;
		else
		    return n*m1(n-1);
	}
	public static void main(String[] args) {
		System.out.print(m1(2));
	}

}
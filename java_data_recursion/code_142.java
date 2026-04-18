package Recursion;
import java.util.Scanner;
public class fibonacci {
	public static int[] fibonaaci(int n) {
		int[] arr = new int[n];
		if(n==1) return new int[1];
		arr[1]=1;
		return solve(0,1,arr,5);
	}
	public static int[] solve(int a, int b, int[] arr, int i) {
		if(i>=arr.length) return arr;
		arr[i] = a+b;
		return solve(b, a+b,arr,i+1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = sc.nextInt();
		fibonaaci(n);
		
}
}
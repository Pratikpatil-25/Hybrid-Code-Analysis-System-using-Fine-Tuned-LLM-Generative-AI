package com.ct.Recursion;

public class FunctionalRecursion {
	
	public static void main(String[] args) {
		
						
		
		System.out.println(findFactorial(4));
		
	}
	
	public static int funcRecursion(int n) {
		
		if(n==0) {
			
			return 0;
		}
				return n + funcRecursion(n-1);
	}
	
	
	public static int findFactorial(int n) {
	
		if(n==1) {
			
			return 1;		
		}
		
		return findFactorial(n-1)*n;
	}

}
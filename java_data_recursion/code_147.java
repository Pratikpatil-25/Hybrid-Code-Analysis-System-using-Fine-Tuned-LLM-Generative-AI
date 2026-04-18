package com.codegnan.recursion;

import java.util.Scanner;

public class LinearSearchUsingRecursion {

	public static int search(int[] arr, int target,int i) {
		
		
		if(i == arr.length) {
			return -1;
		}
		
		if(arr[i] == target) {
			return i;
		}
		
		return search(arr, target, i+1);
		
		
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter array size : ");
		int n= input.nextInt();
		
		int[] nums = new int[n];
		
		for(int i= 0; i<n; i++) {
			System.out.println("Enter element "+(i+1)+" : ");
			nums[i] = input.nextInt();
		}
		
		System.out.println("Enter a number to search : ");
		int target =  input.nextInt();
		
				int res = search(nums, target,0);
		
		if(res >=0) {
			System.out.println("Element found index no : "+res);
		}else {
			System.out.println("Element not found ");
		}
	}

}
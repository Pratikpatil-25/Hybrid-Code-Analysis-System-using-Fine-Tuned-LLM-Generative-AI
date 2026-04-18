package sorting;

import java.util.Arrays;

public class MergeSort {
	int arr[];
	MergeSort(int arr[]){
		this.arr = arr;
	}
	public void mergesort(int arr[]) {
		divide(arr,0,arr.length-1);
	}
	private void divide(int arr[],int start, int end) {
		if(start<end) {
			int middle = (start+end)/2;
			divide(arr,start,middle);
			divide(arr,middle+1,end);
			sort(arr,start,middle,end);
		}
	}
	private void sort(int arr[],int left, int middle, int right) {
		int leftarray[] = new int[middle-left+2];
		int rightarray[] = new int[right-middle+1];
		for(int i=0; i<=middle-left;i++) {
			leftarray[i] = arr[left+i];
		}
		for(int i=0;i<right-middle;i++) {
			rightarray[i] = arr[middle+1+i];
		}
		leftarray[middle-left+1] = Integer.MAX_VALUE;
		rightarray[right-middle] = Integer.MAX_VALUE;
		int i=0,j=0;
		for(int k=left;k<=right;k++) {
			if(leftarray[i]<rightarray[j])
				arr[k] = leftarray[i++];
			else 
				arr[k] = rightarray[j++];
		}
		
	}
	public static void printarray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
}
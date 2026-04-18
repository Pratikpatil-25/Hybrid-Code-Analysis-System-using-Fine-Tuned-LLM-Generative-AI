import java.util.*;


public class SelectionSort {

	public static void main(String arg[]) {

		int[] arr = {5,4,1,0,5,95,4,-100,200,0};
		
		int[] sortedArray = selectionSort(arr);
		
		for(int j: sortedArray){

			System.out.print(j +",");
		}
		
					}

	public static int[] selectionSort(int[] unsortedArray){

		int minIndex;
	
		for(int i=0; i<unsortedArray.length; i++) {
			
			minIndex = findMinIndex(unsortedArray, i, unsortedArray.length-1); 
			
			int temp = unsortedArray[i];
			unsortedArray[i]= unsortedArray[minIndex];
			unsortedArray[minIndex]=temp;
		}

		return unsortedArray;
	}

	public static int findMinIndex(int[] unsortedArray, int startIndex, int endIndex) {

		int minIndex = startIndex;

		for(int i=startIndex; i<=endIndex; i++) {
		
			if(unsortedArray[i] < unsortedArray[minIndex]) {
				
				minIndex = i;
			}		
		}
		return minIndex;
	}

}
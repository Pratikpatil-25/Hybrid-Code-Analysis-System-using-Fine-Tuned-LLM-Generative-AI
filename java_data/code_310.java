package SortAlgorithm;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int [] arrayToSort = {22, 12, 0, 4, 28, 28, 12, 1};
		
		System.out.println("Un Sorted array element is - "+ Arrays.toString(arrayToSort));
				SelectionSort selectionSort = new SelectionSort();
		
		int[] newSortedArray = selectionSort.doSelectionSort(arrayToSort);
		
		System.out.println("Sorted array element is - "+ Arrays.toString(newSortedArray));
	}
	
	public int [] doSelectionSort(int[] arrayToSort) {
		for(int i = 0; i < arrayToSort.length; i++){
			int smallestElement = i;
			for(int j = i +1; j < arrayToSort.length; j++){
				if(arrayToSort[j] < arrayToSort[smallestElement]) {
					smallestElement = j;
				}
			}
			
						int temp = arrayToSort[i];
			arrayToSort[i] = arrayToSort[smallestElement];
			arrayToSort[smallestElement] = temp;
		}
		
		return arrayToSort;
	} 

}
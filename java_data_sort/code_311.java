public class Main {
	 public static void main(String[] args) {
		 int arr[] = {2,4,7,8,9,0,1,2,5,2};
		 		 int swap =0;
		 		 for(int i =0; i<arr.length; i++)
		 {
			 for(int j =0; j<arr.length; j++)
			 {
				 if(arr[j] > arr[i])
				 {
					 swap = arr[i];
					 arr[i] = arr[j];
					 arr[j] = swap;
				 }	 
			 }
		 }
		 
		 for(int i =0; i<arr.length; i++)
		 {
			 System.out.print(arr[i]);
		 }
		 System.out.println();
		 int min_value = arr[0];
		 int min_index = 0;
		 for(int i = 0; i<arr.length; i++) {
			 min_index = i;
			 for(int j = i; j<arr.length; j++)
			 {
				 if(arr[min_index] > arr[j]) {
					 min_index = j;
				 }
			 }
			 
			 swap = arr[min_index];
			 arr[min_index]  =  arr[i];
			 arr[i] = swap;
			 
		 }
		 
		 for(int i =0; i<arr.length; i++)
			 System.out.print(arr[i]);
		 
		 
	 }
}
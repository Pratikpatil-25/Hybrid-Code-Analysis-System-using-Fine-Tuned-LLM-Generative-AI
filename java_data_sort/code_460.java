package Sorting;

public class Quick_Sort {
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si-1;

        for(int j=si; j<ei; j++) {
            if(arr[j] < pivot) {
                i++;
                                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[ei] = temp;
        return i; 
    }

    public static void quickSort(int arr[], int si, int ei) {
        if(si < ei) {
            int pidx = partition(arr, si, ei);

            quickSort(arr, si, pidx-1);
            quickSort(arr, pidx+1, ei);
        }
    }

    public static void main(String args[]) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        quickSort(arr, 0, n-1);

                for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
public class MergeSort {
    
    public static int[] mergeSort(int[] arr, int l, int r) {         if (l < r) {

                        int m = (l + r) / 2;

            mergeSort(arr, l, m);               mergeSort(arr, m+1, r);             merge(arr, l, m, r);            }
        return arr;
    } 

                public static void merge(int[] arr, int l, int m, int r) { 
        
                int length1 = m - l + 1;
        int length2 = r - m;

                int L[] = new int[length1];
        int R[] = new int[length2];

                for (int i = 0; i < length1; i++) {
            L[i] = arr[l + i];
        }
        
        for (int j = 0; j < length2; j++) {
            R[j] = arr[m + 1 + j];
        }
        
                int i = 0;         int j = 0;         int k = l; 
                while(i < length1 && j < length2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
                while (i < length1) {
            arr[k] = L[i];
            i++;
            k++;
        }

                while (j < length2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
import java.util.Arrays;

public class SelectionSort {

    public static void selectionSortAlgo(int[] arr) {
        
        for (int i = 0; i <= arr.length - 2; i++) {
            int mini = i;
            
            for (int j = i; j <= arr.length - 1; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }

            
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, 42, 523, 13, 54, 1, 0, 3 };

                        selectionSortAlgo(arr);
        System.out.println(Arrays.toString(arr));
    }
}
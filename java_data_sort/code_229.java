package ijp.sort.bubblesort;

public class BubbleSortEasyUnderstand {

	
    public static boolean singleBubblePass(int[] arr, int indexLeft, int indexRight) {
        boolean isNoSwap = true;

                if (arr == null || indexLeft < 0 || indexRight >= arr.length || indexLeft >= indexRight) {
            System.out.println("Invalid input");
            return true;         }

        for (int i = indexLeft; i < indexRight; i++) {
            if (arr[i] > arr[i + 1]) {
                                swap(arr, i, i + 1);
                isNoSwap = false;
            }
        }

        return isNoSwap;
    }

        public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

        public static void bubbleSort(int[] arr) {
        int n = arr.length;

                for (int endIndex = n - 1; endIndex > 0; endIndex--) {
            boolean sorted = singleBubblePass(arr, 0, endIndex);
            if (sorted) break;         }
    }

        public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        System.out.println("Before sorting: " + java.util.Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println("After sorting:  " + java.util.Arrays.toString(arr));
    }
	}
//https://chatgpt.com/share/68283652-aed4-8003-b01e-79662db4239f
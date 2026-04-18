package Java_consepts.Array;

public class binary_search {
    
    public static int binarySearch(int array[], int key) {
        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
                        if (array[mid] == key) {
                return mid;
            }
            if (array[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int array[] = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
        int key = 17;
        System.out.println("find the value : " + binarySearch(array, key));
    }
}
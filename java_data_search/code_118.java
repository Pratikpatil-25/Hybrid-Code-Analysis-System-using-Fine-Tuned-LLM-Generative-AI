package Arrays.Searching;

public class linearSeach {
    static int search(int[]arr,int target){
        if (arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;             }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {32,435,462,4234,13322,232,1,67};
        System.out.println(search(arr, 462));
    }
}
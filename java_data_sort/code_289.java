import java.util.Scanner;

public class ZigzagArray_Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
                System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        
                int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
                zigzagSort_Q5(arr);
        
                System.out.println("Array in zigzag pattern:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
        scanner.close();
    }
    
        private static void zigzagSort_Q5(int[] arr) {
        boolean flag = true;         
        for (int i = 0; i < arr.length - 1; i++) {
            if (flag) {                                 if (arr[i] > arr[i + 1]) {
                    swap_Q5(arr, i, i + 1);
                }
            } else {                                 if (arr[i] < arr[i + 1]) {
                    swap_Q5(arr, i, i + 1);
                }
            }
            
                        flag = !flag;
        }
    }
    
        private static void swap_Q5(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
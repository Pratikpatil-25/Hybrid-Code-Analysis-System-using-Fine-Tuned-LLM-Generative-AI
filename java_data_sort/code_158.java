import java.util.Scanner;

public class Solution {

    static int[] sum(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];

        for (int i=0; i<arr1.length; i++) {
            arr[i] = arr1[i];
        }

        for (int i=arr1.length, j=0; i<(arr1.length + arr2.length) && j<arr2.length; i++, j++) {
            arr[i] = arr2[j];
        }

        return arr;
    }

    static int[] sort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-1; j++) {
                if (arr[j] > arr [j+1]) {
                    int z = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = z;
                }
            }
        }
        return arr;
    }
    
    static double median(int[] array) {
        int n = array.length;
        
        if (n % 2 == 1) {
            return array[n/2];
        } else {
            int mid1 = array[n/2];
            int mid2 = array[(n/2)-1];
            return (mid1 + mid2) / 2.0; 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Array 1:");
        System.out.print("Enter the length of the first array: ");
        int len1 = sc.nextInt();
        int[] arr1 = new int[len1];
        for (int i=0; i<len1; i++) {
            System.out.print("Enter value no. " + i + ": ");
            arr1[i] = sc.nextInt();
        }

        System.out.println();
        
        System.out.println("Array 2:");
        System.out.print("Enter the length of the second array: ");
        int len2 = sc.nextInt();
        int[] arr2 = new int[len1];
        for (int i=0; i<len2; i++) {
            System.out.print("Enter value no. " + i + ": ");
            arr2[i] = sc.nextInt();
        }

        int[] arr = Solution.sum(arr1, arr2);
        int[] final_sorted_array = Solution.sort(arr);
        int n = final_sorted_array.length;
        
        System.out.println();
        
        System.out.print("Your combined and sorted array: {");
        for (int j=0; j<n; j++) {
            if (j < n-1) {
                System.out.print(final_sorted_array[j] + ", ");
            } else {
                System.out.print(final_sorted_array[j]);
            }
        }
        System.out.print("}");
        
        double median = Solution.median(final_sorted_array);
        System.out.println("\nThe median of your dataset is: " + median);
    }
}
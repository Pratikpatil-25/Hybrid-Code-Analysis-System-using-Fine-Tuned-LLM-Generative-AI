import java.util.Arrays;

import java.util.Scanner;



public class NumSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        

        System.out.println("Enter the number of elements in the array:");

        int n = scanner.nextInt();

        

        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < n; i++) {

            array[i] = scanner.nextInt();

        }

        

        
        Arrays.sort(array);

        

        
        int sum = 0;

        for (int num : array) {

            sum += num;

        }

        double average = (double) sum / n;

        

        
        System.out.println("Sorted array: " + Arrays.toString(array));

        System.out.println("Sum: " + sum);

        System.out.println("Average: " + average);

        

        scanner.close();

    }

}
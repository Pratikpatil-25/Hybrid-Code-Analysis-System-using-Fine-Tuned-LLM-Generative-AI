package fibo;

import java.util.*;


public class Fibo {

    
    public static void main(String[] args) {
                boolean test = true;
        int[] sequenceFibonacci = new int[45];
                recursion(sequenceFibonacci, 0);
                display(sequenceFibonacci, test);
    }

    static void recursion(int[] array, int i) {

                if (i <= 1) {
            array[i] = i;
            i++;
        }

                if (i > 1) {
            array[i] = array[i - 1] + array[i - 2];
            i++;
        }

                if (i < 45) {
            recursion(array, i);
        }
    }

    static void display(int[] array, boolean test) {
        System.out.println("The 45 sequence Fibonacii");
                for (int i = 0; i < 45; i++) {
            if (test == false) {
                if (i < 44) {
                    System.out.print(array[i] + ",");
                } else {
                    System.out.println(array[i]);
                }
            } else {
                System.out.println("Index " + (i + 1) + ": " + array[i]);
            }
        }
        Scanner sc = new Scanner(System.in);
        int stop = sc.nextInt();
    }

}
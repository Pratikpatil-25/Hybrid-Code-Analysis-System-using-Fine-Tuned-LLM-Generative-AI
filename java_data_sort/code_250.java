import java.util.*;

class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter # of random numbers to sort.");

        int numOfNumbers = s.nextInt();

        s.close();



        SortLib sl = new SortLib();

        int array1[] = new int[numOfNumbers];

        sl.makeData(array1);

        int array2[] = array1; int array3[] = array1; int array4[] = array1;



        sl.displayAll(array1);

        sl.displayTen(array1);



        for (int ctr = 0; ctr <= 3; ctr++) {

            switch(ctr) {

                case 0: 

                    System.out.println("QuickSort took " + sl.quickSorter(array4) + "ms");

                    break;

                case 1:

                    System.out.println("SelectionSort took " + sl.selectionSorter(array2) + "ms");

                    break;

                case 2:

                    System.out.println("InsertionSort took " + sl.insertionSorter(array3) + "ms");

                    break;

                case 3:

                    System.out.println("BubbleSort took " + sl.bubbleSorter(array1) + "ms");

                    break;

            }

        }

    }

}
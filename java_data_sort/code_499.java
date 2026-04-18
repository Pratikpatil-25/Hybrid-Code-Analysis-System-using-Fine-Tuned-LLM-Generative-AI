package homework_30.ascending_descending_sort;

import java.util.*;

public class AscendingDescendingSort {

    public static void main(String[] args) {

        Double[] numbers = new Double[10];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 10 * random.nextDouble();
        }

                System.out.printf("Original numbers: %s%n ", Arrays.toString(numbers));

                Arrays.sort(numbers);
        System.out.printf("Sort ascending:  %s%n ", Arrays.toString(numbers));


        
        Arrays.sort(numbers, Comparator.reverseOrder());
        System.out.printf("Sort descending:  %s%n ", Arrays.toString(numbers));


    }

}
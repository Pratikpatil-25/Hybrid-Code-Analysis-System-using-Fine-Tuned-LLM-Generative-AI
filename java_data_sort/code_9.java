package demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class UpperBoundWildcard<T extends Number> {
    private List<T> numbers = new ArrayList<>();

    public void addNumber(T number) {
        numbers.add(number);
    }

    public double sum() {
        double sum = 0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public void sort() {
        Collections.sort(numbers, (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));
    }

    public List<T> getNumbers() {
        return numbers;
    }
}

public class LAB8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UpperBoundWildcard<Number> genericList = new UpperBoundWildcard<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a number");
            System.out.println("2. Calculate sum");
            System.out.println("3. Sort numbers");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number (Integer or Double): ");
                    if (scanner.hasNextInt()) {
                        genericList.addNumber(scanner.nextInt());
                    } else if (scanner.hasNextDouble()) {
                        genericList.addNumber(scanner.nextDouble());
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();                     }
                    break;
                case 2:
                    System.out.println("Sum of numbers: " + genericList.sum());
                    break;
                case 3:
                    genericList.sort();
                    System.out.println("Sorted numbers: " + genericList.getNumbers());
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();                     System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
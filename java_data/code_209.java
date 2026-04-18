import java.util.Scanner;

public class MinAndMaxScore {

    public static void findMinMax(int[] arr) {

        int n = arr.length;
        int min, max;
        int i;

        if (n == 1) {
            min = max = arr[0];
        } else {

            if (arr[0] < arr[1]) {
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }

            i = 2;

            while (i < n - 1) {

                int localMin, localMax;

                if (arr[i] < arr[i + 1]) {
                    localMin = arr[i];
                    localMax = arr[i + 1];
                } else {
                    localMin = arr[i + 1];
                    localMax = arr[i];
                }

                if (localMin < min) {
                    min = localMin;
                }

                if (localMax > max) {
                    max = localMax;
                }

                i += 2;
            }

            if (n % 2 != 0) {
                if (arr[n - 1] < min) {
                    min = arr[n - 1]; 
                }else if (arr[n - 1] > max) {
                    max = arr[n - 1];
                }
            }
        }

        System.out.println("Min=" + min + ", Max=" + max);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        input = input.replace("[", "").replace("]", "");

        String[] parts = input.split(",");

        int[] arr = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }

        findMinMax(arr);
    }
}

// Space Complexity: O(1)
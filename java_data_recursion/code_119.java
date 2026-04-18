import java.util.Arrays;
import java.util.Scanner;

public class niuniuBag {

    public static int recursion(int n, long w, long[] weights) {
        if (n == 0) {
            return 1;
        }
        int sum = 0;
        if (w >= weights[n - 1])
            sum += recursion(n - 1, w - weights[n - 1], weights);
        sum += recursion(n - 1, w, weights);
        return sum;
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long w = scanner.nextLong(), sum = 0;
        long[] weights = new long[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextLong();
            sum += weights[i];
        }
        if (sum <= w) {
            System.out.format("%.0f", Math.pow(2, n));
            return;
        }
                        System.out.println(recursion(n, w, weights));
    }
}
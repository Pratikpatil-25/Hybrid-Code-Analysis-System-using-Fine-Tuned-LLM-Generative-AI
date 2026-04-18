package Recursion;

public class factorial {

        static int fac(int n) {
        if (n == 0 || n == 1) {
            return 1;          } else {
            return n * fac(n - 1);          }
    }

    public static void main(String[] args) {
        int number = 5;          System.out.println("Factorial of " + number + " is: " + fac(number));
    }
}
import java.util.Scanner;

class lec31 {
    static int lGCD(int x, int y) {
        while (x % y != 0) {
            int rem = x % y;
            x = y;
            y = rem;
        }
        return y;
    }


        static int EuclidsGCD(int x, int y) {
        if (y == 0) return x;
        return EuclidsGCD(y, x % y);
    }
}

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lec31 obj = new lec31();
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(obj.lGCD(x, y));
        System.out.println(obj.EuclidsGCD(x, y));
    }
}
package recursion;

public class Sum {
    public static void main(String[] args) {
        sum(3, 0);
        System.out.println(sum(3));
    }

    static void sum(int i, int sum1){
        if(i < 1){
            System.out.println(sum1);
            return;
        }

        sum(i-1, sum1+i);
    }

    static int sum(int n){
        if(n == 1){
            return n;
        }

        return n + sum(n - 1);
    }
}
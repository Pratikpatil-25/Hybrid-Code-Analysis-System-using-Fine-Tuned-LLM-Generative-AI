package StriversA2ZSdeSheet;

public class Recursion_SumOfFirstNNumbers {
            public static void main(String[] args) {
        int i=1;
        System.out.println(printSumOfN(20));
    }
    static int printSumOfN( int N){
        if(N==0){
            return 0;
        }
        return N + printSumOfN(N-1);

    }
}
import java.util.Scanner;
public class MaxExponent {
    public static int maxExponent(int a, int b){
        int maxNumber = a;
        int maxExponent = 0;

        for(int i=a;i<=b;i++){
            int currentExponent = countExponent(i);
            if(currentExponent > maxExponent){
                maxExponent = currentExponent;
                maxNumber = i;
            }
        }
        return maxNumber;
    }
    public static int countExponent(int number){
        int exponent = 0;
        if(number % 2 == 0){
            exponent++;
            number /= 2;
        }
        return exponent;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(maxExponent(a,b));
    }
}
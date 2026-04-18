package recursion;



import java.util.Scanner;



public class revsum {

    public static int sumnum(int m){

        if(m==1){

            return 0;

        }

        

        

        return m+sumnum(m-1);



    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(" please enter a number:");

        int m = sc.nextInt();

        int result = sumnum(m);

        System.out.println("the sum of numbers from 1 to "+ m +" is :" + result);

        System.out.println(result);

        sc.close();

    }

}
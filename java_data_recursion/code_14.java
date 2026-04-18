public class Lab6 {
    public static void main(String[] args) {

        int sum = Recursion(12345);
        System.out.println("Sum of digits: " + sum);
        

    }  

    public static int Recursion(int number) {
        if (number == 0) {
            return 0;
        } else {
            System.out.println(number % 10);
            System.out.println("------");
            return number%10 + Recursion(number / 10);            
        }
    }
}
public class Recursion {
    public static void main(String[] args) {
       
                int result = permut(10,5);
        System.out.println(result);
      }
      public static int permut(int numerator, int denominator){
        if (numerator > denominator){
            return numerator + permut(numerator-1, denominator);
        }
        else {
            return numerator;
        }
      }
    
}
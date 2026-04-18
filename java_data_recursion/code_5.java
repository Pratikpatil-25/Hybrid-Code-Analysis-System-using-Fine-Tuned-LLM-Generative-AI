public class Recursion {

    public void value(int a) {
        System.out.println(a);
        if( a >= 10){
            return;
        }
        value(a + 1);
    }
  
    public static void main(String[] args) {
        Recursion rec = new Recursion();
        rec.value(1);
    }
}
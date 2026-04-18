import java.util.Scanner;



public class r3 {
public static void main (String [] args ){
    Scanner sc = new Scanner(System.in);
    System.out.println("ENter the value of N ");
    int n = sc.nextInt();
   rev_num(n);
}    
public static void rev_num( int n ){
if(n == 0){
    return;
}
System.out.println(n);
rev_num(n-1);
}
}
public class dsa {

  

   


   static int fib(int n){

    if(n<=1){

        return n;







    }

    int first=fib(n-1);

    int second=fib(n-2);

    int res=first+second;

    return res;



   }

   public static void main(String[]args){

    

    int n=fib(5);

    System.out.println(n);



   }

   }
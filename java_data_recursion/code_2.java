import java.util.Scanner;

class Day8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        recursion obj = new recursion();
        int x = obj.hcf(n, m);
        System.out.print(x);
    }
}
class recursion{
    
    int hcf(int a, int b){
        if(b == 0){
            return a;
        }
        else{
            return hcf(b, a%b);
        }
    }
    
    int fact(int n){
        if(n == 0){
            return 1;
        }
        else{
            return n * fact(n-1);
        }
    }
    
    
    int fibb(int n){
        if (n < 2){
            return n;
        }
        else{
            return fibb(n-1) + fibb(n-2);
        }
    }
}
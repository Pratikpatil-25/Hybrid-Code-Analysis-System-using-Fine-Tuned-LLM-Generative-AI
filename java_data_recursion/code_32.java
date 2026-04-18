public class day4 {
    public void Recursion(int i,int n){
        if(i>n){
            return;
        }
        
        System.out.println(i);
        Recursion(i+1,n);
    }




    public void ReverseRecursion(int i,int n){
        if(i<1){
            return;
        }
        System.out.println(i);
        ReverseRecursion(i-1, n);
    }



public void Recursion1toN(int i,int n){
        if(i<1){
            return;
        }
        Recursion1toN(i-1,n);
        System.out.println(i);
    }



        public void RecursionNto1(int i,int n){
        if(i<1){
            return;
        }
        System.out.println(i);
        RecursionNto1(i-1,n);
    }
    public static void main(String args[]){
        int n=5;
        day4 d4 = new day4();
        

        

        

        d4.RecursionNto1(n, n);
    }
    
}
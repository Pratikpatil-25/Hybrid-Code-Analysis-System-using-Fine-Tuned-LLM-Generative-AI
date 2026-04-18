public class Trailingzerosalgo {
    public static void main(String[] args) {
        
                        
        int n =25;
        int powof=5;
        int res=0;
        while (powof<=n) {
            res+=(n/powof);
            powof=powof*5;
        }
        System.out.println(res);
    }
}
public class q3 {
    public static int length(String s) {
        if(s.isEmpty()) {
            return 0;
        }
        return length(s.substring(1))+1;
    }
    public static void main(String args[]) {
        System.out.print(length("pRatik"));

    }
}
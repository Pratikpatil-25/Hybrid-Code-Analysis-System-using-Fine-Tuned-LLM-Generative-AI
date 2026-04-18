import java.util.Scanner;

class Main2 {
    static int count;
    static String a;
    public static int recursion(String s, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        a = in.nextLine();
        for(int i = 0; i < N; i++){
            a = in.nextLine();
            count = 0;
            System.out.println(isPalindrome(a)+ " " + count);
        }
        in.close();
    }
}
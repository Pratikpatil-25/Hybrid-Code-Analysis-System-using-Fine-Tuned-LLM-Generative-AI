package basics.recursion;
public class StringPalindrome {
    public static void main(String[] args) {
        System.out.println(palindromeCheck("hannah"));
        System.out.println(palindromeCheck("aabbaaa"));
    }
    public static boolean palindromeCheck(String s) {
        if (s.length() <= 1) 
            return true;

        if (s.charAt(0) != s.charAt(s.length()-1)) 
            return false;
        
        return palindromeCheck(s.substring(1, s.length()-1));
    }
}
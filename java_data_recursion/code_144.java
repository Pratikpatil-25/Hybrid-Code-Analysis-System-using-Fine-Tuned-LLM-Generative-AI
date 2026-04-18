package Recursion;

public class Permutation {
    public static void main(String args[]){
        String s = "abcb";
        permut(s , "");

    }
    public static void permut(String s , String ans){
        if(s.length()==0){
            System.out.println(ans);
            return ;
        }
        for(int i = 0;i<s.length();i++){
            char ch  = s.charAt(i);
            boolean f = true;
            for(int j =i+1;j < s.length();j++){                 if(s.charAt(j) == ch){
                    f = false;
                    break;
                }
            }
            if(f){
                String s1 = s.substring(0 , i);
                String s2 = s.substring(i +1);
                permut(s1 + s2 , ans+ch);
            }

        }
    }
}
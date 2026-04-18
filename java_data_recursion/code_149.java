import java.util.* ;
import java.io.*; 
public class Solution {
        public static List<List<String>> partition(String s) {
                List<String> temp = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, temp, res);
        return res;
    }

    private static void helper(String s, int idx, List<String> temp, List<List<String>> res){
        if(idx == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s, idx, i)){
                temp.add(s.substring(idx, i+1));
                helper(s, i+1, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
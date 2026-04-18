package algorithm.leetcode;


public class Solution242 {

    public boolean isAnagram(String s, String t) {
        if (null == s || null == t || s.length() != t.length()) {
            return false;
        }

                int[] map = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++map[s.charAt(i) - 'a'];
            --map[t.charAt(i) - 'a'];
        }

        for (int e : map) {
            if (0 != e) {
                return false;
            }
        }
        return true;
    }

}
package com.ss.leetcode.LC2022.january;

public class RedistributeCharactersToMakeAllStringsEqual {
        
    public boolean makeEqual(String[] words) {
        int[] count = countWords(words);
        for(int c : count) {
            if (c % words.length != 0) {
                return false;
            }
        }
        return true;
    }

    private int[] countWords(String[] words) {
        int[] count = new int[26];
        for(String word : words) {
            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a']++;
            }
        }
        return count;
    }
}
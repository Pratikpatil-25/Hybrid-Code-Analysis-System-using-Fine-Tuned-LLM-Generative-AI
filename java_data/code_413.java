package main.java.algorithm;

import java.util.logging.Logger;


public class MergeStringsAlternately {
    private static final Logger log = Logger.getLogger(MergeStringsAlternately.class.getName());

    public static void main(String[] args) {
        String word1 = "ab";
        String word2 = "pqrs";
        String result = mergeAlternately(word1, word2);
        log.info(() -> String.format("Merge Strings Alternately: word1: %s, word2: %s, result: %s",
                word1, word2, result));
    }

    public static String mergeAlternately(String word1, String word2) {
                if(word1 == null || word2 == null || word1.isEmpty() || word2.isEmpty()) {
            return "";
        }
        if(word1.length() > 100 || word2.length() > 100  ) {
            return "";
        }
        int idxWord = 0;
        StringBuilder result = new StringBuilder();
        while (idxWord < word1.length() || idxWord < word2.length()) {
            if(idxWord < word1.length()) {
                result.append(word1.charAt(idxWord));
            }
            if(idxWord < word2.length()) {
                result.append(word2.charAt(idxWord));
            }
            idxWord++;
        }
        return result.toString();
    }

}
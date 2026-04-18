package com.practice.algorithm.slidingwindow;

public class MaxVowelCountInSubArrayOfK {

    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentVowels = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
                        if (isVowel(s.charAt(right))) {
                currentVowels++;
            }

                        if (right >= k - 1) {
                                maxVowels = Math.max(maxVowels, currentVowels);

                                if (isVowel(s.charAt(left))) {
                    currentVowels--;
                }

                                left++;
            }
        }

        return maxVowels;
    }

    private boolean isVowel(char charAt) {
        return charAt == 'a' || charAt == 'e' || charAt == 'i' || charAt == 'o' || charAt == 'u';
    }

        public static void main(String[] args) {
        MaxVowelCountInSubArrayOfK maxVowelCountInSubArrayOfK = new MaxVowelCountInSubArrayOfK();
        String s1 = "abciiidef";
        int k1 = 3;
        
        System.out.println("Max number of vowels in any substring of length k: " + maxVowelCountInSubArrayOfK      
                .maxVowels(s1, k1));     }

    
}
class Leetcode3163 {
    public String compressedString(String word) {
        StringBuilder compressedString = new StringBuilder();
        int position = 0;
        while (position < word.length()) {
            int consecutiveCount = 0;
            char currentChar = word.charAt(position);
            while (position < word.length() &&
                    consecutiveCount < 9 &&
                    word.charAt(position) == currentChar) {
                consecutiveCount++;
                position++;
            }
            compressedString.append(consecutiveCount).append(currentChar);
        }
        return compressedString.toString();
    }
}
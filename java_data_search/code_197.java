package algos.search;


public class LexicoGraphicalSearch {
    private static char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int h = letters.length-1;
        int m = (l+h)/2;

        while (true) {
            if (target >= letters[m]) {
                if ((m+1 <= letters.length-1) && target < letters[m+1]) {
                    return letters[m+1];
                } else if (m+1 ==  letters.length-1) {
                    if (target >= letters[m+1]) {
                        return letters[0];
                    } else {
                        return letters[m+1];
                    }
                }
                l = m;
            } else {
                if ((m-1 >= 0) && target >= letters[m-1]) {
                    return letters[m];
                } else if (m-1 == 0) {
                    return letters[0];
                }
                h = m;
            }
            m = (l+h)/2;
        }
    }

    public static void main(String[] args) {
                char[] chars = new char[]{'e','e','e','e','e','e','n','n','n','n'};
        char c = nextGreatestLetter(chars,'e');
        

        System.out.println(c);
    }
}
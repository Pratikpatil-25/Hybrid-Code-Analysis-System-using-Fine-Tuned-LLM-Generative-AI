package algorithms.backtracking;


public class StringPermutations {
    public static void main(String[] args) {
        String str = "AAB";
                int n = str.length();
        System.out.println("All unique permutations of \"" + str + "\" are:");
        new StringPermutations().permute(str, 0, n - 1);
    }

    void permute(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);             return;
        }

        for (int i = l; i <= r; i++) {
                        if (isSafe(str, l, i, r)) {
                                str = swap(str, l, i);

                                permute(str, l + 1, r);

                                str = swap(str, l, i);
            }
        }
    }

    boolean isSafe(String str, int l, int i, int r) {
        for (int j = l; j < i; j++) {
            if (str.charAt(j) == str.charAt(i)) {
                return false;             }
        }
        return true;
    }

    String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
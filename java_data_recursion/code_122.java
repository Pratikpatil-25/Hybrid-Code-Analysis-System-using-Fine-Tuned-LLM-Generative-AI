public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().kthGrammar(1, 1));
        System.out.println(new Solution().kthGrammar(2, 1));
        System.out.println(new Solution().kthGrammar(2, 2));
    }

    public int kthGrammar(int n, int k) {
        return recursion(n, k);
    }

    public int recursion(int n, int k) {
                if (n == 1) {
            return 0;
        }

        int totalElements = (int) Math.pow(2, (n - 1));
        int halfElements = totalElements / 2;

                if (k > halfElements) {
            return 1 - recursion(n, k - halfElements);
        }

                return recursion(n - 1, k);
    }
}
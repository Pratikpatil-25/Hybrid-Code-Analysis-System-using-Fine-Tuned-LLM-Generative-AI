class Solution {
    public int maxSubstrings(String word) {
        int n = word.length();
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[word.charAt(i) - 'a'] = i;
        }

        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            int end = last[ch - 'a'];
            if (end == i) continue;

            int j = i;
            while (j <= end) {
                end = Math.max(end, last[word.charAt(j) - 'a']);
                j++;
            }

            if (end - i + 1 >= 4) {
                intervals.add(new int[]{i, end});
            }
        }

        intervals.sort(Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int prevEnd = -1;
        for (int[] interval : intervals) {
            if (interval[0] > prevEnd) {
                count++;
                prevEnd = interval[1];
            }
        }

        return count;           
    }
}
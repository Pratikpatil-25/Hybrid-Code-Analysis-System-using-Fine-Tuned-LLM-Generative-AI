class Solution {
    public static List<int[]> mergeIntervals(List<int[]> intervals) {
        if (intervals.size() == 0) {
            return new ArrayList<>();
        }

                intervals.sort((a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

                int[] currentInterval = intervals.get(0);
        merged.add(currentInterval); 

        for (int i = 1; i < intervals.size(); i++) {
            int[] nextInterval = intervals.get(i);
            int cur_start = currentInterval[0];
            int cur_end = currentInterval[1];
            int next_start = nextInterval[0];
            int next_end = nextInterval[1];

                        if (cur_end >= next_start) {
                                currentInterval[1] = Math.max(cur_end, next_end);
            } else {
                                currentInterval = nextInterval; 
                merged.add(currentInterval); 
            }
        }
        return merged;
    }
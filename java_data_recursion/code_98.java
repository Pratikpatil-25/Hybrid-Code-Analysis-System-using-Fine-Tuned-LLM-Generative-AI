public class Problem40 {
    public int climbStairs(int n) {
        if (n <= 1)
            return 1;
        int[] stair = new int[n+1];
        stair[0] = 1;
        stair[1] = 1;
        for (int i = 2; i < stair.length; i++){
            stair[i] = stair[i-1] + stair[i-2];
        }
        return stair[n];
    }
    
}
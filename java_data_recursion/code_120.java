class Solution {
    static final int MOD = 1_000_000_007;
    public static int[][] dp;
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                dp[i][j] = -2;
            }
        }
        for (int i=0; i<puddles.length; i++) {
            dp[puddles[i][0]-1][puddles[i][1]-1] = -1;
        }
        dp[m-1][n-1] = 1;
        return recursion(0, 0, m, n);
    }
    
    public int recursion(int x, int y, int m, int n) {
        if (dp[x][y] >= 0) {
            return dp[x][y];
        }
        if (x+1 < m && dp[x+1][y] != -1) {
            if (y+1 < n && dp[x][y+1] != -1) {
                dp[x][y] = ((int)recursion(x+1, y, m, n)%MOD + (int)recursion(x, y+1, m, n)%MOD)%MOD;
            }
            else {
                dp[x][y] = (int)recursion(x+1, y, m, n)%MOD;
            }
        }
        else {
            if (y+1 < n && dp[x][y+1] != -1) {
                dp[x][y] = (int)recursion(x, y+1, m, n)%MOD;
            }
            else {
                dp[x][y] = 0;
            }
        }
        return dp[x][y];
    }
}
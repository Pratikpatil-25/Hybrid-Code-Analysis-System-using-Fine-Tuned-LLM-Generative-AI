package com.gitee.passerr.leetcode.problem.algorithm.page2;


public class Solution63 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, columns = obstacleGrid[0].length;
                int[][] dp = new int[rows][columns];
                dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                                if (obstacleGrid[i][j] != 1) {
                                        if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }

                                        if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }

        return dp[rows - 1][columns - 1];
    }
    }
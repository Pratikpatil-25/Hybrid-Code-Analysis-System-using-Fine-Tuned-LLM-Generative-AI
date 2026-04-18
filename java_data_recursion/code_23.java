package com.fengtin.LeetCode;

public class D_48 {
    
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if ((n / 2) > 0) {
                        recursion(matrix, n, 0);
        }
    }

        private void recursion(int[][] matrix, int n, int loop) {
                int m = n - 2 * loop;
        if (loop  >= n / 2) {
            return;
        }
        for (int i = 0; i < (m - 1); i++) {
            int temp = matrix[loop][loop + i];
            matrix[loop][loop + i] = matrix[loop + m - 1 - i][loop];
            matrix[loop + m - 1 - i][loop] = matrix[loop + m - 1][loop + m - 1 - i];
            matrix[loop + m - 1][loop + m - 1 - i] = matrix[loop + i][loop + m - 1];
            matrix[loop + i][loop + m - 1] = temp;
        }
        recursion(matrix, n, loop + 1);
    }
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        new D_48().rotate(matrix);
    }
}
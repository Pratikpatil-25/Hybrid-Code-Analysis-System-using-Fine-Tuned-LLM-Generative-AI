class Recursion {

    class Solution {
        public int totalNQueens(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }
            int[] res = { 0 };
            solve(board, 0, n, res);
            return res[0];
        }

        public void solve(char[][] board, int col, int n, int[] res) {
            if (col == n) {
                res[0]++;
                return;
            }

            for (int row = 0; row < n; row++) {
                if (isSafe(board, row, col, n)) {
                    board[row][col] = 'Q';
                    solve(board, col + 1, n, res);
                    board[row][col] = '.';
                }
            }
        }

        public boolean isSafe(char[][] board, int row, int col, int n) {
            int dupRow = row;
            int dupCol = col;

                        while (dupRow >= 0 && dupCol >= 0) {
                if (board[dupRow--][dupCol--] == 'Q')
                    return false;
            }

            dupRow = row;
            dupCol = col;

                        while (dupCol >= 0) {
                if (board[dupRow][dupCol--] == 'Q')
                    return false;
            }

            dupRow = row;
            dupCol = col;

            while (dupRow < n && dupCol >= 0) {
                if (board[dupRow++][dupCol--] == 'Q')
                    return false;
            }

            return true;

        }

    }

    
                
        
        
    
        
    
        
        
}
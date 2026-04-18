package com.fengtin.LeetCode;

public class D_79 {
    public static boolean exist(char[][] board, String word) {
        boolean flag = false;
        for(int i = 0;i < board.length; i++){
            for(int j = 0;j < board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                     flag = recursion(board,word,new int[]{i,j},new int[board.length][board[0].length],1);
                    if(flag) {
                       return true;
                    }
                }
            }
        }
        return flag;
    }
    private static boolean recursion(char[][] board, String word, int[] pos, int[][] path, int num){
        if(num == word.length()){
           return true;
       }

        
        boolean result = false;
        path[pos[0]][pos[1]] = 1;
        for(int i = -1;i <= 1;i+=2){
            if((pos[0] + i) < board.length && (pos[0] + i) >= 0) {
                if (path[pos[0] + i][pos[1]] == 0) {
                    if (board[pos[0] + i][pos[1]] == word.charAt(num)) {
                        boolean flag = recursion(board, word, new int[]{pos[0] + i, pos[1]}, path, num + 1);
                        if(flag){
                            result = true;
                            break;
                        }
                    }
                }
            }
        }
        for(int i = -1;i <=1 ;i+=2){
            if((pos[1] + i) < board[0].length && (pos[1] + i) >= 0) {
                if (path[pos[0]][pos[1] + i] == 0) {
                    if (board[pos[0]][pos[1] + i] == word.charAt(num)) {
                        boolean flag = recursion(board, word, new int[]{pos[0], pos[1] + i}, path, num + 1);
                        if(flag){
                            result = true;
                            break;
                        }
                    }
                }
            }
        }
        path[pos[0]][pos[1]] = 0;
        return result;
    }
    public static void  main(String[] args){
        char[][] board = new char[3][4];
        board[0] = "ABCE".toCharArray();
        board[1] = "SFCS".toCharArray();
        board[2] ="ADEE".toCharArray();
        String word = "ABCESC";
        System.out.println(exist(board,word));
    }
}
class Solution {
    public int dfs(int r,int c,int rows,int col,int [][]matrix,HashMap<String,Integer> map){
                if(r==rows || c==col || matrix[r][c]!=1){
            return 0;
        }
                String key = r + "," + c;
                if (map.containsKey(key)) {
            return map.get(key);
        }
                                                                                                        map.put(key,1+Math.min(
                            dfs(r+1,c,rows,col,matrix,map),
                Math.min(
                                        dfs(r,c+1,rows,col,matrix,map),
                                        dfs(r+1,c+1,rows,col,matrix,map))
                ));
                        return map.get(key);
    }
    public int countSquares(int[][] matrix) {
                int rows=matrix.length;
        int col=matrix[0].length;
                HashMap<String,Integer> map = new HashMap<String,Integer>();
                int res=0;
                for(int i=0;i<rows;i++){
                        for(int j=0;j<col;j++){
                                res+=dfs(i,j,rows,col,matrix,map);
            }
        }
        return res;
    }
}
class Solution {
    public int countSquares(int[][] matrix) {
        int rowSize  = matrix.length;
        int colSize = matrix[0].length;

        for(int i = 1; i < rowSize; i++)
        {
            for(int j = 1; j < colSize; j++)
            {
                                if(matrix[i][j] == 1)
                    matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i][j - 1]));
            }
        }

        int total = 0;
        for(int i = 0; i < rowSize; i++)
        {
            for(int j = 0; j < colSize; j++)
            {
                                total += matrix[i][j];
            }
        }

        return total;
    }
}
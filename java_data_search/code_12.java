class Solution {
    public boolean exist(char[][] arr, String word) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==word.charAt(0) ){
                    if( search(i,j,0,arr,word,arr.length,arr[0].length) ) return true;
                }
            }
        }
        return false;
    }

    boolean search(int i,int j , int l ,char [][]arr , String s ,int n ,int m){
        if(l==s.length()) return true;
        if(i<0 || j<0 || i>=n || j >=m || arr[i][j]!=s.charAt(l) ) return false;
        
        arr[i][j] = '8';
        
        if( search(i,j-1,l+1,arr,s,n,m) || search(i,j+1,l+1,arr,s,n,m) || search(i-1,j,l+1,arr,s,n,m) || search(i+1,j,l+1,arr,s,n,m)  ) return true;
        
        arr[i][j] = s.charAt(l);
        
        return false;

    }
}
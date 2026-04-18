import java.util.*;
public class LCS {     public static int recursion(String s1,int n,String s2,int m){
        if(n==0 || m==0){return 0;}
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return 1+recursion(s1, n-1, s2, m-1);
        }else{
            return Math.max(recursion(s1, n-1, s2, m),recursion(s1, n, s2, m-1));
        }
    }
    public static int memoization(String s1,int n,String s2,int m,int dp[][]){
        if(n==0 || m==0){return 0;}
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            dp[n][m]= 1+memoization(s1, n-1, s2, m-1,dp);
            return dp[n][m];
        }else{
            dp[n][m]= Math.max(memoization(s1, n-1, s2, m,dp),memoization(s1, n, s2, m-1,dp));
            return dp[n][m];
        }
    }  
    public static int tabulation(String s1,int n,String s2,int m){
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        for(int i[]:dp){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        return dp[n][m];
    }  
    public static void main(String[] args) {
        String s1="abcde";
        String s2="ace";
                                                                                                        System.out.println(tabulation(s1, s1.length(), s2, s2.length()));
    }
}
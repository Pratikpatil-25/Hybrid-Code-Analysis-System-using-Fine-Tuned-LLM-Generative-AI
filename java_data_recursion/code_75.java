class Solution {
    public int fib(int n) {
                int f1=0;
        int f2=1;
        int temp=0;
        for(int i=0;i<n;i++){
            temp=f1+f2;
            f1=f2;
            f2=temp;
        }
        return f1;
        
                if(n<=1){
            return n;
        }
        else{
            return fib(n-1)+fib(n-2);
        }
        
                int dp[]=new int[n+1];
        if(n<=1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]=fib(n-1)+fib(n-2);
        return dp[n];
        
                int dp[]=new int[n+1];
        dp[1]=1;
        dp[0]=0;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
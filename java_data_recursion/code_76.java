class Solution {
    public boolean isPowerOfFour(int n) {
        if(n != 0 && ((n&(n-1)) == 0) && (n & 0xAAAAAAAA) == 0){
            return true;
        }else{
            return false;
        }
    }
}

class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==0){
            return false;
        }else if(n==1){
            return true;
        }else if(n%4!=0){
            return false;
        }else{
            return isPowerOfFour(n/4);
        }
    }
}
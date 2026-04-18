public class Solution {
    public double pow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return x;
        }
        boolean neg = false;
        if(n < 0) {
            neg = true;
            n *= -1;
        }
        double half = pow(x, n/2);
                double odd = pow(x, n - n/2*2);
        if(neg) {
            return 1/(half * half * odd);
        }
        return half * half * odd;
    }
}




public class Solution {
    public double pow(double x, int n) {
                if(n < 0) return 1 / power(x, -n);
        else return power(x, n);
    }
    
    double power(double x, int n) {
        if(n == 0) return 1;
        double half = power(x, n/2);
        if(n%2 == 0) return half * half;
        else return half * half *x;
    }
}
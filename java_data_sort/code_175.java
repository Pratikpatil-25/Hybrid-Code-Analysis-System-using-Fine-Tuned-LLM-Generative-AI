package templates;

import java.util.*;
import java.io.*;

public class UsefulMethods {
    static final int INTMAX = Integer.MAX_VALUE/2;
    static final int INTMIN = Integer.MIN_VALUE/2;
    static final long mod = 1000000000+7;
    public static long power(long x, long y, long mod) {
        long res = 1L;
        x = x%mod;
        while(y > 0)
        {
            if((y&1)==1)
                res = (res*x)%mod;

            y>>=1;
            x = (x*x)%mod;
        }
        return res;
    }
    public static int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b,a%b);
    }
    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
    static void sort(int[] a, boolean... rev) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        if(rev.length>0 && rev[0]==true) Collections.sort(l, Collections.reverseOrder());
        else Collections.sort(l);

        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }
    static void fill2D(int arr[][], int n) {
        for (int[] row: arr)
            Arrays.fill(row, n);
    }

    static class pair implements Comparable < pair > {
        long x;
        long y;
        pair(long i, long j) {
            x = i;
            y = j;
        }
        public int compareTo(pair p) {
            if (this.x != p.x) {
                return Long.compare(this.x,p.x);
            } else {
                return Long.compare(this.y,p.y);
            }
        }
        public String toString() {
            return x + " " + y;
        }
        public boolean equals(Object o) {
            pair x = (pair) o;
            return (x.x == this.x && x.y == this.y);
        }
    }

    static int upper_bound(int arr[], int key) {
                int left = 0, right = arr.length-1;
        int pos = -1;
        while(left<=right)
        {
            int mid = left +(right-left)/2;
            if(arr[mid]>= key)
            {
                pos = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return pos;
    }

    static int lower_bound(int arr[], int key) {
                int left = 0, right = arr.length-1;
        int pos = -1;
        while(left<=right)
        {
            int mid = left +(right-left)/2;
            if(arr[mid] <= key)
            {
                pos = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return pos;
    }
}
package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class hw {

    public static void sort(int[] a){
        ArrayList<Integer> b = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            if(a[i]<0) b.add(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            if(a[i]>0) b.add(a[i]);
        }
        for (int i = 0; i < b.toArray().length; i++) {
            a[i]=b.get(i);
        }
    }

    public static void main(String[] args) {
        int[] a= {-3,5,2,-9,0,-1,3,-202,1313,43,-398,-23,56,98,-57,-23,344,54,-1,2};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
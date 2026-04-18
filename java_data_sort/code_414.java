package com.rocky.algorithm.sort;

import com.rocky.algorithm.utils.ArrayUtil;

public class BubbleSorter2 implements Sorter{
    @Override
    public int[] sort(int[] origin) {
        for (int i= origin.length -1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (origin[j] > origin[j+1]){
                    ArrayUtil.exchange(origin,j,j+1);
                }
            }
        }
        return origin;
    }

    public static void main(String[] args) {
        Checker.check(new BubbleSorter());
    }
}
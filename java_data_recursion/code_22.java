package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class D_46 {
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums
        ) {
            list.add(num);
        }
        recursion(0, nums.length, answer, list);
        return answer;
    }

    
    private static void recursion(int temp, int n, List<List<Integer>> answer, List<Integer> list) {
        if (temp == n) {
            answer.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = temp; i < n; i++) {
            Collections.swap(list, i, temp);
            recursion(temp + 1, n, answer, list);
            Collections.swap(list, i, temp);
        }

    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_39 {
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        recursion(0, candidates, target, answer, new ArrayList<Integer>());
        return answer;
    }

    
    private static void recursion(int pos, int[] candidates, int target, List<List<Integer>> answer, List<Integer> ans) {
        if (target == 0) {
            answer.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                ans.add(candidates[i]);
                recursion(i, candidates, target - candidates[i], answer, ans);
                ans.remove(ans.lastIndexOf(candidates[i]));
            } else {
                break;
            }

        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        combinationSum(new int[]{2, 3, 5}, 8);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
package com.jun.plugin.leetcode.algorithm.no0077;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || k > n) {
            return Collections.emptyList();
        }
        this.backtracking(n, k, 1, new ArrayList<>());
        return result;
    }

    private void backtracking(int n, int k, int start, List<Integer> current) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
                        current.add(i);
                        this.backtracking(n, k - 1, i + 1, current);
                        current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

    }

}
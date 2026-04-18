package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0587_ErectTheFence {
  
  
  public int[][] outerTrees(int[][] trees) {
    int n = trees.length;
    if (n < 4) {
      return trees;
    }
        Arrays.sort(trees, (a, b) -> {
      if (a[0] == b[0]) {
        return Integer.compare(a[1], b[1]);
      }
      return Integer.compare(a[0], b[0]);
    });

    List<Integer> hull = new ArrayList<>();
    boolean[] used = new boolean[n];
        hull.add(0);
        for (int i = 1; i < n; i++) {
      while (hull.size() > 1
        && cross(trees[hull.get(hull.size() - 2)], trees[hull.getLast()], trees[i]) < 0) {
        used[hull.getLast()] = false;
        hull.removeLast();
      }
      used[i] = true;
      hull.add(i);
    }
    int m = hull.size();
        for (int i = n - 2; i >= 0; i--) {
      if (!used[i]) {
        while (hull.size() > m
          && cross(trees[hull.get(hull.size() - 2)], trees[hull.getLast()], trees[i]) < 0) {
          used[hull.getLast()] = false;
          hull.removeLast();
        }
        used[i] = true;
        hull.add(i);
      }
    }
        hull.removeLast();
    int size = hull.size();
    int[][] result = new int[size][2];
    for (int i = 0; i < size; i++) {
      result[i] = trees[hull.get(i)];
    }
    return result;
  }

  private int cross(int[] p, int[] q, int[] r) {
    return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
  }
  }
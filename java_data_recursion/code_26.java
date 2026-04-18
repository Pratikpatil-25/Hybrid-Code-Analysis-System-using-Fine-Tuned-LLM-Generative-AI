package com.fengtin.LeetCode;


import java.util.ArrayList;
import java.util.List;

public class D_78 {
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if(n > 0){
           recursion(new ArrayList<>(),ans,nums,0);
        }
        return ans;
    }
    private static void recursion(List<Integer> list,List<List<Integer>> answer,int[] nums,int begin){
        answer.add(new ArrayList<>(list));
        for (int i = begin; i < nums.length; i++) {
                list.add(nums[i]);
                recursion(list, answer, nums, i + 1);
                list.remove(list.indexOf(nums[i]));

        }

    }
    public static void main(String[] args){
        System.out.println(subsets(new int[]{1,2,2}));
    }
}
package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_47 {
    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        recursion(nums,list,ans,0,visited);
        return ans;
    }
    private static void recursion(int[] nums,List list,List answer,int pos,boolean[] visited){
        if(pos == nums.length){
            answer.add(new ArrayList(list));
            return;
        }
        for(int i = 0;i < nums.length;i++) {
            if(visited[i] || (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])){
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            recursion(nums,list,answer, pos + 1,visited);
            visited[i] = false;
            list.remove(pos);
        }
    }
    public static void main(String[] args){
        System.out.println(permuteUnique(new int[]{0,0,0,1,9}));
    }
}
package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_40 {
    
    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        recursion(answer,candidates,target,new ArrayList<Integer>(),0);
        return answer;
    }

    
    private static void recursion(List<List<Integer>> answer ,int[] candidates,int target,List<Integer> list,int pos){
        if(target == 0){
            answer.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = pos;i < candidates.length;i++) {
            if(i > pos && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (target - candidates[i] >= 0) {
                list.add(candidates[i]);
                recursion(answer, candidates, target - candidates[i], list, i + 1);
                list.remove(list.lastIndexOf(candidates[i]));
            }
            else {
                break;
            }
        }
    }
    public static void main(String[] args){
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }
}
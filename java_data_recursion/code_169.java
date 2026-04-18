package com.concept.recursion;

public class JumpGameII {
    private static int totalJump=Integer.MAX_VALUE;
    public static void main(String[] args) {
        int [] nums = {2,3,1,1,4};
        int steps = jump(nums);
        System.out.println(steps);
    }

    private static int jump(int[] nums) {
        int n= nums.length;
        return solveJumpII(nums,n,0);
    }

    private static int solveJumpII(int[] nums, int n, int i) {
                if(i>=n-1){
            return 0;
        }
        int jump = Integer.MAX_VALUE;
        for(int step=i+1;(step<=i+nums[i] && step<n);step++){
            jump = Math.min(jump, 1+solveJumpII(nums, n,step));
        }
        return jump;
    }
}
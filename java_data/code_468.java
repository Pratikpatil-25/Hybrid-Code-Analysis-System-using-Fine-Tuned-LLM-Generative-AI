package leetcode.medium;

import java.util.Arrays;


public class MaximumSubarray {
    public static void main(String[] args) {
        int[] num1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] num2 = {1};
        int[] num3 = {5,4,-1,7,8};
        System.out.println(maxSubArray1(num1));         System.out.println(maxSubArray1(num2));         System.out.println(maxSubArray1(num3)); 
    }
        public static int maxSubArray1(int[] nums) {
        int currSum = nums[0];
        int maxSum = currSum;
        for (int i = 0; i < nums.length; i++) {
            currSum = nums[i];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                currSum = currSum + nums[j];
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        return maxSum;
    }
        public static int maxSubArray2(int[] nums) {
        int maxSubarray = nums[0];
        int currentMaxArray = maxSubarray;

        for(int i=1; i < nums.length; i++) {
            currentMaxArray = Math.max(currentMaxArray + nums[i], nums[i]);
            if(currentMaxArray > maxSubarray) {
                maxSubarray = currentMaxArray;
            }
            if(currentMaxArray <0) return 0;
        }
        return maxSubarray;
    }
    public static int maxSubArray3(int[] a) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        int n = a.length;
        for(int i=0; i<n ; i++){
            curSum += a[i];
            maxSum = Math.max(curSum, maxSum);
            if(curSum <0) { curSum = 0; }
        }
        return maxSum;
    }
}
package com.noob.algorithm.leetcode.q001_100.q034;


public class Solution2Error {

        public int[] searchRange(int[] nums, int target) {
                int leftIndex = binarySearch(nums, target);

                int[] reverseNums = new int[nums.length];
        int idx = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            reverseNums[idx++] = nums[i];
        }
                int rightIndex = binarySearch(reverseNums, target);

        if (leftIndex != -1 && rightIndex != -1) {
            return new int[]{leftIndex - 1, nums.length - rightIndex + 1};
        } else {
            return new int[]{-1, -1};
        }
    }

    public int binarySearch(int[] nums, int target) {
                int left = 0, right = nums.length - 1;
        while (left <= right) {
                        int mid = left + (right - left) / 2;
                        if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
                return -1;
    }

}
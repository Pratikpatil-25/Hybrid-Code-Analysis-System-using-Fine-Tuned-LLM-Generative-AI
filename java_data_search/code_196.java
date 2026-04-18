package datastructure.binary_search;

import top150.array.CanJump;


public class _34SearchFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftSearch(nums, target), rightSearch(nums, target)};
    }

        private int leftSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }

        private int rightSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }



}
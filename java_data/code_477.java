package ____Offer_51__________LCOF;
public class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] backup = new int[nums.length];
        System.arraycopy(nums, 0, backup, 0, nums.length);
        return mergeSort(backup, 0, backup.length - 1);
    }
    private int mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int middle = left + (right - left >> 1);
        int leftReversePairs = mergeSort(nums, left, middle);
        int rightReversePairs = mergeSort(nums, middle + 1, right);
        if (nums[middle] <= nums[middle + 1]) {
            return leftReversePairs + rightReversePairs;
        }
        return leftReversePairs + rightReversePairs + merge(nums, left, middle, middle + 1, right);
    }
    private int merge(int[] nums, int l1, int r1, int l2, int r2) {
        int reversePairsCount = 0, pointer = 0;
        int[] tmp = new int[r2 + 1 - l1];
        while (pointer < tmp.length) {
            if (l1 > r1) {
                tmp[pointer++] = nums[l2++];
            } else if (l2 > r2 || nums[l1] <= nums[l2]) {
                tmp[pointer++] = nums[l1++];
            } else {
                tmp[pointer++] = nums[l2++];
                reversePairsCount += r1 + 1 - l1;
            }
        }
        System.arraycopy(tmp, 0, nums, r2 + 1 - tmp.length, tmp.length);
        return reversePairsCount;
    }
}
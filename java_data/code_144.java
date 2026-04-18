package pers.hywel.algorithm.divide;

import java.util.Arrays;
import java.util.PriorityQueue;


public class KthLargestElementInAnArray {

    
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;

                                for (int j = low; j < high; j++) {
            if (nums[j] <= nums[high]) {
                                swap(nums, pivot++, j);
            }
        }
        swap(nums, pivot, high);

                int count = high - pivot + 1;
                if (count == k) return nums[pivot];
                if (count > k) return quickSelect(nums, pivot + 1, high, k);
                return quickSelect(nums, low, pivot - 1, k - count);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    
    public int findKthLargestByQueue(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    
    public int findKthLargestBySort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray testObj = new KthLargestElementInAnArray();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(testObj.findKthLargest(nums, k));
    }
}
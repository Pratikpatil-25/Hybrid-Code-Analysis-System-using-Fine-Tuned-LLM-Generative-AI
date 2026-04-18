class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        int lower = 0;
        int upper = nums.length -1;

        if (nums[lower] == nums[upper]) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) return true;
            }
            return false;
        }

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] > nums[upper]) {
                lower = mid + 1;
            }
            else {
                upper = mid;
            }
        }

        int start = lower;
        lower = 0;
        upper = nums.length-1;

        if (target >= nums[start] && target <= nums[upper]) {
            lower = start;
        }
        else {
            upper = start;
        }

        while (lower <= upper) {
            int mid = lower + (upper - lower) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) {
                lower = mid + 1;
            }
            else {
                upper = mid - 1;
            }
        }

        return false;
    }
}
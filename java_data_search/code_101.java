class Solution {
    public int search(int[] nums, int target) {
                        if (nums == null || nums.length == 0)   return -1;
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r])
                l = mid + 1;
            else r = mid;
        }
        int pivot = l;
        l = 0;
        r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            int result = (mid + pivot) % nums.length;
            if (nums[result] == target) return result;
            else if (nums[result] < target)
                l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}
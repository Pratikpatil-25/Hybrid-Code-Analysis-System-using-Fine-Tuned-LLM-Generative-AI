package daily.d210906p704binarysearch;



public class Solution {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                l = mid + 1;
            } else r = mid - 1;
        }
        return nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        assert new Solution().search(new int[]{-1,0,3,5,9,12}, 9) == 4;
        assert new Solution().search(new int[]{-1,0,3,5,9,12}, 2) == -1;
    }

}
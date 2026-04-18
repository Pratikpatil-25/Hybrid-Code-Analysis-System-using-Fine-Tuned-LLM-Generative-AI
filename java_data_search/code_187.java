public int searchInsert(int[] nums, int target) {
    int i=0;
    for(;i<nums.length;i++){
        if(nums[i]==target){
            return i;
        }
        if(nums[i]>=target){
            break;
        }
    }
    return i;
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;
        int ans = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>=target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}
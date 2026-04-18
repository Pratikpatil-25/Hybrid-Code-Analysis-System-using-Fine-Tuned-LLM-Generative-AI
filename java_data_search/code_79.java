class Solution {
    public boolean search(int[] nums, int target) {
        int s=0,e=nums.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(nums[m]==target) return true;
                                                            if (nums[s] == nums[m] && nums[m] == nums[e]) {
                s++;
                e--;
                continue;
            }
            if(nums[s]<=nums[m]){
                if(target<nums[m] && target>=nums[s]) e=m-1;
                else s=m+1;
            }
            else{
                if(target<=nums[e] && target>nums[m]) s=m+1;
                else e=m-1;
            }
        }
        return false;
    }
}
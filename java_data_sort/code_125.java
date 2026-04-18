class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
                                        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length < 4)   return result;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++){
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target)   break;                  if (nums[i] + nums[n-1] + nums[n-2] + nums[n-3] < target)   continue;               if (i > 0 && nums[i] == nums[i-1])  continue;                                       for (int j = i + 1; j < n - 2; j++){
                if (nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) break;                      if (nums[i] + nums[j] + nums[n-1] + nums[n-2] < target) continue;                   if (j > i + 1 && nums[j] == nums[j-1])  continue;                                   int l = j + 1, r = n - 1;
                while (l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1])   l++;
                        while (l < r && nums[r] == nums[r-1])   r--;
                        l++;
                        r--;
                    }
                    else if (sum < target)  l++;
                    else r--;
                }
            }
        }
        return result;
    }
}
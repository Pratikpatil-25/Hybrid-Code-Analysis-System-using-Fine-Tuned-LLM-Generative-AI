class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
                                List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0)   return result;
        Arrays.sort(nums);
        backtracking(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }
    private void backtracking(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, int index){
        result.add(new ArrayList(temp));
        for (int i = index; i < nums.length; i++){
            if (i > index && nums[i] == nums[i - 1])    continue;
            temp.add(nums[i]);
            backtracking(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
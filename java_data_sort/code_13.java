class Problem31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        int index = nums.length-2, higher = Integer.MAX_VALUE, higherIndex = -1;
        while(index > 0 && nums[index] >= nums[index+1]) index--;
        for (int i = index+1; i < nums.length; i++){
            if (nums[i] > nums[index] && nums[i] < higher){
                higher = nums[i];
                higherIndex = i;
            }
        }
        if (higherIndex != -1){
            int temp = nums[index];
            nums[index] = nums[higherIndex];
            nums[higherIndex] = temp;
        }
        else index--;
        sort(nums, index+1, nums.length-1);
    }
    public void sort(int[] nums, int first, int last){
        int pivot, i, j, temp;
        if (first < last){
            pivot = first;
            i = first;
            j = last;
            while (i < j){
                while (nums[pivot] >= nums[i] && i < last)
                    i++;
                while (nums[j] > nums[pivot])
                    j--;
                if (i < j){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }        
            }
            temp = nums[pivot];
            nums[pivot] = nums[j];
            nums[j] = temp;
            sort(nums, first, j-1);
            sort(nums, j+1, last);
        }
    }
}
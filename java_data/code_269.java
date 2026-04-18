import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MinimizeMaximumPairSum {

    
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int minMaxSum = 0;

        while (left < right) {
                        minMaxSum = Math.max(minMaxSum, nums[left] + nums[right]);
            left++;
            right--;
        }
        return minMaxSum;
    }

    @Test
    public void minPairSumTest() {
        
        assertEquals(7, minPairSum(new int[]{3, 5, 2, 3}));
        
        assertEquals(8, minPairSum(new int[]{3, 5, 4, 2, 4, 6}));
    }
}
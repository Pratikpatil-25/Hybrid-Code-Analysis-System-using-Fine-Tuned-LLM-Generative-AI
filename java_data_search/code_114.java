package A4Searching;

import java.util.Arrays;

public class SearchingInMatrix11 {
    public static void main(String[] args) {
        int[][] nums = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        System.out.println(Arrays.toString(search(nums,35)));
    }
    public static int[] search(int[][] nums, int target)
    {
        int r=0,c= nums[0].length-1;         while(r<nums.length && c>=0)
        {
            if(nums[r][c]==target) return new int[]{r,c};
            if(nums[r][c]>target) c--;
            else r++;
        }
        return new int[]{-1,-1};
    }
}
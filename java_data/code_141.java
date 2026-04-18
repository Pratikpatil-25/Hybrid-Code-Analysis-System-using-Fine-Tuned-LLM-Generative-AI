package my.text.algorithm.back.track;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class SubSetDistinct {
    
    private static List<List<Integer>> result = new ArrayList<>();

     
     private static Deque<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        backTrack2(nums, 0);
        System.out.println(result);
    }

    
    private static void backTrack(int[] nums, int startIndex){
                List<Integer> currLevelUsedNums = new ArrayList<>();

        result.add(new ArrayList<>(queue));

        for (int i = startIndex; i < nums.length; i++) {
            int num = nums[i];
                        if (currLevelUsedNums.contains(num)){
                continue;
            }
            queue.add(num);
            currLevelUsedNums.add(num);
            backTrack(nums, i + 1);
            queue.removeLast();
        }
    }

    
    private static void backTrack2(int[] nums, int startIndex){

        result.add(new ArrayList<>(queue));

        for (int i = startIndex; i < nums.length; i++) {
                        if (i > startIndex && nums[i] == nums[i - 1]){
                continue;
            }
            queue.add(nums[i]);
            backTrack2(nums, i + 1);
            queue.removeLast();
        }
    }
}
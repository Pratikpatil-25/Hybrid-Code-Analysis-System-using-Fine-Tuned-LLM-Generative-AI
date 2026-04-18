package algorithm.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ContainsDuplicateII {
    public static void main(String[] args) {

    }

    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i< nums.length; i++) {
            Integer exist = map.get(nums[i]);
            if(exist != null && exist + k >= i) return true;
            map.put(nums[i], i);
        }

        return false;
    }
}
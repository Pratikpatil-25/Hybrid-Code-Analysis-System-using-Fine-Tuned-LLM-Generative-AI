package io.dsa.striver.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    
    public static void main(String[] args) {
        List<List<Integer>> solution = Solution(new int[]{1, 2, 3});
        System.out.println(solution);
    }

    static List<List<Integer>> Solution(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        helper(arr, 0, new ArrayList<>(), res);
        return res;
    }

    static void helper(int[] arr, int index, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));

        for (int i = index; i < arr.length; i++) {
                        if ( i > index && arr[i] == arr[i - 1] )
                continue;
            
            list.add(arr[i]);
            helper(arr, index + 1, list, res);
            list.remove(list.size() - 1); 
        }
    }
}
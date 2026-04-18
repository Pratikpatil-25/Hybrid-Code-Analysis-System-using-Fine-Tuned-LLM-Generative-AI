package problems.sorting;

import java.util.Arrays;
import java.util.TreeMap;


public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

            private static int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for(int n : arr1) cnt[n]++;
        int i = 0;
        for(int n : arr2) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for(int n = 0; n < cnt.length; n++) {              while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }

        private static int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();         for (int n: arr1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int index = 0;
        for (int n: arr2) {
            while (map.get(n) > 0) {
                arr1[index++] = n;
                map.put(n, map.get(n) - 1);
            }
        }

                for (int n: map.keySet()) {
            while (map.get(n) > 0) {
                arr1[index++] = n;
                map.put(n, map.get(n) - 1);
            }
        }
        return arr1;
    }
}
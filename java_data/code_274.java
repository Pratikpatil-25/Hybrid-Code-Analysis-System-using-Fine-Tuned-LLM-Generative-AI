import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LeetCodeQs {
    public static void main(String[] args) {
                                                        
                        

                int[] nums = {-1, 0, 1, 2, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }

            public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }

            public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

            public int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
                        num = num ^ nums[i];
        }

        return num;
    }

            public static int majorityElementI(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }

            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static ArrayList<Integer> findMajority(int[] arr) {
                int n = arr.length;
        int maj = n / 3;
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (freq[arr[i]] > maj && !list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }
        return list;

    }

    public static ArrayList<Integer> majorityElement(int[] arr) {
                for (int i = 0; i < arr.length; i++) {

                        for (int j = i + 1; j < arr.length; j++) {

                                                if (arr[j] < arr[i]) {

                                        int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (map.get(num) > arr.length / 3 && !list.contains(num)) {
                list.add(num);
            }
        }

                return list;
    }

        public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    public static int[] findSortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[nums.length];
        for (int i = res.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                res[i] = nums[right] * nums[right];
                right--;
                ;
            } else {
                res[i] = nums[left] * nums[left];
                left++;
            }
        }
        return res;
    }

        public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int p = 0; p < res.length; p++) {
                res[i] = prod / nums[i];
            }
        }
        return res;
    }

}
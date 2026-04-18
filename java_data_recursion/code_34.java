public class p2426 {

    

    


    public static void main(String[] args) {

        System.out.println(new Solution().numberOfPairs(new int[]{-4,-4,4,-1,-2,5} , new int[]{-2,2,-1,4,4,3} , 1));
    }

    static
    class Solution {

        public static int MAXN = 1_00_000 + 1;
        public static int[] arr = new int[MAXN];
        public static int[] help = new int[MAXN];
        public static int realLength;
        public static int diff;

        public long numberOfPairs(int[] nums1, int[] nums2, int diff) {

            realLength = nums1.length;
            Solution.diff = diff;
            for(int i = 0 ; i < realLength ; i ++)
                arr[i] = nums1[i] - nums2[i];


            return recursion(0 , realLength - 1);
        }

        public long recursion(int left , int right){

            long res = 0;
            if(left >= right)
                return 0;

            int mid = (left + right) >> 1;
            res += recursion(left , mid);
            res += recursion(mid + 1 , right);

            int l1 = left;
            int l2 = mid + 1;

            while (l1 <= mid && l2 <= right){

                while(l2 <= right && arr[l1] > arr[l2] + diff){

                    l2 ++;
                }
                                res += (right - l2 + 1);
                l1++;
            }
                        
                        int index = left;
            l1 = left;
            l2 = mid + 1;
            while (l1 <= mid && l2 <= right){

                if(arr[l1] < arr[l2])
                    help[index++] = arr[l1++];
                else
                    help[index++] = arr[l2++];
            }

            while (l1 <= mid)
                help[index++] = arr[l1++];
            while (l2 <= right)
                help[index++] = arr[l2++];

            for(int i = left ; i <= right ; i++)
                arr[i] = help[i];

            return res;
        }
    }
}
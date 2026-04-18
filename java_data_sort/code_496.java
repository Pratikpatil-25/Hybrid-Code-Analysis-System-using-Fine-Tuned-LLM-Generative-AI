class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
               int [] newarr = new int[m+n];
        int k = 0;
        for(int i = 0;i<m;i++){
            newarr[k++] = nums1[i];
        }
        for(int i = 0;i<n;i++){
            newarr[k++] = nums2[i];

        }
       Arrays.sort(newarr);
       
        for (int i = 0; i < m + n; i++) {
            nums1[i] = newarr[i];
        }
        
        }
       

    }
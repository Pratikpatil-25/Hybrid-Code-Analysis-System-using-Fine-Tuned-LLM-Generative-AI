class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i<numbers.length;i++) {
            int a  = numbers[i];
            int b = target - a;
            int res = search(numbers,b);
            if (res!=-1 && res!=i) {
                if (i+1 < res+1) {
                int[] arr = {i+1,res+1};
                return arr;
                }
                else {
                    int[] arr= {res+1,i+1};
                    return arr;
                }
            }
            
        }
        return numbers;
    }
    public int search(int[] arr, int target) {
        int start = 0;
		int end = arr.length -1;
		while (start <= end ) {
			int mid = start + (end - start) / 2;
			if (target < arr[mid]) {
				end = mid - 1;
			}
			else if (target > arr[mid]) {
				start = mid +1;
			}
			else  {
				return mid;
			}
		}
		return -1;
    }
}
class Solution {

public int maximumSumSubarray(int[] arr, int k) {

int n = arr.length;

int sum = 0 ;

int maxSum = 0;

int index = 0;

while ( index < n && index < k) {

sum += arr[index];

index++;

}

maxSum = sum ;

for (int i = 1 ; i< n-k+1 ; i++) {

int prevEle = arr[i-1];

int nextEle = arr[i+k-1];

sum = sum - prevEle + nextEle;

maxSum = Math.max(maxSum , sum );

}

return maxSum ;

}

}
import java.util.Arrays;



class GfG {

    static int circularSubarraySum(int[] arr) {

        int n = arr.length;

        int suffixSum = arr[n - 1];



        
        
        int[] maxSuffix = new int[n + 1];

        maxSuffix[n - 1] = arr[n - 1];



        for(int i = n - 2; i >= 0; i--) {

            suffixSum = suffixSum + arr[i];

            maxSuffix[i] = Math.max(maxSuffix[i + 1], suffixSum);

        }



        
        int circularSum = arr[0];



        
        
        int normalSum = arr[0];



        int currSum = 0;

        int prefix = 0;



        for(int i = 0; i < n; i++) {

            

            
            currSum = Math.max(currSum + arr[i], arr[i]);

            normalSum = Math.max(normalSum, currSum);

          

			
            prefix = prefix + arr[i];

            circularSum = Math.max(circularSum, prefix + maxSuffix[i + 1]);

        }



        return Math.max(circularSum, normalSum);

    }



    public static void main(String[] args) {

        int[] arr = {8, -8, 9, -9, 10, -11, 12};

        System.out.println(circularSubarraySum(arr));

    }

}
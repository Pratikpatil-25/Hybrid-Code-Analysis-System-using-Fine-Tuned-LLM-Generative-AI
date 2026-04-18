public public class Solution {

    private static final int MOD = 1000000007;



    public int numFactoredBinaryTrees(int[] arr) {

        
        Arrays.sort(arr);

        

        
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int num : arr) {

            uniqueNumbers.add(num);

        }



        
        Map<Integer, Integer> dp = new HashMap<>();

        for (int num : arr) {

            dp.put(num, 1);

        }



        
        for (int i : arr) {

            for (int j : arr) {

                
                if (j > Math.sqrt(i)) break;

                

                
                if (i % j == 0 && uniqueNumbers.contains(i / j)) {

                    long product = (long) dp.get(j) * dp.get(i / j);

                    

                    
                    dp.put(i, (int) ((dp.get(i) + (i / j == j ? product : product * 2)) % MOD));

                }

            }

        }



        
        int result = 0;

        for (int value : dp.values()) {

            result = (result + value) % MOD;

        }

        return result;

    }

} {

    

}
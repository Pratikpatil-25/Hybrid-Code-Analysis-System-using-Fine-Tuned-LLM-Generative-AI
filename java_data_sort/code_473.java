class Solution {
    public int[] sortByBits(int[] arr) {
        int len = arr.length;
        Integer[] sortedArr=new Integer[len];
        for(int i=0;i<len;i++){
            sortedArr[i] = arr[i];
        }
        
        Arrays.sort(sortedArr, new Comparator<>(){
            public int compare(Integer a, Integer b){
                int countA = bitCount(a);
                int countB = bitCount(b);
            return countA == countB ? a-b : countA-countB;
            }
        });
        int[] sortedIntArr = new int[len];
        
        for(int i=0;i<len;i++){
            sortedIntArr[i] = sortedArr[i];
        }
        return sortedIntArr;
    }
    
    int bitCount(int n){
        int count = 0;
        while(n!=0){
            if(n%2==1){
                count++;
            }
            n/=2;
        }
        return count;
    }
}
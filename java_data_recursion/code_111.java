public class CoinsChange {
        private static int[] save;

    private static int compute(int x, int[] arr) {                 if (save[x] != Integer.MIN_VALUE) {
                        return save[x];
        }
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if (x - arr[i] < 0) {
                continue;
            }
            int temp = compute(x-arr[i], arr);
            if (temp == -1) {
                continue;
            }
            temp = temp + 1;
            min = Math.min(min, temp);
        }
        if (min != Integer.MAX_VALUE) {
            save[x] = min;
            return min;
        }
        save[x] = -1;
        return -1;
    }
     public static void main(String[] args) {          int[] arr = {1, 3, 5};
         int value = 1000;
         save = new int[value+1];
         save[0] = 0;
         for(int i = 1; i <= value; i++) {
             save[i] = Integer.MIN_VALUE;
         }

         System.out.println(computeIt(value, arr));
     }

     private static int computeIt(int value, int[] arr) {
        int[] save = new int[value+1];
        save[0] = 0;
        for(int i = 1; i <= value; i++) {
            save[i] = -1;
        }
        for(int x = 1; x <= value; x++) {
                                    int minm = Integer.MAX_VALUE;
            for(int j = 0; j < arr.length; j++) {
                int tempValue = x - arr[j];                   if (tempValue >= 0 && save[tempValue] != -1) {
                    minm = Math.min(minm, 1+save[tempValue]);
                }
            }
            if (minm == Integer.MAX_VALUE) {
                save[x] = -1;
            } else {
                save[x] = minm;
            }
        }
        return save[value];
     }
}
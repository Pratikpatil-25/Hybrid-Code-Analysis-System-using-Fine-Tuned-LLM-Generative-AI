package arrays.twoD;

import java.util.Arrays;


public class SearchMatrix {

    public static void main(String[] args) {
        int[][] variant1 = {{1, 2, 3},
                {4, 5, 16},
                {17, 28, 39}};
        int key1 = 17;
        int[] index = search(variant1, key1);
       System.out.println(Arrays.toString(index));

        int[][] variant2={{1,3,6},
                {4,5,8},
                {9,10,19}};
        int key2=19;
        int[] index2 = search2(variant2,key2);
        System.out.println(Arrays.toString(index2));
    }

    public static int[] search(int[][] a, int k) {
        if (a == null || a.length == 0 || k == '\0')
            return null;
        

        int startIndex = 0;
        int endIndex = a.length * a[0].length - 1;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            int midElement = a[mid / a[0].length][mid % a[0].length];

            if (midElement == k)
                return new int[]{mid / a[0].length, mid % a[0].length};
            else if (k < midElement)
                endIndex = mid - 1;
            else
                startIndex = mid + 1;
        }
        return null;
    }

    public static int[] search2(int[][] a, int k){
        

        int row=a.length-1;
        int col = 0;

        while(row>=0 && col<a[0].length){
            if(k == a[row][col])
                return new int[]{row,col};
            else if(k < a[row][col])
                row--;
            else
                col++;
        }

        return null;
    }

}
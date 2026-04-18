package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDiagonals {

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int d = (n*2)-1;
        int cur = 0;
        List[] arr = new List[d];
        for(int i=0;i<d;i++){
            arr[i] = new ArrayList<Integer>();
        }
        for(int i=n-1;i>=0;i--){
            int k = i;
            int j = 0;
            while(k<n && j<n){
                arr[cur].add(grid[k][j]);
                k++;
                j++;
            }
            cur++;
        }
        for(int j=1;j<n;j++){
            int k = j;
            int i = 0;
            while(k<n && j<n){
                arr[cur].add(grid[i][k]);
                k++;
                i++;
            }
            cur++;
        }
                        
        for(int i=0;i<d;i++){
            if(i<n){
                arr[i].sort(Collections.reverseOrder());
            }else{
                Collections.sort(arr[i]);
            }
        }
                                cur = 0;
        for(int i=n-1;i>=0;i--){
            int k = i;
            int j = 0;
            while(k<n && j<n){
                System.out.println(arr[cur].get(j));
                grid[k][j] = (int) arr[cur].get(j);
                k++;
                j++;
            }
            cur++;
        }
        for(int j=1;j<n;j++){
            int k = j;
            int i = 0;
            while(k<n){
                grid[i][k] = (int)arr[cur].get(i);
                k++;
                i++;
            }
            cur++;
        }
        return grid;
    }
}
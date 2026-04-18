package Arrays_and_string;
import java.util.*;

public class Q28_Wiggle_Sort_II {

    public void wiggleSort(int[] nums) {
        
        Arrays.sort(nums) ;         int n = nums.length ;
        
        int i = 1 ;         int j = nums.length - 1 ;          
        int[] ans = new int[nums.length] ;
        
        while(i < n){
            ans[i] = nums[j] ;             i += 2 ;
            j-- ;
        }
        
        i = 0 ;         
        while(i < n ){
            ans[i] = nums[j] ;             i += 2 ;
            j-- ;
        }
        
        
        for(int k = 0 ; k < nums.length ; k++){             nums[k] = ans[k] ;
        }
        
    }
    
}
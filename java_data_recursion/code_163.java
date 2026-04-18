import java.util.*;



public class AllPermutations {





    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


    
    


    
    
    
    
    





    public static void permute(int index, List<List<Integer>> ans, int nums[]){

        if(index == nums.length){

            List<Integer> ds = new ArrayList<>();

            for(int i=0; i<nums.length; i++){

                ds.add(nums[i]);

            }

            ans.add(new ArrayList<>(ds));

            return;

        }

        for(int i=index; i<nums.length; i++){

            swap(i, index, nums);

            permute(index+1, ans, nums);

            swap(i, index, nums);



        }

    }

    public static void swap(int i, int index, int nums[]){

        int temp = nums[i];

        nums[i] = nums[index];

        nums[index] = temp;

    }

    public static List<List<Integer>> allPermutations(int nums[]){

        List<List<Integer>> ans = new ArrayList<>();

        permute(0, ans, nums);



        return ans;

    }

    public static void main(String args[]){

        int nums[] = {1, 2, 3};

        System.out.println(allPermutations(nums));

        

    }

    

}
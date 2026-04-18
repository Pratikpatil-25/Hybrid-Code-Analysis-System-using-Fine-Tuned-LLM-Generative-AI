import java.util.Arrays;      import java.util.Collections; 
public class ArraySort {     public static void main(String[] args) {
        
                                Integer[] nums = {5, 2, 8, 1};

                Arrays.sort(nums);
        System.out.println("Ascending: " + Arrays.toString(nums));

                        Arrays.sort(nums, Collections.reverseOrder());
        System.out.println("Descending: " + Arrays.toString(nums));

        ---

                String[] fruits = {"banana", "apple", "cherry"};

                Arrays.sort(fruits);
        System.out.println("String Ascending: " + Arrays.toString(fruits));
    }
}
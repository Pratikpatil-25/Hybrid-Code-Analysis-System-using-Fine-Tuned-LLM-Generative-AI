package recursion;



public class sortedArr{



    public static boolean checkStrictlyIncreasing(int arr[], int idx){

        if(idx == arr.length - 1){

            return true;

        }



        if(arr[idx] >= arr[idx + 1]){

            return false;

        }



        return checkStrictlyIncreasing(arr, idx + 1);

    }

    public static void main(String args[]){

        int arr[] = {1,2,3,4,4};

        System.out.println(checkStrictlyIncreasing(arr, 0));

    }

}
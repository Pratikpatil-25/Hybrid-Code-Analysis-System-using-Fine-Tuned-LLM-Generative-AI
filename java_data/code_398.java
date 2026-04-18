package algorithm;



import util.ActionResult;



import java.util.Arrays;





public class MajorityElement implements AlgorithmIfc {

    private static final int UNDEFINED = -24;



    @Override

    public void execute() {

        
        int[] arr = new int[] { 1, 3, 5, 7, 5, 11, 5, 7, 5, 5 }; 
        int[] arr2 = new int[] { 30, 8, 1995, 30, 8, 1995 }; 


        
        ActionResult<Integer> majorityElement1 = majorityElement(arr);

        ActionResult<Integer> majorityElement2 = majorityElement(arr2);



        
        printResult(arr, majorityElement1);

        printResult(arr2, majorityElement2);

    }



    private ActionResult<Integer> majorityElement(int[] arr) {

        
        ActionResult<Integer> candidateResult = majorityElementCandidate(arr);

        int candidate = candidateResult.getResult().intValue();



        
        int counter = 0;

        for (int n : arr) {

            candidateResult.countStep();



            if (n == candidate) {

                counter++;

            }

        }



        
        if (counter < (arr.length / 2)) {

            candidateResult.setResult(Integer.valueOf(UNDEFINED));

        }



        return candidateResult;

    }



    private ActionResult<Integer> majorityElementCandidate(int[] arr) {

        ActionResult<Integer> result = new ActionResult<>();

        int candidate = UNDEFINED;

        int counter = 0;



        
        for (int n : arr) {

            result.countStep();



            if (counter == 0) {

                candidate = n;

            }



            counter += candidate == n ? 1 : -1;

        }



        result.setResult(Integer.valueOf(candidate));

        return result;

    }



    private void printResult(int[] arr, ActionResult<Integer> majorityElement) {

        System.out.println("Array: " + Arrays.toString(arr) + " (size=" + arr.length + ")");

        if (majorityElement.getResult().intValue() == UNDEFINED) {

            System.out.print("No majority element in this array");

        } else {

            System.out.print("Majority element is: " + majorityElement);

        }



        System.out.println(".    (Steps count = " + majorityElement.getStepsCount() + ", which is 2n -> O(n))");

    }

}
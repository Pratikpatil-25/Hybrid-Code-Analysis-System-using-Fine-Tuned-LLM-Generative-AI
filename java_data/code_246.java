import java.util.Scanner;

public class ArrayEquality {
    private Scanner scanner = new Scanner(System.in);
    
    public void execute() {
        System.out.println("================================================================");
        System.out.println("             [*] ARRAY EQUALITY COMPARISON TOOL              ");
        System.out.println("                  Programmed by: Syed Amaan Ali               ");
        System.out.println("================================================================");
        
        int[] arr1 = inputArray("first");
        int[] arr2 = inputArray("second");
        
        boolean areEqual = checkArrayEquality(arr1, arr2);
        displayResults(arr1, arr2, areEqual);
    }
    
    private int[] inputArray(String arrayName) {
        System.out.print(">> Enter size for " + arrayName + " array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        
        System.out.println(">> Enter " + arrayName + " array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("   Element " + (i+1) + ": ");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
    
    private boolean checkArrayEquality(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            System.out.println("[ERROR] Arrays have different lengths: " + arr1.length + " vs " + arr2.length);
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println("[ERROR] Elements differ at index " + i + ": " + arr1[i] + " vs " + arr2[i]);
                return false;
            }
        }
        
        System.out.println("[SUCCESS] All elements match perfectly!");
        return true;
    }
    
    private void displayResults(int[] arr1, int[] arr2, boolean areEqual) {
        System.out.println("\n>> COMPARISON RESULTS:");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("| Array 1: " + java.util.Arrays.toString(arr1));
        System.out.println("| Array 2: " + java.util.Arrays.toString(arr2));
        System.out.println("| " + (areEqual ? "[SUCCESS] Result: EQUAL" : "[ERROR] Result: NOT EQUAL"));
        System.out.println("| [INFO] Analysis by Syed Amaan Ali's comparison algorithm");
        System.out.println("+--------------------------------------------------------------+");
    }
}
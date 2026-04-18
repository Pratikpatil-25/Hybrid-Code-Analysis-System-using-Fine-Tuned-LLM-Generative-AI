import com.nishant.binarysearch.BinarySearch;
import com.nishant.recursion.Recursion;

class Main {

  public static void main(String[] args) {

    recursion(10);

  int[] array = {1,2,9,19,31,42,87,209,345};
  System.out.println(searchArray(array, 87));

  }
 
  public static boolean searchArray(int[] array, int x){
    return BinarySearch.binarySearchArray(array, x, 0, array.length -1);
  }

  public static void recursion (int number){
    for(int i=0; i < number ; i++){
      System.out.print(Recursion.fibonacci(i) + "  ");
    }
  }

}
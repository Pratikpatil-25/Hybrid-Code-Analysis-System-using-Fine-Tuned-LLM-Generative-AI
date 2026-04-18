import java.util.Scanner;
import java.util.Arrays;
class Arraybinary {
void search(int arr[], int item) {
Arrays.sort(arr);
int index = Arrays.binarySearch(arr, item);
if (index >= 0) {
System.out.println("Item found at index: " + index);
} else {
System.out.println("Item not found");
}
}
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
Arraybinary search = new Arraybinary();
System.out.println("Enter the number of elements:");
int n = sc.nextInt();
int[] arr = new int[n];
System.out.println("Enter " + n + " numbers:");
for (int i = 0; i < n; i++) {
arr[i] = sc.nextInt();
}
System.out.println("Enter the number to search for:");
int item = sc.nextInt();
search.search(arr, item);
}
}
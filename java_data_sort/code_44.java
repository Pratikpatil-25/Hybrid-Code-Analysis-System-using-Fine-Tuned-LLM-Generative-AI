import java.util.*;
 class Bs {
  static void sort(int a[], int n){
    int i, j, t;
    for (i = 0; i <= n; i++){
      for (j = 0; j < n - i - 1; j++){
        if (a[j] > a[j+1]) {
          t = a[j];
          a[j] = a[j + 1];
          a[j+1] = t;
        }
      }
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter size of array:");
    int n = sc.nextInt();
    int A[] = new int[n];
    int i;
    System.out.println("Enter Elements:");
    for (i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }
    sort(A, n);
    for (i = 0; i < n; i++) {
      System.out.print(A[i] + " ");
    }
    int start = 0, end = n - 1, mid;
    int pos = -1;
    System.out.println("Enter key to find:");
    int k = sc.nextInt();
    while (start <= end) {
      mid = (start + end) / 2;
      if (A[mid] == k) {
        pos = mid + 1;
        break;
      } else if (k < A[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    if (pos > 0) {
      System.out.printf("Key is found at %d", pos);
    } else {
      System.out.println("Key is not found");
    }
  }
}
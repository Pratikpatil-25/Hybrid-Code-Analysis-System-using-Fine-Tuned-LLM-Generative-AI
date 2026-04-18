import java.util.Scanner;

public class Sorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

                        merge_sort(arr, 0, n-1);
        print(arr, n);
    }

    public static void selection_sort(int[] arr, int n) {
        for(int i = 0; i < n; i++) {                         int minm = i;             for(int j = i; j < n; j++) {
                if (arr[j] < arr[minm]) {
                    minm = j;
                }
            }
                                    swap(arr, i, minm);
        }
        print(arr, n);
                            }
    public static void print(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void merge_sort(int[] arr, int start, int end) {                                         if (start >= end) {
            return;
        }
        int mid = (start + end)/2;
                merge_sort(arr, start, mid);
                merge_sort(arr, mid+1, end);
                merge(arr, start, mid, end);

                    }

    public static void merge(int[] arr, int start, int mid, int end) {                 
                int sizeFirst = mid-start+1;         int sizeSecond = end-mid;                   int[] first = new int[sizeFirst];
        int[] second = new int[sizeSecond];

                        int k = 0;
        for(int i = start; i <= mid; i++) {
            first[k++] = arr[i];
        }
                k = 0;
        for(int i = mid+1; i <= end; i++) {
            second[k++] = arr[i];
        }
                k = start;         int i = 0;         int j = 0;         while(i < sizeFirst && j < sizeSecond) {
            if (first[i] < second[j]) {
                arr[k++] = first[i++];
            } else {
                arr[k++] = second[j++];
            }
        }
                while(i < sizeFirst) {
            arr[k++] = first[i++];
        }
                while(j < sizeSecond) {
            arr[k++] = second[j++];
        }
            }

        public static void merge_arrays(int[] arr1, int[] arr2, int n, int m) {
        int i = 0;         int j = 0;         int[] res = new int[n+m];
        int k = 0;         while(i < n && j < m) {
            if (arr1[i] < arr1[j]) {
                res[k++] = arr1[i++];             } else {
                res[k++] = arr2[j++];
            }
        }
                        while(i < n) {
            res[k++] = arr1[i++];
        }
                while(j < m) {
            res[k++] = arr2[j++];
        }
        for(int x = 0; x < n+m; x++) {
            System.out.print(res[x] + " ");
        }
    }
}
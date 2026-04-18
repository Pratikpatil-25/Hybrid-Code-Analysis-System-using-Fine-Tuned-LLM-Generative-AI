package prac.sorting;

public class CycleSort {
    public static void main(String[] args) {
        int[] a = {87, 42, 27, 17, 7, 37, 57, 47, 2, 1};
        int n = a.length;
        System.out.print("Before sorting array elements are - \n");
        print(a, n);
        cycleSort(a, n);
        System.out.print("\nAfter applying cycle sort, array elements are - \n");
        print(a, n);
    }

    
    private static void cycleSort(int a[], int n) {
        int start, element, pos, temp, i;

        
        for (start = 0; start <= n - 2; start++) {
            element = a[start];

            
            pos = start;

            for (i = start + 1; i < n; i++)
                if (a[i] < element)
                    pos++;
            if (pos == start)  
                continue;
            while (element == a[pos])
                pos ++;
            if (pos != start)  {
                                temp = element;
                element = a[pos];
                a[pos] = temp;
            }

            
            while (pos != start) {
                pos = start;
                
                for (i = start + 1; i < n; i++)
                    if (a[i] < element)
                        pos++;

                
                while (element == a[pos])
                    pos++;

                
                if (element != a[pos]) {
                    temp = element;
                    element = a[pos];
                    a[pos] = temp;
                }
            }
        }

    }

    private static void print(int a[], int n)  {
        int i;
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
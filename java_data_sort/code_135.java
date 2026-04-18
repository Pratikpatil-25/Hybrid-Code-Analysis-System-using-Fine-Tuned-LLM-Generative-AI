package Examples_from_Chapter_16;


public class Sort
{

    public int[] a;


 int  max(int start) 
    {
        int counter = start;
        int idx = start;

        while (counter < a.length) {
            if (a[counter] > a[idx]) {
                idx = counter;
            }
            counter = counter + 1;
        }
        return idx;
    }


     void sort()
    {
        int pos = 0;
        int idx = 0;

        while (pos < a.length - 1) {
            idx = max( pos );
            int tmp = a[idx];
            a[pos] = tmp;
            pos = pos + 1;
        }
    }

}
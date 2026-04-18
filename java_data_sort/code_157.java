public class Main {



    



    public static void sort(int a[]){

        int n = a.length;

        for(int i = 1; i< n ; i++){

            int key = a[i];

            int j = i-1;

            while( j >= 0 && a[j] > key){

                a[j+1] = a[j];

                j = j-1;

            }

            a[j+1] = key;

        }



    }



    public static void PrintArray(int a[]){

        for (int e : a) {

            System.out.print(e + " ");

        }

    }



    public static void main(String[] args) {

        int a[] = {5,8,2,9,5 };

        sort(a);

        PrintArray(a);



    }

}
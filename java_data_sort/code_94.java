import java.util.Scanner;

 public class Sort012{

   public static  void sortArray(int[] arr) {

       int n=arr.length;

        int i=0,zero=0,one=0,two=0;

        while(i<n){

            if(arr[i]==0){

                zero=zero+1;

            }

            else if(arr[i]==1){

                one=one+1;

            }

            else{

                two=two+2;

            }

            i=i+1;

        }

        for(i=0;i<zero;i++){

            arr[i]=0;

        }

        for ( i = zero ; i <zero + one ; i++ )  

    {  

         arr[ i ] = 1 ;  

    }  

    for ( i = zero + one ; i < n ; i++ )  

    {  

        arr[i] = 2 ;  

    }  

    }

    public  static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        System.out.println(" array");

        int n= sc.nextInt();

        int[] arr = new int[n];

        System.out.println("enter the array");

        for(int i=0;i<arr.length;i++){

            arr[i] = sc.nextInt();

        }

        System.out.println("Array afte sorting");

        sortArray(arr);



        for (int num : arr) {

            System.out.println(num);

        }

    }

}\n");
import java.util.*;

public class A8 

{

    public static int add(int[] arr)

    {

        int sum=0;

        for (int i = 0; i < arr.length; i++) 

        {

            sum += arr[i];            

        }

        return sum;

    }    

    public static int max(int[] arr)

    {

        int max=arr[0];

        for(int i = 0; i<arr.length; i++)

        {

            if(max<arr[i])

            {

                max=arr[i];

            }

        }

        return max;

    }

    public static int search(int[] arr, int key)

    {

        int j = -1;

        for(int i = 0; i<arr.length; i++)

        {

            if(arr[i]==key)

            { 

                j = i;

            }

        }

        return j;        

    }

    public static void main(String[] args)

    {

        int arr[]={1,2,3,4,5,6,7,8,9,10};

        int key;

        Scanner sc = new Scanner(System.in);

        System.out.println("Addition: "+add(arr));

        System.out.println("Largest Element: "+max(arr));

        System.out.print("Enter Search Key: ");

        key = sc.nextInt();

        System.out.println(key+" Found at Index " +search(arr, key));

    }

}
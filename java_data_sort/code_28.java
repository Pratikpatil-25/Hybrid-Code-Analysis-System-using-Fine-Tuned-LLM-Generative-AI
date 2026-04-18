import java.util.*;
public class q2_sorting
{
    public static int[] insert(int arr[])
    {
        Scanner sc=new Scanner(System.in);
        int i=0;
        for(i=0;i<arr.length;i++)
        {
            int tt=sc.nextInt();
            arr[i]=tt;
        }
        return arr;
    }
    public static int[] sort(int ar[])
    {
        int i=0,j=0;
        for(i=0;i<ar.length-1;i++)
        {
            for(j=i+1;j<ar.length;j++)
            {
                if(ar[i]>ar[j])
                {
                    int t=ar[i];
                    ar[i]=ar[j];
                    ar[j]=t;
                }
            }
        }
        return ar;
    }
    public static void display(int ar[])
    {
        int i=0;
        for(i=0;i<ar.length;i++)
        {
            System.out.print(ar[i]+" ");
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size");
        int size=sc.nextInt();
        int ar[]=new int[size];
        System.out.println("\nenter elements");
        ar=insert(ar);
        System.out.println("\nelements before sorting");
        display(ar);
        ar=sort(ar);
        System.out.println("\nelements after sorting");
        display(ar);
    }
    
}
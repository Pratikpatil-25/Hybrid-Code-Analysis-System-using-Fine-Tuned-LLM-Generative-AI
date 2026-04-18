import java.util.*;
public class q3_intersection_array {
  private static ArrayList <Integer> find_intersection(int[] a,int[] b)
  {
    ArrayList<Integer> al=new ArrayList<>();
    int i=0,j=0;
    for(i=0;i<a.length;i++)
    {
      for(j=0;j<b.length;j++)
      {
        if(a[i]==b[j])
        {
          al.add(a[i]);
          b[j]=0;
          break;
        }
      }
    }
    return al;
  }
  private static int[] sort(int fun[])
  {
      int i=0,j=0;
      for(i=0;i<fun.length-1;i++)
      {
          for(j=i+1;j<fun.length;j++)
          {
              if(fun[i]>fun[j])
              {
                  int t=fun[i];
                  fun[i]=fun[j];
                  fun[j]=t;
              }
          }
      }
      return fun;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter size");
    int size=sc.nextInt();
    int a[]=new int[size];
    int b[]=new int[size];
    int i=0;
    System.out.println("enter elements in first array");
    for(i=0;i<size;i++)
    {
      a[i]=sc.nextInt();
    }
    System.out.println("enter elements in 2nd array");
    for(i=0;i<size;i++)
    {
      b[i]=sc.nextInt();
    }
    a=sort(a);
    b=sort(b);
    ArrayList <Integer> al=find_intersection(a,b);
    
    System.out.println(al);
  }
}
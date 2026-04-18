import  java.util.*;




public class ascendingOrde
{
    public static void sort(int[] num)
    {
       for (int i = 0; i < num.length; i++)
        {
            int mn = i;
            for (int j = i + 1; j < num.length; j++)
            {
                if (num[mn] > num[j])
                {
                    mn = j;
                }
            }
            int tmp = num[i];
            num[i] = num[mn];
            num[mn] = tmp;
        }
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print(" Enter the  number of element : ");
        int n=s.nextInt();
        int num [] = new int[n];
        for( int i=0;i<n;i++)
        {
            System.out.print( " Enter the numbers : ");
            num[i]=s.nextInt();
        }
        Arrays.sort(num);

        System.out.println("Integers in ascending order:");

        for( int numbers : num)
        {
            System.out.println(" numbers : " + numbers);
        }
    }
}
import java.util.*;

public class A9 

{    

    public  static int search(String[] name, String S)

    {

        int j=0;

        for (int i = 0; i < name.length; i++) 

        {

            if(name[i].equals(S))

            {

                j = i;

            }

        }

        return j;

    }

    public static void sort(String[] name)

    {

        Arrays.sort(name);

        System.out.println("Sorted Name = "+Arrays.toString(name));        

    }

    public static void main(String[] args)

    {

        String[] name = {"abc","def","ghi","jkl","mno"};

        String S;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Search Name: ");

        S = sc.next();

        System.out.println(S+" Found at Index "+search(name,S));

        sort(name);

    }



}
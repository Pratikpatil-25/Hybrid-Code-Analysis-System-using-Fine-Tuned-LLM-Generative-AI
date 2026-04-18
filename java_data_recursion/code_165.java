package recursion.challenging_Programs_On_Recursion;

import java.util.Scanner;

public class Program_on_KeyPad_Codes
{
public static int count=0;
	public static void main(String[] args)
	{
		String keys[] = { "", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wx","yz" };
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		printKeypadCodes(keys,str,"");
		System.out.println("\n"+count);

	}

	private static void printKeypadCodes(String[] keys, String str, String output)
	{
		if(str.length()==0)
		{
			System.out.print(output+" ");
			count++;
			return;
		}
		char ch = str.charAt(0);
		String myString = keys[Integer.parseInt(ch+"")];
		for (int i = 0; i < myString.length(); i++)
		{
			printKeypadCodes(keys, str.substring(1), output+myString.charAt(i));
		}
		
	}

}
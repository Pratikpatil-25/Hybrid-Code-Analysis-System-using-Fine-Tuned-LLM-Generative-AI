import java.util.Scanner;

public class Q36 {
	
	public static String reverse(String s) {
		int k = s.indexOf(" ");
		if(k==-1) {
			return s;
		}
		else {
			return reverse(s.substring(k+1))+" "+s.substring(0,k);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		System.out.println(reverse(s));
	}
}
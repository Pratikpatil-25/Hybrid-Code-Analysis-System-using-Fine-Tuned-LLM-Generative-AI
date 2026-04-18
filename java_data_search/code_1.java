public class Recursion {
	
	static void RecursivePrint(int n){
		String s = "zyxwvutsrqponmlkjihgfedcba";
		if(n<0) {
			return ;
		}
		String subString = s.substring(0, n);
		for(int i = 0;i<subString.length(); i++) {
			System.out.print(subString.charAt(i) + " ");
		}
		System.out.println("");
		RecursivePrint(n-1);
	}
	
	public static void main(String [] args) {
		RecursivePrint(5);
		
		
	}

}
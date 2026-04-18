package mypackage;

public class Recursion {
	static String y = " ";
	

	
  public static void main(String[] args) {
		
		String x = "ADAMS";
		int k =x.length()-1;
		String reverseString = reverseString(x,k);
		System.out.println(reverseString);
		
		
	
	  
	}
  
  
  public static String reverseString(String x,int k) {
	  
	  

	  
		if(k>=0) {
			
			y = y + x.charAt(k);
			
			
			
			k = k -1;
			
			reverseString(x,k);
		}
		return y;
		
		
		
		
		
		
		
		
		
	}

}
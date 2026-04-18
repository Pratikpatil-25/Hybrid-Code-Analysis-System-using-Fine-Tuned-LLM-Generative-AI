package LCS;

public class LCS {
	
	public static void main(String [] args){
	
		System.out.println(LCS("ABCBDAB", "BDCABA"));
	
	}
	
	public static int LCS(String str1, String str2){
				if(str1.length() == 0 || str2.length() == 0)
			return 0;
		
				else if (str1.charAt(str1.length()-1) == str2.charAt(str2.length()-1))
			return LCS(str1.substring(0,str1.length()-1), str2.substring(0,str2.length()-1)) + 1;
		
				else
			return Math.max(LCS(str1.substring(0,str1.length()-1), str2), LCS(str1, str2.substring(0,str2.length()-1)));
		
	}

		public static String LCS2(String str1, String str2){
		String s = "";
		if(str1.length() == 0 || str2.length() == 0)
			return "";
		
		else if (str1.charAt(str1.length()-1) == str2.charAt(str2.length()-1)){
			return	s = LCS(str1.substring(0,str1.length()-1), str2.substring(0,str2.length()-1))+ (str1.charAt(str1.length()-1) +"");
		}
		
		else{
			String a = LCS(str1.substring(0,str1.length()-1), str2);
			String b = LCS(str1, str2.substring(0,str2.length()-1));
			return s = a.length() > b.length() ? a : b ;
		}
	}
	
		
}
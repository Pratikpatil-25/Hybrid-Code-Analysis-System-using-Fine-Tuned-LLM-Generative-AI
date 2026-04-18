import  java.security.*;
import java.math.*;
public class sha {
	public static void main(String args[]) throws Exception{
		MessageDigest md = MessageDigest.getInstance("SHA");
		System.out.println("Algorithm="+ md.getAlgorithm());
		System.out.println("Provider="+ md.getProvider());
		System.out.println("to string="+ md.toString());
		
		String input="";
		md.update(input.getBytes());
		byte[] output= md.digest();
		System.out.println("sha-1"+"("+input+")="+bytestohex(output));
		input="abc";
		md.update(input.getBytes());
		output=md.digest();
		System.out.println("sha-1"+"("+input+")="+bytestohex(output));
		input="abcefghijkl";
		md.update(input.getBytes());
		output=md.digest();
		System.out.println("sha-1"+"("+input+")="+bytestohex(output));
		input="abcdefghijklmnopqrstuvwxyz";
		md.update(input.getBytes());
		output=md.digest();
	}
	public static String bytestohex(byte[] b)
	{
		BigInteger no = new BigInteger(1,b);
		String hashtext = no.toString(16);
		return hashtext;
	}
}
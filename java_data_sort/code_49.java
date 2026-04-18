import java.net.*;
import java.io.*;
import java.util.*;
public class TcpClient
{
public static void main(String args[])throws IOException
{
try
{
Socket con= new Socket("localhost",95);
BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
PrintWriter out=new PrintWriter(con.getOutputStream(),true);
while(true)
{ 
System.out.print("enter the message to the server:");
BufferedReader din=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter 5 nums");
int a[]=new int[5];
	for(int i=0;i<5;i++){
		a[i]=Integer.parseInt(din.readLine());
	}
String st=Arrays.toString(a);
out.println(st);
String s1=in.readLine();
System.out.println("from server:"+s1);
if(st.equalsIgnoreCase("bye")||st==null)
break;
}
in.close();
out.close();
con.close();
}
catch(UnknownHostException e)
{
}

}
}
import java.net.*;
import java.io.*;
import java.util.*;
public class TcpServer 
{
public static void main(String args[])throws IOException
{
try
{
ServerSocket s= new ServerSocket(95);
System.out.println("Server Waiting for the Client");
Socket cs=s.accept();
InetAddress ie=cs.getInetAddress();
String cli=ie.getHostAddress();
System.out.println("Connected to the client with IP "+cli);
BufferedReader in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
PrintWriter out=new PrintWriter(cs.getOutputStream(),true);
do
{ 
String st=in.readLine();
String c[]=st.replaceAll("\\[","").replaceAll("]","").replaceAll(" ","").split(",");
		
		int n[]=new int[c.length];
		for(int i=0;i<c.length;i++){
			n[i]=Integer.valueOf(c[i]);
		}
TcpServer ts=new TcpServer();
ts.sort(n);
String res=Arrays.toString(n);
out.println(res);
if(st.equalsIgnoreCase("bye")||st==null)
break;
System.out.println("from client.  "+st);
}while(true);
in.close();
out.close();
cs.close();
}
catch(IOException e)
{
}

}

void sort(int n[]){
	int i,j,temp;
	int l=n.length;
	for(i=0;i<l-1;i++){
		for(j=0;j<l-i-1;j++){
			if(n[j]>n[j+1]){
				temp=n[j];
				n[j]=n[j+1];
				n[j+1]=temp;
			}
		}
	}
}

}
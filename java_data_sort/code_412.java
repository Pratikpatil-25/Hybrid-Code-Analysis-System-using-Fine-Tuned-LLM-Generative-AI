import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}



class GfG{
    public void solve(Stack<Integer>s,int a){
        if(s.isEmpty() || s.peek()<a){
            s.push(a);
        }else{
            int e=s.pop();
            solve(s,a);
            s.push(e);
        }
    }
	public Stack<Integer> sort(Stack<Integer> s)
	{
				
		if(s.isEmpty()) return s;
		    int a=s.pop();
		    sort(s);
		    solve(s,a);
		    return s;
		
	}
}
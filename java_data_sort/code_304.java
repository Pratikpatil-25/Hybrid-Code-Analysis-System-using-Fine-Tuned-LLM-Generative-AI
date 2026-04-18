package solution;
import java.util.*;
public class KthSmallestNumberAgain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
				
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			ArrayList<Pair> arr = new ArrayList<>();
			for(int j=0; j<n; j++) {
				arr.add(new Pair(sc.nextInt(), sc.nextInt()));
			}
			
						arr.sort(new Comparator<Pair>() {
				@Override
				public int compare(Pair o1, Pair o2) {
					if(o1.a > o2.a)
						return 1;
					return -1;
				}
			});
			
						int idx = 0;
			for(int j=1; j<arr.size(); j++) {
				if(arr.get(idx).b >= arr.get(j).a) {
					arr.get(idx).b = Math.max(arr.get(idx).b, arr.get(j).b);
				}
				else {
					idx++;
					arr.get(idx).a = arr.get(j).a;
					arr.get(idx).b = arr.get(j).b;
				}
			}
			
			while(q>0) {
				int k = sc.nextInt();
				int ans = -1;
				for(int j=0; j<=idx; j++) {
					if((arr.get(j).b - arr.get(j).a + 1)>= k) {
						ans = arr.get(j).a + k-1;
						break;
					}
					else {
						k = k - (arr.get(j).b - arr.get(j).a + 1);
					}
				}
				System.out.println(ans);
				q--;
			}
		}

	}
}

class Pair{
	int a, b;
	Pair(int a, int b){
		this.a = a;
		this.b = b;
	}
}
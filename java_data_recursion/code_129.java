package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Boj16500 {

	private static boolean[] dp;
	private static char[] S;
	private static char[][] A;
	private static int N, result;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine().toCharArray();

		N = Integer.parseInt(br.readLine());
		A = new char[N][];
		dp = new boolean[101];

		for(int i = 0; i < N; i++) {
			A[i] = br.readLine().toCharArray();
		}

		recursion(0);
		System.out.println(result);
	}

	
	private static void recursion(int idx) {
		if(idx == S.length){
			result = 1;
			return;
		}

		if(dp[idx]) return;
		dp[idx] = true;

		for(int nxt = 0; nxt < N; nxt++) {
			int until = A[nxt].length + idx;
			if(until > S.length) continue;

			boolean flag = true;

			for (int i = idx; i < until; i++) {
				flag = S[i] == A[nxt][i - idx];
				if (!flag) break;
			}

			if(flag) recursion(until);
		}
	}
}
package day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ1463 { // 1로 만들기
	static int N;
	static boolean[] visit;
	static int result = Integer.MAX_VALUE;
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visit = new boolean[N + 1];
		// dfs(N, 0);
		// bfs(N);
		
		dp = new int[N + 1];
		dp[0] = dp[1] = 1;
		dp(N);
		System.out.println(result);
	}
	
	static void bfs(int n) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[N + 1];
		
		q.add(n);
		visit[n] = true;
		
		int min = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int s = 0; s < size; s++) {
				int num = q.poll();
				
				if(num == 1) {
					result = min;
					return;
				}
				
				if(num % 3 == 0 && !visit[num / 3]) {
					q.add(num / 3);
					visit[num / 3] = true;
				}
				
				if(num % 2 == 0 && !visit[num / 2]) {
					q.add(num / 2);
					visit[num / 2] = true;
				}
				
				if(!visit[num - 1]) {
					q.add(num - 1);
					visit[num - 1] = true;
				}
			}
			
			min++;
		}
	}
	
	static void dfs(int n, int cnt) {
		if(cnt >= result) {
			return;
		}
		
		if(n == 1) {
			result = Math.min(result, cnt);
			return;
		}
		
		if(n % 3 == 0) dfs(n / 3, cnt + 1);
		if(n % 2 == 0) dfs(n / 2, cnt + 1);
		dfs(n - 1, cnt + 1);
	}
	
	static int dp(int n) {
		if(dp[n] == 0) {
			// dp[n] = 
		}
		
		return dp[n];
	}
}

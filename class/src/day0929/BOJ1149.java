package day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 { // RGB 거리
	static int N;
	static int[][] cost;
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		dp = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
		int result = Math.min(dp(N - 1, 0), Math.min(dp(N - 1, 1), dp(N - 1, 2)));
		System.out.println(result);
	}
	
	static int dp(int n, int c) {
		if(dp[n][c] == 0) {
			if(c == 0) {
				dp[n][0] = Math.min(dp(n - 1, 1), dp(n - 1, 2)) + cost[n][0];
			} else if(c == 1) {
				dp[n][1] = Math.min(dp(n - 1, 0), dp(n - 1, 2)) + cost[n][1];
			} else if(c == 2) {
				dp[n][2] = Math.min(dp(n - 1, 0), dp(n - 1, 1)) + cost[n][2];
			}
		}
		
		return dp[n][c];
	}
}

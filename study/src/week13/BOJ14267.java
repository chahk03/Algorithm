package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14267 { // 회사 문화1
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken()); // 회사 직원 수
		int m = Integer.parseInt(st.nextToken()); // 최초 칭찬 횟수
		int[] boss = new int[n + 1];
		int[] cnt = new int[n + 1];
		int[] dp = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == -1) num = 0;
			boss[num] = i;
		}
		
		for(int x = 0; x < m; x++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			cnt[i] = w;
		} // end input
		
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			int w = cnt[i];
			dp[i] = sum + w;
			sum += w;
		}
		
		int num = 0;
		for(int i = 1; i <= n; i++) {
			if(dp[i] != 0 && dp[i] != num) {
				num = dp[i];
			}
			
			sb.append(num + " ");
		}
		
		System.out.println(sb);
	}
}

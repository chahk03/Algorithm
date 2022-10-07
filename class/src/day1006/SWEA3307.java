package day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA3307 { // 최장 증가 부분 수열
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			} // end input
			
			int[] dp = new int[N];
			Arrays.fill(dp, 1);
			int result = 1;
			
			for(int i = 1; i < N; i++) {
				for(int j = 0; j < i; j++) {
					if(arr[i] > arr[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
				
				result = Math.max(result, dp[i]);
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}

package day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3308 { // 최장 증가 부분 수열 (Hard)
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
			
			int[] dp = new int[N + 1];
			int len = 0, idx = 0;
			
			for(int i = 0; i < N; i++) {
				if(arr[i] > dp[len]) {
					len += 1;
					dp[len] = arr[i];
				} else {
					//idx = binarySearch(0, len, arr[i]);
				}
			}
			
			
			
			// System.out.println("#" + t + " " + result);
		}
	}
	
//	static int binarySearch(int left, int right, int key) {
//		int mid = 0;
//		
//		while(left < right) {
//			mid = (left + right) / 2;
//			// if(dp[mid] < key) {
//				
//			// }
//		}
//	}
}

package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 { // 수들의 합2
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int result = 0;
		
		while(true) {
			if(end < N) {
				if(sum == M) {
					sum += arr[end++];
				} else if(sum < M) {
					sum += arr[end++];
				} else if(sum > M) {
					sum -= arr[start++];
				}
			}
			
			if(start == N) break;
			
			if(sum == M) {
				System.out.println(start + " " + end);
				result++;
			}
		}
		
		System.out.println(result);
	}
}

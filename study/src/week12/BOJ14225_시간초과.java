package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14225_시간초과 { // 부분수열의 합
	static int N;
	static int[] nums;
	static boolean[] sums;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		int total = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			total += nums[i];
		}
		
		sums = new boolean[total + 1];
		result = total + 1;
		findSum(0, 0, 0);
		
		for(int i = 1; i <= total; i++) {
			if(!sums[i]) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}

	private static void findSum(int cnt, int start, int sum) {
		sums[sum] = true;
		// System.out.println(Arrays.toString(sums));
		
		if(cnt == N) {
			return;
		}
		
		for(int i = start; i < N; i++) {
			findSum(cnt + 1, i + 1, sum + nums[i]);
			findSum(cnt + 1, i + 1, sum);
		}		
	}
}

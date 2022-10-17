package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14225_뭐지 { // 부분수열의 합
	static int N;
	static int[] nums;
	static boolean[] select;
	static boolean[] sums;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		select = new boolean[N];
		int total = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			total += nums[i];
		}
		
		sums = new boolean[total + 1];
		result = total + 1;
		findSum(0, 0);
		
		for(int i = 1; i <= total; i++) {
			if(!sums[i]) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}

	private static void findSum(int cnt, int start) {
		if(cnt == N) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(select[i]) sum += nums[i];
			}
			
			sums[sum] = true;
			return;
		}
		
		for(int i = start; i < N; i++) {
			select[i] = true;
			findSum(cnt + 1, i + 1);
			select[i] = false;
			findSum(cnt + 1, i + 1);
		}		
	}
}

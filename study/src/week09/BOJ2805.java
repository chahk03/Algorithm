package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 나무 수
		int M = Integer.parseInt(st.nextToken()); // 나무 길이
		int[] tree = new int[N];
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			sum += tree[i];
		}
		
		Arrays.sort(tree);
		
		int num = N;
		int cnt = 0;
		int minSum = 0;
		int result = 0;
		while(true) {
			if(sum <= M) {
				int plus = 0;
				if(cnt > 0) {
					plus = (M - sum) / cnt;
					if((M - sum) % cnt != 0) {
						plus += 1;
					}
				}
				
				result = minSum - plus;
				if(minSum < plus) {
					result = minSum;
				}
				break;
			}
			
			sum -= (tree[cnt] - minSum) * (num--);
			minSum = tree[cnt];
			cnt += 1;
		}
		
		System.out.println(result);
	}
}

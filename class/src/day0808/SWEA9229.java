package day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9229 { // 한빈이와 Spot Mart
	static int N, M;
	static int[] arr;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 과자 봉지 개수
			M = Integer.parseInt(st.nextToken()); // 무게 합 제한
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			result = -1;
			select(0, 0, 0);
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static void select(int cnt, int weight, int start) {
		if(weight > M) {
			return;
		}
		
		if(cnt == 2) { // 2봉지 구매
			if(weight <= M) {
				result = Math.max(result, weight);
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			select(cnt + 1, weight + arr[i], i + 1);
		}
	}
}

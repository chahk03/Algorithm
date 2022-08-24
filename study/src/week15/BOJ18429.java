package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18429 { // 근손실
	static int N, K;
	static int[] kit, ans;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 기간 = 키트 수
		int K = Integer.parseInt(st.nextToken()); // 하루 감소 중량
		int[] kit = new int[N];// 키트 중량 증가량
		
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			kit[n] = Integer.parseInt(st.nextToken());
		}
		
		
	}
	
	static void perm(int cnt) {
		
		for(int i = 0; i < N; i++) {
			ans[cnt] = kit[i];
		}
	}

}

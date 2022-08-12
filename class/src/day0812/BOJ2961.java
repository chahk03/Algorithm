package day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2961 { // 도영이가 만든 맛있는 음식
	static int N;
	static int[] sour, bit;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bit = new int[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken()); // 신맛
			bit[i] = Integer.parseInt(st.nextToken()); // 쓴맛
		}
		
		comb(0, 0, 1, 0);
		System.out.println(result);
	}
	
	static void comb(int cnt, int start, int s, int b) {
		if(cnt != 0) result = Math.min(result, Math.abs(s - b));
				
		if(cnt == N) return;
		
		for(int i = start; i < N; i++) {
			comb(cnt + 1, i + 1, s * sour[i], b + bit[i]);
			comb(cnt, i + 1, s, b);
		}
	}
}

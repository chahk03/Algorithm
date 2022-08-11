package day0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5215 { // 햄버거 다이어트
	static int N, L;
	static int[] score, calorie;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			score = new int[N];
			calorie = new int[N];
			result = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				calorie[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0, 0, 0);
			System.out.println("#" + t + " " + result);
		}
		
	}
	
	static void comb(int cal, int scr, int start) { // 중복 불가, 순서 비고려
		result = Math.max(result, scr);
		
		for(int i = start; i < N; i++) {
			if(cal + calorie[i] <= L) comb(cal + calorie[i], scr + score[i], i + 1);
			else comb(cal, scr, i + 1);
		}
	}
}

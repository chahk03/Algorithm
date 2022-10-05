package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17179 { // 케이크 자르기
	static int N, M, L;
	static int[] S, Q;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 자르는 횟수
		M = Integer.parseInt(br.readLine()); // 자르는 횟수
		L = Integer.parseInt(br.readLine()); // 자르는 횟수
		
		S = new int[M];
		Q = new int[N];
		
		for(int i = 0; i < M; i++) {
			S[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < N; i++) {
			Q[i] = Integer.parseInt(br.readLine());
		}
		
		
	}
	
	static boolean isPossible(int k, int n) {
		
		return false;
	}
}

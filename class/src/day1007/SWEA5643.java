package day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5643 { // 키 순서
	static int N, M;
	static int[][] adjArr;
	static boolean[] visit;
	static int up, down;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adjArr = new int[N + 1][N + 1];
			int res = 0;
			
			for(int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjArr[a][b] = 1; // a번 학생 키가 b번 학생 키보다 작음, a < b, a -> b
			}
			
			for(int i = 1; i <= N; i++) {
				up = 0; down = 0;
				visit = new boolean[N + 1];
				findUp(i); findDown(i);
				if(up + down == N - 1) res++;
			}
			
			System.out.println("#" + t + " " + res);
		}
	}

	private static void findUp(int n) {
		visit[n] = true;
		for(int i = 1; i <= N; i++) {
			if(adjArr[n][i] == 1 && !visit[i]) {
				up++;
				visit[i] = true;
				findUp(i);
			}
		}
	}

	private static void findDown(int n) {
		visit[n] = true;
		for(int i = 1; i <= N; i++) {
			if(adjArr[i][n] == 1 && !visit[i]) {
				down++;
				visit[i] = true;
				findDown(i);
			}
		}
	}
}

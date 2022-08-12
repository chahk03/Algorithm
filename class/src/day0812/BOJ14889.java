package day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 { // 스타트와 링크
	static int N;
	static int[][] map;
	static boolean[] list;
	static int[] sTeam, lTeam;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 인원 수
		map = new int[N][N]; // 능력치 표
		list = new boolean[N]; // 팀 표시
		sTeam = new int[N / 2];
		lTeam = new int[N / 2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		System.out.println(result);
	}
	
	static void comb(int cnt, int start) {
		if(cnt == N / 2) {
			// 팀 나누기
			for(int n = 0, s = 0, i = 0; n < N; n++) {
				if(list[n] == true) {
					sTeam[s++] = n;
				} else {
					lTeam[i++] = n;
				}
			}
			
			// 능력치 계산
			int startT = 0, linkT = 0;
			for(int i = 0; i < N / 2; i++) {
				for(int j = 0; j < N / 2; j++) {
					if(i == j) continue;
					startT += map[sTeam[i]][sTeam[j]];
					linkT += map[lTeam[i]][lTeam[j]];
				}
			}
			
			result = Math.min(result, Math.abs(startT - linkT));
			return;
		}
		
		for(int i = start; i < N; i++) {
			list[i] = true;
			comb(cnt + 1, i + 1);
			list[i] = false;
		}
	}
}

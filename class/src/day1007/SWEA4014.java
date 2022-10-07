package day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4014 {
	static int N, X;
	static int[][] map;
	static boolean flag;
	static int res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지도 크기
			X = Integer.parseInt(st.nextToken()); // 경사로 길이
			res = 0;
			
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input
			
			// 가로 한 줄씩 탐색
			for(int i = 0; i < N; i++) {
				flag = true;
				int temp = 1;
				
				for(int j = 0; j < N - 1; j++) {
					if(map[i][j] - map[i][j + 1] == -1) { // 오르막길
						if(temp >= X) temp = 1;
						else flag = false;
					} else if(map[i][j] - map[i][j + 1] == 1) { // 내리막길
						temp = 0;
						if(check(i, j + 1, map[i][j + 1], 0)) j += X - 1;
						else flag = false;
					} else if(map[i][j] - map[i][j + 1] == 0) {
						temp++;
					} else {
						flag = false;
					}
					
					if(!flag) break;
				}
				
				System.out.println("가로");
				if(flag) {
					res++;
					System.out.println(i + 1 + "번째 줄");
				}
			}
			
			// 세로 한 줄씩 탐색
			for(int i = 0; i < N; i++) {
				flag = true;
				int temp = 1;
				
				for(int j = 0; j < N - 1; j++) {
					if(map[j][i] - map[j + 1][i] == -1) { // 오르막길
						if(temp >= X) temp = 1;
						else flag = false;
					} else if(map[j][i] - map[j + 1][i] == 1) { // 내리막길
						temp = 0;
						if(check(j + 1, i, map[j + 1][i], 1)) j += X - 1;
						else flag = false;
					} else if(map[j][i] - map[j + 1][i] == 0) {
						temp++;
					} else {
						flag = false;
					}
					
					if(!flag) break;
				}
				
				System.out.println("세로");
				if(flag) {
					res++;
					System.out.println(i + 1 + "번째 줄");
				}
			}
			
			System.out.println("#" + t + " " + res);
		}
	}
	
	// 내리막길 체크
	static boolean check(int x, int y, int value, int rc) {
		if(rc == 0) { // 가로 줄 검사
			for(int i = y; i < y + X; i++) {
				if(i >= N) return false;
				if(map[x][i] != value) return false;
			}			
		} else if(rc == 1) { // 세로 줄 검사
			for(int i = x; i < x + X; i++) {
				if(i >= N) return false;
				if(map[i][y] != value) return false;
			}
		}
		
		return true;
	}
}

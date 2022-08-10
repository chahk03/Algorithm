package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16935 {
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열
		int R = Integer.parseInt(st.nextToken()); // 연산 수
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int r = 0; r < R; r++) {
			int num = Integer.parseInt(st.nextToken());
			move(num);
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void move(int num) {
		int N = arr.length;
		int M = arr[0].length;
		
		if(num == 1) { // 상하 반전
			for(int m = 0; m < M; m++) {
				for(int n = 0; n < N / 2; n++) {
					int temp = arr[n][m];
					arr[n][m] = arr[N - 1 - n][m];
					arr[N - 1 - n][m] = temp;
				}
			}
		}
		
		if(num == 2) { // 좌우 반전 
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M / 2; m++) {
					int temp = arr[n][m];
					arr[n][m] = arr[n][M - 1 - m];
					arr[n][M - 1 - m] = temp;
				}
			}
		}
		
		if(num == 3) { // 오른쪽 90도 회전
			int[][] arr2 = new int[M][N];
			for(int m = 0; m < M; m++) {
				for(int n = N - 1, idx = 0; n >= 0; n--) {
					arr2[m][idx++] = arr[n][m];
				}
			}
			arr = arr2;
		}
		
		if(num == 4) { // 왼쪽 90도 회전
			int[][] arr2 = new int[M][N];
			for(int n = N - 1; n >= 0; n--) {
				for(int m = M - 1, idx = 0; m >= 0; m--) {
					arr2[idx++][n] = arr[n][m];
				}
			}
			arr = arr2;
		}
		
		if(num == 5) {
			int[][] arr2 = new int[N][M];
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					if(n < N / 2 && m < M / 2) { // 1번 그룹
						arr2[n][m + M / 2] = arr[n][m];
					}
					
					if(n < N / 2 && m >= M / 2) { // 2번 그룹
						arr2[n + N / 2][m] = arr[n][m];
					}
					
					if(n >= N / 2 && m >= M / 2) { // 3번 그룹
						arr2[n][m - M / 2] = arr[n][m];
					}
					
					if(n >= N / 2 && m < M / 2) { // 4번 그룹
						arr2[n - N / 2][m] = arr[n][m];
					}
				}
			}
			arr = arr2;
		}
		
		if(num == 6) {
			int[][] arr2 = new int[N][M];
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					if(n < N / 2 && m < M / 2) { // 1번 그룹
						arr2[n + N / 2][m] = arr[n][m];
					}
					
					if(n < N / 2 && m >= M / 2) { // 2번 그룹
						arr2[n][m - M / 2] = arr[n][m];
					}
					
					if(n >= N / 2 && m >= M / 2) { // 3번 그룹
						arr2[n - N / 2][m] = arr[n][m];
					}
					
					if(n >= N / 2 && m < M / 2) { // 4번 그룹
						arr2[n][m + M / 2] = arr[n][m];
					}
				}
			}
			arr = arr2;
		}
	}
}

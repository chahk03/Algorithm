package day0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17069 { // 파이프 옮기기2
	static int N;
	static int[][] map;
	static long[][][] sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		sum = new long[N][N][3];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sum[0][1][0] = 1;
		dp();
		long result = sum[N - 1][N - 1][0] + sum[N - 1][N - 1][1] + sum[N - 1][N - 1][2];
		
		System.out.println(result);
	}
	
	static void dp() {
		for(int i = 0; i < N; i++) {
			for(int j = 2; j < N; j++) {
				if(map[i][j] != 1) {
					sum[i][j][0] = sum[i][j - 1][0] + sum[i][j - 1][2];
				}
				
				if(i > 0 && map[i][j] != 1) {
					sum[i][j][1] = sum[i - 1][j][1] + sum[i - 1][j][2];
				}
				
				if(i > 0 && map[i][j] != 1 && map[i - 1][j] != 1 && map[i][j - 1] != 1) {
					sum[i][j][2] = sum[i - 1][j - 1][0] + sum[i - 1][j - 1][1] + sum[i - 1][j - 1][2];
				}
			}
		}
	}
}

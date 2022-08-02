package daily0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); // ³óÀå Å©±â
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			int result = 0;
//			for(int i = 0; i <= N / 2; i++) {
//				// À­ºÎºÐ
//				for(int j = N / 2 - i; j <= N / 2 + i; j++) {
//					result += map[i][j];
//				}
//				
//				// ¾Æ·§ºÎºÐ
//				for(int j = N / 2 - i; j <= N / 2 + i; j++) {
//					if(i == N / 2) break;
//					result += map[N - i - 1][j];
//				}
//			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(N / 2 < i) {
						if(Math.abs(N / 2 - j) <= Math.abs(i - N - 1)) {
							result += map[i][j];
						}
					} else {
						if(Math.abs(N / 2 - j) <= i) {
							result += map[i][j];
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}

package daily0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1954 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			
			int value = 0;
			int cnt = 1;
			int x = 0, y = 0;
			
			while(true) {
				for(int j = y; j < N - cnt; j++) {
					map[x][y++] = ++value;
				}
				
				if(value == N * N) break;
				
				for(int i = x; i < N - cnt; i++) {
					map[x++][y] = ++value;
				}
				
				for(int j = y; j >= cnt; j--) {
					map[x][y--] = ++value;
				}
				
				for(int i = x; i >= cnt; i--) {
					map[x--][y] = ++value;
				}
				
				x += 1; y += 1;
				cnt++;
			}
			
			sb.append("#" + t).append('\n');
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append('\n');
			}
		}
		
		System.out.println(sb);
	}
}

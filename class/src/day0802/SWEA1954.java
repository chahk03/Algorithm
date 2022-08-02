package day0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1954 {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			boolean[][] visit = new boolean[N][N];
			
			int value = 0, dir = 0;
			int x = 0, y = 0;
			
			while(true) {
				map[x][y] = ++value;
				visit[x][y] = true;
				
				if(value == N * N) break;
				
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny]) {
					dir = (dir + 1) % 4;
				}
				
				x = x + dx[dir];
				y = y + dy[dir];
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

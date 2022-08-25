package day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4485 { // 녹색 옷 입은 애가 젤다지?
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			tc++;
			
			int[][] cave = new int[N][N];
			int[][] dist = new int[N][N];
			boolean[][] visit = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dist[0][0] = cave[0][0];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int value = Integer.MAX_VALUE;
					int x = -1, y = -1;
					
					for(int n = 0; n < N; n++) {
						for(int m = 0; m < N; m++) {
							if(!visit[n][m] && dist[n][m] < value) {
								value = dist[n][m];
								x = n; y = m;
							}
						}
					}
					
					visit[x][y] = true;					
					
					for(int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						
						if(0 <= nx && nx < N && 0 <= ny && ny < N) {
							if(!visit[nx][ny] && dist[nx][ny] > dist[x][y] + cave[nx][ny]) {
								dist[nx][ny] = dist[x][y] + cave[nx][ny];
							}
						}
					}
				}
			}
			
			System.out.println("Problem " + tc + ": " + dist[N - 1][N - 1]);
		}
	}
}

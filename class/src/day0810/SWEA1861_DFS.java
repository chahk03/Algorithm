package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1861_DFS { // 정사각형 방
	static int N;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0, min = 1001;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					dfs(i, j, 1);
					
					if(result > max) {
						min = map[i][j];
						max = result;
					} else if(result == max) {
						if(map[i][j] < min) {
							min = map[i][j];
							max = result;
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + min + " " + max);
		}
	}
	
	static void dfs(int x, int y, int cnt) {
		result = cnt;
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < N) {
				if(map[nx][ny] == map[x][y] + 1) {
					dfs(nx, ny, cnt + 1);
				}
			}
		}
	}
}

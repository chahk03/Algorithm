package day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 { // 알파벳
	static int R, C;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[] alpha;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		alpha = new int[26];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}
		
		dfs(0, 0, 1);
		System.out.println(result);
	}
	
	static void dfs(int x, int y, int n) {
		alpha[map[x][y]] = 1;
		result = Math.max(result, n);
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
				
			if(0 <= nx && nx < R && 0 <= ny && ny < C) {
				if(alpha[map[nx][ny]] == 0) {
					dfs(nx, ny, n + 1);
					alpha[map[nx][ny]] = 0;
				}
			}
		}
	}
}

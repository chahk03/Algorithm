package day1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2105 { // 디저트 카페
	static int N;
	static int[][] map;
	static boolean[] dessert;
	static boolean[][] visit;
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, -1, 1};
	static int[][] go = {{0, 1}, {1, 2}, {2, 3}, {3}};
	static int startX, startY;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 지도 크기
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input
			
			result = -1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					startX = i; startY = j;
					dessert = new boolean[101];
					visit = new boolean[N][N];
					
					dfs(i, j, 0, 0);
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	static void dfs(int x, int y, int dir, int cnt) {
		if(x == startX && y == startY && cnt > 1) {
			result = Math.max(result, cnt);
			return;
		}
		
		for(int d = 0; d < go[dir].length; d++) {
			int nx = x + dx[go[dir][d]];
			int ny = y + dy[go[dir][d]];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < N) {
				if(!visit[nx][ny] && !dessert[map[nx][ny]])	{
					visit[nx][ny] = true;
					dessert[map[nx][ny]] = true;
					dfs(nx, ny, go[dir][d], cnt + 1);
					visit[nx][ny] = false;
					dessert[map[nx][ny]] = false;					
				}
			}
		}
	}
}

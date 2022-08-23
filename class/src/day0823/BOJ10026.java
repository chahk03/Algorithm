package day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ10026 { // 적록색약
	static int N;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		char[][] map_no = new char[N][N];
		char[][] map_yes = new char[N][N];
		boolean[][] visit_no = new boolean[N][N];
		boolean[][] visit_yes = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				char chr = str.charAt(j);
				map_no[i][j] = chr;
				
				if(chr == 'G') map_yes[i][j] = 'R';
				else map_yes[i][j] = chr;
			}
		}
		
		int ans_no = 0, ans_yes = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visit_no[i][j] == false) {
					ans_no += 1;
					bfs(i, j, map_no, visit_no);
				}
				
				if(visit_yes[i][j] == false) {
					ans_yes += 1;
					bfs(i, j, map_yes, visit_yes);
				}
			}
		}
		
		System.out.println(ans_no + " " + ans_yes);
	}
	
	static void bfs(int x, int y, char[][] map, boolean[][] visit) {
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] {x, y});
		visit[x][y] = true;
		char color = map[x][y];
		
		while(!que.isEmpty()) {
			int node[] = que.poll();
			int nx = node[0];
			int ny = node[1];
			
			for(int d = 0; d < 4; d++) {
				int newX = nx + dx[d];
				int newY = ny + dy[d];
				
				if(0 <= newX && newX < N && 0 <= newY && newY < N) {
					if(map[newX][newY] == color && visit[newX][newY] == false) {
						que.add(new int[] {newX, newY});
						visit[newX][newY] = true;
					}
				}
			}
		}
	}
}

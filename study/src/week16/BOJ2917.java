package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2917 { // 늑대 사냥꾼
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int startX, startY;
	static int endX, endY;
	static ArrayList<Node> trees;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		map = new int[N][M];
		visit = new boolean[N][M];
		trees = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				char value = str.charAt(j);
				
				if(value == 'V') {
					startX = i;
					startY = j;
				}
				
				if(value == 'J') {
					endX = i;
					endY = j;
				}
				
				if(value == '+') {
					trees.add(new Node(i, j));
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int min = Integer.MAX_VALUE;
				for(Node tree : trees) {
					int dist = Math.abs(tree.x - i) + Math.abs(tree.y - j);
					min = Math.min(min, dist);
				}
				map[i][j] = min;
			}
		}
		
		for(int i = map[startX][startY]; i >= 1; i--) {
			dfs(startX, startY, i);
			if(max == i) break;
		}
		
		System.out.println(max);
	}
	
	static void dfs(int x, int y, int v) {
		visit[x][y] = true;

		if(x == endX && y == endY) {
			max = Math.max(max,  v);
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < M && !visit[nx][ny]) {
				if(map[nx][ny] >= v) {
					dfs(nx, ny, v);
				}
				
				visit[nx][ny] = false;
			}
		}
	}
	
	static class Node {
		int x, y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

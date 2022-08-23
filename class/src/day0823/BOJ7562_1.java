package day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562_1 { // 나이트의 이동
	static int l;
	static int[][] map;
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			l = Integer.parseInt(br.readLine());
			map = new int[l][l];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
		
			result = 0;
			bfs(startX, startY, endX, endY);
			System.out.println(result);
		}
	}
	
	static void bfs(int startX, int startY, int endX, int endY) {
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] {startX, startY});
		map[startX][startY] = 1;
		
		while(!que.isEmpty()) {
			int node[] = que.poll();
			int nx = node[0];
			int ny = node[1];
			
			if(nx == endX && ny == endY) {
				result = map[nx][ny] - 1;
				return;
			}
			
			for(int d = 0; d < 8; d++) {
				int newX = nx + dx[d];
				int newY = ny + dy[d];
				
				if(0 <= newX && newX < l && 0 <= newY && newY < l) {
					if(map[newX][newY] == 0) {
						que.add(new int[] {newX, newY});
						map[newX][newY] = map[nx][ny] + 1;
					}
				}
			}
		}
	}
}

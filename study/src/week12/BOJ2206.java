package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 { // 벽 부수고 이동하기
	static int N, M;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] visit;
	static int result, max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		map = new int[N][M];
		result = -1;
		
		LinkedList<int[]> list = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				if(map[i][j] == 1) {
					list.add(new int[]{i, j});
				}
			}
		}
		
		int[][] map_copy = new int[N][M];
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < M; y++) {
				map_copy[x][y] = map[x][y];
			}
		}
		
		for(int i = -1; i < list.size(); i++) {
			visit = new int[N][M];
			
			if(i == -1) {
				bfs(0, 0);
				if(result != -1) {
					max = result;
					break;
				}
			} else {
				map[list.get(i)[0]][list.get(i)[1]] = 0;
				bfs(0, 0);
				map = map_copy;
			}
			
			max = Math.max(max, result);
		}
		
		System.out.println(result);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] {x, y, 1});
		visit[x][y] = 1;
		
		while(!que.isEmpty()) {
			int[] node = que.poll();
			int nx = node[0];
			int ny = node[1];
			int nr = node[2];
			
			if(nx == N - 1 && ny == M - 1) {
				result = nr;
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int newX = nx + dx[d];
				int newY = ny + dy[d];
				int newR = nr + 1;
				
				if(0 <= newX && newX < N && 0 <= newY && newY < M) {
					if(map[newX][newY] == 0 && visit[newX][newY] == 0) {
						que.add(new int[] {newX, newY, newR});
						visit[newX][newY] = newR;
					}
				}
			}
		}
	}
}

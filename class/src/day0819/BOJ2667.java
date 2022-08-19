package day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class BOJ2667 { // 단지번호붙이기
	static int N;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static ArrayList<Integer> list;
	static int total;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					// 1. dfs
					total = 0;
					dfs(i, j);
					list.add(total);
					// 2. bfs
					// list.add(bfs(i, j));
					result += 1;
				}
			}
		}
		
		Collections.sort(list);
		list.add(0, result);
		
		for(int val : list) {
			sb.append(val).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int bfs(int x, int y) {
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] {x, y});
		map[x][y] = 2;
		int sum = 1;
		
		while(!que.isEmpty()) {
			int node[] = que.poll();
			int nx = node[0];
			int ny = node[1];
			
			for(int d = 0; d < 4; d++) {
				int newX = nx + dx[d];
				int newY = ny + dy[d];
				
				if(0 <= newX && newX < N && 0 <= newY && newY < N) {
					if(map[newX][newY] == 1) {
						que.add(new int[] {newX, newY});
						map[newX][newY] = 2;
						sum += 1;
					}
				}
			}
		}
		
		return sum;
	}
	
	static void dfs(int x, int y) {
		total += 1;
		map[x][y] = 2;
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < N) {
				if(map[nx][ny] == 1) {
					dfs(nx, ny);
				}
			}
		}
	}
}

package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3055 { // 탈출
	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<int[]> water;
	static Queue<int[]> dochi;
	static boolean end;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 지도 행 크기
		C = Integer.parseInt(st.nextToken()); // 지도 열 크기
		map = new char[R][C];
		visit = new boolean[R][C];
		water = new ArrayDeque<>();
		dochi = new ArrayDeque<>();
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				char val = str.charAt(j);
				map[i][j] = val;
				
				if(val == 'S') { // 고슴도치 위치
					dochi.add(new int[] {i, j});
				}
				
				if(val == '*') {
					water.add(new int[] {i, j});
				}
			}
		}
		
		int time = 0;
		move(water, '*'); // 물 먼저 이동
		
		while(true) {
			if(dochi.isEmpty()) {
				System.out.println("KAKTUS");
				break;
			}
			
			move(dochi, 'S');
			move(water, '*');
			time += 1;
			
			if(end) {
				System.out.println(time);
				break;
			}
		}
	}
	
	static void move(Queue<int[]> que, char val) {
		if(!que.isEmpty()) {
			int size = que.size();
			
			for(int i = 0; i < size; i++) {
				int node[] = que.poll();
				int x = node[0];
				int y = node[1];
				
				for(int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(0 <= nx && nx < R && 0 <= ny && ny < C) {
						if(val == 'S' && map[nx][ny] == 'D') {
							end = true;
							return;
						}
						
						if(val == 'S' && map[nx][ny] == '.') {
							que.add(new int[] {nx, ny});
							map[nx][ny] = val;
						}
						
						if(val == '*' && (map[nx][ny] == '.' || map[nx][ny] == 'S')) {
							que.add(new int[] {nx, ny});
							map[nx][ny] = val;
						}
					}
				}
			}
		}
	}
}

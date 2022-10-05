package day1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636 { // 치즈
	static int R, C;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int cheeseCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int totalTime = 0;
		int lastCheese = 0;
		
		while(true) {
			cheeseCnt = 0;
			bfs();
			
			if(cheeseCnt == 0) break;
			
			totalTime++;
			lastCheese = cheeseCnt;
		}
		
		System.out.println(totalTime);
		System.out.println(lastCheese);
	}
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[R][C];
		
		q.add(new int[] {0, 0});
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int x = n[0];
			int y = n[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(0 <= nx && nx < R && 0 <= ny && ny < C) {
					if(!visit[nx][ny]) {
						visit[nx][ny] = true;
						
						if(map[nx][ny] == 1) {
							map[nx][ny] = 0;
							cheeseCnt++;
						} else {
							q.add(new int[] {nx, ny});
						}
					}
				}
			}
		}
	}
}

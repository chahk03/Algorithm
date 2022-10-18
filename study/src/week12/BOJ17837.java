package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17837 { // 새로운 게임2
	static int N, K;
	static int[][] map;
	static Horse[] horses;
	static Queue<Integer>[][] exist;
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N]; // 0: 흰색, 1: 빨간색, 2: 파란색
		exist = new ArrayDeque[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < K; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				exist[i][j] = new ArrayDeque<>();
			}
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()) - 1;
			horses[i] = new Horse(x, y, dir);
			exist[x][y].add(i);
		} // end input
		
		result = -1;
		
		
	}
	
	static void move() {
		for(int i = 0; i < K; i++) {
			Horse h = horses[i];
			
			int nx = h.x + dx[h.dir];
			int ny = h.y + dy[h.dir];
			
			// 체스판 벗어나는 경우, 파란색인 경우
			if((0 > nx && nx >= N && 0 > ny && ny >= N) || map[nx][ny] == 2) {
				h.dir = (h.dir + 1) % 4;
				nx = h.x + dx[h.dir];
				ny = h.y + dy[h.dir];
			}
			
			// 체스판 벗어나는 경우, 파란색인 경우
			if((0 > nx && nx >= N && 0 > ny && ny >= N) || map[nx][ny] == 2) {
				continue;
			} else {
				while(!exist[h.x][h.y].isEmpty()) {
					
				}
			}
			
			// 흰색인 경우
			if(map[nx][ny] == 0) {
				
			}
			
			// 빨간색인 경우
			if(map[nx][ny] == 1) {
				
			}
		}
	}
	
	static class Horse {
		int x, y, dir;
		
		Horse(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
}

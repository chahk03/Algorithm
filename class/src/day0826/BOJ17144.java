package day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17144 { // 미세먼지 안녕
	static int R, C, T;
	static int[][] map;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	static int up, down;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 행 크기
		C = Integer.parseInt(st.nextToken()); // 열 크기
		T = Integer.parseInt(st.nextToken()); // 실행 시간
		
		map = new int[R][C];
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1) {
					up = r - 1;
					down = r;
				}
			}
		} // end input
		
		for(int t = 0; t < T; t++) {
			move();
			clean();
		}
		
		int sum = 2;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sum += map[i][j];
			}
		}
		
		System.out.println(sum);
	}
	
	// 미세먼지 확산
	static void move() {
		int[][] copy = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == -1) {
					copy[i][j] = -1;
					continue;
				}
				
				int count = 0;
				int value = map[i][j];
				
				for(int d = 0; d < 4; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];
					
					if(0 <= ni && ni < R && 0 <= nj && nj < C) {
						if(map[ni][nj] == -1) continue;
						copy[ni][nj] += value / 5;
						count++;
					}
				}
				
				copy[i][j] += value - (value / 5 * count);
			}
		}
		
		map = copy;
	}
	
	// 공기청정기 작동
	static void clean() {
		map[up][0] = 0;
		map[down][0] = 0;
		
		// up
		int starti = up - 1, startj = 0, d = 0;
		while(true) {
			if(0 > starti + di[d] || starti + di[d] > up || 0 > startj + dj[d] || startj + dj[d] >= C) {
				d = (d + 1) % 4;
			}
			
			int ni = starti + di[d];
			int nj = startj + dj[d];
			
			map[starti][startj] = map[ni][nj];
			starti = ni; startj = nj;
			
			if(starti == up && startj == 0) break;
		}
		
		// down
		starti = down + 1; startj = 0; d = 2;
		while(true) {
			if(down > starti + di[d] || starti + di[d] >= R || 0 > startj + dj[d] || startj + dj[d] >= C) {
				d = (d + 3) % 4;
			}
			
			int ni = starti + di[d];
			int nj = startj + dj[d];
			
			map[starti][startj] = map[ni][nj];
			starti = ni; startj = nj;
			
			if(starti == down && startj == 0) break;
		}
		
		map[up][0] = -1;
		map[down][0] = -1;
	}
}

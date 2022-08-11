package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17406 { // 배열 돌리기4
	static int N, M, K;
	static int[][] map, copy_map;
	static boolean[] visit;
	static int[] list;
	static Rotate[] rtt;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		K = Integer.parseInt(st.nextToken()); // 회전 연산 수
		map = new int[N][M];
		visit = new boolean[K];
		list = new int[K];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rtt = new Rotate[K];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			rtt[i] = new Rotate(r, c, s);
		}
		
		perm(0);
		System.out.println(min);
	}
	
	static void perm(int cnt) {
		if(cnt == K) {
			copy_map = map_copy();
			
			for(int i = 0; i < K; i++) {
				int idx = list[i];
				array(rtt[idx].r, rtt[idx].c, rtt[idx].s);
			}
			
			for(int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = 0; j < M; j++) {
					sum += map[i][j];
				}
				min = Math.min(min, sum);
			}
			
			map = copy_map;
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				list[cnt] = i;
				perm(cnt + 1);
				visit[i] = false;
			}
		}
	}
	
	static void array(int r, int c, int s) {
		for(int i = 0; i < s; i++) {
			int x = r - s + i - 1, y = c - s + i - 1;
			int temp = map[x][y];
			
			for(int d = 0; d < 4; d++) {
				while(true) {
					if(x + dx[d] < r - s + i - 1 || x + dx[d] >= r + s - i || y + dy[d] < c - s + i - 1 || y + dy[d] >= c + s - i) {
						break;
					}
					
					map[x][y] = map[x + dx[d]][y + dy[d]];
					x += dx[d]; y += dy[d];
				}
			}
			
			map[x][y + 1] = temp;
		}
	}
	
	static int[][] map_copy() {
		int[][] copy_map = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copy_map[i][j] = map[i][j];
			}
		}
		return copy_map;
	}
}

class Rotate {
	int r; // 회전 중심 행
	int c; // 회전 중심 열
	int s; // 반지름
	
	Rotate(int r, int c, int s) {
		this.r = r;
		this.c = c;
		this.s = s;
	}
}

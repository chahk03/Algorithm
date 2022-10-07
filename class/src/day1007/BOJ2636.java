package day1007;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2636 { // 치즈
	static int N, M;
	static int[][] map;
	static int time, last;
	static int[] di = {0, 1, 0, -1};
	static int[] dj = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		} // input
		
		time = 0;
		while(true) {
			if(count() == 0) {
				break;
			}
			
			last = count(); // 이번에 다 녹을 수 있으므로 치즈 개수 세놓기
			bfs(); // 녹아야 될 치즈 탐색
			melt(); // 한꺼번에 녹이기
			time++;
		}
		
		System.out.println(time);
		System.out.println(last);
	}

	private static void melt() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2) map[i][j] = 0;
			}
		}
	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		
		queue.add(new Point(0, 0)); // (0, 0)은 무조건 공기
		visit[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point air = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nexti = air.i + di[d];
				int nextj = air.j + dj[d];
				
				if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) continue;
				if(map[nexti][nextj] == 0 && !visit[nexti][nextj]) { // 이웃 공기 탐색
					queue.add(new Point(nexti, nextj)); // 큐에는 공기만 넣음
					visit[nexti][nextj] = true;
				} else if(map[nexti][nextj] == 1) { // 공기 옆 치즈 체크
					map[nexti][nextj] = 2;
				}
			}
		}
	}

	private static int count() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}

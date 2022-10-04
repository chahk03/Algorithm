package day1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 { // 연구소
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static Queue<Virus> vq;
	static int total, vSum, res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		map = new int[N][M];
		vq = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) vq.add(new Virus(i, j));
				if(map[i][j] == 0) total++;
			}
		}
		
		wall(0);
		System.out.println(res);
	}
	
	// 벽 세울 곳 정하기
	static void wall(int cnt) {
		if(cnt == 3) {
			virus(map, vq);
			res = Math.max(res, total - vSum - 3);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					wall(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	// 바이러스 퍼트리기
	static void virus(int[][] arr, Queue<Virus> vq) {
		vSum = 0;
		visit = new boolean[N][M];
		Queue<Virus> q = new ArrayDeque<>(vq);
				
		while(!q.isEmpty()) {
			Virus v = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = v.x + dx[d];
				int ny = v.y + dy[d];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(arr[nx][ny] == 0 && !visit[nx][ny]) {
						q.add(new Virus(nx, ny));
						visit[nx][ny] = true;
						vSum++;
					}
				}
			}
		}
	}
	
	static class Virus {
		int x, y;
		
		Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

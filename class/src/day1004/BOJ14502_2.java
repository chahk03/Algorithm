package day1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502_2 { // 연구소
	static int N, M;
	static int[][] map;
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
			int[][] arr = copy(map);
			
			virus(map, vq);
			res = Math.max(res, total - vSum - 3);
			map = arr;
			
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
		Queue<Virus> q = new ArrayDeque<>(vq);
				
		while(!q.isEmpty()) {
			Virus v = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = v.x + dx[d];
				int ny = v.y + dy[d];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(arr[nx][ny] == 0) {
						q.add(new Virus(nx, ny));
						arr[nx][ny] = 2;
						vSum++;
					}
				}
			}
		}
	}
	
	static int[][] copy(int[][] arr) {
		int[][] copy = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		
		return copy;
	}
	
	static class Virus {
		int x, y;
		
		Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

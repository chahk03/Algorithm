package day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 { // 토마토
	static int M, N;
	static int[][] box;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 상자 열
		N = Integer.parseInt(st.nextToken()); // 상자 행
		box = new int[N][M]; // 상자 배열
		
		Queue<Tomato> tomatoed = new ArrayDeque<>(); // 익은 토마토 리스트
		int tomatoing = 0; // 익지 않은 토마토 개수
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				box[n][m] = Integer.parseInt(st.nextToken()); // 1: 익은 토마토, 0: 익지 않은 토마토, -1: 빈 칸
				if(box[n][m] == 1) tomatoed.add(new Tomato(n, m));
				if(box[n][m] == 0) tomatoing += 1;
			}
		}
		
		System.out.println(bfs(tomatoed, tomatoing));
	}
	
	// 토마토 익히기
	static int bfs(Queue<Tomato> tomatoed, int tomatoing) {
		int x = 0, y = 0;
		
		while(!tomatoed.isEmpty()) {
			Tomato tmt = tomatoed.poll();
			x = tmt.x;
			y = tmt.y;
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(box[nx][ny] == 0) {
						tomatoed.add(new Tomato(nx, ny));
						box[nx][ny] = box[x][y] + 1;
						tomatoing -= 1;
					}
				}
			}
		}
		
		if(tomatoing == 0) {
			return box[x][y] - 1;
		}
		
		return -1;
	}
	
	static class Tomato {
		int x, y;
		
		Tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

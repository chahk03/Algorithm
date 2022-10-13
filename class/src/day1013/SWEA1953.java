package day1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1953 { // 탈주범 검거
	static int N, M, R, C, L;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] ok = {{1, 2, 5, 6}, {1, 3, 6, 7}, {1, 2, 4, 7}, {1, 3, 4, 5}};
	static int[][] go = {{}, {0, 1, 2, 3}, {0, 2}, {1, 3}, {0, 1}, {1, 2}, {2, 3}, {0, 3}};
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 지도 세로
			M = Integer.parseInt(st.nextToken()); // 지도 가로
			R = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 세로 위치
			C = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 가로 위치
			L = Integer.parseInt(st.nextToken()); // 탈출 후 소요 시간
			
			map = new int[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input
			
			result = 1;
			if(L != 1) bfs();
			System.out.println("#" + t + " " + result);
		}
	}
	
	static void bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][M];
		
		queue.add(new Node(R, C, map[R][C]));
		visit[R][C] = true;
		
		int time = 2;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int s = 0; s < size; s++) {
				Node node = queue.poll();
				int num = node.p;
				
				for(int d = 0; d < go[num].length; d++) {
					int nx = node.x + dx[go[num][d]];
					int ny = node.y + dy[go[num][d]];
					
					if(0 > nx || nx >= N || 0 > ny || ny >= M) continue;
					if(map[nx][ny] == 0) continue;
					if(visit[nx][ny]) continue;
					
					boolean flag = false;
					for(int i = 0; i < ok[go[num][d]].length; i++) {
						if(map[nx][ny] == ok[go[num][d]][i]) flag = true;
					}
					
					if(!flag) continue;
					
					queue.add(new Node(nx, ny, map[nx][ny]));
					visit[nx][ny] = true;
					result++;
				}
			}
			
			if(time == L) return;
			time++;
		}
	}
	
	static class Node {
		int x, y, p;
		
		Node(int x, int y, int p) {
			this.x = x;
			this.y = y;
			this.p = p;
		}
	}
}

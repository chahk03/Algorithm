package day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4485_PQ { // 녹색 옷 입은 애가 젤다지?
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			tc++;
			
			int[][] cave = new int[N][N];
			int[][] dist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0, cave[0][0]));
			dist[0][0] = cave[0][0];
			
			while(!pq.isEmpty()) {
				Node n = pq.poll();
					
				for(int d = 0; d < 4; d++) {
					int nx = n.x + dx[d];
					int ny = n.y + dy[d];
						
					if(0 <= nx && nx < N && 0 <= ny && ny < N) {
						if(dist[nx][ny] > dist[n.x][n.y] + cave[nx][ny]) {
							dist[nx][ny] = dist[n.x][n.y] + cave[nx][ny];
							pq.add(new Node(nx, ny, dist[nx][ny]));
						}
					}
				}
			}
			
			System.out.println("Problem " + tc + ": " + dist[N - 1][N - 1]);
		}
	}
	
	static class Node implements Comparable<Node> {
		int x, y, w;
		
		Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
}

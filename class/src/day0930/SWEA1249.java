package day0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SWEA1249 { // 보급로
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); // 지도 크기
			int[][] map = new int[N][N];
			int[][] sum = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
					sum[i][j] = Integer.MAX_VALUE;
				}
			} // end input
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0, 0));
			sum[0][0] = 0;
			
			while(!pq.isEmpty()) {
				Node n = pq.poll();
				
				for(int d = 0; d < 4; d++) {
					int nx = n.x + dx[d];
					int ny = n.y + dy[d];
					
					if(0 <= nx && nx < N && 0 <= ny && ny < N) {
						if(sum[nx][ny] > sum[n.x][n.y] + map[nx][ny]) {
							sum[nx][ny] = sum[n.x][n.y] + map[nx][ny];
							pq.add(new Node(nx, ny, sum[nx][ny]));
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + sum[N - 1][N - 1]);
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

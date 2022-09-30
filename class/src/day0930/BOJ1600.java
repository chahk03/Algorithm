package day0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600 { // 말이 되고픈 원숭이
	static int K, W, H;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[] jx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] jy = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int ans = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 가로
		H = Integer.parseInt(st.nextToken()); // 세로
		map = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][][] visit = new boolean[H][W][K + 1];
		
		q.add(new int[] {0, 0, 0});
		visit[0][0][0] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			System.out.println(".......");
			for(int s = 0; s < size; s++) {
				int[] n = q.poll();
				System.out.println(n[0] + " " + n[1]);
				
				if(n[0] == H - 1 && n[1] == W - 1) {
					ans = cnt;
					return;
				}
				
				for(int d = 0; d < 4; d++) {
					int nx = n[0] + dx[d];
					int ny = n[1] + dy[d];
					
					if(0 <= nx && nx < H && 0 <= ny && ny < W) {
						if(!visit[nx][ny][n[2]] && map[nx][ny] != 1) {
							q.add(new int[] {nx, ny, n[2]});
							visit[nx][ny][n[2]] = true;
						}
					}
				}
				
				for(int d = 0; d < 8; d++) {
					int nx = n[0] + jx[d];
					int ny = n[1] + jy[d];
					
					if(0 <= nx && nx < H && 0 <= ny && ny < W) {
						if(n[2] < K && !visit[nx][ny][n[2] + 1] && map[nx][ny] != 1) {
							q.add(new int[] {nx, ny, n[2] + 1});
							visit[nx][ny][n[2] + 1] = true;
						}
					}
				}	
			}
			
			cnt++;
		}
	}
}

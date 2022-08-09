package day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16926 { // 배열 돌리기1
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 배열 크기 N x M
		int M = Integer.parseInt(st.nextToken()); 
		int R = Integer.parseInt(st.nextToken()); // 회전 수
		
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int min = Math.min(N, M);
		for(int i = 0; i < min / 2; i++) { // 바퀴 수만큼 반복
			List<Integer> list = new ArrayList<>();
			
			int x = i, y = i;
			for(int d = 0; d < 4; d++) {
				while(true) {
					if(x + dx[d] < i || x + dx[d] >= N - i || y + dy[d] < i || y + dy[d] >= M - i) {
						break;
					}
					
					x += dx[d]; y += dy[d];
					list.add(map[x][y]);
				}
			}
			
			int idx = R % list.size();
			list.addAll(list.subList(0, idx));
			
			x = i; y = i;
			for(int d = 0; d < 4; d++) {
				while(true) {
					if(x + dx[d] < i || x + dx[d] >= N - i || y + dy[d] < i || y + dy[d] >= M - i) {
						break;
					}
					
					x += dx[d]; y += dy[d];
					map[x][y] = list.get(idx++);
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}

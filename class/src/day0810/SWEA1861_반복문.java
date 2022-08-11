package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1861_반복문 { // 정사각형 방
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0, min = 1001;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int result = 1;
					int x = i, y = j;
					
					while(true) {
						int origin = result;
						
						for(int d = 0; d < 4; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];
							
							if(0 <= nx && nx < N && 0 <= ny && ny < N) {
								if(map[nx][ny] == map[x][y] + 1) {
									x = nx; y = ny;
									result += 1;
								}
							}
						}
						
						if(result == origin) break;
					}
					
					if(result > max) {
						min = map[i][j];
						max = result;
					} else if(result == max) {
						if(map[i][j] < min) {
							min = map[i][j];
							max = result;
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + min + " " + max);
		}
	}
}

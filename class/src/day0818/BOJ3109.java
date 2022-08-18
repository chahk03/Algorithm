package day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109 { // 빵집
	static int R, C;
	static char[][] map;
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};
	static boolean connect;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 지도 행 크기
		C = Integer.parseInt(st.nextToken()); // 지도 열 크기
		
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < R; i++) {
			connect = false;
			pipe(i, 0);
			if(connect) result += 1;
		}
		
		System.out.println(result);
	}
	
	// 첫열에서 하나씩 출발해서 끝열에 도착한다면 true
	// true면 map 상태 그대로 두기
	// false면 map 원래 상태로 돌리기
	
	static void pipe(int x, int y) {
		if(y == C - 1) {
			connect = true;
			return;
		}
		
		for(int d = 0; d < 3; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(0 <= nx && nx < R && 0 <= ny && ny < C) {
				if(map[nx][ny] == '.' && connect == false) {
					map[nx][ny] = 'x';
					pipe(nx, ny);
				}
			}
		}
	}
	
	static char[][] copy(char[][] map) {
		char[][] copy = new char[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		return copy;
	} 
}

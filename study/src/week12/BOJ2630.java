package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 { // 색종이 만들기
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int range;
	static boolean rect;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		range = N / 2;
		int blue = 0, white = 0;
		while(range > 0) {
			for (int i = 0; i < N; i += range) {
				for (int j = 0; j < N; j += range) {
					if(visit[i][j] == false) {
						rect = true;
						check(i, j, map[i][j], 1);
							
						if(rect) {
							if(map[i][j] == 1) {
								System.out.println(i + " " + j + "파랑");
								blue += 1;
							} else {
								System.out.println(i + " " + j + "하양");
								white += 1;
							}
						}
					}
				}
			}
			
			range /= 2;
		}
		
		System.out.println(white + " " + blue);
	}
	
	static void check(int x, int y, int color, int length) {
		if(map[x][y] != color) {
			rect = false;
			System.out.println("색 달라");
			visit[x][y] = false;
			return;
		}
		
		if(length == range) {
			System.out.println("길이 끝");
			return;
		}
		
		// 오른쪽
		System.out.println("오른쪽 검사");
		check(x, y + 1, color, length + 1);
		
		// 아래
		System.out.println("아래 검사");
		check(x + 1, y, color, length + 1);
		
		// 대각선
		System.out.println("대각선 검사");
		check(x + 1, y + 1, color, length + 1);
		
		if(rect) {
			visit[x][y] = true;
			System.out.println("트루 " + x  + " " + y);
		}
	}
}

package day0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1210 {
	
	static int[][] map;
	static boolean[][] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine()); // 테케 번호
			map = new int[100][100];
			
			int end = 0; // 2인 도착 지점
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(map[i][j] == 2) {
						end = j;
					}
				}
			}
			
			System.out.println("#" + T + " " + up(end));
		}
	}
	
	static int up(int x) {
		int floor = 99; // 층
		visit = new boolean[100][100]; // 방문 배열
		
		while(true) {
			visit[floor][x] = true;
			
			if(floor == 0) {
				return x;
			}
			
			if(0 <= x - 1 && map[floor][x - 1] == 1 && visit[floor][x - 1] == false) {
				x = x - 1;
			} else if(x + 1 < 100 && map[floor][x + 1] == 1 && visit[floor][x + 1] == false) {
				x = x + 1;
			} else {
				floor -= 1;
			}
		}
	}
	
}

package day0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1873 {
	
	static int[] dx = {-1, 1, 0, 0}; // Up, Down, Left, Right
	static int[] dy = {0, 0, -1, 1};
	static char[] dc = {'^', 'v', '<', '>'};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); // 높이
			int W = Integer.parseInt(st.nextToken()); // 너비
			
			char[][] map = new char[H][W];
			int x = 0, y = 0; // 현재 전차 위치
			int dir = 0; // 전차 방향
			
			for(int i = 0; i < H; i++) {
				String str = br.readLine();
				for(int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					
					if(map[i][j] == '^') {
						x = i; y = j; dir = 0;
					} else if(map[i][j] == 'v') {
						x = i; y = j; dir = 1;
					} else if(map[i][j] == '<') {
						x = i; y = j; dir = 2;
					} else if(map[i][j] == '>') {
						x = i; y = j; dir = 3;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine()); // 입력 개수
			String str = br.readLine(); // 입력 문자열
			
			for(int i = 0; i < N; i++) {
				char input = str.charAt(i);
				
				// UDLR인 경우: 방향 조정
				if(input == 'U') dir = 0;
				if(input == 'D') dir = 1;
				if(input == 'L') dir = 2;
				if(input == 'R') dir = 3;
				
				if(input != 'S') {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					
					// 갈 수 있는 위치인지 체크: 맵 안이고 평지인 경우
					if(0 <= nx && nx < H && 0 <= ny && ny < W && map[nx][ny] == '.') {
						// 전차가 지나간 위치는 다시 평지로 변경
						map[x][y] = '.';
						x = nx;
						y = ny;
					}
					
					map[x][y] = dc[dir];					
				}
				
				// S인 경우: 전차가 바라보는 쪽으로 포탄 발사
				if(input == 'S') {
					int sx = x, sy = y;
					
					while(true) {
						int nsx = sx + dx[dir];
						int nsy = sy + dy[dir];
						
						// 맵 안인 경우
						if(0 <= nsx && nsx < H && 0 <= nsy && nsy < W) {
							if(map[nsx][nsy] == '.' || map[nsx][nsy] == '-') { // 평지, 물
								sx = nsx;
								sy = nsy;
							} else if(map[nsx][nsy] == '*') {
								// 벽돌 벽이면 벽돌 벽을 평지로 만들기
								map[nsx][nsy] = '.';
								break;
							} else if(map[nsx][nsy] == '#') {
								// 강철 벽이면 포탄 날리기 종료
								break;
							}
						} else {
							// 맵 밖으로 나가도 종료
							break;
						}
					}
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	
}

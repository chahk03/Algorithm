package day1007;

import java.util.Scanner;

public class BOJ17143 {
	static int R, C, M;
	static Shark[][] start, end;
	static int[] di = {0, -1, 1, 0, 0}; // 1: up, 2: down, 3: right, 4: left
	static int[] dj = {0, 0, 0, 1, -1};
	static int fisher, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt(); // 세로
		C = sc.nextInt(); // 가로
		M = sc.nextInt(); // 상어 수

		start = new Shark[R + 1][C + 1];
		end = new Shark[R + 1][C + 1];
		
		for(int m = 0; m < M; m++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int speed = sc.nextInt();
			int dir = sc.nextInt();
			int size = sc.nextInt();
			
			start[i][j] = new Shark(speed, dir, size);
		}
		
		fisher = 0;
		while(true) {
			fisher++;
			if(fisher > C) break;
			
			fishing(); // 가까운 상어 낚시
			move(); // 모든 상어 이동
		}
	
		System.out.println(ans);
	}
	
	private static void move() {
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				if(start[i][j] != null) {
					Shark now = start[i][j];
					
					int nexti = i + di[now.dir] * now.speed; // 한번에 직진
					int nextj = j + dj[now.dir] * now.speed;
					
					while(nexti > R || nexti < 1) { // 위아래로 벗어났다면 반복
						now.dir = reverse(now.dir);
						if(nexti > R) { // 벗어난 부분이 음수로 계산되서 돌아오게
							nexti = R + (R - nexti); // nexti가 R보다 커서 R-nexti는 음수
						} else if(nexti < 1) {
							nexti = 1 + (1 - nexti); // nexti가 음수라서 1-nexti는 양수
						}
					}
					
					while(nextj > C || nextj < 1) { // 좌우로 벗어났다면 반복
						now.dir = reverse(now.dir);
						if(nextj > C) {
							nextj = C + (C - nextj);
						} else if(nextj < 1) {
							nextj = 1 + (1 - nextj);
						}
					}
					
					start[i][j] = null; // 이동 전 좌표에서 떠남
					if(end[nexti][nextj] == null || end[nexti][nextj].size < now.size) {
						end[nexti][nextj] = now;
					}
				}
			} // end for j
		} // end for i -> all shark
		
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				start[i][j] = end[i][j];
				end[i][j] = null;
			}
		}
	}

	private static void fishing() {
		for(int i = 1; i <= R; i++) {
			if(start[i][fisher] != null) {
				ans += start[i][fisher].size;
				start[i][fisher] = null;
				break;
			}
		}
	}
	
	static int reverse(int dir) {
        switch(dir) {
        case 1: return 2;
        case 2: return 1;
        case 3: return 4;
        case 4: return 3;
        }
        
        return -1;
    }

	static class Shark {
		int speed, dir, size;

		public Shark(int speed, int dir, int size) {
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}
}

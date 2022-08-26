package day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15662 { // 톱니바퀴2
	static int T;
	static char[][] wheel;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 톱니바퀴 개수
		wheel = new char[T + 1][8];
		
		for(int t = 1; t <= T; t++) {
			wheel[t] = br.readLine().toCharArray(); // N극: 0, S극: 1
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 회전시킬 톱니바퀴 번호
			int dir = Integer.parseInt(st.nextToken()); // 회전 방향 (시계: 1, 반시계: -1)
			
			rotateL(num, dir);
			rotateR(num, dir);
			rotate(num, dir);
		}
		
		int result = 0;
		for(int i = 1; i <= T; i++) {
			if(wheel[i][0] == '1') {
				result += 1;
			}
		}
		
		System.out.println(result);
	}
	
	static void rotate(int num, int dir) {
		if(dir == 1) {
			char temp = wheel[num][7];
			for(int i = 7; i > 0; i--) {
				wheel[num][i] = wheel[num][i - 1];
			}
			wheel[num][0] = temp;
		} else if(dir == -1) {
			char temp = wheel[num][0];
			for(int i = 0; i < 7; i++) {
				wheel[num][i] = wheel[num][i + 1];
			}
			wheel[num][7] = temp;
		}
	}
	
	static void rotateL(int num, int dir) {
		if(num == 1) return;

		if(wheel[num][6] != wheel[num - 1][2]) {
			rotateL(num - 1, -dir);
			rotate(num - 1, -dir);
		}		
	}
	
	static void rotateR(int num, int dir) {
		if(num == T) return;
		
		if(wheel[num][2] != wheel[num + 1][6]) {
			rotateR(num + 1, -dir);
			rotate(num + 1, -dir);
		}
	}
}

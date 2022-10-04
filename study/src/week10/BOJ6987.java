package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6987 { // 월드컵
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int c = 0; c < 4; c++) {
			int[][] score = new int[6][3];
			StringTokenizer st = new StringTokenizer(br.readLine());

			int wCnt = 0, lCnt = 0;
			for(int k = 0; k < 6; k++) {
				for(int s = 0; s < 3; s++) {
					score[k][s] = Integer.parseInt(st.nextToken());
					if(s == 0) wCnt += score[k][s];
					if(s == 2) lCnt += score[k][s];
				}
			}
			
			boolean possible = true;
			
			// 팀당 경기수 확인
			for(int i = 0; i < 6; i++) {
				int sum = 0;
				for(int j = 0; j < 3; j++) {
					sum += score[i][j];
				}
				
				if(sum != 5) {
					possible = false;
					break;
				}
			}
			
			// 승 == 합 확인
			if(wCnt != lCnt) {
				possible = false;
			}
			
			// 무승부 확인
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 6; j++) {
					if(i != j && score[i][1] != 0) {
						if(score[j][1] != 0) {
							score[i][1] -= 1;
							score[j][1] -= 1;
						}
					}
				}
			}
			
			for(int i = 0; i < 6; i++) {
				if(score[i][1] != 0) {
					possible = false;
					break;
				}
			}
			
			if(possible) sb.append(1 + " ");
			else sb.append(0 + " ");
		}
		
		System.out.println(sb);
	}
}

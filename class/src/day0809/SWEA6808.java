package day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA6808 { // 규영이와 인영이의 카드게임
	static int[] ky, iy;
	static boolean[] visit;
	static int kyWin, iyWin;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int[] card = new int[19];
			ky = new int[9];
			iy = new int[9];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++) {
				int cardNum = Integer.parseInt(st.nextToken());
				ky[i] = cardNum;
				card[cardNum] = 1;
			}
			
			for(int i = 1, idx = 0; i < 19; i++) {
				if(card[i] == 0) {
					iy[idx++] = i;
				}
			}
			
			kyWin = 0; iyWin = 0;
			visit = new boolean[9];
			select(0, 0, 0);
			System.out.println("#" + t + " " + kyWin + " " + iyWin);
		}
	}
	
	static void select(int cnt, int kyScore, int iyScore) {
		if(cnt == 9) {
			if(kyScore > iyScore) {
				kyWin += 1;
			} else if(kyScore < iyScore) {
				iyWin += 1;
			}
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				if(ky[cnt] > iy[i]) {
					select(cnt + 1, kyScore + ky[cnt] + iy[i], iyScore);
				} else {
					select(cnt + 1, kyScore, iyScore + ky[cnt] + iy[i]);
				}
				visit[i] = false;
			}
		}
	}
}

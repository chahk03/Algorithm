package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15997 { // 승부 예측
	static int[][][] score;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		score = new int[4][4][3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] team = new String[4];
		
		for(int i = 0; i < 4; i++) {
			team[i] = st.nextToken();
		}
		
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
		}
	}
	
	static void play() {
		
	}
}

package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10162 { // 전자레인지
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 요리시간
		
		int cnt300 = T / 300;
		int cnt60 = (T % 300) / 60;
		int cnt10 = ((T % 300) % 60) / 10;
		
		while(true) {
			if(cnt300 * 300 + cnt60 * 60 + cnt10 * 10 == T) break;
			
		}
	}
}

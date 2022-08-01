package day0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2810 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 좌석 수
		int total = 1;
		
		String str = br.readLine();
		for(int i = 0; i < N; i++) {
			char seat = str.charAt(i);
			
			if(seat == 'S') {
				total += 1;
			} else if(seat == 'L') {
				i += 1;
				total += 1;
			}
		}
		
		if(N < total) System.out.println(N);
		else System.out.println(total);
	}
}

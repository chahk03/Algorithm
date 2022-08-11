package day0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3040 { // 백설 공주와 일곱 난쟁이
	static int[] arr9;
	static int[] arr7;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		arr9 = new int[9]; // 아홉 난쟁이
		arr7 = new int[7]; // 일곱 난쟁이
		
		for(int i = 0; i < 9; i++) {
			arr9[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0, 0, 0);
		System.out.println(sb);
	}
	
	static void comb(int cnt, int sum, int start) {
		if(cnt == 7) {
			if(sum == 100) {
				for(int i = 0; i < 7; i++) {
					sb.append(arr7[i]).append('\n');
				}
			}
			return;
		}
		
		for(int i = start; i < 9; i++) {
			if(sum + arr9[i] <= 100) {
				arr7[cnt] = arr9[i];
				comb(cnt + 1, sum + arr9[i], i + 1);
			} else {
				comb(cnt, sum, i + 1);
			}
		}
	}
}

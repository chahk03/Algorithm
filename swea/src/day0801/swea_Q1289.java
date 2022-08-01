package day0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_Q1289 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			String input = br.readLine();
			int result = 0;
			char bit = '0';
			
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) != bit) {
					bit = input.charAt(i);
					result += 1;
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}

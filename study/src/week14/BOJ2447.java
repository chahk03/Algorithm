package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2447 { // 별 찍기-10
	static String star = "*";
	static String result = "";
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		star(3, star);
		for(int i = 0; i < N; i++) {
			
		}
		System.out.println(result);
	}
	
	static void star(int n, String star) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i % 3 == 1 && j % 3 == 1) {
					result += " ";
				} else {
					result += star;
				}
			}
			
//			if(result.length() == n * (i + 1) + i) {
//				result += "\n";
//			}
			
			
		}
		
		if(n == N) {
			return;
		}
		
		star(n * 3, result);
	}
}

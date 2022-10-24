package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2607 { // 비슷한 단어
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 단어 개수
		
		int[] alpha = new int[26];
		
		String word = br.readLine();
		for(int i = 0; i < word.length(); i++) {
			char chr = word.charAt(i);
			alpha[chr - 65] += 1;
		}	
		
		int result = 0;
		for(int i = 1; i < n; i++) {
			int change = 0;
			boolean flag = true;
			int[] alpha_copy = alpha.clone();
			word = br.readLine();
			
			for(int j = 0; j < word.length(); j++) {
				char chr = word.charAt(j);
				if(alpha_copy[chr - 65] == 0) {
					if(change == 0) {
						change += 1;						
					} else {
						flag = false;
						break;
					}
				} else {
					alpha_copy[chr - 65] -= 1;
				}
			}
			
			if(flag) result++;
		}
		
		System.out.println(result);
	}

}

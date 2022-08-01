package day0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8320 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= Math.sqrt(i); j++) {
				if(i % j == 0) result += 1;
			}
		}
		
		System.out.println(result);
	}
}

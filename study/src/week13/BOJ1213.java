package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1213 { // 팰린드롬 만들기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] arr = new char[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		
		Arrays.sort(arr);
		
		
		for(int i = 0; i < str.length(); i++) {
			
			
			
		}
	}
}

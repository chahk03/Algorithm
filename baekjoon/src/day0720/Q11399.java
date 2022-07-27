package day0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11399 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] money = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		Arrays.sort(money);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i + 1; j++) {
				result += money[j];
			}
		}
		
		System.out.println(result);
	}
	
}

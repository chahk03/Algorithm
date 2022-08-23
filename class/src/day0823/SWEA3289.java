package day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA3289 { // 서로소 집합
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			int N = Integer.parseInt(st.nextToken()); // n개의 집합, 1~n
			int M = Integer.parseInt(st.nextToken()); // 연산 개수
			
			
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken()); // 0: 합집합, 1: 포함 확인
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				
			}
			
			System.out.println(sb);
		}
	}
}

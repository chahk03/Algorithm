package day0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1592 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 자리 수
		int M = Integer.parseInt(st.nextToken()); // 게임 끝
		int L = Integer.parseInt(st.nextToken()); // 공 던짐
		
		int[] arr = new int[N];
		int idx = 0, result = 0;
		arr[idx] = 1;
		
		while(true) {
			if(arr[idx] == M) break;
			
			if(arr[idx] % 2 == 1) {
				idx = (idx + L) % N;
			} else {
				idx = (idx + N - L) % N;
			}
			
			arr[idx] += 1;
			result += 1;
		}
		
		System.out.println(result);
	}
}

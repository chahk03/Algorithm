package day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 { // 로또
	static int K;
	static int[] arr, numArr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			
			K = Integer.parseInt(st.nextToken());
			if(K == 0) break;
			
			arr = new int[K];
			numArr = new int[6];
			for(int i = 0; i < K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			select(0, 0);
			System.out.println(sb);
		}
	}
	
	static void select(int cnt, int start) {
		if(cnt == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(arr[numArr[i]]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = start; i < K; i++) {
			numArr[cnt] = i;
			select(cnt + 1, i + 1);
		}
	}
}

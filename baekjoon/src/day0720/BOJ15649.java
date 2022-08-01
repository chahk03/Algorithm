// 11399번 풀기 위해 조합 문제 다시 품
package day0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
	
	static int N, M;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visit = new boolean[N];
		dfs(0);
		
		System.out.println(sb);
	}
	
	static void dfs(int idx) {
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visit[i] == false) {
				arr[idx] = i + 1;
				visit[i] = true;
				dfs(idx + 1);
				visit[i] = false;
			}
		}
	}
}

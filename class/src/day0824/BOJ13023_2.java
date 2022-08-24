package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13023_2 { // ABCDE 안풀리는 방식
	static int N, M;
	static ArrayList<Integer>[] list;
	static int[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			visit = new int[N];
			dfs(i);
			
			int sum = 0;
			for(int j = 0; j < N; j++) {
				sum += visit[j];
			}
			
			if(sum >= 5) {
				ans = 1;
				break;
			}
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int num) {
		visit[num] = 1;
		
		for(int val : list[num]) {
			if(visit[val] == 0) {
				dfs(val);
				return;
			}
		}
	}
}

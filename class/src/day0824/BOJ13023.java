package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13023 { // ABCDE
	static int N, M;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static boolean ABCDE;
	
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
			visit = new boolean[N];
			ABCDE = false;
			dfs(i, 1);
			
			if(ABCDE) {
				ans = 1;
				break;
			}
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int num, int cnt) {
		if(cnt == 5) {
			ABCDE = true;
			return;
		}
		
		visit[num] = true;
		
		for(int val : list[num]) {
			if(visit[val] == false) {
				dfs(val, cnt + 1);
				visit[val] = false;
			}
		}
	}
}

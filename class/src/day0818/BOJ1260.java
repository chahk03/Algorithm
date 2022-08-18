package day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 { // DFS와 BFS
	static int N, M, V;
	static LinkedList<Integer>[] list;
	static boolean[] visit_dfs, visit_bfs;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken()); // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		V = Integer.parseInt(st.nextToken()); // 시작 정점
		list = new LinkedList[N + 1];
		
		for(int n = 1; n <= N; n++) {
			list[n] = new LinkedList<Integer>();
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			list[v1].add(v2);
			list[v2].add(v1);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		
		visit_dfs = new boolean[N + 1];
		visit_bfs = new boolean[N + 1];
		
		dfs(V, 1);
		sb.append('\n');
		bfs(V);
		sb.append('\n');		
		
		System.out.println(sb);
	}
	
	static void dfs(int v, int n) {
		visit_dfs[v] = true;
		sb.append(v).append(' ');
		
		if(n == N) {
			return;
		}
		
		for(int i : list[v]) {
			if(visit_dfs[i] == false) {
				dfs(i, n + 1);
			}
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> que = new ArrayDeque<>();
		que.add(v);
		visit_bfs[v] = true;
		
		while(!que.isEmpty()) {
			int nv = que.poll();
			sb.append(nv).append(' ');
			
			for(int i : list[nv]) {
				if(visit_bfs[i] == false) {
					que.add(i);
					visit_bfs[i] = true;
				}
			}
		}
	}
}

package day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1238 { // Contact
	static int size;
	static int start;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer>[] last;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			size = Integer.parseInt(st.nextToken()); // 입력 데이터 길이
			start = Integer.parseInt(st.nextToken()); // 시작점
			list = new ArrayList[101];
			last = new ArrayList[101];
			visit = new boolean[101];
			
			for(int i = 1; i < 101; i++) {
				list[i] = new ArrayList<>();
				last[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if(!list[from].contains(to)) list[from].add(to);
			}
			
			int result = 0;
			for(int val : last[bfs()]) {
				result = Math.max(result, val);
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	static int bfs() {
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] {start, 0});
		int cnt = 0;
		
		while(!que.isEmpty()) {
			int node[] = que.poll();
			int num = node[0];
			cnt = node[1];
			
			for(int next : list[num]) {
				if(visit[next] == false) {
					que.add(new int[] {next, cnt + 1});
					last[cnt + 1].add(next);
					visit[next] = true;
				}
			}
		}
		
		return cnt;
	}
}

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
	static boolean[] visit;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			size = Integer.parseInt(st.nextToken()); // 입력 데이터 길이
			start = Integer.parseInt(st.nextToken()); // 시작점
			list = new ArrayList[101];
			visit = new boolean[101];
			
			for(int i = 1; i < 101; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if(!list[from].contains(to)) list[from].add(to);
			}
			
			bfs();
			System.out.println("#" + t + " " + result);
		}
	}
	
	static void bfs() {
		Queue<Integer> que = new ArrayDeque<>();
		que.add(start);
		visit[start] = true;
		
		while(!que.isEmpty()) {
			int size = que.size();
			result = 0;
			
			for(int i = 0; i < size; i++) {
				int num = que.poll();
				result = Math.max(result, num);
				
				for(int next : list[num]) {
					if(visit[next] == false) {
						que.add(next);
						visit[next] = true;
					}
				}
			}
		}
	}
}

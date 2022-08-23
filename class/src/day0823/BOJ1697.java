package day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 { // 숨바꼭질
	static int N, K;
	static boolean[] visit;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visit = new boolean[100001];
		
		bfs();
		System.out.println(result);
	}
	
	static void bfs() {
		Queue<Integer> que = new ArrayDeque<>();
		que.add(N);
		visit[N] = true;
		
		int time = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			
			for(int i = 0; i < size; i++) {
				int n = que.poll();
				
				if(n == K) {
					result = time;
					return;
				}
				
				if(n - 1 >= 0 && visit[n - 1] == false) {
					que.add(n - 1);
					visit[n - 1] = true;
				}
				
				if(n + 1 < 100001 && visit[n + 1] == false) {
					que.add(n + 1);
					visit[n + 1] = true;
				}
				
				if(n * 2 < 100001 && visit[n * 2] == false) {
					que.add(n * 2);
					visit[n * 2] = true;
				}
			}
			
			time++;
		}
	}
}

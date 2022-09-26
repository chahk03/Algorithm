package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2660 { // 회장뽑기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1) break;
			
			list[a].add(b);
			list[b].add(a);
		}
		
		int[][] dist = new int[N + 1][N + 1];
		for(int i = 1; i < N + 1; i++) {
			Queue<Integer> q = new ArrayDeque<>();
			q.add(i);
			int d = 1;
			
			while(!q.isEmpty()) {
				int size = q.size();
				for(int s = 0; s < size; s++) {
					int num = q.poll();
					
					for(int next : list[num]) {
						if(dist[next][i] == 0) {
							dist[i][next] = d;
							dist[next][i] = d;
							q.add(next);
						}
					}					
				}
				
				d++;
			}
		}
		
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}
}

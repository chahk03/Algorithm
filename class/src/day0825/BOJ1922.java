package day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1922 { // 네트워크 연결
	static int N, M;
	static ArrayList<Com>[] list;
	static boolean[] visit;
	static int start, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 컴퓨터 수
		M = Integer.parseInt(br.readLine()); // 선의 수
		
		list = new ArrayList[N + 1]; // 연결 비용 정보
		visit = new boolean[N + 1]; // 연결 여부 체크
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int m = 0; m < M; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 컴퓨터 a
			int b = Integer.parseInt(st.nextToken()); // 컴퓨터 b
			int c = Integer.parseInt(st.nextToken()); // 연결 비용
			
			list[a].add(new Com(b, c));
			list[b].add(new Com(a, c));
			start = a;
		}
		
		ans = 0; // 최소 연결 비용
		connect();
		System.out.println(ans);
	}
	
	static void connect() {
		PriorityQueue<Com> pq = new PriorityQueue<>();
		pq.add(new Com(start, 0));
		int cnt = 0; // 연결된 컴퓨터 수

		while(!pq.isEmpty()) {
			Com cur = pq.poll();
			
			if(visit[cur.num]) continue;
			
			// 아직 연결 안된 컴퓨터인 경우
			visit[cur.num] = true;
			ans += cur.cost;
			cnt += 1;
			
			if(cnt == N) break;
			
			for(Com next : list[cur.num]) {
				if(!visit[next.num]) {
					pq.add(next);
				}
			}
		}
	}
	
	static class Com implements Comparable<Com> {
		int num, cost;
		
		Com(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(Com o) {
			return this.cost - o.cost;
		}
	}
}

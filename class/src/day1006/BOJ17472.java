package day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17472 { // 다리 만들기2
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static boolean[] iVisit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static ArrayList<Island>[] list;
	static int islandNum, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input
		
		// 섬 번호 표시하기
		islandNum = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					markingIsland(i, j, islandNum);
					islandNum++;
				}
			}
		}
		
		list = new ArrayList[islandNum];
		for(int i = 1; i < islandNum; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 가능한 모든 다리 놓기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					for(int d = 0; d < 4; d++) {
						makingBridge(i, j, d, map[i][j], -1);
					}
				}
			}
		}
		
		print();
		
		for(int i = 1; i < islandNum; i++) {
			System.out.println(i + "번 섬과 연결된 다리");
			for(int j = 0; j < list[i].size(); j++) {
				System.out.println(list[i].get(j));
			}
		}
		
		ans = 0;
		iVisit = new boolean[islandNum];
		prim();
		
		for(int i = 1; i < islandNum; i++) {
			if(!iVisit[i]) ans = -1;
		}
		
		System.out.println(ans);
	}
	
	// 최소 스패닝 트리
	static void prim() {
		PriorityQueue<Island> pq = new PriorityQueue<>();
		pq.add(new Island(1, 0));
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			Island cur = pq.poll();
			
			if(iVisit[cur.v]) continue;
			
			iVisit[cur.v] = true;
			ans += cur.w;
			cnt += 1;
			
			if(cnt == islandNum) break;
			
			for(Island next : list[cur.v]) {
				if(!iVisit[next.v]) {
					pq.add(next);
				}
			}
		}
	}
	
	// 다리 놓기
	static void makingBridge(int x, int y, int dir, int num, int length) {
		// 다른 섬에 도착
		if(map[x][y] != 0 && map[x][y] != num) {
			if(length >= 2) {
				list[num].add(new Island(map[x][y], length));
				list[map[x][y]].add(new Island(num, length));
			}
			
			return;
		}
		
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if(0 <= nx && nx < N && 0 <= ny && ny < M) {
			if(map[nx][ny] != num) {
				makingBridge(nx, ny, dir, num, length + 1);
			}
		}
	}
	
	// 섬 번호 표시하기
	static void markingIsland(int x, int y, int n) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x, y});
		visit[x][y] = true;
		map[x][y] = n;
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = node[0] + dx[d];
				int ny = node[1] + dy[d];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(map[nx][ny] == 1 && !visit[nx][ny]) {
						q.add(new int[] {nx, ny});
						visit[nx][ny] = true;
						map[nx][ny] = n;
					}
				}
			}
		}
	}

	static class Island implements Comparable<Island> {
		int v, w;
		
		Island(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Island o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Island [v=" + v + ", w=" + w + "]";
		}
	}
	
	static void print() {
		System.out.println("::::::::: 현재 맵 :::::::::");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}
}

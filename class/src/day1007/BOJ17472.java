package day1007;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ17472 { // 다리 만들기2
	static int R, C, ans;
	static int[][] map;
	static boolean[][] visit;
	
	static int[] di = {0, 0, 1, -1};
	static int[] dj = {1, -1, 0, 0};
	
	static int[] disjoint;
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new int[R][C];
		visit = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// step1: 섬 찾아서 번호 붙이기
		int landCnt = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					landCnt++; // 새로운 섬을 찾았다!
					bfs(i, j, landCnt);
				}
			}
		}
		

		// step2. 섬과 섬을 잇는 모든 간선 탐색해서 pq에 담기
		pq = new PriorityQueue<>();
		makeEdge();
		
		// step3: 간선들 중 가장 짧은 것부터 꺼내서 두 섬을 연결하는 작업 진행, 이미 연결된 섬은
		disjoint = new int[landCnt + 1]; // 섬이 5개면 5번 인덱스까지 사용 가능
		for(int i = 1; i <= landCnt; i++) { // disjoint 초기화
			disjoint[i] = i;
		}
		
		ArrayList<Edge> mst = new ArrayList<>();
		while(!pq.isEmpty() && mst.size() < landCnt - 1) { // mst는 landCnt-1개의 간선 필요
			Edge edge = pq.poll();
			if(union(edge.st, edge.end)) { // 간선 선택 완료, 두 섬 연결
				mst.add(edge);
				ans += edge.dist; // 지금 선택한 다리 길이 누적
			}
		}
		
		System.out.println((mst.size() == landCnt - 1) ? ans : -1);
	}
	
	static int find(int num) {
		if(disjoint[num] == num) return num;
		return disjoint[num] = find(disjoint[num]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa == pb) return false;
		
		disjoint[pa] = pb;
		return true;
	}
	
	static void makeEdge() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 0) { // 땅이면 사방으로 간선 생기는지 뻗어보기
					for(int d = 0; d < 4; d++) {
						int nexti = i;
						int nextj = j;
						int dist = 0; // 현재 뻗는 간선의 길이

						while(true) {
							nexti = i + di[d];
							nextj = j + dj[d];
							
							if(nexti >= 0 && nexti < R && nextj >= 0 && nextj < C
									&& map[nexti][nextj] == 0) {
								dist++;
								continue;
							}
							
							if(nexti >= 0 && nexti < R && nextj >= 0 && nextj < C
									&& map[i][j] != map[nexti][nextj] && dist > 1) {
								pq.add(new Edge(map[i][j], map[nexti][nextj], dist));
							}
							
							break;
						}
					}
				}
			}
		}
	}
	
	private static void bfs(int i, int j, int landCnt) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(i, j));
		visit[i][j] = true;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			map[now.i][now.j] = landCnt; // 현재 돌아다니고 있는 이 섬의 번호 기록
			
			for(int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				
				if(nexti < 0 || nexti >= R || nextj < 0 || nextj >= C) continue;
				if(map[nexti][nextj] == 1 && !visit[nexti][nextj]) {
					queue.add(new Point(nexti, nextj));
					visit[nexti][nextj] = true;
				}
			}
		}
		
	}

	static class Edge implements Comparable<Edge> {
		int st, end, dist;

		public Edge(int st, int end, int dist) {
			this.st = st;
			this.end = end;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
	}
	
	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}

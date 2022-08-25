package day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753_PQ { // 최단경로
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 정점 개수
		int E = Integer.parseInt(st.nextToken()); // 간선 개수
		int K = Integer.parseInt(br.readLine()); // 시작 정점
		ArrayList<Node>[] graph = new ArrayList[V + 1];
		
		for(int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, w));
		}
		
		int[] dist = new int[V + 1];
		boolean[] visit = new boolean[V + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(K, 0));
		dist[K] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			visit[n.num] = true;
			
			for(int i = 0; i < graph[n.num].size(); i++) {
				Node next = graph[n.num].get(i);
				if(!visit[next.num] && dist[next.num] > dist[n.num] + next.weight) {
					dist[next.num] = dist[n.num] + next.weight;
					pq.add(new Node(next.num, dist[next.num]));
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}
	
	static class Node implements Comparable<Node> {
		int num, weight;
		
		Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
}

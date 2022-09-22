import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class test {
	static int N;
	static ArrayList<Node>[] list;
	
	public static void main(String[] args) {
		N = 5;
		list = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		list[1].add(new Node(5, 1));
		list[5].add(new Node(1, 1));
		list[5].add(new Node(4, 1));
		list[4].add(new Node(5, 1));
		list[4].add(new Node(3, 1));
		list[3].add(new Node(4, 1));
		list[3].add(new Node(2, 1));
		list[2].add(new Node(3, 1));
		list[1].add(new Node(2, 3));
		list[2].add(new Node(1, 3));
		
		System.out.println(dij(1, 2));
	}
	
	static int dij(int start, int end) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visit = new boolean[N + 1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			//visit[n.v] = true;
			
			for(Node next : list[n.v]) {
				if(!visit[next.v] && dist[next.v] > dist[n.v] + next.v) {
					System.out.println(next.v + " 방문");
					dist[next.v] = dist[n.v] + next.w;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
		
		return dist[end];
	}
	
	static class Node implements Comparable<Node> {
		int v;
		int w;
		
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
}

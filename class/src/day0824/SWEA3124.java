package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA3124 { // 최소 스패닝 트리
	static int V, E;
	static ArrayList<Node>[] vList;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); // 정점 개수
			int E = Integer.parseInt(st.nextToken()); // 간선 개수
			
			vList = new ArrayList[100001];
			for(int i = 1; i <= 100000; i++) {
				vList[i] = new ArrayList<>();
			}
			
			for(int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken()); // 정점1
				int B = Integer.parseInt(st.nextToken()); // 정점2
				int C = Integer.parseInt(st.nextToken()); // 간선 가중치
				
				// 간선 연결
				vList[A].add(new Node(B, C));
				vList[B].add(new Node(A, C));
			}
			
			
		}
	}
	
	static void prim() {
		
	}
	
	static class Node implements Comparable<Node> {
		int no;
		int wg;
		
		Node(int no, int wg) {
			this.no = no;
			this.wg = wg;
		}

		@Override
		public int compareTo(Node o) {
			//if()
			return 0;
		}
		
	}
}

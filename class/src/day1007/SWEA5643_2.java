package day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA5643_2 { // 키 순서
	static int N, M;
	static ArrayList<Integer>[] uplist;
	static ArrayList<Integer>[] downlist;
	static boolean[] visit;
	static int up, down;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			uplist = new ArrayList[N + 1];
			downlist = new ArrayList[N + 1];
			int res = 0;
			
			for(int i = 1; i <= N; i++) {
				uplist[i] = new ArrayList<>();
				downlist[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				uplist[a].add(b); // a번 학생 키가 b번 학생 키보다 작음, a < b, a -> b
				downlist[b].add(a); // b번 학생 키가 a번 학생 키보다 큼, a < b, a -> b
			}
			
			for(int i = 1; i <= N; i++) {
				up = 0; down = 0;
				visit = new boolean[N + 1];
				findUp(i); findDown(i);
				if(up + down == N - 1) res++;
			}
			
			System.out.println("#" + t + " " + res);
		}
	}

	private static void findUp(int n) {
		visit[n] = true;
		for(int num : uplist[n]) {
			if(!visit[num]) {
				up++;
				visit[num] = true;
				findUp(num);
			}
		}
	}

	private static void findDown(int n) {
		visit[n] = true;
		for(int num : downlist[n]) {
			if(!visit[num]) {
				down++;
				visit[num] = true;
				findDown(num);
			}
		}
	}
}

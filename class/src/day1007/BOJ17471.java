package day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17471 { // 게리맨더링
	static int N;
	static int[] population;
	static boolean[] guMarker;
	static boolean[] checkConnect;
	static ArrayList<Integer>[] list;
	static int res = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		population = new int[N + 1];
		guMarker = new boolean[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < num; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		} // end input
		
		select(1, 0, 0);
		res = (res == Integer.MAX_VALUE) ? -1 : res;
		System.out.println(res);
	}
	
	// 선거구 나누기 (부분집합)
	static void select(int idx, int n1, int n2) {
		if(idx == N + 1) {
			// 가능한 선거구인지 확인
			if(n1 == 0 || n2 == 0) return;
			
			boolean oneGu = false, twoGu = false;
			checkConnect = new boolean[N + 1];
			for(int i = 1; i <= N; i++) {
				if(guMarker[i] && !oneGu) {
					connect(i);
					oneGu = true;
				} else if(!guMarker[i] && !twoGu) {
					connect(i);
					twoGu = true;
				}
			}
			
			// 모두 연결 안됐다면 불가능한 경우
			for(int i = 1; i <= N; i++) {
				if(!checkConnect[i]) return;
			}
			
			int oneGuPopulation = 0;
			int twoGuPopulation = 0;
			for(int i = 1; i <= N; i++) {
				if(guMarker[i]) {
					oneGuPopulation += population[i];
				} else {
					twoGuPopulation += population[i];
				}
			}
			
			res = Math.min(res, Math.abs(oneGuPopulation - twoGuPopulation));
			return;
		}
		
		guMarker[idx] = true;
		select(idx + 1, n1 + 1, n2);
		guMarker[idx] = false;
		select(idx + 1, n1, n2 + 1);
	}
	
	// 선거구 내 구역 모두 연결되었는지 확인
	static void connect(int n) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(n);
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			checkConnect[num] = true;
			
			for(int next : list[num]) {
				if(guMarker[next] == guMarker[num]) { // 같은 선거구인 경우
					if(!checkConnect[next]) {
						queue.add(next);
					}
				}
			}
		}
	}
}

package day0930;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1463 { // 1로 만들기
	static int X, ans;
	static int[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		
		visit = new int[X + 1];
		Arrays.fill(visit, Integer.MAX_VALUE);
		ans = Integer.MAX_VALUE;
		
		// dfs(X, 0);
		// bfs();
		dp();
		System.out.println(ans);
	}
	
	static void dfs(int num, int cnt) {
		if(cnt >= ans) return; // 이전에 1을 만든 연산 수보다 연산을 더 많이 한 경우 리턴
		
		if(num == 1) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		// 숫자마다 최소 연산수 저장해서 총 연산수 줄이기
		if(visit[num] <= cnt) return;
		visit[num] = cnt;
		
		if(num % 3 == 0) dfs(num / 3, cnt + 1);
		if(num % 2 == 0) dfs(num / 2, cnt + 1);
		dfs(num - 1, cnt + 1);
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[X + 1];
		
		q.add(X);
		visit[X] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {
				int now = q.poll();
				
				if(now == 1) {
					ans = cnt;
					return;
				}
				
				if(now % 3 == 0 && !visit[now / 3]) {
					q.add(now / 3);
					visit[now / 3] = true;
				}

				if(now % 2 == 0 && !visit[now / 2]) {
					q.add(now / 2);
					visit[now / 2] = true;
				}
				
				if(!visit[now - 1]) {
					q.add(now - 1);
					visit[now - 1] = true;
				}
			}
			
			cnt++;
		}
	}
	
	static void dp() {
		int[] memo = new int[X + 1];
		
		for(int i = 2; i <= X; i++) {
			memo[i] = memo[i - 1] + 1; // 현재 i보다 하나 작은 숫자로부터 +1 연산 한번 수행하면 현재 i 만들어짐
			
			if(i % 3 == 0)
				memo[i] = Math.min(memo[i], memo[i / 3] + 1);
			if(i % 2 == 0)
				memo[i] = Math.min(memo[i], memo[i / 2] + 1);
		}
		
		ans = memo[X];
	}
}

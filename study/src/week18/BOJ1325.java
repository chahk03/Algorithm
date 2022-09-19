package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1325 { // 효율적인 해킹
	static int N, M;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
		M = Integer.parseInt(st.nextToken()); // 신뢰 관계
		list = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[B].add(A);
		}
		
//		int max = 0;
//		int[] arr = new int[N + 1];
//		for(int i = 1; i <= N; i++) {
//			arr[i] = hacking(i);
//			max = Math.max(max, arr[i]);
//		}
//		
//		ArrayList<Integer> result = new ArrayList<>();
//		for(int i = 1; i <= N; i++) {
//			if(arr[i] == max) {
//				result.add(i);
//			}
//		}
		
		a = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			go(i);
		}
		
//		Arrays.sort(a);
//		for(int num : result) {
//			sb.append(num).append(' ');
//		}
//		
//		System.out.println(sb);
		System.out.println(Arrays.toString(a));
	}
	
	static int[] a;
	
	static int go(int num) {
		if(list[num].size() == 0) {
			a[num] = 1;
		}
		
		if(a[num] == 0) {
			for(int i = 0; i < list[num].size(); i++) {
				a[num] += go(list[num].get(i));
			}
		}
		
		return a[num];
	}
	
//	static int hacking(int num) {
//		Queue<Integer> q = new ArrayDeque<>();
//		boolean[] visit = new boolean[N + 1];
//
//		q.add(num);
//		visit[num] = true;
//		int total = 1;
//		
//		while(!q.isEmpty()) {
//			int cNum = q.poll();
//			
//			for(int i = 0; i < list[cNum].size(); i++) {
//				if(!visit[list[cNum].get(i)]) {
//					q.add(list[cNum].get(i));
//					visit[list[cNum].get(i)] = true;
//					total += 1;
//				}
//			}
//		}
//		
//		return total;
//	}
}

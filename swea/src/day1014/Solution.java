package day1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] trees;
	static int[] height;
	static int maxHeight;
	static int total, result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 나무 개수
			trees = new int[N];
			maxHeight = 0;
			result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, trees[i]);
			} // end input
			
			total = 0;
			for(int i = 0; i < N; i++) {
				if(trees[i] != maxHeight) {
					total += (maxHeight - trees[i]);
				}
			}
			
			height = new int[total + 1];
			Arrays.fill(height, Integer.MAX_VALUE);
			
			dfs(0, 0);
			result = height[total];
			
			System.out.println("#" + t + " " + result);
		}
	}

	private static void dfs(int tall, int day) {
		if(tall == total) {
			height[tall] = Math.min(height[tall], day);
			return;
		}
		
		if(tall > total) return;
		if(day > 0) {
			if(height[tall] > day) height[tall] = day;
			else return;
		}
		
		dfs(tall, day + 1);
		if((day + 1) % 2 == 1) dfs(tall + 1, day + 1);
		else if((day + 1) % 2 == 0) dfs(tall + 2, day + 1);
	}
}

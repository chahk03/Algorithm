package day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ17135 { // 캐슬 디펜스
	static int N, M, D;
	static int[][] map;
	static ArrayList<Info> enemy;
	static ArrayList<Integer> eList; // 제거할 적 리스트
	static int[] arr;
	static int sum, result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 격자판 행 수
		M = Integer.parseInt(st.nextToken()); // 격자판 열 수
		D = Integer.parseInt(st.nextToken()); // 궁수 공격 거리 제한
		enemy = new ArrayList<>(); // 적 리스트
		map = new int[N][M]; // 격자판 배열
		arr = new int[3]; // 궁수 위치 배열
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = Integer.MIN_VALUE;
		position(0, 0);
		System.out.println(result);
	}
	
	static void position(int cnt, int start) {
		if(cnt == 3) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						enemy.add(new Info(i, j));
					}
				}
			}
			
			Collections.sort(enemy);
			sum = 0; // 궁수 공격으로 제거한 적의 수 초기화
			game();
			result = Math.max(result, sum);
			return;
		}
		
		for(int i = start; i < M; i++) {
			arr[cnt] = i;
			position(cnt + 1, i + 1);
		}
	}
	
	// 게임 시작
	static void game() {
		while(true) {
			if(enemy.isEmpty()) break;

			// 적 제거
			eList = find(arr);
			Collections.sort(eList);
			for(int i = eList.size() - 1; i >= 0 ; i--) {
				int idx = eList.get(i);
				enemy.remove(idx);
				sum += 1;
			}			
			
			// 적 이동
			down();
		}
	}
	
	// 가까운 적 찾기
	static ArrayList<Integer> find(int[] arr) {
		ArrayList<Integer> eIdx = new ArrayList<>();
		for(int i = 0; i < arr.length; i++) {
			int idx = -1;
			int min = Integer.MAX_VALUE;
			
			for(int j = 0; j < enemy.size(); j++) {
				int dist = Math.abs(N - enemy.get(j).x) + Math.abs(arr[i] - enemy.get(j).y);
				if(min > dist) {
					min = dist;
					idx = j;
				}
			}
			
			if(!eIdx.contains(idx) && min <= D) eIdx.add(idx);
		}
		
		return eIdx;
	}
	
	// 적 한 칸 아래로 이동
	static void down() {
		for(int i = enemy.size() - 1; i >= 0; i--) {
			enemy.get(i).x += 1;
			
			if(enemy.get(i).x == N) {
				enemy.remove(i);
			}
		}
	}
	
	static class Info implements Comparable<Info> {
		int x, y;
		
		Info(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Info o) {
			return this.y - o.y;
		}
	}
}

package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236 { // 아기상어
	static int N; 
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static ArrayList<Fish> fish;
	static Fish shark;
	static int time, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 정사각형 크기
		map = new int[N][N]; // 정사각형
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					map[i][j] = 0;
					shark = new Fish(i, j); // 아기상어
				}
			}
		}
		
		int size = 0; // 아기상어 크기만큼 증가하면 아기상어 크기 +1
		while(true) {
			fish = new ArrayList<>(); // 거리가 가장 가까운 먹을 수 있는 물고기 리스트
			visit = new boolean[N][N]; // 방문 체크
			bfs(); // 거리가 가장 가까운 먹을 수 있는 물고기 탐색
			
			if(fish.isEmpty()) break; // 먹을 수 있는 물고기가 더 이상 없으면 종료
			
			// 먹을 수 있는 물고기가 있는 경우
			Collections.sort(fish); // 거리가 같은 물고기가 여러마리 있을 수 있으므로 조건에 따라 정렬
				
			shark.x = fish.get(0).x; // 아기상어 위치 변경
			shark.y = fish.get(0).y;
			map[shark.x][shark.y] = 0;
			size++;
				
			if(size == shark.size) {
				shark.size++;
				size = 0;
			}
				
			ans += time; // 먹으러 이동한 시간 추가
		}
		
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Fish> que = new ArrayDeque<>();
		que.add(shark);
		visit[shark.x][shark.y] = true;
		time = 0;
		
		while(!que.isEmpty()) {
			int size = que.size();
			boolean eat = false;
			time++;
			
			for(int i = 0; i < size; i++) {
				Fish node = que.poll();
				int x = node.x;
				int y = node.y;
				
				for(int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(0 <= nx && nx < N && 0 <= ny && ny < N) {
						if(visit[nx][ny] == false) {
							// 더 큰 물고기가 있으면 이동할 수 없음
							if(map[nx][ny] > shark.size) continue;
							
							// 먹을 수 있는 물고기라면 리스트에 추가
							if(map[nx][ny] != 0 && map[nx][ny] < shark.size) {
								fish.add(new Fish(nx, ny));
								eat = true;
								continue;
							}

							// 같은 크기의 물고기거나 빈 칸이면 이동
							que.add(new Fish(nx, ny));
							visit[nx][ny] = true;
						}
					}
				}
			}
			
			// 먹을 수 있는 물고기 찾았으면 탐색 종료
			if(eat) {
				return;
			}
		}
	}
	
	static class Fish implements Comparable<Fish> {
		int x, y;
		int size = 2;
		
		Fish(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
	}
}

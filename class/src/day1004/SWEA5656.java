package day1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA5656 { // 벽돌 깨기
	static int N, W, H;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int total, sum, res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 구슬 떨어뜨리는 횟수
			W = Integer.parseInt(st.nextToken()); // 열
			H = Integer.parseInt(st.nextToken()); // 행
			map = new int[H][W];
			total = 0;
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) total++;
				}
			} // end input
			
			res = Integer.MAX_VALUE;
			pos(0, total);
			System.out.println("#" + tc + " " + res);
		}
	}

	// 구슬 떨어뜨릴 위치 정하기 (W개 중에 N개만큼 조합)
	static void pos(int cnt, int total) {
		if(total == 0) {
			res = 0;
			return;
		}
		
		if(cnt == N) {
			res = Math.min(res, total);
			return;
		}
		
		for(int i = 0; i < W; i++) {
			int idx = -1;
			for(int j = 0; j < H; j++) {
				if(map[j][i] != 0) {
					idx = j;
					break;
				}
			}
			
			if(idx == -1) continue;
			
			int[][] arr = copy(map);
			crush(map, idx, i);
			drop(map);
			pos(cnt + 1, total - sum);
			map = arr;
		}
	}
	
	// 구슬 떨어뜨려서 벽돌 깨기
	static void crush(int[][] arr, int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x, y, arr[x][y]});
		arr[x][y] = 0;
		sum = 1;
		
		while(!q.isEmpty()) {
			int node[] = q.poll();
			int nodeX = node[0];
			int nodeY = node[1];
			
			for(int i = 1; i < node[2]; i++) {
				for(int d = 0; d < 4; d++) {
					int nx = nodeX + dx[d] * i;
					int ny = nodeY + dy[d] * i;
					
					if(0 <= nx && nx < H && 0 <= ny && ny < W) {
						if(arr[nx][ny] != 0) {
							q.add(new int[] {nx, ny, arr[nx][ny]});
							arr[nx][ny] = 0;
							sum++;
						}
					}
				}
			}
		}
	}
	
	// 벽돌 깬 후 벽돌 밑으로 내리기
	static void drop(int[][] arr) {
		for(int i = 0; i < W; i++) {
			Stack<Integer> stack = new Stack<>();
			for(int j = 0; j < H; j++) {
				if(arr[j][i] != 0) {
					stack.push(arr[j][i]);
					arr[j][i] = 0;
				}
			}
			
			int idx = H;
			while(!stack.isEmpty()) {
				arr[--idx][i] = stack.pop();
			}
		}
	}
	
	// 남은 벽돌 개수 구하기
	static int remain(int[][] arr) {
		int total = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(arr[i][j] != 0) {
					total++;
				}
			}
		}
		
		return total;
	}
	
	static int[][] copy(int[][] arr) {
		int[][] copy = new int[H][W];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		return copy;
	}
}
